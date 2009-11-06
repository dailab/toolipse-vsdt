/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connecting Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.ConnectingObject#getParentDiagram <em>Parent Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getConnectingObject()
 * @model abstract="true"
 * @generated
 */
public interface ConnectingObject extends GraphicalObject {
	/**
	 * Returns the value of the '<em><b>Parent Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.BusinessProcessDiagram#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Diagram</em>' container reference.
	 * @see #setParentDiagram(BusinessProcessDiagram)
	 * @see de.dailab.vsdt.VsdtPackage#getConnectingObject_ParentDiagram()
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getConnections
	 * @model opposite="connections" required="true" transient="false"
	 * @generated
	 */
	BusinessProcessDiagram getParentDiagram();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.ConnectingObject#getParentDiagram <em>Parent Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Diagram</em>' container reference.
	 * @see #getParentDiagram()
	 * @generated
	 */
	void setParentDiagram(BusinessProcessDiagram value);

} // ConnectingObject
