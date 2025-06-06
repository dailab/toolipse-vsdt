/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.trafo.strucbpmn.util.StrucBpmnResourceImpl
 * @generated
 */
public class StrucBpmnResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrucBpmnResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		Resource result = new StrucBpmnResourceImpl(uri);
		return result;
	}

} //StrucBpmnResourceFactoryImpl
