/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl.util;

import de.dailab.vsdt.vxl.vxl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage
 * @generated
 */
public class VxlAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static VxlPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VxlAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = VxlPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VxlSwitch<Adapter> modelSwitch =
    new VxlSwitch<Adapter>()
    {
      @Override
      public Adapter caseTerm(Term object)
      {
        return createTermAdapter();
      }
      @Override
      public Adapter caseHead(Head object)
      {
        return createHeadAdapter();
      }
      @Override
      public Adapter caseTail(Tail object)
      {
        return createTailAdapter();
      }
      @Override
      public Adapter caseBracketTerm(BracketTerm object)
      {
        return createBracketTermAdapter();
      }
      @Override
      public Adapter caseNegation(Negation object)
      {
        return createNegationAdapter();
      }
      @Override
      public Adapter caseMinus(Minus object)
      {
        return createMinusAdapter();
      }
      @Override
      public Adapter caseAtom(Atom object)
      {
        return createAtomAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseAccessor(Accessor object)
      {
        return createAccessorAdapter();
      }
      @Override
      public Adapter caseArrayAccessor(ArrayAccessor object)
      {
        return createArrayAccessorAdapter();
      }
      @Override
      public Adapter caseFieldAccessor(FieldAccessor object)
      {
        return createFieldAccessorAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseStringConst(StringConst object)
      {
        return createStringConstAdapter();
      }
      @Override
      public Adapter caseNumericConst(NumericConst object)
      {
        return createNumericConstAdapter();
      }
      @Override
      public Adapter caseBooleanConst(BooleanConst object)
      {
        return createBooleanConstAdapter();
      }
      @Override
      public Adapter caseNullConst(NullConst object)
      {
        return createNullConstAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Term
   * @generated
   */
  public Adapter createTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Head <em>Head</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Head
   * @generated
   */
  public Adapter createHeadAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Tail <em>Tail</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Tail
   * @generated
   */
  public Adapter createTailAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.BracketTerm <em>Bracket Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.BracketTerm
   * @generated
   */
  public Adapter createBracketTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Negation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Negation
   * @generated
   */
  public Adapter createNegationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Minus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Minus
   * @generated
   */
  public Adapter createMinusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Atom <em>Atom</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Atom
   * @generated
   */
  public Adapter createAtomAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Accessor <em>Accessor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Accessor
   * @generated
   */
  public Adapter createAccessorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.ArrayAccessor <em>Array Accessor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.ArrayAccessor
   * @generated
   */
  public Adapter createArrayAccessorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.FieldAccessor <em>Field Accessor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.FieldAccessor
   * @generated
   */
  public Adapter createFieldAccessorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.StringConst <em>String Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.StringConst
   * @generated
   */
  public Adapter createStringConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.NumericConst <em>Numeric Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.NumericConst
   * @generated
   */
  public Adapter createNumericConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.BooleanConst <em>Boolean Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.BooleanConst
   * @generated
   */
  public Adapter createBooleanConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.NullConst <em>Null Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.NullConst
   * @generated
   */
  public Adapter createNullConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //VxlAdapterFactory
