/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl.impl;

import de.dailab.vsdt.vxl.vxl.VxlAccessor;
import de.dailab.vsdt.vxl.vxl.VxlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Accessor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.impl.VxlAccessorImpl#getAccessor <em>Accessor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VxlAccessorImpl extends MinimalEObjectImpl.Container implements VxlAccessor
{
  /**
   * The cached value of the '{@link #getAccessor() <em>Accessor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAccessor()
   * @generated
   * @ordered
   */
  protected VxlAccessor accessor;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VxlAccessorImpl()
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
    return VxlPackage.Literals.VXL_ACCESSOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlAccessor getAccessor()
  {
    return accessor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAccessor(VxlAccessor newAccessor, NotificationChain msgs)
  {
    VxlAccessor oldAccessor = accessor;
    accessor = newAccessor;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_ACCESSOR__ACCESSOR, oldAccessor, newAccessor);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAccessor(VxlAccessor newAccessor)
  {
    if (newAccessor != accessor)
    {
      NotificationChain msgs = null;
      if (accessor != null)
        msgs = ((InternalEObject)accessor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VXL_ACCESSOR__ACCESSOR, null, msgs);
      if (newAccessor != null)
        msgs = ((InternalEObject)newAccessor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VXL_ACCESSOR__ACCESSOR, null, msgs);
      msgs = basicSetAccessor(newAccessor, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_ACCESSOR__ACCESSOR, newAccessor, newAccessor));
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
      case VxlPackage.VXL_ACCESSOR__ACCESSOR:
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
      case VxlPackage.VXL_ACCESSOR__ACCESSOR:
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
      case VxlPackage.VXL_ACCESSOR__ACCESSOR:
        setAccessor((VxlAccessor)newValue);
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
      case VxlPackage.VXL_ACCESSOR__ACCESSOR:
        setAccessor((VxlAccessor)null);
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
      case VxlPackage.VXL_ACCESSOR__ACCESSOR:
        return accessor != null;
    }
    return super.eIsSet(featureID);
  }

} //VxlAccessorImpl
