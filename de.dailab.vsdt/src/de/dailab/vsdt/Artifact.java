/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.Artifact#getParentDiagram <em>Parent Diagram</em>}</li>
 *   <li>{@link de.dailab.vsdt.Artifact#getPool <em>Pool</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getArtifact()
 * @model abstract="true"
 * @generated
 */
public interface Artifact extends GraphicalObject {
	/**
	 * Returns the value of the '<em><b>Parent Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.BusinessProcessDiagram#getArtifacts <em>Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Diagram</em>' container reference.
	 * @see #setParentDiagram(BusinessProcessDiagram)
	 * @see de.dailab.vsdt.VsdtPackage#getArtifact_ParentDiagram()
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getArtifacts
	 * @model opposite="artifacts" required="true" transient="false"
	 * @generated
	 */
	BusinessProcessDiagram getParentDiagram();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Artifact#getParentDiagram <em>Parent Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Diagram</em>' container reference.
	 * @see #getParentDiagram()
	 * @generated
	 */
	void setParentDiagram(BusinessProcessDiagram value);

	/**
	 * Returns the value of the '<em><b>Pool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pool</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pool</em>' reference.
	 * @see #setPool(Pool)
	 * @see de.dailab.vsdt.VsdtPackage#getArtifact_Pool()
	 * @model
	 * @generated
	 */
	Pool getPool();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Artifact#getPool <em>Pool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pool</em>' reference.
	 * @see #getPool()
	 * @generated
	 */
	void setPool(Pool value);

} // Artifact
