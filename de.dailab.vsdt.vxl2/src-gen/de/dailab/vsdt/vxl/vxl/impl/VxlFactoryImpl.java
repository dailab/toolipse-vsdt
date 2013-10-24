/**
 */
package de.dailab.vsdt.vxl.vxl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.dailab.vsdt.vxl.vxl.VxlAccessor;
import de.dailab.vsdt.vxl.vxl.VxlArrayAccessor;
import de.dailab.vsdt.vxl.vxl.VxlBooleanConst;
import de.dailab.vsdt.vxl.vxl.VxlBracketTerm;
import de.dailab.vsdt.vxl.vxl.VxlCardinality;
import de.dailab.vsdt.vxl.vxl.VxlElement;
import de.dailab.vsdt.vxl.vxl.VxlFactory;
import de.dailab.vsdt.vxl.vxl.VxlFieldAccessor;
import de.dailab.vsdt.vxl.vxl.VxlList;
import de.dailab.vsdt.vxl.vxl.VxlListElement;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VxlFactoryImpl extends EFactoryImpl implements VxlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VxlFactory init()
  {
    try
    {
      VxlFactory theVxlFactory = (VxlFactory)EPackage.Registry.INSTANCE.getEFactory(VxlPackage.eNS_URI);
      if (theVxlFactory != null)
      {
        return theVxlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new VxlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case VxlPackage.VXL_TERM: return createVxlTerm();
      case VxlPackage.VXL_ELEMENT: return createVxlElement();
      case VxlPackage.VXL_BRACKET_TERM: return createVxlBracketTerm();
      case VxlPackage.VXL_NEGATION: return createVxlNegation();
      case VxlPackage.VXL_MINUS: return createVxlMinus();
      case VxlPackage.VXL_CARDINALITY: return createVxlCardinality();
      case VxlPackage.VXL_VARIABLE: return createVxlVariable();
      case VxlPackage.VXL_ACCESSOR: return createVxlAccessor();
      case VxlPackage.VXL_ARRAY_ACCESSOR: return createVxlArrayAccessor();
      case VxlPackage.VXL_FIELD_ACCESSOR: return createVxlFieldAccessor();
      case VxlPackage.VXL_LIST: return createVxlList();
      case VxlPackage.VXL_LIST_ELEMENT: return createVxlListElement();
      case VxlPackage.VXL_VALUE: return createVxlValue();
      case VxlPackage.VXL_BOOLEAN_CONST: return createVxlBooleanConst();
      case VxlPackage.VXL_NULL_CONST: return createVxlNullConst();
      case VxlPackage.VXL_NUMERIC_CONST: return createVxlNumericConst();
      case VxlPackage.VXL_STRING_CONST: return createVxlStringConst();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case VxlPackage.VXL_OPERATOR:
        return createVxlOperatorFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case VxlPackage.VXL_OPERATOR:
        return convertVxlOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlTerm createVxlTerm()
  {
    VxlTermImpl vxlTerm = new VxlTermImpl();
    return vxlTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlElement createVxlElement()
  {
    VxlElementImpl vxlElement = new VxlElementImpl();
    return vxlElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlBracketTerm createVxlBracketTerm()
  {
    VxlBracketTermImpl vxlBracketTerm = new VxlBracketTermImpl();
    return vxlBracketTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlNegation createVxlNegation()
  {
    VxlNegationImpl vxlNegation = new VxlNegationImpl();
    return vxlNegation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlMinus createVxlMinus()
  {
    VxlMinusImpl vxlMinus = new VxlMinusImpl();
    return vxlMinus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlCardinality createVxlCardinality()
  {
    VxlCardinalityImpl vxlCardinality = new VxlCardinalityImpl();
    return vxlCardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlVariable createVxlVariable()
  {
    VxlVariableImpl vxlVariable = new VxlVariableImpl();
    return vxlVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlAccessor createVxlAccessor()
  {
    VxlAccessorImpl vxlAccessor = new VxlAccessorImpl();
    return vxlAccessor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlArrayAccessor createVxlArrayAccessor()
  {
    VxlArrayAccessorImpl vxlArrayAccessor = new VxlArrayAccessorImpl();
    return vxlArrayAccessor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlFieldAccessor createVxlFieldAccessor()
  {
    VxlFieldAccessorImpl vxlFieldAccessor = new VxlFieldAccessorImpl();
    return vxlFieldAccessor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlList createVxlList()
  {
    VxlListImpl vxlList = new VxlListImpl();
    return vxlList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlListElement createVxlListElement()
  {
    VxlListElementImpl vxlListElement = new VxlListElementImpl();
    return vxlListElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlValue createVxlValue()
  {
    VxlValueImpl vxlValue = new VxlValueImpl();
    return vxlValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlBooleanConst createVxlBooleanConst()
  {
    VxlBooleanConstImpl vxlBooleanConst = new VxlBooleanConstImpl();
    return vxlBooleanConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlNullConst createVxlNullConst()
  {
    VxlNullConstImpl vxlNullConst = new VxlNullConstImpl();
    return vxlNullConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlNumericConst createVxlNumericConst()
  {
    VxlNumericConstImpl vxlNumericConst = new VxlNumericConstImpl();
    return vxlNumericConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlStringConst createVxlStringConst()
  {
    VxlStringConstImpl vxlStringConst = new VxlStringConstImpl();
    return vxlStringConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlOperator createVxlOperatorFromString(EDataType eDataType, String initialValue)
  {
    VxlOperator result = VxlOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertVxlOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlPackage getVxlPackage()
  {
    return (VxlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static VxlPackage getPackage()
  {
    return VxlPackage.eINSTANCE;
  }

} //VxlFactoryImpl
