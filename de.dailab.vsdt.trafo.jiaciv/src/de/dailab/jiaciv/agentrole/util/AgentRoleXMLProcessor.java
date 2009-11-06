/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.dailab.jiaciv.agentrole.AgentRolePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AgentRoleXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentRoleXMLProcessor() {
		super(new EPackageRegistryImpl(EPackage.Registry.INSTANCE));
		extendedMetaData.putPackage(null, AgentRolePackage.eINSTANCE);
	}
	
	/**
	 * Register for "*" and "xml" file extensions the AgentRoleResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new AgentRoleResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new AgentRoleResourceFactoryImpl());
		}
		return registrations;
	}

} //AgentRoleXMLProcessor
