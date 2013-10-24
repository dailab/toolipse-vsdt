/**
 */
package de.dailab.vsdt.vxl.vxl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.vxl.vxl.VxlAccessor;
import de.dailab.vsdt.vxl.vxl.VxlArrayAccessor;
import de.dailab.vsdt.vxl.vxl.VxlBooleanConst;
import de.dailab.vsdt.vxl.vxl.VxlBracketTerm;
import de.dailab.vsdt.vxl.vxl.VxlCardinality;
import de.dailab.vsdt.vxl.vxl.VxlElement;
import de.dailab.vsdt.vxl.vxl.VxlFieldAccessor;
import de.dailab.vsdt.vxl.vxl.VxlList;
import de.dailab.vsdt.vxl.vxl.VxlListElement;
import de.dailab.vsdt.vxl.vxl.VxlMinus;
import de.dailab.vsdt.vxl.vxl.VxlNegation;
import de.dailab.vsdt.vxl.vxl.VxlNullConst;
import de.dailab.vsdt.vxl.vxl.VxlNumericConst;
import de.dailab.vsdt.vxl.vxl.VxlPackage;
import de.dailab.vsdt.vxl.vxl.VxlStringConst;
import de.dailab.vsdt.vxl.vxl.VxlTerm;
import de.dailab.vsdt.vxl.vxl.VxlValue;
import de.dailab.vsdt.vxl.vxl.VxlVariable;

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
      public Adapter caseVxlTerm(VxlTerm object)
      {
        return createVxlTermAdapter();
      }
      @Override
      public Adapter caseVxlElement(VxlElement object)
      {
        return createVxlElementAdapter();
      }
      @Override
      public Adapter caseVxlBracketTerm(VxlBracketTerm object)
      {
        return createVxlBracketTermAdapter();
      }
      @Override
      public Adapter caseVxlNegation(VxlNegation object)
      {
        return createVxlNegationAdapter();
      }
      @Override
      public Adapter caseVxlMinus(VxlMinus object)
      {
        return createVxlMinusAdapter();
      }
      @Override
      public Adapter caseVxlCardinality(VxlCardinality object)
      {
        return createVxlCardinalityAdapter();
      }
      @Override
      public Adapter caseVxlVariable(VxlVariable object)
      {
        return createVxlVariableAdapter();
      }
      @Override
      public Adapter caseVxlAccessor(VxlAccessor object)
      {
        return createVxlAccessorAdapter();
      }
      @Override
      public Adapter caseVxlArrayAccessor(VxlArrayAccessor object)
      {
        return createVxlArrayAccessorAdapter();
      }
      @Override
      public Adapter caseVxlFieldAccessor(VxlFieldAccessor object)
      {
        return createVxlFieldAccessorAdapter();
      }
      @Override
      public Adapter caseVxlList(VxlList object)
      {
        return createVxlListAdapter();
      }
      @Override
      public Adapter caseVxlListElement(VxlListElement object)
      {
        return createVxlListElementAdapter();
      }
      @Override
      public Adapter caseVxlValue(VxlValue object)
      {
        return createVxlValueAdapter();
      }
      @Override
      public Adapter caseVxlBooleanConst(VxlBooleanConst object)
      {
        return createVxlBooleanConstAdapter();
      }
      @Override
      public Adapter caseVxlNullConst(VxlNullConst object)
      {
        return createVxlNullConstAdapter();
      }
      @Override
      public Adapter caseVxlNumericConst(VxlNumericConst object)
      {
        return createVxlNumericConstAdapter();
      }
      @Override
      public Adapter caseVxlStringConst(VxlStringConst object)
      {
        return createVxlStringConstAdapter();
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
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlTerm
   * @generated
   */
  public Adapter createVxlTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlElement
   * @generated
   */
  public Adapter createVxlElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlBracketTerm <em>Bracket Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlBracketTerm
   * @generated
   */
  public Adapter createVxlBracketTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlNegation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlNegation
   * @generated
   */
  public Adapter createVxlNegationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlMinus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlMinus
   * @generated
   */
  public Adapter createVxlMinusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlCardinality
   * @generated
   */
  public Adapter createVxlCardinalityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlVariable
   * @generated
   */
  public Adapter createVxlVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlAccessor <em>Accessor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlAccessor
   * @generated
   */
  public Adapter createVxlAccessorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlArrayAccessor <em>Array Accessor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlArrayAccessor
   * @generated
   */
  public Adapter createVxlArrayAccessorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlFieldAccessor <em>Field Accessor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlFieldAccessor
   * @generated
   */
  public Adapter createVxlFieldAccessorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlList
   * @generated
   */
  public Adapter createVxlListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlListElement <em>List Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlListElement
   * @generated
   */
  public Adapter createVxlListElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlValue
   * @generated
   */
  public Adapter createVxlValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlBooleanConst <em>Boolean Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlBooleanConst
   * @generated
   */
  public Adapter createVxlBooleanConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlNullConst <em>Null Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlNullConst
   * @generated
   */
  public Adapter createVxlNullConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlNumericConst <em>Numeric Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlNumericConst
   * @generated
   */
  public Adapter createVxlNumericConstAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.dailab.vsdt.vxl.vxl.VxlStringConst <em>String Const</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.dailab.vsdt.vxl.vxl.VxlStringConst
   * @generated
   */
  public Adapter createVxlStringConstAdapter()
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
