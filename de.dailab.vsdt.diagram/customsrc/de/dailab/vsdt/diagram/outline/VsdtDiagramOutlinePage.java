/***********************************************************************
 * Copyright (c) 2007, 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EcoreDiagramOutlinePage.java,v 1.4 2008/04/28 15:23:59 jlescot Exp $
 **********************************************************************/

package de.dailab.vsdt.diagram.outline;


/**
 * A customized outline page for rendering both a Thumbnail view of the editor
 * and/or a tree structure of the underlying model
 * 
 * To be used in VsdtDiagramEditor.getAdapter
 * Depends on org.eclipse.gmf.runtime.diagram.ui.outline
 * 
 * XXX Problems with Eclipse 3.4 ?
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 * @generated NOT
 */
public class VsdtDiagramOutlinePage {//extends AbstractDiagramsOutlinePage {

//	/**
//	 * Constructor
//	 * 
//	 * @param editor
//	 *            the Editor
//	 */
//	public VsdtDiagramOutlinePage(DiagramEditor editor) {
//		super(editor);
//	}
//
//	/**
//	 * @see org.eclipse.gmf.runtime.diagram.ui.outline.AbstractDiagramsOutlinePage#createNavigator(org.eclipse.swt.widgets.Composite,
//	 *      org.eclipse.ui.part.IPageSite)
//	 */
//	@Override
//	protected AbstractModelNavigator createNavigator(Composite parent, IPageSite pageSite) {
//		return new VsdtModelNavigator(parent, getEditor(), pageSite);
//	}
//
//	/**
//	 * @see org.eclipse.gmf.runtime.diagram.ui.outline.AbstractDiagramsOutlinePage#getPreferenceStore()
//	 */
//	@Override
//	protected IPreferenceStore getPreferenceStore() {
//		return VsdtDiagramEditorPlugin.getInstance().getPreferenceStore();
//	}
//
//	/**
//	 * @see org.eclipse.gmf.runtime.diagram.ui.outline.AbstractDiagramsOutlinePage#getEditorID()
//	 */
//	@Override
//	protected String getEditorID() {
//		return de.dailab.vsdt.diagram.part.VsdtDiagramEditor.ID;
//	}
}
