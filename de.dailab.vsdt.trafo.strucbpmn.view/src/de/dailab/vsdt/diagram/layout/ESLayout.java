package de.dailab.vsdt.diagram.layout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.dailab.es.ESModel;
import de.dailab.es.ESObserver;
import de.dailab.es.ESRunner;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.SequenceFlow;

/**
 * This Layout Algorithm used concepts from Evolution Strategy (alias genetic
 * algorithms) for optimizing the layout.
 * 
 * @author kuester
 */
public class ESLayout extends AbstractLayout implements ESModel<ESLayout.ESLayoutData>, ESObserver<ESLayout.ESLayoutData> {

	static final Random random= new Random();
	
	public static int MAX_GENERATIONS = 2000;
	public static int POPULATIONS     =   10;
	
	public static int MY=      10;
	public static int RHO=      1;
	public static int LAMBDA=  25;
	
	public static int MOVE_BY= 1000;

	public static int PENALTY_OVERLAP             = 1000000;
	public static int PENALTY_TOO_NARROW          = 100000;
	public static int PENALTY_PER_DISTANCE        = 1;
	public static int PENALTY_VERTICAL_DIVERGENCE = 2;
	public static int PENALTY_WRONG_DIRECTION     = 2;
	
	public static boolean START_RANDOMLY = true;
	public static boolean MOVE_ALL_NODES = false;
	
	/** the thread running the layout algorithm */
	private final ESRunner<ESLayoutData> esRunner;
	
	/** the business process diagram currently being laid out */
	private BusinessProcessDiagram current_bpd;
	
	/**
	 * Create instance of Evolutionary Layout
	 */
	public ESLayout() {
		super("Evolutionary Layout");
		esRunner= new ESRunner<ESLayoutData>(this, this, MAX_GENERATIONS);
	}
	
	/**
	 * Initialize first generation of layouts, 
	 */
	@Override
	protected Map<FlowObject, Rectangle> createLayoutMap(BusinessProcessDiagram bpd) {
		// set current diagram
		current_bpd= bpd;
		// setup and start ESRunner -- this will also call the initialize method
		ESLayoutData best= null;
		// repeat the optimization a few times, pick best result
		for (int i=0; i < POPULATIONS; i++) {
			esRunner.setup(MY, RHO, LAMBDA, true, true, true);
			esRunner.start(MAX_GENERATIONS);
			esRunner.join();
			// save new best result
			ESLayoutData best2= esRunner.getBest();
			best= best == null || getQuality(best2) > getQuality(best) ? best2 : best;
		}
		System.out.println("Best result: " + 1/best.quality);
		// reset current diagram
		current_bpd= null;
		// return best positions of all runs
		return best.positions;
	}

	/**
	 * TODO use process diagram's current layout as starting point
	 * 
	 * Possible starting configurations:
	 * - all elements centered at one point
	 * - random distribution of elements over some area
	 * - process diagram's current layout
	 * - structure based layout (danger of starting right in a local optimum)
	 */
	@Override
	public List<ESLayoutData> initialize(int my) {
		List<ESLayoutData> first_generation= new ArrayList<ESLayoutData>(my);
		for (int i=0; i < my; i++) {
			Map<FlowObject, Rectangle> positions= new HashMap<FlowObject, Rectangle>();
			
			// for the start, initialize parent so that all nodes sit on one spot...
			TreeIterator<EObject> iter= current_bpd.eAllContents();
			while (iter.hasNext()) {
				EObject eObject= iter.next();
				if (eObject instanceof FlowObject) {
					FlowObject flowObject = (FlowObject) eObject;
					int x= START_RANDOMLY ? random.nextInt(1000) : 0;
					int y= START_RANDOMLY ? random.nextInt(500)  : 0;
					int width= SIZE_DEFAULT.x;
					int height= SIZE_DEFAULT.y;
					Rectangle position= new Rectangle(x, y, width, height);
					positions.put(flowObject, position);
				}
			}
			
			first_generation.add(new ESLayoutData(positions));
		}
		return first_generation;
	}

	/**
	 * Mutate parent by randomly moving one point by a small amount.
	 */
	@Override
	public ESLayoutData mutate(ESLayoutData parent, double delta) {
		Map<FlowObject, Rectangle> positions= new HashMap<FlowObject, Rectangle>(parent.positions);

		// select FlowObject(s) to be moved
		Collection<FlowObject> flowObjects= null;
		if (MOVE_ALL_NODES) {
			// move all flow objects
			flowObjects= positions.keySet();
		} else {
			// move flow object with lowest quality
			FlowObject worst = null;
			double worstQ = Double.MAX_VALUE;
			for (FlowObject flowObject : parent.positions.keySet()) {
				Double q = parent.qualities.get(flowObject);
				if (q != null && q < worstQ) {
					worst = flowObject;
					worstQ = q;
				}
			}
			if (worst != null) {
				flowObjects = Collections.singleton(worst);
			} else {
				// move random flow object
				Object[] objects= positions.keySet().toArray();
				FlowObject flowObject= (FlowObject) objects[random.nextInt(objects.length)]; 
				flowObjects = Collections.singleton(flowObject);
			}
		}
		
		for (FlowObject flowObject : flowObjects) {
			// change position of flow object
			Rectangle position= positions.get(flowObject);
			int dx = (int) (random.nextGaussian() * delta * MOVE_BY); 
			int dy = (int) (random.nextGaussian() * delta * MOVE_BY);
			Rectangle newPosition= new Rectangle(position.x+dx, position.y+dy, position.width, position.height);
			positions.put(flowObject, newPosition);
		}
		
		// return offspring
		return new ESLayoutData(positions);
	}
	
