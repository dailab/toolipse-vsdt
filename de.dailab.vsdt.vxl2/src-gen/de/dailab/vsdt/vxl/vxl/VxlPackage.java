/**
 */
package de.dailab.vsdt.vxl.vxl;

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
 * @see de.dailab.vsdt.vxl.vxl.VxlFactory
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
  String eNS_URI = "http://www.dailab.de/vsdt/vxl/Vxl";

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
  VxlPackage eINSTANCE = de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl.init();

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlTermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlTermImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlTerm()
   * @generated
   */
  int VXL_TERM = 0;

  /**
   * The feature id for the '<em><b>Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_TERM__HEAD = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_TERM__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_TERM__TAIL = 2;

  /**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_TERM_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlElementImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlElement()
   * @generated
   */
  int VXL_ELEMENT = 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlBracketTermImpl <em>Bracket Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlBracketTermImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlBracketTerm()
   * @generated
   */
  int VXL_BRACKET_TERM = 2;

  /**
   * The feature id for the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_BRACKET_TERM__TERM = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bracket Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_BRACKET_TERM_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlNegationImpl <em>Negation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlNegationImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlNegation()
   * @generated
   */
  int VXL_NEGATION = 3;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_NEGATION__ELEMENT = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Negation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_NEGATION_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlMinusImpl <em>Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlMinusImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlMinus()
   * @generated
   */
  int VXL_MINUS = 4;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MINUS__ELEMENT = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MINUS_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlCardinalityImpl <em>Cardinality</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlCardinalityImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlCardinality()
   * @generated
   */
  int VXL_CARDINALITY = 5;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_CARDINALITY__ELEMENT = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Cardinality</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_CARDINALITY_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlVariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlVariableImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlVariable()
   * @generated
   */
  int VXL_VARIABLE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_VARIABLE__NAME = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_VARIABLE__ACCESSOR = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_VARIABLE_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlAccessorImpl <em>Accessor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlAccessorImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlAccessor()
   * @generated
   */
  int VXL_ACCESSOR = 7;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_ACCESSOR__ACCESSOR = 0;

  /**
   * The number of structural features of the '<em>Accessor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_ACCESSOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlArrayAccessorImpl <em>Array Accessor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlArrayAccessorImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlArrayAccessor()
   * @generated
   */
  int VXL_ARRAY_ACCESSOR = 8;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_ARRAY_ACCESSOR__ACCESSOR = VXL_ACCESSOR__ACCESSOR;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_ARRAY_ACCESSOR__INDEX = VXL_ACCESSOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Accessor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_ARRAY_ACCESSOR_FEATURE_COUNT = VXL_ACCESSOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlFieldAccessorImpl <em>Field Accessor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlFieldAccessorImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlFieldAccessor()
   * @generated
   */
  int VXL_FIELD_ACCESSOR = 9;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_FIELD_ACCESSOR__ACCESSOR = VXL_ACCESSOR__ACCESSOR;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_FIELD_ACCESSOR__NAME = VXL_ACCESSOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Field Accessor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_FIELD_ACCESSOR_FEATURE_COUNT = VXL_ACCESSOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlMethodAccessorImpl <em>Method Accessor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlMethodAccessorImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlMethodAccessor()
   * @generated
   */
  int VXL_METHOD_ACCESSOR = 10;

  /**
   * The feature id for the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_METHOD_ACCESSOR__ACCESSOR = VXL_ACCESSOR__ACCESSOR;

  /**
   * The feature id for the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_METHOD_ACCESSOR__FUNCTION = VXL_ACCESSOR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Method Accessor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_METHOD_ACCESSOR_FEATURE_COUNT = VXL_ACCESSOR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlListImpl <em>List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlListImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlList()
   * @generated
   */
  int VXL_LIST = 11;

  /**
   * The feature id for the '<em><b>Empty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_LIST__EMPTY = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_LIST__BODY = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_LIST_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlListElementImpl <em>List Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlListElementImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlListElement()
   * @generated
   */
  int VXL_LIST_ELEMENT = 12;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_LIST_ELEMENT__FIRST = 0;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_LIST_ELEMENT__REST = 1;

  /**
   * The number of structural features of the '<em>List Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_LIST_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlMapImpl <em>Map</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlMapImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlMap()
   * @generated
   */
  int VXL_MAP = 13;

  /**
   * The feature id for the '<em><b>Empty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MAP__EMPTY = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MAP__BODY = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Map</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MAP_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlMapElementImpl <em>Map Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlMapElementImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlMapElement()
   * @generated
   */
  int VXL_MAP_ELEMENT = 14;

  /**
   * The feature id for the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MAP_ELEMENT__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MAP_ELEMENT__VALUE = 1;

  /**
   * The feature id for the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MAP_ELEMENT__REST = 2;

  /**
   * The number of structural features of the '<em>Map Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_MAP_ELEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlFunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlFunctionImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlFunction()
   * @generated
   */
  int VXL_FUNCTION = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_FUNCTION__NAME = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Empty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_FUNCTION__EMPTY = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_FUNCTION__BODY = VXL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_FUNCTION_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlConstructorImpl <em>Constructor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlConstructorImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlConstructor()
   * @generated
   */
  int VXL_CONSTRUCTOR = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_CONSTRUCTOR__NAME = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Empty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_CONSTRUCTOR__EMPTY = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_CONSTRUCTOR__BODY = VXL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Constructor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_CONSTRUCTOR_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlValueImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlValue()
   * @generated
   */
  int VXL_VALUE = 17;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_VALUE__CONST = VXL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_VALUE_FEATURE_COUNT = VXL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlBooleanConstImpl <em>Boolean Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlBooleanConstImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlBooleanConst()
   * @generated
   */
  int VXL_BOOLEAN_CONST = 18;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_BOOLEAN_CONST__CONST = VXL_VALUE__CONST;

  /**
   * The number of structural features of the '<em>Boolean Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_BOOLEAN_CONST_FEATURE_COUNT = VXL_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlNullConstImpl <em>Null Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlNullConstImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlNullConst()
   * @generated
   */
  int VXL_NULL_CONST = 19;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_NULL_CONST__CONST = VXL_VALUE__CONST;

  /**
   * The number of structural features of the '<em>Null Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_NULL_CONST_FEATURE_COUNT = VXL_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlNumericConstImpl <em>Numeric Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlNumericConstImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlNumericConst()
   * @generated
   */
  int VXL_NUMERIC_CONST = 20;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_NUMERIC_CONST__CONST = VXL_VALUE__CONST;

  /**
   * The number of structural features of the '<em>Numeric Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_NUMERIC_CONST_FEATURE_COUNT = VXL_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlStringConstImpl <em>String Const</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlStringConstImpl
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlStringConst()
   * @generated
   */
  int VXL_STRING_CONST = 21;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_STRING_CONST__CONST = VXL_VALUE__CONST;

  /**
   * The number of structural features of the '<em>String Const</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VXL_STRING_CONST_FEATURE_COUNT = VXL_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.dailab.vsdt.vxl.vxl.VxlOperator <em>Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.dailab.vsdt.vxl.vxl.VxlOperator
   * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlOperator()
   * @generated
   */
  int VXL_OPERATOR = 22;


  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlTerm
   * @generated
   */
  EClass getVxlTerm();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlTerm#getHead <em>Head</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Head</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlTerm#getHead()
   * @see #getVxlTerm()
   * @generated
   */
  EReference getVxlTerm_Head();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlTerm#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlTerm#getOperator()
   * @see #getVxlTerm()
   * @generated
   */
  EAttribute getVxlTerm_Operator();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlTerm#getTail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tail</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlTerm#getTail()
   * @see #getVxlTerm()
   * @generated
   */
  EReference getVxlTerm_Tail();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlElement
   * @generated
   */
  EClass getVxlElement();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlBracketTerm <em>Bracket Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bracket Term</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlBracketTerm
   * @generated
   */
  EClass getVxlBracketTerm();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlBracketTerm#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Term</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlBracketTerm#getTerm()
   * @see #getVxlBracketTerm()
   * @generated
   */
  EReference getVxlBracketTerm_Term();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlNegation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negation</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlNegation
   * @generated
   */
  EClass getVxlNegation();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlNegation#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlNegation#getElement()
   * @see #getVxlNegation()
   * @generated
   */
  EReference getVxlNegation_Element();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlMinus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Minus</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMinus
   * @generated
   */
  EClass getVxlMinus();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlMinus#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMinus#getElement()
   * @see #getVxlMinus()
   * @generated
   */
  EReference getVxlMinus_Element();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cardinality</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlCardinality
   * @generated
   */
  EClass getVxlCardinality();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlCardinality#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlCardinality#getElement()
   * @see #getVxlCardinality()
   * @generated
   */
  EReference getVxlCardinality_Element();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlVariable
   * @generated
   */
  EClass getVxlVariable();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlVariable#getName()
   * @see #getVxlVariable()
   * @generated
   */
  EAttribute getVxlVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlVariable#getAccessor <em>Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Accessor</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlVariable#getAccessor()
   * @see #getVxlVariable()
   * @generated
   */
  EReference getVxlVariable_Accessor();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlAccessor <em>Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Accessor</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlAccessor
   * @generated
   */
  EClass getVxlAccessor();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlAccessor#getAccessor <em>Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Accessor</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlAccessor#getAccessor()
   * @see #getVxlAccessor()
   * @generated
   */
  EReference getVxlAccessor_Accessor();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlArrayAccessor <em>Array Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Accessor</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlArrayAccessor
   * @generated
   */
  EClass getVxlArrayAccessor();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlArrayAccessor#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlArrayAccessor#getIndex()
   * @see #getVxlArrayAccessor()
   * @generated
   */
  EReference getVxlArrayAccessor_Index();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlFieldAccessor <em>Field Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Accessor</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlFieldAccessor
   * @generated
   */
  EClass getVxlFieldAccessor();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlFieldAccessor#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlFieldAccessor#getName()
   * @see #getVxlFieldAccessor()
   * @generated
   */
  EAttribute getVxlFieldAccessor_Name();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlMethodAccessor <em>Method Accessor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Accessor</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMethodAccessor
   * @generated
   */
  EClass getVxlMethodAccessor();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlMethodAccessor#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMethodAccessor#getFunction()
   * @see #getVxlMethodAccessor()
   * @generated
   */
  EReference getVxlMethodAccessor_Function();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlList
   * @generated
   */
  EClass getVxlList();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlList#isEmpty <em>Empty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Empty</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlList#isEmpty()
   * @see #getVxlList()
   * @generated
   */
  EAttribute getVxlList_Empty();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlList#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlList#getBody()
   * @see #getVxlList()
   * @generated
   */
  EReference getVxlList_Body();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlListElement <em>List Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Element</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlListElement
   * @generated
   */
  EClass getVxlListElement();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlListElement#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlListElement#getFirst()
   * @see #getVxlListElement()
   * @generated
   */
  EReference getVxlListElement_First();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlListElement#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlListElement#getRest()
   * @see #getVxlListElement()
   * @generated
   */
  EReference getVxlListElement_Rest();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlMap <em>Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Map</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMap
   * @generated
   */
  EClass getVxlMap();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlMap#isEmpty <em>Empty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Empty</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMap#isEmpty()
   * @see #getVxlMap()
   * @generated
   */
  EAttribute getVxlMap_Empty();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlMap#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMap#getBody()
   * @see #getVxlMap()
   * @generated
   */
  EReference getVxlMap_Body();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlMapElement <em>Map Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Map Element</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMapElement
   * @generated
   */
  EClass getVxlMapElement();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Key</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMapElement#getKey()
   * @see #getVxlMapElement()
   * @generated
   */
  EReference getVxlMapElement_Key();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMapElement#getValue()
   * @see #getVxlMapElement()
   * @generated
   */
  EReference getVxlMapElement_Value();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getRest <em>Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rest</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlMapElement#getRest()
   * @see #getVxlMapElement()
   * @generated
   */
  EReference getVxlMapElement_Rest();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlFunction
   * @generated
   */
  EClass getVxlFunction();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlFunction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlFunction#getName()
   * @see #getVxlFunction()
   * @generated
   */
  EAttribute getVxlFunction_Name();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlFunction#isEmpty <em>Empty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Empty</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlFunction#isEmpty()
   * @see #getVxlFunction()
   * @generated
   */
  EAttribute getVxlFunction_Empty();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlFunction#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlFunction#getBody()
   * @see #getVxlFunction()
   * @generated
   */
  EReference getVxlFunction_Body();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlConstructor <em>Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constructor</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlConstructor
   * @generated
   */
  EClass getVxlConstructor();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlConstructor#getName()
   * @see #getVxlConstructor()
   * @generated
   */
  EAttribute getVxlConstructor_Name();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#isEmpty <em>Empty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Empty</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlConstructor#isEmpty()
   * @see #getVxlConstructor()
   * @generated
   */
  EAttribute getVxlConstructor_Empty();

  /**
   * Returns the meta object for the containment reference '{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlConstructor#getBody()
   * @see #getVxlConstructor()
   * @generated
   */
  EReference getVxlConstructor_Body();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlValue
   * @generated
   */
  EClass getVxlValue();

  /**
   * Returns the meta object for the attribute '{@link de.dailab.vsdt.vxl.vxl.VxlValue#getConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Const</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlValue#getConst()
   * @see #getVxlValue()
   * @generated
   */
  EAttribute getVxlValue_Const();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlBooleanConst <em>Boolean Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Const</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlBooleanConst
   * @generated
   */
  EClass getVxlBooleanConst();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlNullConst <em>Null Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Const</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlNullConst
   * @generated
   */
  EClass getVxlNullConst();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlNumericConst <em>Numeric Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Const</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlNumericConst
   * @generated
   */
  EClass getVxlNumericConst();

  /**
   * Returns the meta object for class '{@link de.dailab.vsdt.vxl.vxl.VxlStringConst <em>String Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Const</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlStringConst
   * @generated
   */
  EClass getVxlStringConst();

  /**
   * Returns the meta object for enum '{@link de.dailab.vsdt.vxl.vxl.VxlOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Operator</em>'.
   * @see de.dailab.vsdt.vxl.vxl.VxlOperator
   * @generated
   */
  EEnum getVxlOperator();

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
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlTermImpl <em>Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlTermImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlTerm()
     * @generated
     */
    EClass VXL_TERM = eINSTANCE.getVxlTerm();

    /**
     * The meta object literal for the '<em><b>Head</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_TERM__HEAD = eINSTANCE.getVxlTerm_Head();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_TERM__OPERATOR = eINSTANCE.getVxlTerm_Operator();

    /**
     * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_TERM__TAIL = eINSTANCE.getVxlTerm_Tail();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlElementImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlElement()
     * @generated
     */
    EClass VXL_ELEMENT = eINSTANCE.getVxlElement();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlBracketTermImpl <em>Bracket Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlBracketTermImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlBracketTerm()
     * @generated
     */
    EClass VXL_BRACKET_TERM = eINSTANCE.getVxlBracketTerm();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_BRACKET_TERM__TERM = eINSTANCE.getVxlBracketTerm_Term();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlNegationImpl <em>Negation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlNegationImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlNegation()
     * @generated
     */
    EClass VXL_NEGATION = eINSTANCE.getVxlNegation();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_NEGATION__ELEMENT = eINSTANCE.getVxlNegation_Element();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlMinusImpl <em>Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlMinusImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlMinus()
     * @generated
     */
    EClass VXL_MINUS = eINSTANCE.getVxlMinus();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_MINUS__ELEMENT = eINSTANCE.getVxlMinus_Element();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlCardinalityImpl <em>Cardinality</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlCardinalityImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlCardinality()
     * @generated
     */
    EClass VXL_CARDINALITY = eINSTANCE.getVxlCardinality();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_CARDINALITY__ELEMENT = eINSTANCE.getVxlCardinality_Element();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlVariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlVariableImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlVariable()
     * @generated
     */
    EClass VXL_VARIABLE = eINSTANCE.getVxlVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_VARIABLE__NAME = eINSTANCE.getVxlVariable_Name();

    /**
     * The meta object literal for the '<em><b>Accessor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_VARIABLE__ACCESSOR = eINSTANCE.getVxlVariable_Accessor();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlAccessorImpl <em>Accessor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlAccessorImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlAccessor()
     * @generated
     */
    EClass VXL_ACCESSOR = eINSTANCE.getVxlAccessor();

    /**
     * The meta object literal for the '<em><b>Accessor</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_ACCESSOR__ACCESSOR = eINSTANCE.getVxlAccessor_Accessor();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlArrayAccessorImpl <em>Array Accessor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlArrayAccessorImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlArrayAccessor()
     * @generated
     */
    EClass VXL_ARRAY_ACCESSOR = eINSTANCE.getVxlArrayAccessor();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_ARRAY_ACCESSOR__INDEX = eINSTANCE.getVxlArrayAccessor_Index();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlFieldAccessorImpl <em>Field Accessor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlFieldAccessorImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlFieldAccessor()
     * @generated
     */
    EClass VXL_FIELD_ACCESSOR = eINSTANCE.getVxlFieldAccessor();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_FIELD_ACCESSOR__NAME = eINSTANCE.getVxlFieldAccessor_Name();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlMethodAccessorImpl <em>Method Accessor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlMethodAccessorImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlMethodAccessor()
     * @generated
     */
    EClass VXL_METHOD_ACCESSOR = eINSTANCE.getVxlMethodAccessor();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_METHOD_ACCESSOR__FUNCTION = eINSTANCE.getVxlMethodAccessor_Function();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlListImpl <em>List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlListImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlList()
     * @generated
     */
    EClass VXL_LIST = eINSTANCE.getVxlList();

    /**
     * The meta object literal for the '<em><b>Empty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_LIST__EMPTY = eINSTANCE.getVxlList_Empty();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_LIST__BODY = eINSTANCE.getVxlList_Body();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlListElementImpl <em>List Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlListElementImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlListElement()
     * @generated
     */
    EClass VXL_LIST_ELEMENT = eINSTANCE.getVxlListElement();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_LIST_ELEMENT__FIRST = eINSTANCE.getVxlListElement_First();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_LIST_ELEMENT__REST = eINSTANCE.getVxlListElement_Rest();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlMapImpl <em>Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlMapImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlMap()
     * @generated
     */
    EClass VXL_MAP = eINSTANCE.getVxlMap();

    /**
     * The meta object literal for the '<em><b>Empty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_MAP__EMPTY = eINSTANCE.getVxlMap_Empty();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_MAP__BODY = eINSTANCE.getVxlMap_Body();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlMapElementImpl <em>Map Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlMapElementImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlMapElement()
     * @generated
     */
    EClass VXL_MAP_ELEMENT = eINSTANCE.getVxlMapElement();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_MAP_ELEMENT__KEY = eINSTANCE.getVxlMapElement_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_MAP_ELEMENT__VALUE = eINSTANCE.getVxlMapElement_Value();

    /**
     * The meta object literal for the '<em><b>Rest</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_MAP_ELEMENT__REST = eINSTANCE.getVxlMapElement_Rest();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlFunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlFunctionImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlFunction()
     * @generated
     */
    EClass VXL_FUNCTION = eINSTANCE.getVxlFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_FUNCTION__NAME = eINSTANCE.getVxlFunction_Name();

    /**
     * The meta object literal for the '<em><b>Empty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_FUNCTION__EMPTY = eINSTANCE.getVxlFunction_Empty();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_FUNCTION__BODY = eINSTANCE.getVxlFunction_Body();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlConstructorImpl <em>Constructor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlConstructorImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlConstructor()
     * @generated
     */
    EClass VXL_CONSTRUCTOR = eINSTANCE.getVxlConstructor();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_CONSTRUCTOR__NAME = eINSTANCE.getVxlConstructor_Name();

    /**
     * The meta object literal for the '<em><b>Empty</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_CONSTRUCTOR__EMPTY = eINSTANCE.getVxlConstructor_Empty();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VXL_CONSTRUCTOR__BODY = eINSTANCE.getVxlConstructor_Body();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlValueImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlValue()
     * @generated
     */
    EClass VXL_VALUE = eINSTANCE.getVxlValue();

    /**
     * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VXL_VALUE__CONST = eINSTANCE.getVxlValue_Const();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlBooleanConstImpl <em>Boolean Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlBooleanConstImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlBooleanConst()
     * @generated
     */
    EClass VXL_BOOLEAN_CONST = eINSTANCE.getVxlBooleanConst();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlNullConstImpl <em>Null Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlNullConstImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlNullConst()
     * @generated
     */
    EClass VXL_NULL_CONST = eINSTANCE.getVxlNullConst();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlNumericConstImpl <em>Numeric Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlNumericConstImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlNumericConst()
     * @generated
     */
    EClass VXL_NUMERIC_CONST = eINSTANCE.getVxlNumericConst();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.impl.VxlStringConstImpl <em>String Const</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlStringConstImpl
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlStringConst()
     * @generated
     */
    EClass VXL_STRING_CONST = eINSTANCE.getVxlStringConst();

    /**
     * The meta object literal for the '{@link de.dailab.vsdt.vxl.vxl.VxlOperator <em>Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.dailab.vsdt.vxl.vxl.VxlOperator
     * @see de.dailab.vsdt.vxl.vxl.impl.VxlPackageImpl#getVxlOperator()
     * @generated
     */
    EEnum VXL_OPERATOR = eINSTANCE.getVxlOperator();

  }

} //VxlPackage
