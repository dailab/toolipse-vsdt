/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans.impl;

import jiacbeans.CodeElement;
import jiacbeans.JavaVariable;
import jiacbeans.JiacbeansPackage;
import jiacbeans.Recieve;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recieve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.RecieveImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link jiacbeans.impl.RecieveImpl#getPayload <em>Payload</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecieveImpl extends ScriptImpl implements Recieve {
	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPayload() <em>Payload</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayload()
	 * @generated
	 * @ordered
	 */
	protected JavaVariable payload;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecieveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.RECIEVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.RECIEVE__ADDRESS, oldAddress, address));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaVariable getPayload() {
		if (payload != null && payload.eIsProxy()) {
			InternalEObject oldPayload = (InternalEObject)payload;
			payload = (JavaVariable)eResolveProxy(oldPayload);
			if (payload != oldPayload) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JiacbeansPackage.RECIEVE__PAYLOAD, oldPayload, payload));
			}
		}
		return payload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaVariable basicGetPayload() {
		return payload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayload(JavaVariable newPayload) {
		JavaVariable oldPayload = payload;
		payload = newPayload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.RECIEVE__PAYLOAD, oldPayload, payload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.RECIEVE__ADDRESS:
				return getAddress();
			case JiacbeansPackage.RECIEVE__PAYLOAD:
				if (resolve) return getPayload();
				return basicGetPayload();
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
			case JiacbeansPackage.RECIEVE__ADDRESS:
				setAddress((String)newValue);
				return;
			case JiacbeansPackage.RECIEVE__PAYLOAD:
				setPayload((JavaVariable)newValue);
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
			case JiacbeansPackage.RECIEVE__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case JiacbeansPackage.RECIEVE__PAYLOAD:
				setPayload((JavaVariable)null);
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
			case JiacbeansPackage.RECIEVE__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case JiacbeansPackage.RECIEVE__PAYLOAD:
				return payload != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * return the java code representation
	 */
	@Override
	public String toString() {
		String result = "";
		result += "Action joinAction = retrieveAction(ICommunicationBean.ACTION_JOIN_GROUP);\n";
		result += "Action leaveAction = retrieveAction(ICommunicationBean.ACTION_LEAVE_GROUP);\n";
		//create Groupaddress
		result += "IGroupAddress groupAddress = CommunicationAddressFactory.createGroupAddress(\""+address+"\");\n";
		//invoke join action
		result += "invoke(joinAction,new Serializable[]{groupAddress});\n";
		//read
		result += payload.toString()+" = null;";//declare payload variable
		//wait for message
		result+="while("+payload.getName()+"==null) {\n";
		//read message from memory
		result+="\tSet<IFact> all = memory.readAll();\n";
		result+="\tfor(IFact fact : all){\n";
		result+="\t\tif(fact instanceof JiacMessage) {\n";
		result+="\t\t\tJiacMessage jiacMessage = (JiacMessage)fact;\n";
		//check the payload and address
		result+="\t\t\tif(jiacMessage.getPayload() instanceof "+payload.getType()+" && jiacMessage.getHeader(IJiacMessage.Header.SEND_TO).equals(address)) {\n";
		result+="\t\t\t\tmemory.remove(jiacMessage);";
		result+="\t\t\t\t"+payload.getName()+" = jiacMessage.getPayload();\n";
		result+="\t\t\t\tbreak;\n";//message found leave foreach block
		result+="\t\t\t}\n";//closing if
		//next
		result+="\t\t}\n";//closing if
		result+="\t}\n";//closing foreach
		//wait 100 ms and then try again 
		result+="\ttry{\n";
		result+="\t\tThread.sleep(100);\n";
		result+="\t} catch(InterruptedException e) { }\n";
		result+="}\n";//closing while
		//leave group
		result+="invoke(leaveAction, new Serializable[]{groupAddress});\n";
		//assign to payload
		return result;
	}

} //RecieveImpl
