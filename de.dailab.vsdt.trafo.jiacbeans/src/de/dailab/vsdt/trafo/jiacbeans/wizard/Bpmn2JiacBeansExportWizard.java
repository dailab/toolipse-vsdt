package de.dailab.vsdt.trafo.jiacbeans.wizard;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.ui.util.ConsoleUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.MappingWrapper;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.impl.DefaultBpmnValidation;
import de.dailab.vsdt.trafo.jiacbeans.export.Bpmn2JiacBeansElementMapping;
import de.dailab.vsdt.trafo.jiacbeans.export.JiacBeansExportWrapper;
import de.dailab.vsdt.trafo.jiacbeans.export.JiacBeansResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.export.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class Bpmn2JiacBeansExportWizard extends BpmnExportWizard {
	
	private static final String FS= File.separator;
	
	@Override
	public String getTitle() {
		return "BPMN to JIAC AgentBeans Export Wizard";
	}

	@Override
	protected void initializeMappingStages() {
		mappingStages = new ArrayList<MappingStage>();
		mappingStages.add(new DefaultBpmnValidation());
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		mappingStages.add(new Bpmn2JiacBeansElementMapping());
		
		resultSaver= new JiacBeansResultSaver();
	}
	
	@Override
	protected MappingWrapper createMappingWrapper(Object source) {
		if (source instanceof BusinessProcessSystem) {
			return new JiacBeansExportWrapper((BusinessProcessSystem) source);
		} else {
			throw new IllegalArgumentException("Source must be of type BusinessProcessSystem");
		}
	}

	@Override
	protected BpmnExportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new BpmnExportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
	}
	
	/**
	 * When finishing the dialog, the transformation is performed for each of
	 * the selected resources. The transformation is performed inside of a 
	 * Progress Dialog, so the user has some kind of feedback that something 
	 * happens when he clicks the Finish-button (although the dialog does not 
	 * indicate any progress in the transformation as such). Finally, a dialog 
	 * is shown with the result of the transformation.
	 */
	@Override
	public boolean performFinish() {
		applyOptions();

		ConsoleUtil.registerConsole(VSDT_TRAFO_CONSOLE);
		
		for (final IFile file : optionsPage.getSelectedResources()) {
			final URI fileURI = URI.createFileURI(
					new File(file.getLocationURI()).getAbsolutePath());
			
			// start progress monitor
			final Shell shell= Display.getCurrent().getActiveShell();
			try {
				ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(shell);
				progressMonitorDialog.run(false, true, new IRunnableWithProgress() {
					@Override
					public void run(IProgressMonitor monitor) {

						// Transform!
						Object sourceObject = getSouceObject(fileURI);
						String targetDirectory = optionsPage.getPath() + FS ;
						boolean trafoOk= performTransformation(sourceObject, targetDirectory);

						// show dialog
						String logMsg = TrafoLog.getBufferedMessages();
						String id = "de.dailab.vsdt.trafo";
						String details = "Please see the transformation log for details";
						if (trafoOk) {
							if (TrafoLog.hasWarnings()) {
								IStatus status = new Status(IStatus.WARNING, id, details, new Throwable(logMsg));
								ErrorDialog.openError(shell, SUCCESS_TITLE, SUCCESS_WARN_MESSAGE, status);
								
							} else {
								MessageDialog.openInformation(shell, SUCCESS_TITLE, SUCCESS_MESSAGE);
							}
						} else {
							IStatus status = new Status(IStatus.ERROR, id, details, new Throwable(logMsg));
							ErrorDialog.openError(shell, ERROR_TRAFO_TITLE, ERROR_TRAFO_MESSAGE, status);
						}
						
						//refresh projects
						try {
							file.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
						} catch (CoreException e) {
							printError(e);
						}
					}
				});
				return true;
				
			} catch (InvocationTargetException e) {
				printError(e);
			} catch (InterruptedException e) {
				printError(e);
			}
		}
		return false;
	}
	
	/**
	 * Convert Exception Stacktrace to String and print it to Eclipse console.
	 * 
	 * @param exception		some exception
	 * @return				exception stacktrace as string
	 */
	private String printError(Exception exception) {
		StringWriter sw = new StringWriter();
		exception.printStackTrace(new PrintWriter(sw));
		String errMsg= sw.toString();
		ConsoleUtil.printError(VSDT_TRAFO_CONSOLE, errMsg);
		return errMsg;
	}
	
	@Override
	public JiacBeansResultSaver getResultSaver() {
		return (JiacBeansResultSaver) resultSaver;
	}
}