	@Override
	public ESLayoutData recombine(List<ESLayoutData> parents) {
		Map<FlowObject, Rectangle> positions= new HashMap<FlowObject, Rectangle>(parents.get(0).positions);
		
		// take positions randomly form the different parents
		for (FlowObject flowObject : positions.keySet()) {
			ESLayoutData parent= parents.get(random.nextInt(parents.size()));
			positions.put(flowObject, parent.positions.get(flowObject));
		}
		
		return new ESLayoutData(positions);
	}
	
	/**
	 * Aspects that should be considered when calculating the quality:
	 * - overview: no overlapping nodes, minimal distance between nodes, etc.
	 *   - no overlapping edges (this might be quite hard to calculate)
	 * - compactness: minimal sum of distances of connected nodes
	 * - alignment: connected nodes should be lines up, if possible
	 * - left-to-right: the general direction should be from left to right
	 * - positioning: no position should be smaller than (0,0), but not too big either
	 * - advanced: symmetry, angles between edges, etc.
	 * Quality should be the higher the better the individual is, and should not
	 * be negative or zero for any individual.
	 */
	@Override
	public double getQuality(ESLayoutData individual) {
		if (individual.quality == -1) {
			Map<FlowObject, Rectangle> positions= individual.positions;
			double penalty = 1;

			// summarize quality over all flow objects
			for (FlowObject flowObject : positions.keySet()) {
				Rectangle p1 = positions.get(flowObject);
			
				double this_penalty = 1;
				
				// for all other flow objects
				for (FlowObject other : flowObject.getParent().getContainedFlowObjects()) {
					if (other != flowObject) {
						Rectangle p2 = positions.get(other);
						
						// no overlapping nodes
						if (p1.intersects(p2)) {
							this_penalty += PENALTY_OVERLAP;
						}
						
						// minimal distance between nodes, etc.
						int dx= Math.abs(p2.x - p1.x);
						int dy= Math.abs(p2.y - p1.y);
						if (dx < MARGIN_H + SIZE_DEFAULT.x) {
							this_penalty += PENALTY_TOO_NARROW;
						}
						if (dy < MARGIN_V + SIZE_DEFAULT.y) {
							this_penalty += PENALTY_TOO_NARROW;
						}
					}
				}
				// for successive flow objects
				for (SequenceFlow sequenceFlow : flowObject.getOutgoingSeq()) {
					FlowObject other= sequenceFlow.getTarget();
					Rectangle p2 = positions.get(other);

					// minimal sum of distances of connected nodes
					double distance= getDistance(p1.getCenter(), p2.getCenter()) - SIZE_DEFAULT.x - MARGIN_H;
					distance = distance * distance;
					if (distance > 0) {
						this_penalty += distance * PENALTY_PER_DISTANCE;
					}
					
					// connected nodes should be lines up, if possible
					int dy= Math.abs(p2.y - p1.y);
					dy = dy * dy;
					this_penalty += dy * PENALTY_VERTICAL_DIVERGENCE;
					
					// the general direction should be from left to right
					if (p2.x < p1.x) {
						int dx = p1.x - p2.y;
						dx = dx * dx;
						this_penalty += dx * PENALTY_WRONG_DIRECTION;
					}
				}
				// TODO no position should be smaller than (0,0), but not too big either
				
				individual.qualities.put(flowObject, 1 / this_penalty);
				penalty += this_penalty;
			}
			// TODO no overlapping edges (this might be quite hard to calculate)
			// TODO advanced: symmetry, angles between edges, etc.
			individual.quality = 1 / penalty;
		}
		return individual.quality;
	}

	static MockupFrame frame;
	
	@Override
	public void setBest(ESLayoutData best, int generation, boolean didImprove) {
		if (didImprove) {
			System.out.println(generation + "\t" + 1 / best.quality);
			if (frame == null) {
				frame = new MockupFrame(best.positions);
			} else {
				frame.setVisible(true);
				frame.update(best.positions);
			}
		}
	}
	
	// Clear, Load, and Save are not needed here...
	
	@Override
	public void clear() {}
	
	@Override
	public void load(String pathToFile) throws IOException {}
	
	@Override
	public void save(String pathToFile) throws IOException {}
	

	/**
	 * Class encapsulating Layout Map with cached quality.
	 * 
	 * @author kuester
	 */
	public class ESLayoutData {
		
		/** the positions of the several graph elements */
		public final Map<FlowObject, Rectangle> positions;

		/** the quality calculated for this map */
		public double quality= -1;

		/** Map holding the qualities for each individual Flow Object */
		public final Map<FlowObject, Double> qualities;
		
		/**
		 * Create LayoutData instance with given positions
		 * 
		 * @param positions		Map of FlowObjects' Positions
		 */
		public ESLayoutData(Map<FlowObject, Rectangle> positions) {
			this.positions = positions;
			this.qualities = new HashMap<FlowObject, Double>();
		}
		
	}
	
}
