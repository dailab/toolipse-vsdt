package de.dailab.common.swt.views;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * Abstract superclass for Views, providing some common features,
 * such as means to contribute actions to the menus.
 * 
 * @author kuester
 */
public abstract class AbstractStructuredViewerView extends ViewPart {
	
//	/**
//	 * The main viewer, e.g. a Table or a Tree
//	 */
//	protected StructuredViewer viewer;
//
//	@Override
//	public void setFocus() {
//		viewer.getControl().setFocus();
//	}
//	
//	public Viewer getViewer() {
//		return viewer;
//	}
	
	/**
	 * Creates a context menu for the given Viewer and registers the actions at 
	 * the context menus.
	 * 
	 * @param viewer	the Viewer to add the context menu to
	 * @param actions	some Actions for the context menu
	 */
	protected void hookContextMenu(Viewer viewer, final Action... actions) {
		MenuManager menuMgr = new MenuManager("#PopupMenu"); //$NON-NLS-1$
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				for (Action action : actions) {
					manager.add(action);
				}
				// Other plug-ins can contribute there actions here
				manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/**
	 * Contributes the given actions to the tool bar.
	 * 
	 * @param actions	some Actions
	 */
	protected void contributeToToolBar(IAction... actions) {
		for (IAction action : actions) {
			getViewSite().getActionBars().getToolBarManager().add(action);
		}
	}
	
	/**
	 * Contributes the given actions to the menu.
	 * 
	 * @param actions	some Actions
	 */
	protected void contributeToMenu(Action... actions) {
		for (Action action : actions) {
			getViewSite().getActionBars().getMenuManager().add(action);
		}
	}
	
	/**
	 * @param viewer	The Viewer which's selection to return
	 * @return			The element currently selected in the viewer.
	 */
	public Object getSelectedElement(Viewer viewer) {
		if (viewer != null && viewer.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
			return selection.getFirstElement();
		}
		return null;
	}

	/**
	 * Shortcut for opening a Message Dialog
	 * 
	 * @param kind		Dialog Type (see MessageDialog constants)
	 * @param message	Message to be displayed
	 * @return			OK clicked? (for types where applicable)
	 */
	public boolean openMessageDialog(int kind, String message) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		return MessageDialog.open(kind, shell,
				getClass().getSimpleName(), message, SWT.NONE);
	}

	/**
	 * Open message dialogue using Display.syncExec. This should also work when used
	 * e.g. from a forked ProgressMonitor.
	 */
	public void openMessageDialogSafe(int kind, String message) {
		Display.getDefault().asyncExec(() -> openMessageDialog(kind, message));
	}

	/**
	 * Shorthand for running something in a progress monitor.
	 * When using `fork=true`, make sure to move all display-access out of the
	 * runnable or use Display.syncExec or Display.asyncExec for those.
	 * 
	 * @see #openMessageDialogSafe(int, String)
	 */
	public boolean runInProgressMonitor(Shell shell, boolean fork, boolean cancel, IRunnableWithProgress runnable) {
		try {
			shell = shell == null ? Display.getDefault().getActiveShell() : shell;
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(shell);
			progressMonitorDialog.run(fork, cancel, runnable);
			/*
			 * XXX maybe create another anonymous runnable within this method that runs the 
			 * given runnable in Display.asyncExec? This might handle all the problems with
			 * illegal thread access, but I'm not sure that this is a good idea in general.
			 * Seems like this can freeze Eclipse even worse than not forking at all...
			 */
//			progressMonitorDialog.run(fork, cancel, (IProgressMonitor monitor) -> {
//				Display.getDefault().asyncExec(() -> {
//					try {
//						runnable.run(monitor);
//					} catch (InvocationTargetException | InterruptedException e) {
//						e.printStackTrace();
//					}
//				});
//			});
			return true;
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Get Selected Element from viewer, if it has the given type, else null.
	 * @param <T>
	 * @param viewer	viewer to get element from
	 * @param clazz		class required for element
	 * @return			selected element of type T or null
	 */
	@SuppressWarnings("unchecked")
	public <T> T getSelected(Viewer viewer, Class<T> clazz) {
		Object element = getSelectedElement(viewer);
		if (clazz.isInstance(element)) {
			return (T) element;
		}
		return null;
	}

	/**
	 * Get active editor part of given class, or null
	 * 
	 * @param editorClass		the required editor class
	 * @return					active editor of that class, or null
	 */
	@SuppressWarnings("unchecked")
	public <T> T getActiveEditor(Class<T> editorClass) {
		IWorkbenchPage wp = getViewSite().getWorkbenchWindow().getActivePage();
		if (wp != null && editorClass.isInstance(wp.getActiveEditor())) {
			return (T) wp.getActiveEditor();
		}
		return null;
	}
	
//	/**
//	 * This is a callback that will allow us to create the viewer and initialize it.
//	 */
//	@Override
//	public void createPartControl(Composite composite) {
//		// Create the Viewer
//		if (viewer != null) {
//			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
//				public void selectionChanged(SelectionChangedEvent event) {
//					performSelectionChanged(event.getSelection());
//				}
//			});
//			viewer.addDoubleClickListener(new IDoubleClickListener() {
//				public void doubleClick(DoubleClickEvent event) {
//					performDoubleClick();
//				}
//			});
//		}
//		makeActions();
//	}
//	
//	/**
//	 * Called on changing the selection in the viewer
//	 */
//	protected abstract void performSelectionChanged(ISelection selection);
//	
//	/**
//	 * Called on double-clicking an item in the viewer
//	 */
//	protected abstract void performDoubleClick();
//	
//	/**
//	 * creates the Action objects
//	 * implementers should also call the methods contributeToActionBars and hookContextMenu,
//	 * according to which actions should be placed where, and updateActionEnablement
//	 */
//	protected abstract void makeActions();

}