/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans.impl;

import java.util.Collection;

import jiacbeans.Action;
import jiacbeans.JiacbeansPackage;
import jiacbeans.Method;
import jiacbeans.Script;
import jiacbeans.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.MethodImpl#getContent <em>Content</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getThrows <em>Throws</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getExposedAs <em>Exposed As</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodImpl extends NamedElementImpl implements Method {
	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected Script content;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> parameters;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;
	/**
	 * The default value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @ordered
	 */
	protected static final String RETURN_TYPE_EDEFAULT = "void";
	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected String returnType = RETURN_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final String VISIBILITY_EDEFAULT = "public";

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected String visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getThrows() <em>Throws</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrows()
	 * @generated
	 * @ordered
	 */
	protected EList<String> throws_;

	/**
	 * The cached value of the '{@link #getExposedAs() <em>Exposed As</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExposedAs()
	 * @generated
	 * @ordered
	 */
	protected Action exposedAs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script getContent() {
		if (content != null && content.eIsProxy()) {
			InternalEObject oldContent = (InternalEObject)content;
			content = (Script)eResolveProxy(oldContent);
			if (content != oldContent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JiacbeansPackage.METHOD__CONTENT, oldContent, content));
			}
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script basicGetContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(Script newContent) {
		Script oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.METHOD__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(String newReturnType) {
		String oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.METHOD__RETURN_TYPE, oldReturnType, returnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(String newVisibility) {
		String oldVisibility = visibility;
		visibility = newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.METHOD__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getThrows() {
		if (throws_ == null) {
			throws_ = new EDataTypeUniqueEList<String>(String.class, this, JiacbeansPackage.METHOD__THROWS);
		}
		return throws_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getExposedAs() {
		if (exposedAs != null && exposedAs.eIsProxy()) {
			InternalEObject oldExposedAs = (InternalEObject)exposedAs;
			exposedAs = (Action)eResolveProxy(oldExposedAs);
			if (exposedAs != oldExposedAs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JiacbeansPackage.METHOD__EXPOSED_AS, oldExposedAs, exposedAs));
			}
		}
		return exposedAs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetExposedAs() {
		return exposedAs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExposedAs(Action newExposedAs) {
		Action oldExposedAs = exposedAs;
		exposedAs = newExposedAs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.METHOD__EXPOSED_AS, oldExposedAs, exposedAs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<Variable>(Variable.class, this, JiacbeansPackage.METHOD__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectResolvingEList<Variable>(Variable.class, this, JiacbeansPackage.METHOD__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.METHOD__CONTENT:
				if (resolve) return getContent();
				return basicGetContent();
			case JiacbeansPackage.METHOD__PARAMETERS:
				return getParameters();
			case JiacbeansPackage.METHOD__VARIABLES:
				return getVariables();
			case JiacbeansPackage.METHOD__RETURN_TYPE:
				return getReturnType();
			case JiacbeansPackage.METHOD__VISIBILITY:
				return getVisibility();
			case JiacbeansPackage.METHOD__THROWS:
				return getThrows();
			case JiacbeansPackage.METHOD__EXPOSED_AS:
				if (resolve) return getExposedAs();
				return basicGetExposedAs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JiacbeansPackage.METHOD__CONTENT:
				setContent((Script)newValue);
				return;
			case JiacbeansPackage.METHOD__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Variable>)newValue);
				return;
			case JiacbeansPackage.METHOD__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
				return;
			case JiacbeansPackage.METHOD__RETURN_TYPE:
				setReturnType((String)newValue);
				return;
			case JiacbeansPackage.METHOD__VISIBILITY:
				setVisibility((String)newValue);
				return;
			case JiacbeansPackage.METHOD__THROWS:
				getThrows().clear();
				getThrows().addAll((Collection<? extends String>)newValue);
				return;
			case JiacbeansPackage.METHOD__EXPOSED_AS:
				setExposedAs((Action)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case JiacbeansPackage.METHOD__CONTENT:
				setContent((Script)null);
				return;
			case JiacbeansPackage.METHOD__PARAMETERS:
				getParameters().clear();
				return;
			case JiacbeansPackage.METHOD__VARIABLES:
				getVariables().clear();
				return;
			case JiacbeansPackage.METHOD__RETURN_TYPE:
				setReturnType(RETURN_TYPE_EDEFAULT);
				return;
			case JiacbeansPackage.METHOD__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case JiacbeansPackage.METHOD__THROWS:
				getThrows().clear();
				return;
			case JiacbeansPackage.METHOD__EXPOSED_AS:
				setExposedAs((Action)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JiacbeansPackage.METHOD__CONTENT:
				return content != null;
			case JiacbeansPackage.METHOD__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case JiacbeansPackage.METHOD__VARIABLES:
				return variables != null && !variables.isEmpty();
			case JiacbeansPackage.METHOD__RETURN_TYPE:
				return RETURN_TYPE_EDEFAULT == null ? returnType != null : !RETURN_TYPE_EDEFAULT.equals(returnType);
			case JiacbeansPackage.METHOD__VISIBILITY:
				return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
			case JiacbeansPackage.METHOD__THROWS:
				return throws_ != null && !throws_.isEmpty();
			case JiacbeansPackage.METHOD__EXPOSED_AS:
				return exposedAs != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (returnType: ");
		result.append(returnType);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(", throws: ");
		result.append(throws_);
		result.append(')');
		return result.toString();
	}

} //MethodImpl
