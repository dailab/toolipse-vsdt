/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.dailab.vsdt.vxl.Accessor;
import de.dailab.vsdt.vxl.ArrayAccessor;
import de.dailab.vsdt.vxl.Atom;
import de.dailab.vsdt.vxl.BooleanConst;
import de.dailab.vsdt.vxl.BracketTerm;
import de.dailab.vsdt.vxl.FieldAccessor;
import de.dailab.vsdt.vxl.Head;
import de.dailab.vsdt.vxl.Negation;
import de.dailab.vsdt.vxl.NullConst;
import de.dailab.vsdt.vxl.NumericConst;
import de.dailab.vsdt.vxl.Operator;
import de.dailab.vsdt.vxl.StringConst;
import de.dailab.vsdt.vxl.Tail;
import de.dailab.vsdt.vxl.Term;
import de.dailab.vsdt.vxl.VXLFactory;
import de.dailab.vsdt.vxl.VXLPackage;
import de.dailab.vsdt.vxl.Value;
import de.dailab.vsdt.vxl.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VXLFactoryImpl extends EFactoryImpl implements VXLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VXLFactory init()
  {
    try
    {
      VXLFactory theVXLFactory = (VXLFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.dailab.de/vsdt/Vxl"); 
      if (theVXLFactory != null)
      {
        return theVXLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new VXLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VXLFactoryImpl()
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
      case VXLPackage.TERM: return createTerm();
      case VXLPackage.HEAD: return createHead();
      case VXLPackage.TAIL: return createTail();
      case VXLPackage.BRACKET_TERM: return createBracketTerm();
      case VXLPackage.NEGATION: return createNegation();
      case VXLPackage.ATOM: return createAtom();
      case VXLPackage.VARIABLE: return createVariable();
      case VXLPackage.ACCESSOR: return createAccessor();
      case VXLPackage.ARRAY_ACCESSOR: return createArrayAccessor();
      case VXLPackage.FIELD_ACCESSOR: return createFieldAccessor();
      case VXLPackage.VALUE: return createValue();
      case VXLPackage.STRING_CONST: return createStringConst();
      case VXLPackage.NUMERIC_CONST: return createNumericConst();
      case VXLPackage.BOOLEAN_CONST: return createBooleanConst();
      case VXLPackage.NULL_CONST: return createNullConst();
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
      case VXLPackage.OPERATOR:
        return createOperatorFromString(eDataType, initialValue);
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
      case VXLPackage.OPERATOR:
        return convertOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Term createTerm()
  {
    TermImpl term = new TermImpl();
    return term;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Head createHead()
  {
    HeadImpl head = new HeadImpl();
    return head;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tail createTail()
  {
    TailImpl tail = new TailImpl();
    return tail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BracketTerm createBracketTerm()
  {
    BracketTermImpl bracketTerm = new BracketTermImpl();
    return bracketTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Negation createNegation()
  {
    NegationImpl negation = new NegationImpl();
    return negation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Atom createAtom()
  {
    AtomImpl atom = new AtomImpl();
    return atom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Accessor createAccessor()
  {
    AccessorImpl accessor = new AccessorImpl();
    return accessor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayAccessor createArrayAccessor()
  {
    ArrayAccessorImpl arrayAccessor = new ArrayAccessorImpl();
    return arrayAccessor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FieldAccessor createFieldAccessor()
  {
    FieldAccessorImpl fieldAccessor = new FieldAccessorImpl();
    return fieldAccessor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringConst createStringConst()
  {
    StringConstImpl stringConst = new StringConstImpl();
    return stringConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericConst createNumericConst()
  {
    NumericConstImpl numericConst = new NumericConstImpl();
    return numericConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanConst createBooleanConst()
  {
    BooleanConstImpl booleanConst = new BooleanConstImpl();
    return booleanConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullConst createNullConst()
  {
    NullConstImpl nullConst = new NullConstImpl();
    return nullConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operator createOperatorFromString(EDataType eDataType, String initialValue)
  {
    Operator result = Operator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VXLPackage getVXLPackage()
  {
    return (VXLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static VXLPackage getPackage()
  {
    return VXLPackage.eINSTANCE;
  }

} //VXLFactoryImpl
