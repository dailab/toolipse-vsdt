/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import de.dailab.vsdt.vxl.vxl.VxlListElement;
import de.dailab.vsdt.vxl.vxl.VxlPackage;
import de.dailab.vsdt.vxl.vxl.VxlTerm;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.impl.VxlListElementImpl#getFirst <em>First</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.impl.VxlListElementImpl#getRest <em>Rest</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VxlListElementImpl extends MinimalEObjectImpl.Container implements VxlListElement
{
  /**
   * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirst()
   * @generated
   * @ordered
   */
  protected VxlTerm first;

  /**
   * The cached value of the '{@link #getRest() <em>Rest</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRest()
   * @generated
   * @ordered
   */
  protected VxlListElement rest;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VxlListElementImpl()
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
    return VxlPackage.Literals.VXL_LIST_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlTerm getFirst()
  {
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirst(VxlTerm newFirst, NotificationChain msgs)
  {
    VxlTerm oldFirst = first;
    first = newFirst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_LIST_ELEMENT__FIRST, oldFirst, newFirst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirst(VxlTerm newFirst)
  {
    if (newFirst != first)
    {
      NotificationChain msgs = null;
      if (first != null)
        msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VXL_LIST_ELEMENT__FIRST, null, msgs);
      if (newFirst != null)
        msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VXL_LIST_ELEMENT__FIRST, null, msgs);
      msgs = basicSetFirst(newFirst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_LIST_ELEMENT__FIRST, newFirst, newFirst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlListElement getRest()
  {
    return rest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRest(VxlListElement newRest, NotificationChain msgs)
  {
    VxlListElement oldRest = rest;
    rest = newRest;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_LIST_ELEMENT__REST, oldRest, newRest);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRest(VxlListElement newRest)
  {
    if (newRest != rest)
    {
      NotificationChain msgs = null;
      if (rest != null)
        msgs = ((InternalEObject)rest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VXL_LIST_ELEMENT__REST, null, msgs);
      if (newRest != null)
        msgs = ((InternalEObject)newRest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VxlPackage.VXL_LIST_ELEMENT__REST, null, msgs);
      msgs = basicSetRest(newRest, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VxlPackage.VXL_LIST_ELEMENT__REST, newRest, newRest));
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
      case VxlPackage.VXL_LIST_ELEMENT__FIRST:
        return basicSetFirst(null, msgs);
      case VxlPackage.VXL_LIST_ELEMENT__REST:
        return basicSetRest(null, msgs);
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
      case VxlPackage.VXL_LIST_ELEMENT__FIRST:
        return getFirst();
      case VxlPackage.VXL_LIST_ELEMENT__REST:
        return getRest();
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
      case VxlPackage.VXL_LIST_ELEMENT__FIRST:
        setFirst((VxlTerm)newValue);
        return;
      case VxlPackage.VXL_LIST_ELEMENT__REST:
        setRest((VxlListElement)newValue);
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
      case VxlPackage.VXL_LIST_ELEMENT__FIRST:
        setFirst((VxlTerm)null);
        return;
      case VxlPackage.VXL_LIST_ELEMENT__REST:
        setRest((VxlListElement)null);
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
      case VxlPackage.VXL_LIST_ELEMENT__FIRST:
        return first != null;
      case VxlPackage.VXL_LIST_ELEMENT__REST:
        return rest != null;
    }
    return super.eIsSet(featureID);
  }

} //VxlListElementImpl
