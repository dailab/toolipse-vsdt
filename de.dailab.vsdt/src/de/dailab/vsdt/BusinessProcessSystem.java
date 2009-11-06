/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Process System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getVersion <em>Version</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getAuthor <em>Author</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getLanguage <em>Language</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getQueryLanguage <em>Query Language</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getModificationDate <em>Modification Date</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getBusinessProcesses <em>Business Processes</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getParticipants <em>Participants</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getMessages <em>Messages</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessSystem#getImplementations <em>Implementations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem()
 * @model
 * @generated
 */
public interface BusinessProcessSystem extends IdObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BusinessProcessSystem#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BusinessProcessSystem#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_Language()
	 * @model
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BusinessProcessSystem#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Language</em>' attribute.
	 * @see #setExpressionLanguage(String)
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_ExpressionLanguage()
	 * @model
	 * @generated
	 */
	String getExpressionLanguage();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BusinessProcessSystem#getExpressionLanguage <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Language</em>' attribute.
	 * @see #getExpressionLanguage()
	 * @generated
	 */
	void setExpressionLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Query Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Language</em>' attribute.
	 * @see #setQueryLanguage(String)
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_QueryLanguage()
	 * @model
	 * @generated
	 */
	String getQueryLanguage();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BusinessProcessSystem#getQueryLanguage <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Language</em>' attribute.
	 * @see #getQueryLanguage()
	 * @generated
	 */
	void setQueryLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_CreationDate()
	 * @model
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BusinessProcessSystem#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Modification Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modification Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modification Date</em>' attribute.
	 * @see #setModificationDate(Date)
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_ModificationDate()
	 * @model
	 * @generated
	 */
	Date getModificationDate();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BusinessProcessSystem#getModificationDate <em>Modification Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modification Date</em>' attribute.
	 * @see #getModificationDate()
	 * @generated
	 */
	void setModificationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Business Processes</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.BusinessProcessDiagram}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.BusinessProcessDiagram#getBusinessProcessSystem <em>Business Process System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Business Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Business Processes</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_BusinessProcesses()
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getBusinessProcessSystem
	 * @model opposite="businessProcessSystem" containment="true"
	 * @generated
	 */
	EList<BusinessProcessDiagram> getBusinessProcesses();

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Participant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_Participants()
	 * @model containment="true"
	 * @generated
	 */
	EList<Participant> getParticipants();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_Messages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Message> getMessages();

	/**
	 * Returns the value of the '<em><b>Implementations</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Implementation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementations</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessSystem_Implementations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Implementation> getImplementations();

} // BusinessProcessSystem
