package de.dailab.es;

import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This Frame can be used for configuring, running, and visualizing an evolution
 * strategy-based optimization. The Frame provides a number of controls for
 * setting up the strategy (such as number of parents and offspring) and a
 * button to run the optimization in a thread. The domain and the results of the
 * optimization are visualized in a specialized AbstractESComponent.
 * 
 * @see AbstractESComponent
 * @see ESRunner
 * @see ESModel
 * 
 * @author kuester
 *
 * @param <T>	Class describing the individuals
 */
public abstract class AbstractESFrame<T> extends JFrame implements ActionListener, ESObserver<T> {

	private static final long serialVersionUID = -1923884258513802062L;

	static final String LABEL_START = "Start/Stop";
	static final String LABEL_QUIT = "Quit";
	static final String LABEL_SAVE = "Save...";
	static final String LABEL_LOAD = "Load...";
	
	/** the ESRunner running the optimization */
	protected final ESRunner<T> esRunner;
	
	/** the domain model to be optimized */
	protected final ESModel<T> model;
	
	/** component for visualizing the domain and the current performance */
	protected final AbstractESComponent<T> esComp;
	
	protected final JLabel statusLabel;
	protected final JLabel qualityLabel;
	protected final JLabel generationLabel;
	
	private final JTextField myTF;
	private final JTextField rhoTF;
	private final JTextField lambdaTF;
	
	private final JCheckBoxMenuItem multiMutateCB;
	private final JCheckBoxMenuItem keepParentsCB;
	private final JCheckBoxMenuItem useDeltaCB;

	/**
	 * Create AbstractESFrame with given title
	 * 
	 * @param title		to be displayed in frame's title bar
	 */
	public AbstractESFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// create ES model and component for input and visualization
		this.model= createESModel();
		this.esRunner= new ESRunner<T>(model, this, null);
		this.esComp= createESComponent();
		
		// CREATE MENU BAR
		
		// file menu: new, load, save, quit
		JMenu fileMenu= new JMenu("File");
		JMenuItem loadMI= new JMenuItem(LABEL_LOAD);
		loadMI.addActionListener(this);
		fileMenu.add(loadMI);
		JMenuItem saveMI= new JMenuItem(LABEL_SAVE);
		saveMI.addActionListener(this);
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		JMenuItem quitMI= new JMenuItem(LABEL_QUIT);
		quitMI.addActionListener(this);
		fileMenu.add(quitMI);
		
		// options menu: multi-mutate, keep parents, use delta
		JMenu optionsMenu= new JMenu("Options");
		multiMutateCB= new JCheckBoxMenuItem("Multi-Mutate", true);
		multiMutateCB.addActionListener(this);
		optionsMenu.add(multiMutateCB);
		keepParentsCB= new JCheckBoxMenuItem("Keep Parents", true);
		keepParentsCB.addActionListener(this);
		optionsMenu.add(keepParentsCB);
		useDeltaCB= new JCheckBoxMenuItem("Use Delta", true);
		useDeltaCB.addActionListener(this);
		optionsMenu.add(useDeltaCB);
		
		// assemble menu bar
		JMenuBar menu= new JMenuBar();
		menu.add(fileMenu);
		menu.add(optionsMenu);
		this.setJMenuBar(menu);
		
		// CREATE MAIN AREA

		statusLabel= new JLabel("Welcome!");
		
		// output panel
		generationLabel= new JLabel("0");
		qualityLabel= new JLabel("0");
		JPanel outputPanel= new JPanel(new GridLayout(2, 2));
		outputPanel.add(new JLabel("Generation:"));
		outputPanel.add(generationLabel);
		outputPanel.add(new JLabel("Quality:"));
		outputPanel.add(qualityLabel);
		
		// start button
		JButton startButton= new JButton(LABEL_START);
		startButton.addActionListener(this);
		
		// panel with strategy parameters
		myTF= new JTextField("3", 3);
		rhoTF= new JTextField("1", 3);
		lambdaTF= new JTextField("8", 3);
		JPanel esPanel= new JPanel();
		esPanel.add(new JLabel("Using ("));
		esPanel.add(myTF);
		esPanel.add(new JLabel("/"));
		esPanel.add(rhoTF);
		esPanel.add(new JLabel("+"));
		esPanel.add(lambdaTF);
		esPanel.add(new JLabel(")-ES"));
		
