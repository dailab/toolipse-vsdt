/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.util.VsdtHelper;
import de.dailab.vsdt.vxl.util.Util;
import de.dailab.vsdt.vxl.util.VxlParseException;
import de.dailab.vsdt.vxl.util.VxlParser;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.ExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ExpressionImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionImpl extends EObjectImpl implements Expression {
	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EXPRESSION__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EXPRESSION__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getGlobalExpressionLanguage() {
		try {
			// retrieve the BPD as the first element of the Resource's content
			BusinessProcessSystem bps= (BusinessProcessSystem) eResource().getContents().get(0);
			return bps.getExpressionLanguage();
		} catch (Exception e) {
			// Problem: no Resource, no Content, Content not BPD -- all of which should not occur
			// This can occur, however, if an expression has temporarily been created as a wrapper
			// for passing a plain String to some method expecting an Expression.
//			System.err.println("Error: The Expression seems not to be contained in a Resource holding a Business Process Diagram");
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method returns the expression language to be used by this specific expression.
	 * If the language attribute is set and not empty, then that language will be returned,
	 * otherwise the global expression language will be used. In any case, the result
	 * will be null if the language is an empty string.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getExpressionLanguageToBeUsed() {
		String lang= null;
		if (getLanguage() != null && ! getLanguage().trim().isEmpty()) {
			lang= getLanguage();
		} else {
			lang= getGlobalExpressionLanguage();
		}
		if (lang != null) {
			lang= lang.trim().isEmpty() ? null : lang.trim(); 
		}
		return lang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * If this is an VLX expression, try to parse it, otherwise return true.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validate() {
		String lang= getExpressionLanguageToBeUsed();
		if (expression == null) {
			return true;
		}
		if (Util.languageIsVxl(lang)) {
			VxlParser parser= VxlParser.getInstance();
			try {
				// try to parse
				parser.parse(expression);
				List<String> varNames= new ArrayList<String>();
				for (Property prop : VsdtHelper.getVisibleProperties(this)) {
					varNames.add(prop.getName());
				}
				return parser.getUnknownVariables(varNames).isEmpty();
			} catch (VxlParseException e) {
				// failed to parse or parsed with error
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VsdtPackage.EXPRESSION__EXPRESSION:
				return getExpression();
			case VsdtPackage.EXPRESSION__LANGUAGE:
				return getLanguage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VsdtPackage.EXPRESSION__EXPRESSION:
				setExpression((String)newValue);
				return;
			case VsdtPackage.EXPRESSION__LANGUAGE:
				setLanguage((String)newValue);
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
			case VsdtPackage.EXPRESSION__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case VsdtPackage.EXPRESSION__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
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
			case VsdtPackage.EXPRESSION__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case VsdtPackage.EXPRESSION__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
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
		result.append(" (expression: ");
		result.append(expression);
		result.append(", language: ");
		result.append(language);
		result.append(')');
		return result.toString();
	}

} //ExpressionImpl
