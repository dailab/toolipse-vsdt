/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Parameter;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Process System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getExpressionLanguage <em>Expression Language</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getQueryLanguage <em>Query Language</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getModificationDate <em>Modification Date</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#isExecutable <em>Executable</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getBusinessProcesses <em>Business Processes</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getMessageChannels <em>Message Channels</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getServices <em>Services</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getDataTypes <em>Data Types</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessProcessSystemImpl extends IdObjectImpl implements BusinessProcessSystem {
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

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
	 * The default value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLanguage()
	 * @generated
	 * @ordered
	 */
	protected String expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getQueryLanguage() <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQueryLanguage() <em>Query Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryLanguage()
	 * @generated
	 * @ordered
	 */
	protected String queryLanguage = QUERY_LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModificationDate() <em>Modification Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date MODIFICATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModificationDate() <em>Modification Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModificationDate()
	 * @generated
	 * @ordered
	 */
	protected Date modificationDate = MODIFICATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isExecutable() <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXECUTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExecutable() <em>Executable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExecutable()
	 * @generated
	 * @ordered
	 */
	protected boolean executable = EXECUTABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBusinessProcesses() <em>Business Processes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusinessProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<BusinessProcessDiagram> businessProcesses;

	/**
	 * The cached value of the '{@link #getParticipants() <em>Participants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<Participant> participants;

	/**
	 * The cached value of the '{@link #getMessageChannels() <em>Message Channels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageChannels()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageChannel> messageChannels;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> services;

	/**
	 * The cached value of the '{@link #getDataTypes() <em>Data Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> dataTypes;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * + set name, creation date and modification date
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected BusinessProcessSystemImpl() {
		super();
		setName("New Business Process Diagram");
		setCreationDate(new Date());
		setModificationDate(new Date());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_SYSTEM__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_SYSTEM__AUTHOR, oldAuthor, author));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_SYSTEM__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionLanguage() {
		return expressionLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionLanguage(String newExpressionLanguage) {
		String oldExpressionLanguage = expressionLanguage;
		expressionLanguage = newExpressionLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE, oldExpressionLanguage, expressionLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQueryLanguage() {
		return queryLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryLanguage(String newQueryLanguage) {
		String oldQueryLanguage = queryLanguage;
		queryLanguage = newQueryLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE, oldQueryLanguage, queryLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_SYSTEM__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getModificationDate() {
		return modificationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModificationDate(Date newModificationDate) {
		Date oldModificationDate = modificationDate;
		modificationDate = newModificationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE, oldModificationDate, modificationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExecutable() {
		return executable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutable(boolean newExecutable) {
		boolean oldExecutable = executable;
		executable = newExecutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXECUTABLE, oldExecutable, executable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusinessProcessDiagram> getBusinessProcesses() {
		if (businessProcesses == null) {
			businessProcesses = new EObjectContainmentWithInverseEList<BusinessProcessDiagram>(BusinessProcessDiagram.class, this, VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARENT);
		}
		return businessProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Participant> getParticipants() {
		if (participants == null) {
			participants = new EObjectContainmentEList<Participant>(Participant.class, this, VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS);
		}
		return participants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageChannel> getMessageChannels() {
		if (messageChannels == null) {
			messageChannels = new EObjectContainmentEList<MessageChannel>(MessageChannel.class, this, VsdtPackage.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS);
		}
		return messageChannels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getServices() {
		if (services == null) {
			services = new EObjectContainmentEList<Service>(Service.class, this, VsdtPackage.BUSINESS_PROCESS_SYSTEM__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDataTypes() {
		if (dataTypes == null) {
			dataTypes = new EObjectContainmentEList<DataType>(DataType.class, this, VsdtPackage.BUSINESS_PROCESS_SYSTEM__DATA_TYPES);
		}
		return dataTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBusinessProcesses()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES:
				return ((InternalEList<?>)getBusinessProcesses()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS:
				return ((InternalEList<?>)getParticipants()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS:
				return ((InternalEList<?>)getMessageChannels()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__DATA_TYPES:
				return ((InternalEList<?>)getDataTypes()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__VERSION:
				return getVersion();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__AUTHOR:
				return getAuthor();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__LANGUAGE:
				return getLanguage();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE:
				return getExpressionLanguage();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE:
				return getQueryLanguage();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__CREATION_DATE:
				return getCreationDate();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE:
				return getModificationDate();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXECUTABLE:
				return isExecutable();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES:
				return getBusinessProcesses();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS:
				return getParticipants();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS:
				return getMessageChannels();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__SERVICES:
				return getServices();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__DATA_TYPES:
				return getDataTypes();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARAMETERS:
				return getParameters();
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
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__VERSION:
				setVersion((String)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__AUTHOR:
				setAuthor((String)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE:
				setExpressionLanguage((String)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE:
				setQueryLanguage((String)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE:
				setModificationDate((Date)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXECUTABLE:
				setExecutable((Boolean)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES:
				getBusinessProcesses().clear();
				getBusinessProcesses().addAll((Collection<? extends BusinessProcessDiagram>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS:
				getParticipants().clear();
				getParticipants().addAll((Collection<? extends Participant>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS:
				getMessageChannels().clear();
				getMessageChannels().addAll((Collection<? extends MessageChannel>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__DATA_TYPES:
				getDataTypes().clear();
				getDataTypes().addAll((Collection<? extends DataType>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
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
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE:
				setExpressionLanguage(EXPRESSION_LANGUAGE_EDEFAULT);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE:
				setQueryLanguage(QUERY_LANGUAGE_EDEFAULT);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE:
				setModificationDate(MODIFICATION_DATE_EDEFAULT);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXECUTABLE:
				setExecutable(EXECUTABLE_EDEFAULT);
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES:
				getBusinessProcesses().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS:
				getParticipants().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS:
				getMessageChannels().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__SERVICES:
				getServices().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__DATA_TYPES:
				getDataTypes().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARAMETERS:
				getParameters().clear();
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
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE:
				return EXPRESSION_LANGUAGE_EDEFAULT == null ? expressionLanguage != null : !EXPRESSION_LANGUAGE_EDEFAULT.equals(expressionLanguage);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE:
				return QUERY_LANGUAGE_EDEFAULT == null ? queryLanguage != null : !QUERY_LANGUAGE_EDEFAULT.equals(queryLanguage);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE:
				return MODIFICATION_DATE_EDEFAULT == null ? modificationDate != null : !MODIFICATION_DATE_EDEFAULT.equals(modificationDate);
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXECUTABLE:
				return executable != EXECUTABLE_EDEFAULT;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES:
				return businessProcesses != null && !businessProcesses.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS:
				return participants != null && !participants.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS:
				return messageChannels != null && !messageChannels.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__SERVICES:
				return services != null && !services.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__DATA_TYPES:
				return dataTypes != null && !dataTypes.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
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
		result.append(" (version: ");
		result.append(version);
		result.append(", author: ");
		result.append(author);
		result.append(", language: ");
		result.append(language);
		result.append(", expressionLanguage: ");
		result.append(expressionLanguage);
		result.append(", queryLanguage: ");
		result.append(queryLanguage);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(", modificationDate: ");
		result.append(modificationDate);
		result.append(", executable: ");
		result.append(executable);
		result.append(')');
		return result.toString();
	}

} //BusinessProcessSystemImpl
