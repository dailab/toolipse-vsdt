/**
 */
package de.dailab.vsdt.vxl.vxl.util;

import de.dailab.vsdt.vxl.vxl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
public class VxlSwitch<T> extends Switch<T>
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
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
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
      case VxlPackage.VXL_ELEMENT:
      {
        VxlElement vxlElement = (VxlElement)theEObject;
        T result = caseVxlElement(vxlElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_BRACKET_TERM:
      {
        VxlBracketTerm vxlBracketTerm = (VxlBracketTerm)theEObject;
        T result = caseVxlBracketTerm(vxlBracketTerm);
        if (result == null) result = caseVxlElement(vxlBracketTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_NEGATION:
      {
        VxlNegation vxlNegation = (VxlNegation)theEObject;
        T result = caseVxlNegation(vxlNegation);
        if (result == null) result = caseVxlElement(vxlNegation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_MINUS:
      {
        VxlMinus vxlMinus = (VxlMinus)theEObject;
        T result = caseVxlMinus(vxlMinus);
        if (result == null) result = caseVxlElement(vxlMinus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_CARDINALITY:
      {
        VxlCardinality vxlCardinality = (VxlCardinality)theEObject;
        T result = caseVxlCardinality(vxlCardinality);
        if (result == null) result = caseVxlElement(vxlCardinality);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_VARIABLE:
      {
        VxlVariable vxlVariable = (VxlVariable)theEObject;
        T result = caseVxlVariable(vxlVariable);
        if (result == null) result = caseVxlElement(vxlVariable);
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
      case VxlPackage.VXL_METHOD_ACCESSOR:
      {
        VxlMethodAccessor vxlMethodAccessor = (VxlMethodAccessor)theEObject;
        T result = caseVxlMethodAccessor(vxlMethodAccessor);
        if (result == null) result = caseVxlAccessor(vxlMethodAccessor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_LIST:
      {
        VxlList vxlList = (VxlList)theEObject;
        T result = caseVxlList(vxlList);
        if (result == null) result = caseVxlElement(vxlList);
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
      case VxlPackage.VXL_MAP:
      {
        VxlMap vxlMap = (VxlMap)theEObject;
        T result = caseVxlMap(vxlMap);
        if (result == null) result = caseVxlElement(vxlMap);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_MAP_ELEMENT:
      {
        VxlMapElement vxlMapElement = (VxlMapElement)theEObject;
        T result = caseVxlMapElement(vxlMapElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_FUNCTION:
      {
        VxlFunction vxlFunction = (VxlFunction)theEObject;
        T result = caseVxlFunction(vxlFunction);
        if (result == null) result = caseVxlElement(vxlFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_CONSTRUCTOR:
      {
        VxlConstructor vxlConstructor = (VxlConstructor)theEObject;
        T result = caseVxlConstructor(vxlConstructor);
        if (result == null) result = caseVxlElement(vxlConstructor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_VALUE:
      {
        VxlValue vxlValue = (VxlValue)theEObject;
        T result = caseVxlValue(vxlValue);
        if (result == null) result = caseVxlElement(vxlValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_BOOLEAN_CONST:
      {
        VxlBooleanConst vxlBooleanConst = (VxlBooleanConst)theEObject;
        T result = caseVxlBooleanConst(vxlBooleanConst);
        if (result == null) result = caseVxlValue(vxlBooleanConst);
        if (result == null) result = caseVxlElement(vxlBooleanConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_NULL_CONST:
      {
        VxlNullConst vxlNullConst = (VxlNullConst)theEObject;
        T result = caseVxlNullConst(vxlNullConst);
        if (result == null) result = caseVxlValue(vxlNullConst);
        if (result == null) result = caseVxlElement(vxlNullConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_NUMERIC_CONST:
      {
        VxlNumericConst vxlNumericConst = (VxlNumericConst)theEObject;
        T result = caseVxlNumericConst(vxlNumericConst);
        if (result == null) result = caseVxlValue(vxlNumericConst);
        if (result == null) result = caseVxlElement(vxlNumericConst);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case VxlPackage.VXL_STRING_CONST:
      {
        VxlStringConst vxlStringConst = (VxlStringConst)theEObject;
        T result = caseVxlStringConst(vxlStringConst);
        if (result == null) result = caseVxlValue(vxlStringConst);
        if (result == null) result = caseVxlElement(vxlStringConst);
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
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlElement(VxlElement object)
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
   * Returns the result of interpreting the object as an instance of '<em>Cardinality</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cardinality</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlCardinality(VxlCardinality object)
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
   * Returns the result of interpreting the object as an instance of '<em>Method Accessor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method Accessor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlMethodAccessor(VxlMethodAccessor object)
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
   * Returns the result of interpreting the object as an instance of '<em>Map</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Map</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlMap(VxlMap object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Map Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Map Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlMapElement(VxlMapElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlFunction(VxlFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constructor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constructor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVxlConstructor(VxlConstructor object)
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
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //VxlSwitch
