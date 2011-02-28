/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl.util;

import de.dailab.vsdt.vxl.vxl.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage
 * @generated
 */
public class VxlSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VxlPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = VxlPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case VxlPackage.VXL_TERM:
      {
        VxlTerm vxlTerm = (VxlTerm)theEObject;
        T result = caseVxlTerm(vxlTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_HEAD:
      {
        VxlHead vxlHead = (VxlHead)theEObject;
        T result = caseVxlHead(vxlHead);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_TAIL:
      {
        VxlTail vxlTail = (VxlTail)theEObject;
        T result = caseVxlTail(vxlTail);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_BRACKET_TERM:
      {
        VxlBracketTerm vxlBracketTerm = (VxlBracketTerm)theEObject;
        T result = caseVxlBracketTerm(vxlBracketTerm);
        if (result == null) result = caseVxlHead(vxlBracketTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_NEGATION:
      {
        VxlNegation vxlNegation = (VxlNegation)theEObject;
        T result = caseVxlNegation(vxlNegation);
        if (result == null) result = caseVxlHead(vxlNegation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_MINUS:
      {
        VxlMinus vxlMinus = (VxlMinus)theEObject;
        T result = caseVxlMinus(vxlMinus);
        if (result == null) result = caseVxlHead(vxlMinus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_ATOM:
      {
        VxlAtom vxlAtom = (VxlAtom)theEObject;
        T result = caseVxlAtom(vxlAtom);
        if (result == null) result = caseVxlHead(vxlAtom);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_VARIABLE:
      {
        VxlVariable vxlVariable = (VxlVariable)theEObject;
        T result = caseVxlVariable(vxlVariable);
        if (result == null) result = caseVxlAtom(vxlVariable);
        if (result == null) result = caseVxlHead(vxlVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_ACCESSOR:
      {
        VxlAccessor vxlAccessor = (VxlAccessor)theEObject;
        T result = caseVxlAccessor(vxlAccessor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_ARRAY_ACCESSOR:
      {
        VxlArrayAccessor vxlArrayAccessor = (VxlArrayAccessor)theEObject;
        T result = caseVxlArrayAccessor(vxlArrayAccessor);
        if (result == null) result = caseVxlAccessor(vxlArrayAccessor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_FIELD_ACCESSOR:
      {
        VxlFieldAccessor vxlFieldAccessor = (VxlFieldAccessor)theEObject;
        T result = caseVxlFieldAccessor(vxlFieldAccessor);
        if (result == null) result = caseVxlAccessor(vxlFieldAccessor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_LIST:
      {
        VxlList vxlList = (VxlList)theEObject;
        T result = caseVxlList(vxlList);
        if (result == null) result = caseVxlAtom(vxlList);
        if (result == null) result = caseVxlHead(vxlList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_LIST_ELEMENT:
      {
        VxlListElement vxlListElement = (VxlListElement)theEObject;
        T result = caseVxlListElement(vxlListElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_VALUE:
      {
        VxlValue vxlValue = (VxlValue)theEObject;
        T result = caseVxlValue(vxlValue);
        if (result == null) result = caseVxlAtom(vxlValue);
        if (result == null) result = caseVxlHead(vxlValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_STRING_CONST:
      {
        VxlStringConst vxlStringConst = (VxlStringConst)theEObject;
        T result = caseVxlStringConst(vxlStringConst);
        if (result == null) result = caseVxlValue(vxlStringConst);
        if (result == null) result = caseVxlAtom(vxlStringConst);
        if (result == null) result = caseVxlHead(vxlStringConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_NUMERIC_CONST:
      {
        VxlNumericConst vxlNumericConst = (VxlNumericConst)theEObject;
        T result = caseVxlNumericConst(vxlNumericConst);
        if (result == null) result = caseVxlValue(vxlNumericConst);
        if (result == null) result = caseVxlAtom(vxlNumericConst);
        if (result == null) result = caseVxlHead(vxlNumericConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_BOOLEAN_CONST:
      {
        VxlBooleanConst vxlBooleanConst = (VxlBooleanConst)theEObject;
        T result = caseVxlBooleanConst(vxlBooleanConst);
        if (result == null) result = caseVxlValue(vxlBooleanConst);
        if (result == null) result = caseVxlAtom(vxlBooleanConst);
        if (result == null) result = caseVxlHead(vxlBooleanConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_NULL_CONST:
      {
        VxlNullConst vxlNullConst = (VxlNullConst)theEObject;
        T result = caseVxlNullConst(vxlNullConst);
        if (result == null) result = caseVxlValue(vxlNullConst);
        if (result == null) result = caseVxlAtom(vxlNullConst);
        if (result == null) result = caseVxlHead(vxlNullConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlTerm(VxlTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Head</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Head</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlHead(VxlHead object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tail</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tail</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlTail(VxlTail object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bracket Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bracket Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlBracketTerm(VxlBracketTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Negation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Negation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlNegation(VxlNegation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlMinus(VxlMinus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atom</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlAtom(VxlAtom object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlVariable(VxlVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Accessor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Accessor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlAccessor(VxlAccessor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Accessor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Accessor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlArrayAccessor(VxlArrayAccessor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field Accessor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field Accessor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlFieldAccessor(VxlFieldAccessor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlList(VxlList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlListElement(VxlListElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlValue(VxlValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlStringConst(VxlStringConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numeric Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numeric Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlNumericConst(VxlNumericConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlBooleanConst(VxlBooleanConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Const</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Const</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlNullConst(VxlNullConst object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //VxlSwitch
