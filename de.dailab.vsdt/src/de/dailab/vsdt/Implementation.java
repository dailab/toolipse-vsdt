/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.Implementation#getType <em>Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.Implementation#getParticipant <em>Participant</em>}</li>
 *   <li>{@link de.dailab.vsdt.Implementation#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.dailab.vsdt.Implementation#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.dailab.vsdt.Implementation#getDescription <em>Description</em>}</li>
 *   <li>{@link de.dailab.vsdt.Implementation#getLocation <em>Location</em>}</li>
 *   <li>{@link de.dailab.vsdt.Implementation#getInputMessage <em>Input Message</em>}</li>
 *   <li>{@link de.dailab.vsdt.Implementation#getOutputMessage <em>Output Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getImplementation()
 * @model
 * @generated
 */
public interface Implementation extends EObject {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"WebService"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.dailab.vsdt.VsdtPackage#getImplementation_Type()
	 * @model default="WebService" required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Implementation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Participant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant</em>' reference.
	 * @see #setParticipant(Participant)
	 * @see de.dailab.vsdt.VsdtPackage#getImplementation_Participant()
	 * @model required="true"
	 * @generated
	 */
	Participant getParticipant();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Implementation#getParticipant <em>Participant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Participant</em>' reference.
	 * @see #getParticipant()
	 * @generated
	 */
	void setParticipant(Participant value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' attribute.
	 * @see #setInterface(String)
	 * @see de.dailab.vsdt.VsdtPackage#getImplementation_Interface()
	 * @model required="true"
	 * @generated
	 */
	String getInterface();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Implementation#getInterface <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' attribute.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(String value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see de.dailab.vsdt.VsdtPackage#getImplementation_Operation()
	 * @model required="true"
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Implementation#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.dailab.vsdt.VsdtPackage#getImplementation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Implementation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see de.dailab.vsdt.VsdtPackage#getImplementation_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Implementation#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Returns the value of the '<em><b>Input Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Message</em>' reference.
	 * @see #setInputMessage(Message)
	 * @see de.dailab.vsdt.VsdtPackage#getImplementation_InputMessage()
	 * @model
	 * @generated
	 */
	Message getInputMessage();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Implementation#getInputMessage <em>Input Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Message</em>' reference.
	 * @see #getInputMessage()
	 * @generated
	 */
	void setInputMessage(Message value);

	/**
	 * Returns the value of the '<em><b>Output Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Message</em>' reference.
	 * @see #setOutputMessage(Message)
	 * @see de.dailab.vsdt.VsdtPackage#getImplementation_OutputMessage()
	 * @model
	 * @generated
	 */
	Message getOutputMessage();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Implementation#getOutputMessage <em>Output Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Message</em>' reference.
	 * @see #getOutputMessage()
	 * @generated
	 */
	void setOutputMessage(Message value);
} // Implementation
