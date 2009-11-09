/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TSequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getEmpty <em>Empty</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getReceive <em>Receive</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getReply <em>Reply</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getWait <em>Wait</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getThrow <em>Throw</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getTerminate <em>Terminate</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getWhile <em>While</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getPick <em>Pick</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence()
 * @model extendedMetaData="name='tSequence' kind='elementOnly'"
 * @generated
 */
public interface TSequence extends TActivity {
	/**
	 * Returns the value of the '<em><b>Activity</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' attribute list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Activity()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='Activity:7'"
	 * @generated
	 */
	FeatureMap getActivity();

	/**
	 * Returns the value of the '<em><b>Empty</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Empty</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Empty</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Empty()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='empty' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TEmpty> getEmpty();

	/**
	 * Returns the value of the '<em><b>Invoke</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invoke</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invoke</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Invoke()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='invoke' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TInvoke> getInvoke();

	/**
	 * Returns the value of the '<em><b>Receive</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Receive()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='receive' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TReceive> getReceive();

	/**
	 * Returns the value of the '<em><b>Reply</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reply</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reply</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Reply()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='reply' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TReply> getReply();

	/**
	 * Returns the value of the '<em><b>Assign</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TAssign}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assign</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assign</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Assign()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='assign' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TAssign> getAssign();

	/**
	 * Returns the value of the '<em><b>Wait</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Wait()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='wait' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TWait> getWait();

	/**
	 * Returns the value of the '<em><b>Throw</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TThrow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throw</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throw</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Throw()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='throw' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TThrow> getThrow();

	/**
	 * Returns the value of the '<em><b>Terminate</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TTerminate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminate</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Terminate()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='terminate' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TTerminate> getTerminate();

	/**
	 * Returns the value of the '<em><b>Flow</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Flow()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='flow' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TFlow> getFlow();

	/**
	 * Returns the value of the '<em><b>Switch</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Switch()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='switch' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TSwitch> getSwitch();

	/**
	 * Returns the value of the '<em><b>While</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>While</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>While</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_While()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='while' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TWhile> getWhile();

	/**
	 * Returns the value of the '<em><b>Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Sequence()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='sequence' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TSequence> getSequence();

	/**
	 * Returns the value of the '<em><b>Pick</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pick</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pick</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Pick()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='pick' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TPick> getPick();

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSequence_Scope()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='scope' namespace='##targetNamespace' group='#Activity:7'"
	 * @generated
	 */
	EList<TScope> getScope();

	/**
	 * @param tActivity	some concrete activity
	 * @return			the list for the given activity
	 * @generated NOT
	 */
	List getActivityList(TActivity tActivity);
	
	/**
	 * @param tActivity	add the given Activity to the respective list
	 * @generated NOT
	 */
	void addActivity(TActivity tActivity);

	/**
	 * @param tActivity	some concrete activity
	 * @return			the list for the given activity
	 * @generated NOT
	 */
	void addActivity(int index, TActivity tActivity);
	
	/**
	 * @param activity	some activity of that sequence
	 * @return			the index of that activity
	 * @generated NOT
	 */
	int getActivityIndex(TActivity activity);
	
} // TSequence