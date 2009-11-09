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
import org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TPartner Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinkImpl#getMyRole <em>My Role</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinkImpl#getPartnerLinkType <em>Partner Link Type</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinkImpl#getPartnerRole <em>Partner Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TPartnerLinkImpl extends TExtensibleElementsImpl implements TPartnerLink {
	/**
	 * The default value of the '{@link #getMyRole() <em>My Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyRole()
	 * @generated
	 * @ordered
	 */
	protected static final String MY_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMyRole() <em>My Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyRole()
	 * @generated
	 * @ordered
	 */
	protected String myRole = MY_ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartnerLinkType() <em>Partner Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLinkType()
	 * @generated
	 * @ordered
	 */
	protected static final QName PARTNER_LINK_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartnerLinkType() <em>Partner Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLinkType()
	 * @generated
	 * @ordered
	 */
	protected QName partnerLinkType = PARTNER_LINK_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartnerRole() <em>Partner Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerRole()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTNER_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartnerRole() <em>Partner Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerRole()
	 * @generated
	 * @ordered
	 */
	protected String partnerRole = PARTNER_ROLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TPartnerLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TPARTNER_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMyRole() {
		return myRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMyRole(String newMyRole) {
		String oldMyRole = myRole;
		myRole = newMyRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TPARTNER_LINK__MY_ROLE, oldMyRole, myRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TPARTNER_LINK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getPartnerLinkType() {
		return partnerLinkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartnerLinkType(QName newPartnerLinkType) {
		QName oldPartnerLinkType = partnerLinkType;
		partnerLinkType = newPartnerLinkType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TPARTNER_LINK__PARTNER_LINK_TYPE, oldPartnerLinkType, partnerLinkType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartnerRole() {
		return partnerRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartnerRole(String newPartnerRole) {
		String oldPartnerRole = partnerRole;
		partnerRole = newPartnerRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TPARTNER_LINK__PARTNER_ROLE, oldPartnerRole, partnerRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcessPackage.TPARTNER_LINK__MY_ROLE:
				return getMyRole();
			case ProcessPackage.TPARTNER_LINK__NAME:
				return getName();
			case ProcessPackage.TPARTNER_LINK__PARTNER_LINK_TYPE:
				return getPartnerLinkType();
			case ProcessPackage.TPARTNER_LINK__PARTNER_ROLE:
				return getPartnerRole();
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
			case ProcessPackage.TPARTNER_LINK__MY_ROLE:
				setMyRole((String)newValue);
				return;
			case ProcessPackage.TPARTNER_LINK__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.TPARTNER_LINK__PARTNER_LINK_TYPE:
				setPartnerLinkType((QName)newValue);
				return;
			case ProcessPackage.TPARTNER_LINK__PARTNER_ROLE:
				setPartnerRole((String)newValue);
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
			case ProcessPackage.TPARTNER_LINK__MY_ROLE:
				setMyRole(MY_ROLE_EDEFAULT);
				return;
			case ProcessPackage.TPARTNER_LINK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.TPARTNER_LINK__PARTNER_LINK_TYPE:
				setPartnerLinkType(PARTNER_LINK_TYPE_EDEFAULT);
				return;
			case ProcessPackage.TPARTNER_LINK__PARTNER_ROLE:
				setPartnerRole(PARTNER_ROLE_EDEFAULT);
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
			case ProcessPackage.TPARTNER_LINK__MY_ROLE:
				return MY_ROLE_EDEFAULT == null ? myRole != null : !MY_ROLE_EDEFAULT.equals(myRole);
			case ProcessPackage.TPARTNER_LINK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.TPARTNER_LINK__PARTNER_LINK_TYPE:
				return PARTNER_LINK_TYPE_EDEFAULT == null ? partnerLinkType != null : !PARTNER_LINK_TYPE_EDEFAULT.equals(partnerLinkType);
			case ProcessPackage.TPARTNER_LINK__PARTNER_ROLE:
				return PARTNER_ROLE_EDEFAULT == null ? partnerRole != null : !PARTNER_ROLE_EDEFAULT.equals(partnerRole);
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
		result.append(" (myRole: ");
		result.append(myRole);
		result.append(", name: ");
		result.append(name);
		result.append(", partnerLinkType: ");
		result.append(partnerLinkType);
		result.append(", partnerRole: ");
		result.append(partnerRole);
		result.append(')');
		return result.toString();
	}

} //TPartnerLinkImpl