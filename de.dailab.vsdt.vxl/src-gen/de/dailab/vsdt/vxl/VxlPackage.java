/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.vxl.VxlFactory
 * @model kind="package"
 * @generated
 */
public interface VxlPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "vxl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.dailab.de/vsdt/Vxl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "vxl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  VxlPackage eINSTANCE = de.dailab.vsdt.vxl.impl.VxlPackageImpl.init();

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.TermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.TermImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getTerm()
   * @generated
   */
  int TERM = 0;

  /**
   * The feature id for the '<em><b>Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__HEAD = 0;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM__TAIL = 1;

  /**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.HeadImpl <em>Head</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.HeadImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getHead()
   * @generated
   */
  int HEAD = 1;

  /**
   * The number of structural features of the '<em>Head</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEAD_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.TailImpl <em>Tail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.TailImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getTail()
   * @generated
   */
  int TAIL = 2;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAIL__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAIL__TERM = 1;

  /**
   * The number of structural features of the '<em>Tail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAIL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.BracketTermImpl <em>Bracket Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.BracketTermImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getBracketTerm()
   * @generated
   */
  int BRACKET_TERM = 3;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRACKET_TERM__TERM = HEAD_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bracket Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRACKET_TERM_FEATURE_COUNT = HEAD_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.NegationImpl <em>Negation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.NegationImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getNegation()
   * @generated
   */
  int NEGATION = 4;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION__TERM = HEAD_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Negation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION_FEATURE_COUNT = HEAD_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.AtomImpl <em>Atom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.AtomImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getAtom()
   * @generated
   */
  int ATOM = 5;

  /**
   * The number of structural features of the '<em>Atom</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOM_FEATURE_COUNT = HEAD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.VariableImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = ATOM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__ACCESSOR = ATOM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = ATOM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.AccessorImpl <em>Accessor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.AccessorImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getAccessor()
   * @generated
   */
  int ACCESSOR = 7;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCESSOR__ACCESSOR = 0;

  /**
   * The number of structural features of the '<em>Accessor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACCESSOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.ArrayAccessorImpl <em>Array Accessor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.ArrayAccessorImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getArrayAccessor()
   * @generated
   */
  int ARRAY_ACCESSOR = 8;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESSOR__ACCESSOR = ACCESSOR__ACCESSOR;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESSOR__INDEX = ACCESSOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Accessor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESSOR_FEATURE_COUNT = ACCESSOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.FieldAccessorImpl <em>Field Accessor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.FieldAccessorImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getFieldAccessor()
   * @generated
   */
  int FIELD_ACCESSOR = 9;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_ACCESSOR__ACCESSOR = ACCESSOR__ACCESSOR;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_ACCESSOR__NAME = ACCESSOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Field Accessor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_ACCESSOR_FEATURE_COUNT = ACCESSOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.ValueImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getValue()
   * @generated
   */
  int VALUE = 10;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__CONST = ATOM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = ATOM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.StringConstImpl <em>String Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.StringConstImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getStringConst()
   * @generated
   */
  int STRING_CONST = 11;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_CONST__CONST = VALUE__CONST;

  /**
   * The number of structural features of the '<em>String Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_CONST_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.NumericConstImpl <em>Numeric Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.NumericConstImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getNumericConst()
   * @generated
   */
  int NUMERIC_CONST = 12;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_CONST__CONST = VALUE__CONST;

  /**
   * The number of structural features of the '<em>Numeric Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_CONST_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.BooleanConstImpl <em>Boolean Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.BooleanConstImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getBooleanConst()
   * @generated
   */
  int BOOLEAN_CONST = 13;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_CONST__CONST = VALUE__CONST;

  /**
   * The number of structural features of the '<em>Boolean Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_CONST_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.impl.NullConstImpl <em>Null Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.impl.NullConstImpl
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getNullConst()
   * @generated
   */
  int NULL_CONST = 14;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_CONST__CONST = VALUE__CONST;

  /**
   * The number of structural features of the '<em>Null Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_CONST_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.Operator <em>Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.Operator
   * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getOperator()
   * @generated
   */
  int OPERATOR = 15;


  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term</em>'.
   * @see de.dailab.vsdt.vxl.Term
   * @generated
   */
  EClass getTerm();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.Term#getHead <em>Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Head</em>'.
   * @see de.dailab.vsdt.vxl.Term#getHead()
   * @see #getTerm()
   * @generated
   */
  EReference getTerm_Head();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.Term#getTail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tail</em>'.
   * @see de.dailab.vsdt.vxl.Term#getTail()
   * @see #getTerm()
   * @generated
   */
  EReference getTerm_Tail();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.Head <em>Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Head</em>'.
   * @see de.dailab.vsdt.vxl.Head
   * @generated
   */
  EClass getHead();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.Tail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tail</em>'.
   * @see de.dailab.vsdt.vxl.Tail
   * @generated
   */
  EClass getTail();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.Tail#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see de.dailab.vsdt.vxl.Tail#getOperator()
   * @see #getTail()
   * @generated
   */
  EAttribute getTail_Operator();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.Tail#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see de.dailab.vsdt.vxl.Tail#getTerm()
   * @see #getTail()
   * @generated
   */
  EReference getTail_Term();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.BracketTerm <em>Bracket Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bracket Term</em>'.
   * @see de.dailab.vsdt.vxl.BracketTerm
   * @generated
   */
  EClass getBracketTerm();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.BracketTerm#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see de.dailab.vsdt.vxl.BracketTerm#getTerm()
   * @see #getBracketTerm()
   * @generated
   */
  EReference getBracketTerm_Term();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.Negation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negation</em>'.
   * @see de.dailab.vsdt.vxl.Negation
   * @generated
   */
  EClass getNegation();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.Negation#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see de.dailab.vsdt.vxl.Negation#getTerm()
   * @see #getNegation()
   * @generated
   */
  EReference getNegation_Term();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atom</em>'.
   * @see de.dailab.vsdt.vxl.Atom
   * @generated
   */
  EClass getAtom();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see de.dailab.vsdt.vxl.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dailab.vsdt.vxl.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.Variable#getAccessor <em>Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Accessor</em>'.
   * @see de.dailab.vsdt.vxl.Variable#getAccessor()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Accessor();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.Accessor <em>Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Accessor</em>'.
   * @see de.dailab.vsdt.vxl.Accessor
   * @generated
   */
  EClass getAccessor();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.Accessor#getAccessor <em>Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Accessor</em>'.
   * @see de.dailab.vsdt.vxl.Accessor#getAccessor()
   * @see #getAccessor()
   * @generated
   */
  EReference getAccessor_Accessor();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.ArrayAccessor <em>Array Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Accessor</em>'.
   * @see de.dailab.vsdt.vxl.ArrayAccessor
   * @generated
   */
  EClass getArrayAccessor();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.ArrayAccessor#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see de.dailab.vsdt.vxl.ArrayAccessor#getIndex()
   * @see #getArrayAccessor()
   * @generated
   */
  EReference getArrayAccessor_Index();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.FieldAccessor <em>Field Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Accessor</em>'.
   * @see de.dailab.vsdt.vxl.FieldAccessor
   * @generated
   */
  EClass getFieldAccessor();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.FieldAccessor#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dailab.vsdt.vxl.FieldAccessor#getName()
   * @see #getFieldAccessor()
   * @generated
   */
  EAttribute getFieldAccessor_Name();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see de.dailab.vsdt.vxl.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.Value#getConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Const</em>'.
   * @see de.dailab.vsdt.vxl.Value#getConst()
   * @see #getValue()
   * @generated
   */
  EAttribute getValue_Const();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.StringConst <em>String Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Const</em>'.
   * @see de.dailab.vsdt.vxl.StringConst
   * @generated
   */
  EClass getStringConst();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.NumericConst <em>Numeric Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Const</em>'.
   * @see de.dailab.vsdt.vxl.NumericConst
   * @generated
   */
  EClass getNumericConst();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.BooleanConst <em>Boolean Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Const</em>'.
   * @see de.dailab.vsdt.vxl.BooleanConst
   * @generated
   */
  EClass getBooleanConst();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.NullConst <em>Null Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Const</em>'.
   * @see de.dailab.vsdt.vxl.NullConst
   * @generated
   */
  EClass getNullConst();

  /**
   * Returns the meta object for enum '{@link de.dailab.vsdt.vxl.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Operator</em>'.
   * @see de.dailab.vsdt.vxl.Operator
   * @generated
   */
  EEnum getOperator();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  VxlFactory getVxlFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.TermImpl <em>Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.TermImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getTerm()
     * @generated
     */
    EClass TERM = eINSTANCE.getTerm();

    /**
     * The meta object literal for the '<em><b>Head</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERM__HEAD = eINSTANCE.getTerm_Head();

    /**
     * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TERM__TAIL = eINSTANCE.getTerm_Tail();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.HeadImpl <em>Head</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.HeadImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getHead()
     * @generated
     */
    EClass HEAD = eINSTANCE.getHead();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.TailImpl <em>Tail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.TailImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getTail()
     * @generated
     */
    EClass TAIL = eINSTANCE.getTail();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TAIL__OPERATOR = eINSTANCE.getTail_Operator();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAIL__TERM = eINSTANCE.getTail_Term();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.BracketTermImpl <em>Bracket Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.BracketTermImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getBracketTerm()
     * @generated
     */
    EClass BRACKET_TERM = eINSTANCE.getBracketTerm();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BRACKET_TERM__TERM = eINSTANCE.getBracketTerm_Term();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.NegationImpl <em>Negation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.NegationImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getNegation()
     * @generated
     */
    EClass NEGATION = eINSTANCE.getNegation();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEGATION__TERM = eINSTANCE.getNegation_Term();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.AtomImpl <em>Atom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.AtomImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getAtom()
     * @generated
     */
    EClass ATOM = eINSTANCE.getAtom();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.VariableImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '<em><b>Accessor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__ACCESSOR = eINSTANCE.getVariable_Accessor();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.AccessorImpl <em>Accessor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.AccessorImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getAccessor()
     * @generated
     */
    EClass ACCESSOR = eINSTANCE.getAccessor();

    /**
     * The meta object literal for the '<em><b>Accessor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACCESSOR__ACCESSOR = eINSTANCE.getAccessor_Accessor();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.ArrayAccessorImpl <em>Array Accessor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.ArrayAccessorImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getArrayAccessor()
     * @generated
     */
    EClass ARRAY_ACCESSOR = eINSTANCE.getArrayAccessor();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESSOR__INDEX = eINSTANCE.getArrayAccessor_Index();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.FieldAccessorImpl <em>Field Accessor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.FieldAccessorImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getFieldAccessor()
     * @generated
     */
    EClass FIELD_ACCESSOR = eINSTANCE.getFieldAccessor();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_ACCESSOR__NAME = eINSTANCE.getFieldAccessor_Name();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.ValueImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE__CONST = eINSTANCE.getValue_Const();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.StringConstImpl <em>String Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.StringConstImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getStringConst()
     * @generated
     */
    EClass STRING_CONST = eINSTANCE.getStringConst();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.NumericConstImpl <em>Numeric Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.NumericConstImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getNumericConst()
     * @generated
     */
    EClass NUMERIC_CONST = eINSTANCE.getNumericConst();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.BooleanConstImpl <em>Boolean Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.BooleanConstImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getBooleanConst()
     * @generated
     */
    EClass BOOLEAN_CONST = eINSTANCE.getBooleanConst();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.impl.NullConstImpl <em>Null Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.impl.NullConstImpl
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getNullConst()
     * @generated
     */
    EClass NULL_CONST = eINSTANCE.getNullConst();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.Operator <em>Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.Operator
     * @see de.dailab.vsdt.vxl.impl.VxlPackageImpl#getOperator()
     * @generated
     */
    EEnum OPERATOR = eINSTANCE.getOperator();

  }

} //VxlPackage
