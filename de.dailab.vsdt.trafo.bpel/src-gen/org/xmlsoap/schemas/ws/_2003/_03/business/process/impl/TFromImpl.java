/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFrom;
import org.xmlsoap.schemas.ws._2003._03.business.process.TRoles;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TFrom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl#getEndpointReference <em>Endpoint Reference</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl#getOpaque <em>Opaque</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TFromImpl extends TExtensibleElementsImpl implements TFrom {
	/**
	 * The default value of the '{@link #getEndpointReference() <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointReference()
	 * @generated
	 * @ordered
	 */
	protected static final TRoles ENDPOINT_REFERENCE_EDEFAULT = TRoles.MY_ROLE;

	/**
	 * The cached value of the '{@link #getEndpointReference() <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointReference()
	 * @generated
	 * @ordered
	 */
	protected TRoles endpointReference = ENDPOINT_REFERENCE_EDEFAULT;

	/**
	 * This is true if the Endpoint Reference attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean endpointReferenceESet;

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOpaque() <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpaque()
	 * @generated
	 * @ordered
	 */
	protected static final TBoolean OPAQUE_EDEFAULT = TBoolean.YES;

	/**
	 * The cached value of the '{@link #getOpaque() <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpaque()
	 * @generated
	 * @ordered
	 */
	protected TBoolean opaque = OPAQUE_EDEFAULT;

	/**
	 * This is true if the Opaque attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean opaqueESet;

	/**
	 * The default value of the '{@link #getPart() <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected static final String PART_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected String part = PART_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartnerLink() <em>Partner Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTNER_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartnerLink() <em>Partner Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected String partnerLink = PARTNER_LINK_EDEFAULT;

	/**
	 * The default value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected static final QName PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected QName property = PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected String query = QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariable() <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected String variable = VARIABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TFromImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TFROM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TRoles getEndpointReference() {
		return endpointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointReference(TRoles newEndpointReference) {
		TRoles oldEndpointReference = endpointReference;
		endpointReference = newEndpointReference == null ? ENDPOINT_REFERENCE_EDEFAULT : newEndpointReference;
		boolean oldEndpointReferenceESet = endpointReferenceESet;
		endpointReferenceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFROM__ENDPOINT_REFERENCE, oldEndpointReference, endpointReference, !oldEndpointReferenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEndpointReference() {
		TRoles oldEndpointReference = endpointReference;
		boolean oldEndpointReferenceESet = endpointReferenceESet;
		endpointReference = ENDPOINT_REFERENCE_EDEFAULT;
		endpointReferenceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ProcessPackage.TFROM__ENDPOINT_REFERENCE, oldEndpointReference, ENDPOINT_REFERENCE_EDEFAULT, oldEndpointReferenceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEndpointReference() {
		return endpointReferenceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFROM__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBoolean getOpaque() {
		return opaque;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpaque(TBoolean newOpaque) {
		TBoolean oldOpaque = opaque;
		opaque = newOpaque == null ? OPAQUE_EDEFAULT : newOpaque;
		boolean oldOpaqueESet = opaqueESet;
		opaqueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFROM__OPAQUE, oldOpaque, opaque, !oldOpaqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOpaque() {
		TBoolean oldOpaque = opaque;
		boolean oldOpaqueESet = opaqueESet;
		opaque = OPAQUE_EDEFAULT;
		opaqueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ProcessPackage.TFROM__OPAQUE, oldOpaque, OPAQUE_EDEFAULT, oldOpaqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOpaque() {
		return opaqueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPart() {
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPart(String newPart) {
		String oldPart = part;
		part = newPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFROM__PART, oldPart, part));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartnerLink() {
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartnerLink(String newPartnerLink) {
		String oldPartnerLink = partnerLink;
		partnerLink = newPartnerLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFROM__PARTNER_LINK, oldPartnerLink, partnerLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(QName newProperty) {
		QName oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFROM__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(String newQuery) {
		String oldQuery = query;
		query = newQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFROM__QUERY, oldQuery, query));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(String newVariable) {
		String oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFROM__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcessPackage.TFROM__ENDPOINT_REFERENCE:
				return getEndpointReference();
			case ProcessPackage.TFROM__EXPRESSION:
				return getExpression();
			case ProcessPackage.TFROM__OPAQUE:
				return getOpaque();
			case ProcessPackage.TFROM__PART:
				return getPart();
			case ProcessPackage.TFROM__PARTNER_LINK:
				return getPartnerLink();
			case ProcessPackage.TFROM__PROPERTY:
				return getProperty();
			case ProcessPackage.TFROM__QUERY:
				return getQuery();
			case ProcessPackage.TFROM__VARIABLE:
				return getVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProcessPackage.TFROM__ENDPOINT_REFERENCE:
				setEndpointReference((TRoles)newValue);
				return;
			case ProcessPackage.TFROM__EXPRESSION:
				setExpression((String)newValue);
				return;
			case ProcessPackage.TFROM__OPAQUE:
				setOpaque((TBoolean)newValue);
				return;
			case ProcessPackage.TFROM__PART:
				setPart((String)newValue);
				return;
			case ProcessPackage.TFROM__PARTNER_LINK:
				setPartnerLink((String)newValue);
				return;
			case ProcessPackage.TFROM__PROPERTY:
				setProperty((QName)newValue);
				return;
			case ProcessPackage.TFROM__QUERY:
				setQuery((String)newValue);
				return;
			case ProcessPackage.TFROM__VARIABLE:
				setVariable((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProcessPackage.TFROM__ENDPOINT_REFERENCE:
				unsetEndpointReference();
				return;
			case ProcessPackage.TFROM__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case ProcessPackage.TFROM__OPAQUE:
				unsetOpaque();
				return;
			case ProcessPackage.TFROM__PART:
				setPart(PART_EDEFAULT);
				return;
			case ProcessPackage.TFROM__PARTNER_LINK:
				setPartnerLink(PARTNER_LINK_EDEFAULT);
				return;
			case ProcessPackage.TFROM__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case ProcessPackage.TFROM__QUERY:
				setQuery(QUERY_EDEFAULT);
				return;
			case ProcessPackage.TFROM__VARIABLE:
				setVariable(VARIABLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProcessPackage.TFROM__ENDPOINT_REFERENCE:
				return isSetEndpointReference();
			case ProcessPackage.TFROM__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case ProcessPackage.TFROM__OPAQUE:
				return isSetOpaque();
			case ProcessPackage.TFROM__PART:
				return PART_EDEFAULT == null ? part != null : !PART_EDEFAULT.equals(part);
			case ProcessPackage.TFROM__PARTNER_LINK:
				return PARTNER_LINK_EDEFAULT == null ? partnerLink != null : !PARTNER_LINK_EDEFAULT.equals(partnerLink);
			case ProcessPackage.TFROM__PROPERTY:
				return PROPERTY_EDEFAULT == null ? property != null : !PROPERTY_EDEFAULT.equals(property);
			case ProcessPackage.TFROM__QUERY:
				return QUERY_EDEFAULT == null ? query != null : !QUERY_EDEFAULT.equals(query);
			case ProcessPackage.TFROM__VARIABLE:
				return VARIABLE_EDEFAULT == null ? variable != null : !VARIABLE_EDEFAULT.equals(variable);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (endpointReference: ");
		if (endpointReferenceESet) result.append(endpointReference); else result.append("<unset>");
		result.append(", expression: ");
		result.append(expression);
		result.append(", opaque: ");
		if (opaqueESet) result.append(opaque); else result.append("<unset>");
		result.append(", part: ");
		result.append(part);
		result.append(", partnerLink: ");
		result.append(partnerLink);
		result.append(", property: ");
		result.append(property);
		result.append(", query: ");
		result.append(query);
		result.append(", variable: ");
		result.append(variable);
		result.append(')');
		return result.toString();
	}

} //TFromImpl