/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.OutputSet#getOutputs <em>Outputs</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getOutputSet()
 * @model
 * @generated
 */
public interface OutputSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Artifact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getOutputSet_Outputs()
	 * @model required="true"
	 * @generated
	 */
	EList<Artifact> getOutputs();

} // OutputSet
