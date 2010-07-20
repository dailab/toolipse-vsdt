/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl.impl;

import de.dailab.vsdt.vxl.vxl.Accessor;
import de.dailab.vsdt.vxl.vxl.Variable;
import de.dailab.vsdt.vxl.vxl.VxlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.impl.VariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.impl.VariableImpl#getAccessor <em>Accessor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends AtomImpl implements Variable
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
   * The cached value of the '{@link #getAccessor() <em>Accessor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessor()
   * @generated
   * @ordered
   */
  protected Accessor accessor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableImpl()
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
    return VxlPackage.Literals.VARIABLE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, VxlPackage.VARIABLE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Accessor getAccessor()
  {
    return accessor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccessor(Accessor newAccessor, NotificationChain msgs)
  {
    Accessor oldAccessor = accessor;
    accessor = newAccessor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VxlPackage.VARIABLE__ACCESSOR, oldAccessor, newAccessor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccessor(Accessor newAccessor)
  {
    if (newAccessor != accessor)
    {
      NotificationChain msgs = null;
      if (accessor != null)
        msgs = ((InternalEObject)accessor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VARIABLE__ACCESSOR, null, msgs);
      if (newAccessor != null)
        msgs = ((InternalEObject)newAccessor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VARIABLE__ACCESSOR, null, msgs);
      msgs = basicSetAccessor(newAccessor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VxlPackage.VARIABLE__ACCESSOR, newAccessor, newAccessor));
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
      case VxlPackage.VARIABLE__ACCESSOR:
        return basicSetAccessor(null, msgs);
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
      case VxlPackage.VARIABLE__NAME:
        return getName();
      case VxlPackage.VARIABLE__ACCESSOR:
        return getAccessor();
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
      case VxlPackage.VARIABLE__NAME:
        setName((String)newValue);
        return;
      case VxlPackage.VARIABLE__ACCESSOR:
        setAccessor((Accessor)newValue);
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
      case VxlPackage.VARIABLE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case VxlPackage.VARIABLE__ACCESSOR:
        setAccessor((Accessor)null);
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
      case VxlPackage.VARIABLE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case VxlPackage.VARIABLE__ACCESSOR:
        return accessor != null;
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
    result.append(')');
    return result.toString();
  }

} //VariableImpl
