package de.dailab.vsdt.diagram.expressions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
@SuppressWarnings("rawtypes")
public abstract class VsdtAbstractExpression {

	/**
	 * @generated
	 */
	private IStatus status = Status.OK_STATUS;

	/**
	 * @generated
	 */
	protected void setStatus(int severity, String message, Throwable throwable) {
		String pluginID = VsdtDiagramEditorPlugin.ID;
		this.status = new Status(severity, pluginID, -1,
				(message != null) ? message : "", throwable); //$NON-NLS-1$
		if (!this.status.isOK()) {
			VsdtDiagramEditorPlugin
					.getInstance()
					.logError(
							"Expression problem:" + message + "body:" + body(), throwable); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * @generated
	 */
	public IStatus getStatus() {
		return status;
	}

	/**
	 * @generated
	 */
	private final String myBody;

	/**
	 * @generated
	 */
	public String body() {
		return myBody;
	}

	/**
	 * @generated
	 */
	private final EClassifier myContext;

	/**
	 * @generated
	 */
	public EClassifier context() {
		return myContext;
	}

	/**
	 * @generated
	 */
	protected VsdtAbstractExpression(String body, EClassifier context) {
		myBody = body;
		myContext = context;
	}

	/**
	 * @generated
	 */
	protected abstract Object doEvaluate(Object context, Map env);

	/**
	 * @generated
	 */
	public Object evaluate(Object context) {
		return evaluate(context, Collections.EMPTY_MAP);
	}

	/**
	 * @generated
	 */
	public Object evaluate(Object context, Map env) {
		if (context().isInstance(context)) {
			try {
				return doEvaluate(context, env);
			} catch (Exception e) {
				VsdtDiagramEditorPlugin.getInstance().logError(
						"Expression evaluation failure: " + body(), e);//$NON-NLS-1$
			}
		}
		return null;
	}

	/**
	 * Expression may return number value which is not directly compatible with feature type (e.g. Double when Integer is expected), or EEnumLiteral meta-object when literal instance is expected
	 * @generated
	 */
	public static Object performCast(Object value, EDataType targetType) {
		if (targetType instanceof EEnum) {
			if (value instanceof EEnumLiteral) {
				EEnumLiteral literal = (EEnumLiteral) value;
				return (literal.getInstance() != null) ? literal.getInstance()
						: literal;
			}
		}
		if (false == value instanceof Number || targetType == null
				|| targetType.getInstanceClass() == null) {
			return value;
		}
		Class targetClass = targetType.getInstanceClass();
		Number num = (Number) value;
		Class valClass = value.getClass();
		Class targetWrapperClass = targetClass;
		if (targetClass.isPrimitive()) {
			targetWrapperClass = EcoreUtil.wrapperClassFor(targetClass);
		}
		if (valClass.equals(targetWrapperClass)) {
			return value;
		}
		if (Number.class.isAssignableFrom(targetWrapperClass)) {
			if (targetWrapperClass.equals(Byte.class))
				return Byte.valueOf(num.byteValue());
			if (targetWrapperClass.equals(Integer.class))
				return Integer.valueOf(num.intValue());
			if (targetWrapperClass.equals(Short.class))
				return Short.valueOf(num.shortValue());
			if (targetWrapperClass.equals(Long.class))
				return Long.valueOf(num.longValue());
			if (targetWrapperClass.equals(BigInteger.class))
				return BigInteger.valueOf(num.longValue());
			if (targetWrapperClass.equals(Float.class))
				return Float.valueOf(num.floatValue());
			if (targetWrapperClass.equals(Double.class))
				return Double.valueOf(num.doubleValue());
			if (targetWrapperClass.equals(BigDecimal.class))
				return BigDecimal.valueOf(num.doubleValue());
		}
		return value;
	}

}
