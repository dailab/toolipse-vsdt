/**
 */
package de.dailab.vsdt.vxl.vxl.impl;

import de.dailab.vsdt.vxl.vxl.VxlConstructor;
import de.dailab.vsdt.vxl.vxl.VxlListElement;
import de.dailab.vsdt.vxl.vxl.VxlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constructor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.impl.VxlConstructorImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.impl.VxlConstructorImpl#isEmpty <em>Empty</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.impl.VxlConstructorImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VxlConstructorImpl extends VxlElementImpl implements VxlConstructor
{
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
   * The default value of the '{@link #isEmpty() <em>Empty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEmpty()
   * @generated
   * @ordered
   */
  protected static final boolean EMPTY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isEmpty() <em>Empty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isEmpty()
   * @generated
   * @ordered
   */
  protected boolean empty = EMPTY_EDEFAULT;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected VxlListElement body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VxlConstructorImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return VxlPackage.Literals.VXL_CONSTRUCTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_CONSTRUCTOR__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isEmpty()
  {
    return empty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmpty(boolean newEmpty)
  {
    boolean oldEmpty = empty;
    empty = newEmpty;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_CONSTRUCTOR__EMPTY, oldEmpty, empty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlListElement getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(VxlListElement newBody, NotificationChain msgs)
  {
    VxlListElement oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_CONSTRUCTOR__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(VxlListElement newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VXL_CONSTRUCTOR__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VXL_CONSTRUCTOR__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_CONSTRUCTOR__BODY, newBody, newBody));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case VxlPackage.VXL_CONSTRUCTOR__BODY:
        return basicSetBody(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case VxlPackage.VXL_CONSTRUCTOR__NAME:
        return getName();
      case VxlPackage.VXL_CONSTRUCTOR__EMPTY:
        return isEmpty();
      case VxlPackage.VXL_CONSTRUCTOR__BODY:
        return getBody();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VxlPackage.VXL_CONSTRUCTOR__NAME:
        setName((String)newValue);
        return;
      case VxlPackage.VXL_CONSTRUCTOR__EMPTY:
        setEmpty((Boolean)newValue);
        return;
      case VxlPackage.VXL_CONSTRUCTOR__BODY:
        setBody((VxlListElement)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case VxlPackage.VXL_CONSTRUCTOR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VxlPackage.VXL_CONSTRUCTOR__EMPTY:
        setEmpty(EMPTY_EDEFAULT);
        return;
      case VxlPackage.VXL_CONSTRUCTOR__BODY:
        setBody((VxlListElement)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case VxlPackage.VXL_CONSTRUCTOR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VxlPackage.VXL_CONSTRUCTOR__EMPTY:
        return empty != EMPTY_EDEFAULT;
      case VxlPackage.VXL_CONSTRUCTOR__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", empty: ");
    result.append(empty);
    result.append(')');
    return result.toString();
  }

} //VxlConstructorImpl
