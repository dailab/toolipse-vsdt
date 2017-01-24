/**
 */
package de.dailab.vsdt.vxl.vxl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage
 * @generated
 */
public interface VxlFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  VxlFactory eINSTANCE = de.dailab.vsdt.vxl.vxl.impl.VxlFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
  VxlTerm createVxlTerm();

  /**
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  VxlElement createVxlElement();

  /**
   * Returns a new object of class '<em>Bracket Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bracket Term</em>'.
   * @generated
   */
  VxlBracketTerm createVxlBracketTerm();

  /**
   * Returns a new object of class '<em>Negation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negation</em>'.
   * @generated
   */
  VxlNegation createVxlNegation();

  /**
   * Returns a new object of class '<em>Minus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Minus</em>'.
   * @generated
   */
  VxlMinus createVxlMinus();

  /**
   * Returns a new object of class '<em>Cardinality</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cardinality</em>'.
   * @generated
   */
  VxlCardinality createVxlCardinality();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  VxlVariable createVxlVariable();

  /**
   * Returns a new object of class '<em>Accessor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accessor</em>'.
   * @generated
   */
  VxlAccessor createVxlAccessor();

  /**
   * Returns a new object of class '<em>Array Accessor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Accessor</em>'.
   * @generated
   */
  VxlArrayAccessor createVxlArrayAccessor();

  /**
   * Returns a new object of class '<em>Field Accessor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field Accessor</em>'.
   * @generated
   */
  VxlFieldAccessor createVxlFieldAccessor();

  /**
   * Returns a new object of class '<em>Method Accessor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method Accessor</em>'.
   * @generated
   */
  VxlMethodAccessor createVxlMethodAccessor();

  /**
   * Returns a new object of class '<em>List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List</em>'.
   * @generated
   */
  VxlList createVxlList();

  /**
   * Returns a new object of class '<em>List Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Element</em>'.
   * @generated
   */
  VxlListElement createVxlListElement();

  /**
   * Returns a new object of class '<em>Map</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map</em>'.
   * @generated
   */
  VxlMap createVxlMap();

  /**
   * Returns a new object of class '<em>Map Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map Element</em>'.
   * @generated
   */
  VxlMapElement createVxlMapElement();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  VxlFunction createVxlFunction();

  /**
   * Returns a new object of class '<em>Constructor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constructor</em>'.
   * @generated
   */
  VxlConstructor createVxlConstructor();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  VxlValue createVxlValue();

  /**
   * Returns a new object of class '<em>Boolean Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Const</em>'.
   * @generated
   */
  VxlBooleanConst createVxlBooleanConst();

  /**
   * Returns a new object of class '<em>Null Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Const</em>'.
   * @generated
   */
  VxlNullConst createVxlNullConst();

  /**
   * Returns a new object of class '<em>Numeric Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numeric Const</em>'.
   * @generated
   */
  VxlNumericConst createVxlNumericConst();

  /**
   * Returns a new object of class '<em>String Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Const</em>'.
   * @generated
   */
  VxlStringConst createVxlStringConst();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  VxlPackage getVxlPackage();

} //VxlFactory
