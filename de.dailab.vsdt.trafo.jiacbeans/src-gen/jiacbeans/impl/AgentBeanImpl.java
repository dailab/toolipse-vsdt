/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans.impl;

import java.util.Collection;
import jiacbeans.Action;
import jiacbeans.AgentBean;
import jiacbeans.JavaVariable;
import jiacbeans.JiacbeansPackage;

import jiacbeans.Method;
import jiacbeans.SubProcess;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent Bean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#getName <em>Name</em>}</li>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#getSubprocesses <em>Subprocesses</em>}</li>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#isHasTimeEventHandler <em>Has Time Event Handler</em>}</li>
 *   <li>{@link jiacbeans.impl.AgentBeanImpl#isHasMessageEventHandler <em>Has Message Event Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AgentBeanImpl extends EObjectImpl implements AgentBean {
	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methods;

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
	 * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected String packageName = PACKAGE_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<String> imports;

	/**
	 * The cached value of the '{@link #getSubprocesses() <em>Subprocesses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubprocesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubProcess> subprocesses;

	/**
	 * The default value of the '{@link #isHasTimeEventHandler() <em>Has Time Event Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasTimeEventHandler()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_TIME_EVENT_HANDLER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasTimeEventHandler() <em>Has Time Event Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasTimeEventHandler()
	 * @generated
	 * @ordered
	 */
	protected boolean hasTimeEventHandler = HAS_TIME_EVENT_HANDLER_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasMessageEventHandler() <em>Has Message Event Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasMessageEventHandler()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_MESSAGE_EVENT_HANDLER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasMessageEventHandler() <em>Has Message Event Handler</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasMessageEventHandler()
	 * @generated
	 * @ordered
	 */
	protected boolean hasMessageEventHandler = HAS_MESSAGE_EVENT_HANDLER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AgentBeanImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.AGENT_BEAN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectResolvingEList<Method>(Method.class, this, JiacbeansPackage.AGENT_BEAN__METHODS);
		}
		return methods;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.AGENT_BEAN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageName(String newPackageName) {
		String oldPackageName = packageName;
		packageName = newPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.AGENT_BEAN__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaVariable> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectResolvingEList<JavaVariable>(JavaVariable.class, this, JiacbeansPackage.AGENT_BEAN__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectResolvingEList<Action>(Action.class, this, JiacbeansPackage.AGENT_BEAN__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getImports() {
		if (imports == null) {
			imports = new EDataTypeUniqueEList<String>(String.class, this, JiacbeansPackage.AGENT_BEAN__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubProcess> getSubprocesses() {
		if (subprocesses == null) {
			subprocesses = new EObjectResolvingEList<SubProcess>(SubProcess.class, this, JiacbeansPackage.AGENT_BEAN__SUBPROCESSES);
		}
		return subprocesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasTimeEventHandler() {
		return hasTimeEventHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasTimeEventHandler(boolean newHasTimeEventHandler) {
		boolean oldHasTimeEventHandler = hasTimeEventHandler;
		hasTimeEventHandler = newHasTimeEventHandler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.AGENT_BEAN__HAS_TIME_EVENT_HANDLER, oldHasTimeEventHandler, hasTimeEventHandler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasMessageEventHandler() {
		return hasMessageEventHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasMessageEventHandler(boolean newHasMessageEventHandler) {
		boolean oldHasMessageEventHandler = hasMessageEventHandler;
		hasMessageEventHandler = newHasMessageEventHandler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.AGENT_BEAN__HAS_MESSAGE_EVENT_HANDLER, oldHasMessageEventHandler, hasMessageEventHandler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addMethod(Method m) {
		getMethods().add(m);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.AGENT_BEAN__METHODS:
				return getMethods();
			case JiacbeansPackage.AGENT_BEAN__NAME:
				return getName();
			case JiacbeansPackage.AGENT_BEAN__PACKAGE_NAME:
				return getPackageName();
			case JiacbeansPackage.AGENT_BEAN__ATTRIBUTES:
				return getAttributes();
			case JiacbeansPackage.AGENT_BEAN__ACTIONS:
				return getActions();
			case JiacbeansPackage.AGENT_BEAN__IMPORTS:
				return getImports();
			case JiacbeansPackage.AGENT_BEAN__SUBPROCESSES:
				return getSubprocesses();
			case JiacbeansPackage.AGENT_BEAN__HAS_TIME_EVENT_HANDLER:
				return isHasTimeEventHandler();
			case JiacbeansPackage.AGENT_BEAN__HAS_MESSAGE_EVENT_HANDLER:
				return isHasMessageEventHandler();
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
			case JiacbeansPackage.AGENT_BEAN__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Method>)newValue);
				return;
			case JiacbeansPackage.AGENT_BEAN__NAME:
				setName((String)newValue);
				return;
			case JiacbeansPackage.AGENT_BEAN__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case JiacbeansPackage.AGENT_BEAN__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends JavaVariable>)newValue);
				return;
			case JiacbeansPackage.AGENT_BEAN__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case JiacbeansPackage.AGENT_BEAN__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends String>)newValue);
				return;
			case JiacbeansPackage.AGENT_BEAN__SUBPROCESSES:
				getSubprocesses().clear();
				getSubprocesses().addAll((Collection<? extends SubProcess>)newValue);
				return;
			case JiacbeansPackage.AGENT_BEAN__HAS_TIME_EVENT_HANDLER:
				setHasTimeEventHandler((Boolean)newValue);
				return;
			case JiacbeansPackage.AGENT_BEAN__HAS_MESSAGE_EVENT_HANDLER:
				setHasMessageEventHandler((Boolean)newValue);
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
			case JiacbeansPackage.AGENT_BEAN__METHODS:
				getMethods().clear();
				return;
			case JiacbeansPackage.AGENT_BEAN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JiacbeansPackage.AGENT_BEAN__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case JiacbeansPackage.AGENT_BEAN__ATTRIBUTES:
				getAttributes().clear();
				return;
			case JiacbeansPackage.AGENT_BEAN__ACTIONS:
				getActions().clear();
				return;
			case JiacbeansPackage.AGENT_BEAN__IMPORTS:
				getImports().clear();
				return;
			case JiacbeansPackage.AGENT_BEAN__SUBPROCESSES:
				getSubprocesses().clear();
				return;
			case JiacbeansPackage.AGENT_BEAN__HAS_TIME_EVENT_HANDLER:
				setHasTimeEventHandler(HAS_TIME_EVENT_HANDLER_EDEFAULT);
				return;
			case JiacbeansPackage.AGENT_BEAN__HAS_MESSAGE_EVENT_HANDLER:
				setHasMessageEventHandler(HAS_MESSAGE_EVENT_HANDLER_EDEFAULT);
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
			case JiacbeansPackage.AGENT_BEAN__METHODS:
				return methods != null && !methods.isEmpty();
			case JiacbeansPackage.AGENT_BEAN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JiacbeansPackage.AGENT_BEAN__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case JiacbeansPackage.AGENT_BEAN__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case JiacbeansPackage.AGENT_BEAN__ACTIONS:
				return actions != null && !actions.isEmpty();
			case JiacbeansPackage.AGENT_BEAN__IMPORTS:
				return imports != null && !imports.isEmpty();
			case JiacbeansPackage.AGENT_BEAN__SUBPROCESSES:
				return subprocesses != null && !subprocesses.isEmpty();
			case JiacbeansPackage.AGENT_BEAN__HAS_TIME_EVENT_HANDLER:
				return hasTimeEventHandler != HAS_TIME_EVENT_HANDLER_EDEFAULT;
			case JiacbeansPackage.AGENT_BEAN__HAS_MESSAGE_EVENT_HANDLER:
				return hasMessageEventHandler != HAS_MESSAGE_EVENT_HANDLER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", packageName: ");
		result.append(packageName);
		result.append(')');
		return result.toString();
	}

} //AgentBeanImpl
