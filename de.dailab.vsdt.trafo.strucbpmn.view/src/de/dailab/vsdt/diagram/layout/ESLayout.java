package de.dailab.vsdt.diagram.layout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.draw2d.geometry.Point;
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
	
	public static final int MAX_GENERATIONS= 1000;
	public static final int MY=     15;
	public static final int RHO=     1;
	public static final int LAMBDA= 25;

	/** in one mutation, move graph nodes by delta * gaussian * this number */
	final int MOVE_BY= 20;
	
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
		esRunner.setup(MY, RHO, LAMBDA, true, true, true);
		setBest(esRunner.getBest(), -1, true);
		esRunner.start(MAX_GENERATIONS);
		esRunner.join();
		// reset current diagram
		current_bpd= null;
		// return best result
		return esRunner.getBest().positions;
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
		for (int i=0; i<my; i++) {
			Map<FlowObject, Rectangle> positions= new HashMap<FlowObject, Rectangle>();
			
			// for the start, initialize parent so that all nodes sit on one spot...
			TreeIterator<EObject> iter= current_bpd.eAllContents();
			while (iter.hasNext()) {
				EObject eObject= iter.next();
				if (eObject instanceof FlowObject) {
					FlowObject flowObject = (FlowObject) eObject;
					positions.put(flowObject, new Rectangle(new Point(1000, 500), SIZE_DEFAULT));
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
		
		// get random flow object
		Object[] flowObjects= positions.keySet().toArray();

//		FlowObject flowObject= (FlowObject) flowObjects[random.nextInt(flowObjects.length)]; 
		for (Object object : flowObjects) {
			FlowObject flowObject = (FlowObject) object;
			// change position of flow object
			Rectangle position= positions.get(flowObject);
			int dx = (int) (random.nextGaussian() * delta * MOVE_BY); 
			int dy = (int) (random.nextGaussian() * delta * MOVE_BY);
			position= position.getCopy().translate(dx, dy);
			positions.put(flowObject, position);
		}
		
		// return offspring
		return new ESLayoutData(positions);
	}
	
	@Override
	public ESLayoutData recombine(List<ESLayoutData> parents) {
		/*
		 * TODO recombine parent
		 */
		return parents.get(0);
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

			int PENALTY_OVERLAP= 1000;
			int PENALTY_TOO_NARROW= 500;
			int PENALTY_PER_DISTANCE= 2;
			int PENALTY_VERTICAL_DIVERGENCE= 10;
			int PENALTY_WRONG_DIRECTION= 20;
			
			// summarize quality over all flow objects
			for (FlowObject flowObject : positions.keySet()) {
				Rectangle p1 = positions.get(flowObject);
			
				// for all other flow objects
				for (FlowObject other : positions.keySet()) {
					if (other != flowObject && other.getFlowObjectContainer() == flowObject.getFlowObjectContainer()) {
						Rectangle p2 = positions.get(other);
						
						// no overlapping nodes
						if (p1.intersects(p2)) {
							penalty += PENALTY_OVERLAP;
						}
						// minimal distance between nodes, etc.
						int dx= Math.abs(p2.x - p1.x);
						int dy= Math.abs(p2.y - p1.y);
						if (dx < MARGIN_H) {
							penalty += PENALTY_TOO_NARROW;
						}
						if (dy < MARGIN_V) {
							penalty += PENALTY_TOO_NARROW;
						}
					}
				}
				// for successive flow objects
				for (SequenceFlow sequenceFlow : flowObject.getOutgoingSeq()) {
					FlowObject other= sequenceFlow.getTarget();
					Rectangle p2 = positions.get(other);

					// minimal sum of distances of connected nodes
					double distance= getDistance(p1.getCenter(), p2.getCenter()) - 40 - MARGIN_H;
					penalty += distance * distance * PENALTY_PER_DISTANCE;
					
					// connected nodes should be lines up, if possible
					int dy= Math.abs(p2.y - p1.y); 
					penalty += dy * dy * PENALTY_VERTICAL_DIVERGENCE;
					
					// the general direction should be from left to right
					if (p2.x < p1.x) {
						int dx = p2.x - p1.y;
						penalty += dx * dx * PENALTY_WRONG_DIRECTION;
					}
				}
				// TODO no position should be smaller than (0,0), but not too big either
			}
			// TODO no overlapping edges (this might be quite hard to calculate)
			// TODO advanced: symmetry, angles between edges, etc.
			individual.quality = 1 / penalty;
		}
		return individual.quality;
	}

	@Override
	public void setBest(ESLayoutData best, int generation, boolean didImprove) {
		if (didImprove) {
			System.out.println(generation + "\t" + 1 / best.quality);
			for (FlowObject flowObject : best.positions.keySet()) {
				System.out.println("\t" + flowObject.getName() + "\t" + best.positions.get(flowObject).getCenter());
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

		/**
		 * Create LayoutData instance with given positions
		 * 
		 * @param positions		Map of FlowObjects' Positions
		 */
		public ESLayoutData(Map<FlowObject, Rectangle> positions) {
			this.positions = positions;
		}
		
	}
	
}
