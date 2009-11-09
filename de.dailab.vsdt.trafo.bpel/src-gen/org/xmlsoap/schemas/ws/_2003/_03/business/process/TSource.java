/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TSource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource#getLinkName <em>Link Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource#getTransitionCondition <em>Transition Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSource()
 * @model extendedMetaData="name='tSource' kind='elementOnly'"
 * @generated
 */
public interface TSource extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Link Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Name</em>' attribute.
	 * @see #setLinkName(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSource_LinkName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='linkName'"
	 * @generated
	 */
	String getLinkName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource#getLinkName <em>Link Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link Name</em>' attribute.
	 * @see #getLinkName()
	 * @generated
	 */
	void setLinkName(String value);

	/**
	 * Returns the value of the '<em><b>Transition Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition Condition</em>' attribute.
	 * @see #setTransitionCondition(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSource_TransitionCondition()
	 * @model unique="false" dataType="org.xmlsoap.schemas.ws._2003._03.business.process.TBooleanExpr"
	 *        extendedMetaData="kind='attribute' name='transitionCondition'"
	 * @generated
	 */
	String getTransitionCondition();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource#getTransitionCondition <em>Transition Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition Condition</em>' attribute.
	 * @see #getTransitionCondition()
	 * @generated
	 */
	void setTransitionCondition(String value);

} // TSource