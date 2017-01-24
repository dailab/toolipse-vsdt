/**
 */
package de.dailab.vsdt.vxl.vxl.impl;

import de.dailab.vsdt.vxl.vxl.VxlAccessor;
import de.dailab.vsdt.vxl.vxl.VxlArrayAccessor;
import de.dailab.vsdt.vxl.vxl.VxlBooleanConst;
import de.dailab.vsdt.vxl.vxl.VxlBracketTerm;
import de.dailab.vsdt.vxl.vxl.VxlCardinality;
import de.dailab.vsdt.vxl.vxl.VxlConstructor;
import de.dailab.vsdt.vxl.vxl.VxlElement;
import de.dailab.vsdt.vxl.vxl.VxlFactory;
import de.dailab.vsdt.vxl.vxl.VxlFieldAccessor;
import de.dailab.vsdt.vxl.vxl.VxlFunction;
import de.dailab.vsdt.vxl.vxl.VxlList;
import de.dailab.vsdt.vxl.vxl.VxlListElement;
import de.dailab.vsdt.vxl.vxl.VxlMap;
import de.dailab.vsdt.vxl.vxl.VxlMapElement;
import de.dailab.vsdt.vxl.vxl.VxlMethodAccessor;
import de.dailab.vsdt.vxl.vxl.VxlMinus;
import de.dailab.vsdt.vxl.vxl.VxlNegation;
import de.dailab.vsdt.vxl.vxl.VxlNullConst;
import de.dailab.vsdt.vxl.vxl.VxlNumericConst;
import de.dailab.vsdt.vxl.vxl.VxlOperator;
import de.dailab.vsdt.vxl.vxl.VxlPackage;
import de.dailab.vsdt.vxl.vxl.VxlStringConst;
import de.dailab.vsdt.vxl.vxl.VxlTerm;
import de.dailab.vsdt.vxl.vxl.VxlValue;
import de.dailab.vsdt.vxl.vxl.VxlVariable;

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
  private EClass vxlTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlBracketTermEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlNegationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlMinusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlCardinalityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlAccessorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlArrayAccessorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlFieldAccessorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlMethodAccessorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlListElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlMapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlMapElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlConstructorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlBooleanConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlNullConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlNumericConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass vxlStringConstEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum vxlOperatorEEnum = null;

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
  public EClass getVxlTerm()
  {
    return vxlTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlTerm_Head()
  {
    return (EReference)vxlTermEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlTerm_Operator()
  {
    return (EAttribute)vxlTermEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlTerm_Tail()
  {
    return (EReference)vxlTermEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlElement()
  {
    return vxlElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlBracketTerm()
  {
    return vxlBracketTermEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlBracketTerm_Term()
  {
    return (EReference)vxlBracketTermEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlNegation()
  {
    return vxlNegationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlNegation_Element()
  {
    return (EReference)vxlNegationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlMinus()
  {
    return vxlMinusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlMinus_Element()
  {
    return (EReference)vxlMinusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlCardinality()
  {
    return vxlCardinalityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlCardinality_Element()
  {
    return (EReference)vxlCardinalityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlVariable()
  {
    return vxlVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlVariable_Name()
  {
    return (EAttribute)vxlVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlVariable_Accessor()
  {
    return (EReference)vxlVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlAccessor()
  {
    return vxlAccessorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlAccessor_Accessor()
  {
    return (EReference)vxlAccessorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlArrayAccessor()
  {
    return vxlArrayAccessorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlArrayAccessor_Index()
  {
    return (EReference)vxlArrayAccessorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlFieldAccessor()
  {
    return vxlFieldAccessorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlFieldAccessor_Name()
  {
    return (EAttribute)vxlFieldAccessorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlMethodAccessor()
  {
    return vxlMethodAccessorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlMethodAccessor_Function()
  {
    return (EReference)vxlMethodAccessorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlList()
  {
    return vxlListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlList_Empty()
  {
    return (EAttribute)vxlListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlList_Body()
  {
    return (EReference)vxlListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlListElement()
  {
    return vxlListElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlListElement_First()
  {
    return (EReference)vxlListElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlListElement_Rest()
  {
    return (EReference)vxlListElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlMap()
  {
    return vxlMapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlMap_Empty()
  {
    return (EAttribute)vxlMapEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlMap_Body()
  {
    return (EReference)vxlMapEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlMapElement()
  {
    return vxlMapElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlMapElement_Key()
  {
    return (EReference)vxlMapElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlMapElement_Value()
  {
    return (EReference)vxlMapElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlMapElement_Rest()
  {
    return (EReference)vxlMapElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlFunction()
  {
    return vxlFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlFunction_Name()
  {
    return (EAttribute)vxlFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlFunction_Empty()
  {
    return (EAttribute)vxlFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlFunction_Body()
  {
    return (EReference)vxlFunctionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlConstructor()
  {
    return vxlConstructorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlConstructor_Name()
  {
    return (EAttribute)vxlConstructorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlConstructor_Empty()
  {
    return (EAttribute)vxlConstructorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVxlConstructor_Body()
  {
    return (EReference)vxlConstructorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlValue()
  {
    return vxlValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVxlValue_Const()
  {
    return (EAttribute)vxlValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlBooleanConst()
  {
    return vxlBooleanConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlNullConst()
  {
    return vxlNullConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlNumericConst()
  {
    return vxlNumericConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVxlStringConst()
  {
    return vxlStringConstEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVxlOperator()
  {
    return vxlOperatorEEnum;
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
    vxlTermEClass = createEClass(VXL_TERM);
    createEReference(vxlTermEClass, VXL_TERM__HEAD);
    createEAttribute(vxlTermEClass, VXL_TERM__OPERATOR);
    createEReference(vxlTermEClass, VXL_TERM__TAIL);

    vxlElementEClass = createEClass(VXL_ELEMENT);

    vxlBracketTermEClass = createEClass(VXL_BRACKET_TERM);
    createEReference(vxlBracketTermEClass, VXL_BRACKET_TERM__TERM);

    vxlNegationEClass = createEClass(VXL_NEGATION);
    createEReference(vxlNegationEClass, VXL_NEGATION__ELEMENT);

    vxlMinusEClass = createEClass(VXL_MINUS);
    createEReference(vxlMinusEClass, VXL_MINUS__ELEMENT);

    vxlCardinalityEClass = createEClass(VXL_CARDINALITY);
    createEReference(vxlCardinalityEClass, VXL_CARDINALITY__ELEMENT);

    vxlVariableEClass = createEClass(VXL_VARIABLE);
    createEAttribute(vxlVariableEClass, VXL_VARIABLE__NAME);
    createEReference(vxlVariableEClass, VXL_VARIABLE__ACCESSOR);

    vxlAccessorEClass = createEClass(VXL_ACCESSOR);
    createEReference(vxlAccessorEClass, VXL_ACCESSOR__ACCESSOR);

    vxlArrayAccessorEClass = createEClass(VXL_ARRAY_ACCESSOR);
    createEReference(vxlArrayAccessorEClass, VXL_ARRAY_ACCESSOR__INDEX);

    vxlFieldAccessorEClass = createEClass(VXL_FIELD_ACCESSOR);
    createEAttribute(vxlFieldAccessorEClass, VXL_FIELD_ACCESSOR__NAME);

    vxlMethodAccessorEClass = createEClass(VXL_METHOD_ACCESSOR);
    createEReference(vxlMethodAccessorEClass, VXL_METHOD_ACCESSOR__FUNCTION);

    vxlListEClass = createEClass(VXL_LIST);
    createEAttribute(vxlListEClass, VXL_LIST__EMPTY);
    createEReference(vxlListEClass, VXL_LIST__BODY);

    vxlListElementEClass = createEClass(VXL_LIST_ELEMENT);
    createEReference(vxlListElementEClass, VXL_LIST_ELEMENT__FIRST);
    createEReference(vxlListElementEClass, VXL_LIST_ELEMENT__REST);

    vxlMapEClass = createEClass(VXL_MAP);
    createEAttribute(vxlMapEClass, VXL_MAP__EMPTY);
    createEReference(vxlMapEClass, VXL_MAP__BODY);

    vxlMapElementEClass = createEClass(VXL_MAP_ELEMENT);
    createEReference(vxlMapElementEClass, VXL_MAP_ELEMENT__KEY);
    createEReference(vxlMapElementEClass, VXL_MAP_ELEMENT__VALUE);
    createEReference(vxlMapElementEClass, VXL_MAP_ELEMENT__REST);

    vxlFunctionEClass = createEClass(VXL_FUNCTION);
    createEAttribute(vxlFunctionEClass, VXL_FUNCTION__NAME);
    createEAttribute(vxlFunctionEClass, VXL_FUNCTION__EMPTY);
    createEReference(vxlFunctionEClass, VXL_FUNCTION__BODY);

    vxlConstructorEClass = createEClass(VXL_CONSTRUCTOR);
    createEAttribute(vxlConstructorEClass, VXL_CONSTRUCTOR__NAME);
    createEAttribute(vxlConstructorEClass, VXL_CONSTRUCTOR__EMPTY);
    createEReference(vxlConstructorEClass, VXL_CONSTRUCTOR__BODY);

    vxlValueEClass = createEClass(VXL_VALUE);
    createEAttribute(vxlValueEClass, VXL_VALUE__CONST);

    vxlBooleanConstEClass = createEClass(VXL_BOOLEAN_CONST);

    vxlNullConstEClass = createEClass(VXL_NULL_CONST);

    vxlNumericConstEClass = createEClass(VXL_NUMERIC_CONST);

    vxlStringConstEClass = createEClass(VXL_STRING_CONST);

    // Create enums
    vxlOperatorEEnum = createEEnum(VXL_OPERATOR);
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
    vxlBracketTermEClass.getESuperTypes().add(this.getVxlElement());
    vxlNegationEClass.getESuperTypes().add(this.getVxlElement());
    vxlMinusEClass.getESuperTypes().add(this.getVxlElement());
    vxlCardinalityEClass.getESuperTypes().add(this.getVxlElement());
    vxlVariableEClass.getESuperTypes().add(this.getVxlElement());
    vxlArrayAccessorEClass.getESuperTypes().add(this.getVxlAccessor());
    vxlFieldAccessorEClass.getESuperTypes().add(this.getVxlAccessor());
    vxlMethodAccessorEClass.getESuperTypes().add(this.getVxlAccessor());
    vxlListEClass.getESuperTypes().add(this.getVxlElement());
    vxlMapEClass.getESuperTypes().add(this.getVxlElement());
    vxlFunctionEClass.getESuperTypes().add(this.getVxlElement());
    vxlConstructorEClass.getESuperTypes().add(this.getVxlElement());
    vxlValueEClass.getESuperTypes().add(this.getVxlElement());
    vxlBooleanConstEClass.getESuperTypes().add(this.getVxlValue());
    vxlNullConstEClass.getESuperTypes().add(this.getVxlValue());
    vxlNumericConstEClass.getESuperTypes().add(this.getVxlValue());
    vxlStringConstEClass.getESuperTypes().add(this.getVxlValue());

    // Initialize classes and features; add operations and parameters
    initEClass(vxlTermEClass, VxlTerm.class, "VxlTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlTerm_Head(), this.getVxlElement(), null, "head", null, 0, 1, VxlTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVxlTerm_Operator(), this.getVxlOperator(), "operator", null, 0, 1, VxlTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlTerm_Tail(), this.getVxlTerm(), null, "tail", null, 0, 1, VxlTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlElementEClass, VxlElement.class, "VxlElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(vxlBracketTermEClass, VxlBracketTerm.class, "VxlBracketTerm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlBracketTerm_Term(), this.getVxlTerm(), null, "term", null, 0, 1, VxlBracketTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlNegationEClass, VxlNegation.class, "VxlNegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlNegation_Element(), this.getVxlElement(), null, "element", null, 0, 1, VxlNegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlMinusEClass, VxlMinus.class, "VxlMinus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlMinus_Element(), this.getVxlElement(), null, "element", null, 0, 1, VxlMinus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlCardinalityEClass, VxlCardinality.class, "VxlCardinality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlCardinality_Element(), this.getVxlElement(), null, "element", null, 0, 1, VxlCardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlVariableEClass, VxlVariable.class, "VxlVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVxlVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, VxlVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlVariable_Accessor(), this.getVxlAccessor(), null, "accessor", null, 0, 1, VxlVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlAccessorEClass, VxlAccessor.class, "VxlAccessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlAccessor_Accessor(), this.getVxlAccessor(), null, "accessor", null, 0, 1, VxlAccessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlArrayAccessorEClass, VxlArrayAccessor.class, "VxlArrayAccessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlArrayAccessor_Index(), this.getVxlTerm(), null, "index", null, 0, 1, VxlArrayAccessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlFieldAccessorEClass, VxlFieldAccessor.class, "VxlFieldAccessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVxlFieldAccessor_Name(), ecorePackage.getEString(), "name", null, 0, 1, VxlFieldAccessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlMethodAccessorEClass, VxlMethodAccessor.class, "VxlMethodAccessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlMethodAccessor_Function(), this.getVxlFunction(), null, "function", null, 0, 1, VxlMethodAccessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlListEClass, VxlList.class, "VxlList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVxlList_Empty(), ecorePackage.getEBoolean(), "empty", null, 0, 1, VxlList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlList_Body(), this.getVxlListElement(), null, "body", null, 0, 1, VxlList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlListElementEClass, VxlListElement.class, "VxlListElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlListElement_First(), this.getVxlTerm(), null, "first", null, 0, 1, VxlListElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlListElement_Rest(), this.getVxlListElement(), null, "rest", null, 0, 1, VxlListElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlMapEClass, VxlMap.class, "VxlMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVxlMap_Empty(), ecorePackage.getEBoolean(), "empty", null, 0, 1, VxlMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlMap_Body(), this.getVxlMapElement(), null, "body", null, 0, 1, VxlMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlMapElementEClass, VxlMapElement.class, "VxlMapElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVxlMapElement_Key(), this.getVxlTerm(), null, "key", null, 0, 1, VxlMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlMapElement_Value(), this.getVxlTerm(), null, "value", null, 0, 1, VxlMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlMapElement_Rest(), this.getVxlMapElement(), null, "rest", null, 0, 1, VxlMapElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlFunctionEClass, VxlFunction.class, "VxlFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVxlFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, VxlFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVxlFunction_Empty(), ecorePackage.getEBoolean(), "empty", null, 0, 1, VxlFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlFunction_Body(), this.getVxlListElement(), null, "body", null, 0, 1, VxlFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlConstructorEClass, VxlConstructor.class, "VxlConstructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVxlConstructor_Name(), ecorePackage.getEString(), "name", null, 0, 1, VxlConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVxlConstructor_Empty(), ecorePackage.getEBoolean(), "empty", null, 0, 1, VxlConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVxlConstructor_Body(), this.getVxlListElement(), null, "body", null, 0, 1, VxlConstructor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlValueEClass, VxlValue.class, "VxlValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVxlValue_Const(), ecorePackage.getEString(), "const", null, 0, 1, VxlValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(vxlBooleanConstEClass, VxlBooleanConst.class, "VxlBooleanConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(vxlNullConstEClass, VxlNullConst.class, "VxlNullConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(vxlNumericConstEClass, VxlNumericConst.class, "VxlNumericConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(vxlStringConstEClass, VxlStringConst.class, "VxlStringConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(vxlOperatorEEnum, VxlOperator.class, "VxlOperator");
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.LT);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.LE);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.EQ);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.NEQ);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.GT);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.GE);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.ADD);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.SUB);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.MULT);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.DIV);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.MOD);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.AND);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.OR);
    addEEnumLiteral(vxlOperatorEEnum, VxlOperator.CONCAT);

    // Create resource
    createResource(eNS_URI);
  }

} //VxlPackageImpl
