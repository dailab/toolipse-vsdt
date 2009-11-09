/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCorrelation With Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationWithPattern()
 * @model extendedMetaData="name='tCorrelationWithPattern' kind='elementOnly'"
 * @generated
 */
public interface TCorrelationWithPattern extends TCorrelation {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * The default value is <code>"in"</code>.
	 * The literals are from the enumeration {@link org.xmlsoap.schemas.ws._2003._03.business.process.PatternType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PatternType
	 * @see #isSetPattern()
	 * @see #unsetPattern()
	 * @see #setPattern(PatternType)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationWithPattern_Pattern()
	 * @model default="in" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='pattern'"
	 * @generated
	 */
	PatternType getPattern();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PatternType
	 * @see #isSetPattern()
	 * @see #unsetPattern()
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(PatternType value);

	/**
	 * Unsets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPattern()
	 * @see #getPattern()
	 * @see #setPattern(PatternType)
	 * @generated
	 */
	void unsetPattern();

	/**
	 * Returns whether the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern#getPattern <em>Pattern</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Pattern</em>' attribute is set.
	 * @see #unsetPattern()
	 * @see #getPattern()
	 * @see #setPattern(PatternType)
	 * @generated
	 */
	boolean isSetPattern();

} // TCorrelationWithPattern