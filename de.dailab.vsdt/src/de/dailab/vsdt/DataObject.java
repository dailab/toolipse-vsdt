/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.DataObject#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.dailab.vsdt.DataObject#isRequiredForStart <em>Required For Start</em>}</li>
 *   <li>{@link de.dailab.vsdt.DataObject#isProducedAtCompletion <em>Produced At Completion</em>}</li>
 *   <li>{@link de.dailab.vsdt.DataObject#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getDataObject()
 * @model
 * @generated
 */
public interface DataObject extends Artifact {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getDataObject_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Required For Start</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required For Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required For Start</em>' attribute.
	 * @see #setRequiredForStart(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getDataObject_RequiredForStart()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isRequiredForStart();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.DataObject#isRequiredForStart <em>Required For Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required For Start</em>' attribute.
	 * @see #isRequiredForStart()
	 * @generated
	 */
	void setRequiredForStart(boolean value);

	/**
	 * Returns the value of the '<em><b>Produced At Completion</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produced At Completion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produced At Completion</em>' attribute.
	 * @see #setProducedAtCompletion(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getDataObject_ProducedAtCompletion()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isProducedAtCompletion();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.DataObject#isProducedAtCompletion <em>Produced At Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Produced At Completion</em>' attribute.
	 * @see #isProducedAtCompletion()
	 * @generated
	 */
	void setProducedAtCompletion(boolean value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see #setState(String)
	 * @see de.dailab.vsdt.VsdtPackage#getDataObject_State()
	 * @model
	 * @generated
	 */
	String getState();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.DataObject#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see #getState()
	 * @generated
	 */
	void setState(String value);

} // DataObject
