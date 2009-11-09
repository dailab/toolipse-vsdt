/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TActivity Or Compensate Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getEmpty <em>Empty</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getReceive <em>Receive</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getReply <em>Reply</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getWait <em>Wait</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getThrow <em>Throw</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getTerminate <em>Terminate</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getWhile <em>While</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getPick <em>Pick</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getScope <em>Scope</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getCompensate <em>Compensate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer()
 * @model extendedMetaData="name='tActivityOrCompensateContainer' kind='elementOnly'"
 * @generated
 */
public interface TActivityOrCompensateContainer extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Empty</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Empty</em>' containment reference.
	 * @see #setEmpty(TEmpty)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Empty()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='empty' namespace='##targetNamespace'"
	 * @generated
	 */
	TEmpty getEmpty();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getEmpty <em>Empty</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Empty</em>' containment reference.
	 * @see #getEmpty()
	 * @generated
	 */
	void setEmpty(TEmpty value);

	/**
	 * Returns the value of the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invoke</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invoke</em>' containment reference.
	 * @see #setInvoke(TInvoke)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Invoke()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='invoke' namespace='##targetNamespace'"
	 * @generated
	 */
	TInvoke getInvoke();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getInvoke <em>Invoke</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invoke</em>' containment reference.
	 * @see #getInvoke()
	 * @generated
	 */
	void setInvoke(TInvoke value);

	/**
	 * Returns the value of the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receive</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receive</em>' containment reference.
	 * @see #setReceive(TReceive)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Receive()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='receive' namespace='##targetNamespace'"
	 * @generated
	 */
	TReceive getReceive();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getReceive <em>Receive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receive</em>' containment reference.
	 * @see #getReceive()
	 * @generated
	 */
	void setReceive(TReceive value);

	/**
	 * Returns the value of the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reply</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reply</em>' containment reference.
	 * @see #setReply(TReply)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Reply()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='reply' namespace='##targetNamespace'"
	 * @generated
	 */
	TReply getReply();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getReply <em>Reply</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reply</em>' containment reference.
	 * @see #getReply()
	 * @generated
	 */
	void setReply(TReply value);

	/**
	 * Returns the value of the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assign</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assign</em>' containment reference.
	 * @see #setAssign(TAssign)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Assign()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='assign' namespace='##targetNamespace'"
	 * @generated
	 */
	TAssign getAssign();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getAssign <em>Assign</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assign</em>' containment reference.
	 * @see #getAssign()
	 * @generated
	 */
	void setAssign(TAssign value);

	/**
	 * Returns the value of the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait</em>' containment reference.
	 * @see #setWait(TWait)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Wait()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='wait' namespace='##targetNamespace'"
	 * @generated
	 */
	TWait getWait();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getWait <em>Wait</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait</em>' containment reference.
	 * @see #getWait()
	 * @generated
	 */
	void setWait(TWait value);

	/**
	 * Returns the value of the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throw</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throw</em>' containment reference.
	 * @see #setThrow(TThrow)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Throw()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='throw' namespace='##targetNamespace'"
	 * @generated
	 */
	TThrow getThrow();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getThrow <em>Throw</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Throw</em>' containment reference.
	 * @see #getThrow()
	 * @generated
	 */
	void setThrow(TThrow value);

	/**
	 * Returns the value of the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terminate</em>' containment reference.
	 * @see #setTerminate(TTerminate)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Terminate()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='terminate' namespace='##targetNamespace'"
	 * @generated
	 */
	TTerminate getTerminate();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getTerminate <em>Terminate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Terminate</em>' containment reference.
	 * @see #getTerminate()
	 * @generated
	 */
	void setTerminate(TTerminate value);

	/**
	 * Returns the value of the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow</em>' containment reference.
	 * @see #setFlow(TFlow)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Flow()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='flow' namespace='##targetNamespace'"
	 * @generated
	 */
	TFlow getFlow();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getFlow <em>Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flow</em>' containment reference.
	 * @see #getFlow()
	 * @generated
	 */
	void setFlow(TFlow value);

	/**
	 * Returns the value of the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch</em>' containment reference.
	 * @see #setSwitch(TSwitch)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Switch()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='switch' namespace='##targetNamespace'"
	 * @generated
	 */
	TSwitch getSwitch();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getSwitch <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch</em>' containment reference.
	 * @see #getSwitch()
	 * @generated
	 */
	void setSwitch(TSwitch value);

	/**
	 * Returns the value of the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>While</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>While</em>' containment reference.
	 * @see #setWhile(TWhile)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_While()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='while' namespace='##targetNamespace'"
	 * @generated
	 */
	TWhile getWhile();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getWhile <em>While</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>While</em>' containment reference.
	 * @see #getWhile()
	 * @generated
	 */
	void setWhile(TWhile value);

	/**
	 * Returns the value of the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence</em>' containment reference.
	 * @see #setSequence(TSequence)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Sequence()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='sequence' namespace='##targetNamespace'"
	 * @generated
	 */
	TSequence getSequence();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getSequence <em>Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence</em>' containment reference.
	 * @see #getSequence()
	 * @generated
	 */
	void setSequence(TSequence value);

	/**
	 * Returns the value of the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pick</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pick</em>' containment reference.
	 * @see #setPick(TPick)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Pick()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='pick' namespace='##targetNamespace'"
	 * @generated
	 */
	TPick getPick();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getPick <em>Pick</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pick</em>' containment reference.
	 * @see #getPick()
	 * @generated
	 */
	void setPick(TPick value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' containment reference.
	 * @see #setScope(TScope)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Scope()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='scope' namespace='##targetNamespace'"
	 * @generated
	 */
	TScope getScope();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getScope <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' containment reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(TScope value);

	/**
	 * Returns the value of the '<em><b>Compensate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compensate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compensate</em>' containment reference.
	 * @see #setCompensate(TCompensate)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivityOrCompensateContainer_Compensate()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='compensate' namespace='##targetNamespace'"
	 * @generated
	 */
	TCompensate getCompensate();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getCompensate <em>Compensate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compensate</em>' containment reference.
	 * @see #getCompensate()
	 * @generated
	 */
	void setCompensate(TCompensate value);
	

	/**
	 * @param tActivity	some concrete activity
	 * @return			the list for the given activity
	 * @generated NOT
	 */
	public void setActivity(TActivity tActivity);

} // TActivityOrCompensateContainer