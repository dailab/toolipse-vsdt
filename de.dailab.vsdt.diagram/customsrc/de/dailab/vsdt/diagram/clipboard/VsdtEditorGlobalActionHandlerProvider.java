package de.dailab.vsdt.diagram.clipboard;

import java.util.Hashtable;

import org.eclipse.gmf.runtime.common.ui.services.action.global.AbstractGlobalActionHandlerProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerContext;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @see https://esalagea.wordpress.com/2011/04/13/lets-solve-once-for-all-the-gmf-copy-paste-problem-and-then-forget-about-it/
 * 
 * @author kuester
 */
public final class VsdtEditorGlobalActionHandlerProvider
		extends AbstractGlobalActionHandlerProvider {

	/** List for handlers. */
	private Hashtable<IWorkbenchPart, VsdtEditorClipboardSupportGlobalActionHandler> handlerList = new Hashtable<>();

	/**
	 * Creates a new instance.
	 */
	public VsdtEditorGlobalActionHandlerProvider() {
		super();
	}

	/**
	 * Returns a global action handler that supports global image operations
	 * (cut, copy, and paste).
	 */
	public IGlobalActionHandler getGlobalActionHandler(IGlobalActionHandlerContext context) {
		// Create the handler
		if (! handlerList.containsKey(context.getActivePart())) {
			handlerList.put(context.getActivePart(),
					new VsdtEditorClipboardSupportGlobalActionHandler());
			 
		    /*
			 * Register as a part listener so that the cache can be cleared when
			 * the part is disposed
			 */
			IPartListener listener = new IPartListener() {
				private IWorkbenchPart localPart = context.getActivePart();
				@Override
				public void partActivated(IWorkbenchPart part) {
					// Do nothing
				}
				@Override
				public void partBroughtToTop(IWorkbenchPart part) {
					// Do nothing
				}
				@Override
				public void partClosed(IWorkbenchPart part) {
					// Remove the cache associated with the part
					if (part != null && part == localPart && handlerList.containsKey(part)) {
						handlerList.remove(part);
						localPart.getSite().getPage().removePartListener(this);
						localPart = null;
					}
				}
				@Override
				public void partDeactivated(IWorkbenchPart part) {
					// Do nothing
				}
				@Override
				public void partOpened(IWorkbenchPart part) {
					// Do nothing
				}
			};
			context.getActivePart().getSite().getPage().addPartListener(listener);
		}
		return handlerList.get(context.getActivePart());
	}

}
