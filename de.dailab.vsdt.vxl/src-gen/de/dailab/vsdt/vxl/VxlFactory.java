/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.vxl.VxlPackage
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
  VxlFactory eINSTANCE = de.dailab.vsdt.vxl.impl.VxlFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
  Term createTerm();

  /**
   * Returns a new object of class '<em>Head</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Head</em>'.
   * @generated
   */
  Head createHead();

  /**
   * Returns a new object of class '<em>Tail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tail</em>'.
   * @generated
   */
  Tail createTail();

  /**
   * Returns a new object of class '<em>Bracket Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bracket Term</em>'.
   * @generated
   */
  BracketTerm createBracketTerm();

  /**
   * Returns a new object of class '<em>Negation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negation</em>'.
   * @generated
   */
  Negation createNegation();

  /**
   * Returns a new object of class '<em>Atom</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atom</em>'.
   * @generated
   */
  Atom createAtom();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Accessor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accessor</em>'.
   * @generated
   */
  Accessor createAccessor();

  /**
   * Returns a new object of class '<em>Array Accessor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Accessor</em>'.
   * @generated
   */
  ArrayAccessor createArrayAccessor();

  /**
   * Returns a new object of class '<em>Field Accessor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field Accessor</em>'.
   * @generated
   */
  FieldAccessor createFieldAccessor();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>String Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Const</em>'.
   * @generated
   */
  StringConst createStringConst();

  /**
   * Returns a new object of class '<em>Numeric Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numeric Const</em>'.
   * @generated
   */
  NumericConst createNumericConst();

  /**
   * Returns a new object of class '<em>Boolean Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Const</em>'.
   * @generated
   */
  BooleanConst createBooleanConst();

  /**
   * Returns a new object of class '<em>Null Const</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Const</em>'.
   * @generated
   */
  NullConst createNullConst();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  VxlPackage getVxlPackage();

} //VxlFactory
