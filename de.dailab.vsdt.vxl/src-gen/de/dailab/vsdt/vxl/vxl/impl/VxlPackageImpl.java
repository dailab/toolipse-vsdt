/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl.impl;

import de.dailab.vsdt.vxl.vxl.Accessor;
import de.dailab.vsdt.vxl.vxl.ArrayAccessor;
import de.dailab.vsdt.vxl.vxl.Atom;
import de.dailab.vsdt.vxl.vxl.BooleanConst;
import de.dailab.vsdt.vxl.vxl.BracketTerm;
import de.dailab.vsdt.vxl.vxl.FieldAccessor;
import de.dailab.vsdt.vxl.vxl.Head;
import de.dailab.vsdt.vxl.vxl.Minus;
import de.dailab.vsdt.vxl.vxl.Negation;
import de.dailab.vsdt.vxl.vxl.NullConst;
import de.dailab.vsdt.vxl.vxl.NumericConst;
import de.dailab.vsdt.vxl.vxl.Operator;
import de.dailab.vsdt.vxl.vxl.StringConst;
import de.dailab.vsdt.vxl.vxl.Tail;
import de.dailab.vsdt.vxl.vxl.Term;
import de.dailab.vsdt.vxl.vxl.Value;
import de.dailab.vsdt.vxl.vxl.Variable;
import de.dailab.vsdt.vxl.vxl.VxlFactory;
import de.dailab.vsdt.vxl.vxl.VxlPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VxlPackageImpl extends EPackageImpl implements VxlPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass termEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass headEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tailEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bracketTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass negationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass minusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass accessorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayAccessorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fieldAccessorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum operatorEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private VxlPackageImpl()
  {
    super(eNS_URI, VxlFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link VxlPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static VxlPackage init()
  {
    if (isInited) return (VxlPackage)EPackage.Registry.INSTANCE.getEPackage(VxlPackage.eNS_URI);

    // Obtain or create and register package
    VxlPackageImpl theVxlPackage = (VxlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VxlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VxlPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theVxlPackage.createPackageContents();

    // Initialize created meta-data
    theVxlPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theVxlPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(VxlPackage.eNS_URI, theVxlPackage);
    return theVxlPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTerm()
  {
    return termEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTerm_Head()
  {
    return (EReference)termEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTerm_Tail()
  {
    return (EReference)termEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHead()
  {
    return headEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTail()
  {
    return tailEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTail_Operator()
  {
    return (EAttribute)tailEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTail_Term()
  {
    return (EReference)tailEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBracketTerm()
  {
    return bracketTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBracketTerm_Term()
  {
    return (EReference)bracketTermEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNegation()
  {
    return negationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNegation_Head()
  {
    return (EReference)negationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMinus()
  {
    return minusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMinus_Head()
  {
    return (EReference)minusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtom()
  {
    return atomEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariable_Name()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariable_Accessor()
  {
    return (EReference)variableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAccessor()
  {
    return accessorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAccessor_Accessor()
  {
    return (EReference)accessorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayAccessor()
  {
    return arrayAccessorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayAccessor_Index()
  {
    return (EReference)arrayAccessorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFieldAccessor()
  {
    return fieldAccessorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFieldAccessor_Name()
  {
    return (EAttribute)fieldAccessorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValue_Const()
  {
    return (EAttribute)valueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringConst()
  {
    return stringConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericConst()
  {
    return numericConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanConst()
  {
    return booleanConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullConst()
  {
    return nullConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOperator()
  {
    return operatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlFactory getVxlFactory()
  {
    return (VxlFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    termEClass = createEClass(TERM);
    createEReference(termEClass, TERM__HEAD);
    createEReference(termEClass, TERM__TAIL);

    headEClass = createEClass(HEAD);

    tailEClass = createEClass(TAIL);
    createEAttribute(tailEClass, TAIL__OPERATOR);
    createEReference(tailEClass, TAIL__TERM);

    bracketTermEClass = createEClass(BRACKET_TERM);
    createEReference(bracketTermEClass, BRACKET_TERM__TERM);

    negationEClass = createEClass(NEGATION);
    createEReference(negationEClass, NEGATION__HEAD);

    minusEClass = createEClass(MINUS);
    createEReference(minusEClass, MINUS__HEAD);

    atomEClass = createEClass(ATOM);

    variableEClass = createEClass(VARIABLE);
    createEAttribute(variableEClass, VARIABLE__NAME);
    createEReference(variableEClass, VARIABLE__ACCESSOR);

    accessorEClass = createEClass(ACCESSOR);
    createEReference(accessorEClass, ACCESSOR__ACCESSOR);

    arrayAccessorEClass = createEClass(ARRAY_ACCESSOR);
    createEReference(arrayAccessorEClass, ARRAY_ACCESSOR__INDEX);

    fieldAccessorEClass = createEClass(FIELD_ACCESSOR);
    createEAttribute(fieldAccessorEClass, FIELD_ACCESSOR__NAME);

    valueEClass = createEClass(VALUE);
    createEAttribute(valueEClass, VALUE__CONST);

    stringConstEClass = createEClass(STRING_CONST);

    numericConstEClass = createEClass(NUMERIC_CONST);

    booleanConstEClass = createEClass(BOOLEAN_CONST);

    nullConstEClass = createEClass(NULL_CONST);

    // Create enums
    operatorEEnum = createEEnum(OPERATOR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    bracketTermEClass.getESuperTypes().add(this.getHead());
    negationEClass.getESuperTypes().add(this.getHead());
    minusEClass.getESuperTypes().add(this.getHead());
    atomEClass.getESuperTypes().add(this.getHead());
    variableEClass.getESuperTypes().add(this.getAtom());
    arrayAccessorEClass.getESuperTypes().add(this.getAccessor());
    fieldAccessorEClass.getESuperTypes().add(this.getAccessor());
    valueEClass.getESuperTypes().add(this.getAtom());
    stringConstEClass.getESuperTypes().add(this.getValue());
    numericConstEClass.getESuperTypes().add(this.getValue());
    booleanConstEClass.getESuperTypes().add(this.getValue());
    nullConstEClass.getESuperTypes().add(this.getValue());

    // Initialize classes and features; add operations and parameters
    initEClass(termEClass, Term.class, "Term", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTerm_Head(), this.getHead(), null, "head", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTerm_Tail(), this.getTail(), null, "tail", null, 0, 1, Term.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(headEClass, Head.class, "Head", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tailEClass, Tail.class, "Tail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTail_Operator(), this.getOperator(), "operator", null, 0, 1, Tail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTail_Term(), this.getTerm(), null, "term", null, 0, 1, Tail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bracketTermEClass, BracketTerm.class, "BracketTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBracketTerm_Term(), this.getTerm(), null, "term", null, 0, 1, BracketTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(negationEClass, Negation.class, "Negation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNegation_Head(), this.getHead(), null, "head", null, 0, 1, Negation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(minusEClass, Minus.class, "Minus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMinus_Head(), this.getHead(), null, "head", null, 0, 1, Minus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomEClass, Atom.class, "Atom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariable_Accessor(), this.getAccessor(), null, "accessor", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(accessorEClass, Accessor.class, "Accessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAccessor_Accessor(), this.getAccessor(), null, "accessor", null, 0, 1, Accessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayAccessorEClass, ArrayAccessor.class, "ArrayAccessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayAccessor_Index(), this.getTerm(), null, "index", null, 0, 1, ArrayAccessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fieldAccessorEClass, FieldAccessor.class, "FieldAccessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFieldAccessor_Name(), ecorePackage.getEString(), "name", null, 0, 1, FieldAccessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValue_Const(), ecorePackage.getEString(), "const", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringConstEClass, StringConst.class, "StringConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numericConstEClass, NumericConst.class, "NumericConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(booleanConstEClass, BooleanConst.class, "BooleanConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nullConstEClass, NullConst.class, "NullConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(operatorEEnum, Operator.class, "Operator");
    addEEnumLiteral(operatorEEnum, Operator.LT);
    addEEnumLiteral(operatorEEnum, Operator.LE);
    addEEnumLiteral(operatorEEnum, Operator.EQ);
    addEEnumLiteral(operatorEEnum, Operator.NEQ);
    addEEnumLiteral(operatorEEnum, Operator.GT);
    addEEnumLiteral(operatorEEnum, Operator.GE);
    addEEnumLiteral(operatorEEnum, Operator.ADD);
    addEEnumLiteral(operatorEEnum, Operator.SUB);
    addEEnumLiteral(operatorEEnum, Operator.MULT);
    addEEnumLiteral(operatorEEnum, Operator.DIV);
    addEEnumLiteral(operatorEEnum, Operator.MOD);
    addEEnumLiteral(operatorEEnum, Operator.AND);
    addEEnumLiteral(operatorEEnum, Operator.OR);
    addEEnumLiteral(operatorEEnum, Operator.CONCAT);

    // Create resource
    createResource(eNS_URI);
  }

} //VxlPackageImpl
