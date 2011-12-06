/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;

import jiacbeans.JavaVariable;
import jiacbeans.JiacbeansPackage;
import jiacbeans.Method;
import jiacbeans.Script;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.MethodImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getName <em>Name</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getContent <em>Content</em>}</li>
 *   <li>{@link jiacbeans.impl.MethodImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodImpl extends EObjectImpl implements Method {
	public static final int PRIVATE = 0;
	public static final int PROTECTED = 1;
	public static final int PUBLIC = 2;
	public static final String[] VISIBILITIES = new String[]{"private","protected","public"};
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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaVariable> parameters;
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The default value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STATIC_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean isStatic = IS_STATIC_EDEFAULT;
	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final int VISIBILITY_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected int visibility = VISIBILITY_EDEFAULT;
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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaVariable> attributes;

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
	public EList<JavaVariable> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectResolvingEList<JavaVariable>(JavaVariable.class, this, JiacbeansPackage.METHOD__ATTRIBUTES);
		}
		return attributes;
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
	public EList<JavaVariable> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<JavaVariable>(JavaVariable.class, this, JiacbeansPackage.METHOD__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.METHOD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStatic() {
		return isStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStatic(boolean newIsStatic) {
		boolean oldIsStatic = isStatic;
		isStatic = newIsStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.METHOD__IS_STATIC, oldIsStatic, isStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(int newVisibility) {
		int oldVisibility = visibility;
		visibility = newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.METHOD__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.METHOD__RETURN_TYPE:
				return getReturnType();
			case JiacbeansPackage.METHOD__PARAMETERS:
				return getParameters();
			case JiacbeansPackage.METHOD__NAME:
				return getName();
			case JiacbeansPackage.METHOD__IS_STATIC:
				return isIsStatic();
			case JiacbeansPackage.METHOD__VISIBILITY:
				return getVisibility();
			case JiacbeansPackage.METHOD__CONTENT:
				if (resolve) return getContent();
				return basicGetContent();
			case JiacbeansPackage.METHOD__ATTRIBUTES:
				return getAttributes();
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
			case JiacbeansPackage.METHOD__RETURN_TYPE:
				setReturnType((String)newValue);
				return;
			case JiacbeansPackage.METHOD__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends JavaVariable>)newValue);
				return;
			case JiacbeansPackage.METHOD__NAME:
				setName((String)newValue);
				return;
			case JiacbeansPackage.METHOD__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case JiacbeansPackage.METHOD__VISIBILITY:
				setVisibility((Integer)newValue);
				return;
			case JiacbeansPackage.METHOD__CONTENT:
				setContent((Script)newValue);
				return;
			case JiacbeansPackage.METHOD__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends JavaVariable>)newValue);
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
			case JiacbeansPackage.METHOD__RETURN_TYPE:
				setReturnType(RETURN_TYPE_EDEFAULT);
				return;
			case JiacbeansPackage.METHOD__PARAMETERS:
				getParameters().clear();
				return;
			case JiacbeansPackage.METHOD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JiacbeansPackage.METHOD__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case JiacbeansPackage.METHOD__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case JiacbeansPackage.METHOD__CONTENT:
				setContent((Script)null);
				return;
			case JiacbeansPackage.METHOD__ATTRIBUTES:
				getAttributes().clear();
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
			case JiacbeansPackage.METHOD__RETURN_TYPE:
				return RETURN_TYPE_EDEFAULT == null ? returnType != null : !RETURN_TYPE_EDEFAULT.equals(returnType);
			case JiacbeansPackage.METHOD__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case JiacbeansPackage.METHOD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JiacbeansPackage.METHOD__IS_STATIC:
				return isStatic != IS_STATIC_EDEFAULT;
			case JiacbeansPackage.METHOD__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case JiacbeansPackage.METHOD__CONTENT:
				return content != null;
			case JiacbeansPackage.METHOD__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Prints itself out as a Java Method
	 */
	@Override
	public String toString() {
		String result = "";
		result += VISIBILITIES[visibility]+" ";
		if(isStatic) result += "static"+" ";
		result += returnType +" "+name+"(";
		String params = "";
		boolean first = true;
		for (JavaVariable var : getParameters()) {
			if(!first)params+=", ";
			else first = false;
			params+= var.getType()+" "+var.getName();
		}
		result += params+") {\n";
		if(content!=null){
			String cS = content.toJavaCode();
			if(cS!=null && !cS.equals("")){
				BufferedReader reader = new BufferedReader(new StringReader(cS));
				try{
					String line = reader.readLine();
					while(line!=null){
						if(!line.equals(""))result+="\t"+line+"\n";
						line = reader.readLine();
					}
				}catch(IOException e){
					result +="//Error occured while reading content";
				}
			}
		}
		result+="}";
		return result;
	}
} //MethodImpl