		// put everything together
		getContentPane().setLayout(new GridBagLayout());
		int	b= GridBagConstraints.BOTH,
			h= GridBagConstraints.HORIZONTAL,
			n= GridBagConstraints.NONE,
			c= GridBagConstraints.CENTER,
			w= GridBagConstraints.WEST;
		getContentPane().add(esComp, 		makeGBC(0, 0, 2, 1, b, c));
		getContentPane().add(esPanel, 		makeGBC(0, 1, 1, 1, h, w));
		getContentPane().add(startButton, 	makeGBC(0, 2, 1, 1, n, c));
		getContentPane().add(outputPanel, 	makeGBC(1, 1, 1, 2, h, w));
		getContentPane().add(statusLabel, 	makeGBC(0, 3, 2, 1, h, c));
		pack();
	}
	
	/**
	 * @return	GridBagConstraint with given values, others good defaults
	 */
	private GridBagConstraints makeGBC(int x, int y, int width, int height, int fill, int anchor) {
		return new GridBagConstraints(x, y, width, height, 1, 1, anchor, fill, new Insets(1,1,1,1), 0, 0);
	}
	
	/**
	 * stop optimization, reset domain model and visualization 
	 */
	protected void reset() {
		model.clear();
		esComp.update(model);
		esRunner.stop();
		qualityLabel.setText(null);
	}
	
	/**
	 * Create and return the domain model for the optimization
	 * 
	 * @return	domain model for the optimization
	 */
	protected abstract ESModel<T> createESModel();

	/**
	 * Create and return the component visualizing the optimization
	 * @return	component visualizing the optimization
	 */
	protected abstract AbstractESComponent<T> createESComponent();
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd= event.getActionCommand();
		// load plan
		if (LABEL_LOAD.equals(cmd)) {
			FileDialog dlg= new FileDialog(AbstractESFrame.this, LABEL_LOAD, FileDialog.LOAD);
			dlg.setVisible(true);
			if (dlg.getFile() != null) {
				reset();
				try {
					model.load(dlg.getDirectory() + dlg.getFile());
					esComp.update(model);
					setStatus("File " + dlg.getFile() + " loaded");
				} catch (IOException e) {
					setStatus("Could not load file");
				}
			}
		}
		// save plan
		if (LABEL_SAVE.equals(cmd)) {
			FileDialog dlg= new FileDialog(AbstractESFrame.this, LABEL_SAVE, FileDialog.SAVE);
			dlg.setVisible(true);
			if (dlg.getFile() != null) {
				try {
					model.save(dlg.getDirectory() + dlg.getFile());
					setStatus("Saved to file " + dlg.getFile());
				} catch (IOException e) {
					setStatus("Failed to save file");
				}
			}
		}
		// quit program
		if (LABEL_QUIT.equals(cmd)) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		// start optimization
		if (LABEL_START.equals(cmd)) {
			if (esRunner.isRunning()) {
				esRunner.stop();
			} else {
				try {
					// get my, rho, lambda
					int my= Integer.parseInt(myTF.getText());
					int rho= Integer.parseInt(rhoTF.getText());
					int lambda= Integer.parseInt(lambdaTF.getText());
	
					// check parameters
					if (my < 1 || rho < 1 || lambda < 1 || my < rho
							|| my > 150 || rho > 50 || lambda > 1000) {
						throw new IllegalArgumentException();
					}
	
					// get options
					boolean multiMutate = multiMutateCB.isSelected();
					boolean keepParents = keepParentsCB.isSelected();
					boolean useDelta = useDeltaCB.isSelected();
					
					// setup engine and start thread
					esRunner.setup(my, rho, lambda, multiMutate, keepParents, useDelta);
					esRunner.start(0);
				} catch (NumberFormatException e) {
					setStatus("Input parameters can not be parsed as numbers!");
				} catch (IllegalArgumentException e) {
					setStatus("Input parameters are outside of reasonable bounds!");
				}
			}
		}
	}
	
	/**
	 * Display status message on status label
	 * 
	 * @param message		message to be displayed
	 */
	public void setStatus(String message) {
		this.statusLabel.setText(message);
	}
		
	/**
	 * Pass the currently best individual to be displayed in the central view.
	 * Further, by default the individual's quality is displayed on the quality
	 * label. You can overwrite this method to display something else on the
	 * quality label, in case the quality itself is not very meaningful to the
	 * user.  
	 */
	@Override
	public void setBest(T best, int generation, boolean didImprove) {
		this.generationLabel.setText(String.valueOf(generation));
		if (didImprove) {
			this.esComp.setIndividual(best);
			this.qualityLabel.setText(String.valueOf(model.getQuality(best)));
			this.setStatus("Last improvement in generation " + generation);
		}
	};

	/**
	 * The Component visualizing the Domain model and the currently best
	 * individual. This can be everything from a long table, over a bunch of
	 * controls to a drawing area, as long as it implements the required
	 * methods. Further, this class will most likely need to provide some sort
	 * of input mechanism, e.g. text fields or a mouse control, for manipulating
	 * the currently loaded domain model.
	 * 
	 * @author kuester
	 *
	 * @param <T>	Class describing the individuals
	 */
	protected abstract class AbstractESComponent<S> extends JComponent {
		
		private static final long serialVersionUID = -1532719949172149532L;

		/**
		 * Update the visualization according to the given domain model. This
		 * method is called e.g. when the model is reset, or when it is loaded
		 * from a file.
		 * 
		 * @param model			domain model to be displayed
		 */
		public abstract void update(ESModel<S> model);
		
		/**
		 * Set the currently best individual to be visualized in the component. 
		 * 
		 * @param individual	currently best individual
		 */
		public abstract void setIndividual(S individual);
	}

}
