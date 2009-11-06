package de.dailab.vsdt.trafo.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;

import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.MappingWrapper;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;

public abstract class BpmnTrafoWizard extends Wizard {
	
	public static final String SUCCESS_TITLE= "Transformation Complete";
	public static final String SUCCESS_MESSAGE= "Transformation completed.";
	public static final String SUCCESS_WARN_MESSAGE= "Transformation completed with warnings.";
	public static final String ERROR_TRAFO_TITLE= "Transformation Error";
	public static final String ERROR_TRAFO_MESSAGE= "An error occured during transformation.";
	public static final String SEE_LOG_MESSAGE= System.getProperty("line.separator") + "Please see the log file for details.";
	
	/** the options page */
	protected BpmnTrafoWizardOptionsPage optionsPage= null;
	
	/** the selected file(s) */
	protected IStructuredSelection selection= new StructuredSelection();
	
	/** these classes handle the transformation itself*/
	protected List<MappingStage> mappingStages= new ArrayList<MappingStage>();
	
	/** this class handles saving the result of the transformation*/
	protected MappingResultSaver resultSaver= null;
	
	public BpmnTrafoWizard() {
		this.setWindowTitle(getTitle());
	}
	
	public abstract String getTitle();

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection instanceof TreeSelection) {
			this.selection= selection;	
		}
	}
	
	public void addPages() {
		optionsPage= createOptionsPage(getTitle(), selection);
		this.addPage(optionsPage);
	}
	
	/**
	 * Override this method to return the OptionsPage to use. In case no specific options
	 * other than the default are required, a new BpmnExportWizardOptionsPage can be returned,
	 * otherwise the BEWOP should be extended by a custom Page, providing additional options.
	 * 
	 * @return	generic or customized BpmnExportWizardOptionsPage
	 */
	protected abstract BpmnTrafoWizardOptionsPage createOptionsPage(String title, IStructuredSelection selection);
	
	/**
	 * in this method the several stages of the mapping and the result saver are initialized
	 */
	protected abstract void initializeMappingStages();
	
	/**
	 * Create a (possibly target framework specific) mapping wrapper instance,
	 * which is used to pass the source model together with intermediate results
	 * from one mapping stage to the next.
	 */
	protected MappingWrapper createMappingWrapper(Object source) {
		return new MappingWrapper(source);
	}
	
	/**
	 * in this method, additional options provided by the OptionsPage can be read and applied to the
	 * mapping stages. This method is called in the performFinish method before invoking the transformation.
	 */
	protected abstract void applyOptions();

	@Override
	public boolean performFinish() {
		initializeMappingStages();
		applyOptions();
		String path= optionsPage.getPath();
		boolean log= optionsPage.getCreateLog();
		
		for (IFile file : optionsPage.getSelectedResources()) {
			try {
				URI fileURI = URI.createFileURI(
						new File(file.getLocationURI()).getAbsolutePath());
				Object source= getSouceObject(fileURI);
				
				StringBuffer buff= new StringBuffer();
				buff.append(path);
				buff.append(File.separator);
				buff.append("target");
				buff.append(File.separator);
				buff.append(getModelName(source));
				buff.append(File.separator);
				File baseDir= new File(buff.toString());

				if (optionsPage.getCreateLog()) {
					String logFile= getModelName(source) + ".log";
					TrafoLog.addFileAppender(new File(baseDir,logFile).getAbsolutePath());
				}
				TrafoLog.setLogLevel(optionsPage.getLogLevel());
				TrafoLog.info("<<<<< Starting Transformation");
				
				boolean ok= true;
				
				// create model wrapper
				MappingWrapper wrapper= createMappingWrapper(source);
				// iterate over mapping stages
				for (MappingStage stage : mappingStages) {
					stage.initialize();
					stage.setWrapper(wrapper);
					ok= stage.apply();
					if (!ok) {
						break;
					}
				}
				// save result
				if (ok && resultSaver != null) {
					resultSaver.setDirectory(baseDir);
					resultSaver.setWrapper(wrapper);
					ok= resultSaver.save();
				}
				// show dialog
				if (ok) {
					if (TrafoLog.hasWarnings()) {
						MessageDialog.openWarning(this.getShell(), SUCCESS_TITLE, SUCCESS_WARN_MESSAGE + (log ? SEE_LOG_MESSAGE : ""));
					} else {
						MessageDialog.openInformation(this.getShell(), SUCCESS_TITLE, SUCCESS_MESSAGE + (log ? SEE_LOG_MESSAGE : ""));
					}
				} else {
					MessageDialog.openError(this.getShell(), ERROR_TRAFO_TITLE, ERROR_TRAFO_MESSAGE + (log ? SEE_LOG_MESSAGE : ""));
				}
				
				//refresh projects
				TrafoLog.info(">>>>> Finished Transformation");
				TrafoLog.reset();
				file.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);

			} catch (Exception e) {
				e.printStackTrace();
				String message= e.getStackTrace().length > 0 ? message= e.getStackTrace()[0].toString() : e.getMessage();
				TrafoLog.error("Saving files failed");
				TrafoLog.fatal(message,e);
				MessageDialog.openError(this.getShell(), ERROR_TRAFO_TITLE, ERROR_TRAFO_MESSAGE + (log ? SEE_LOG_MESSAGE : ""));
				TrafoLog.reset();
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Load source model from a given file URI. Default: Load model as EObject.
	 * 
	 * @param fileURI	URI of the source file
	 * @return			Source model instance
	 */
	protected Object getSouceObject(URI fileURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		
		Resource resource = resourceSet.getResource(fileURI, true);
		EObject source= resource.getContents().get(0);
		EcoreUtil.resolveAll(source);
		
		return source;
	}
	
	/**
	 * @param model		The target model object
	 * @return			Name of the model, to be used e.g. as the file name
	 */
	protected String getModelName(Object model) {
		return "_unnamed_";
	}
}
