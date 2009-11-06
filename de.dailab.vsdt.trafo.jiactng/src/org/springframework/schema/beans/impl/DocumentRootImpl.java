/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.springframework.schema.beans.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.springframework.schema.beans.AliasType;
import org.springframework.schema.beans.ArgTypeType;
import org.springframework.schema.beans.BeanType;
import org.springframework.schema.beans.BeansPackage;
import org.springframework.schema.beans.BeansType;
import org.springframework.schema.beans.ConstructorArgType;
import org.springframework.schema.beans.DescriptionType;
import org.springframework.schema.beans.DocumentRoot;
import org.springframework.schema.beans.EntryType;
import org.springframework.schema.beans.IdrefType;
import org.springframework.schema.beans.ImportType;
import org.springframework.schema.beans.KeyType;
import org.springframework.schema.beans.ListOrSetType;
import org.springframework.schema.beans.LookupMethodType;
import org.springframework.schema.beans.MapType;
import org.springframework.schema.beans.MetaType;
import org.springframework.schema.beans.NullType;
import org.springframework.schema.beans.PropType;
import org.springframework.schema.beans.PropertyType;
import org.springframework.schema.beans.PropsType;
import org.springframework.schema.beans.RefType;
import org.springframework.schema.beans.ReplacedMethodType;
import org.springframework.schema.beans.ValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getArgType <em>Arg Type</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getBean <em>Bean</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getBeans <em>Beans</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getConstructorArg <em>Constructor Arg</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getIdref <em>Idref</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getList <em>List</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getLookupMethod <em>Lookup Method</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getMap <em>Map</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getNull <em>Null</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getProp <em>Prop</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getProps <em>Props</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getReplacedMethod <em>Replaced Method</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getSet <em>Set</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.DocumentRootImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BeansPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, BeansPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, BeansPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, BeansPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AliasType getAlias() {
		return (AliasType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__ALIAS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlias(AliasType newAlias, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__ALIAS, newAlias, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlias(AliasType newAlias) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__ALIAS, newAlias);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgTypeType getArgType() {
		return (ArgTypeType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__ARG_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArgType(ArgTypeType newArgType, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__ARG_TYPE, newArgType, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgType(ArgTypeType newArgType) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__ARG_TYPE, newArgType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanType getBean() {
		return (BeanType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__BEAN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBean(BeanType newBean, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__BEAN, newBean, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBean(BeanType newBean) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__BEAN, newBean);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeansType getBeans() {
		return (BeansType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__BEANS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBeans(BeansType newBeans, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__BEANS, newBeans, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeans(BeansType newBeans) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__BEANS, newBeans);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorArgType getConstructorArg() {
		return (ConstructorArgType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__CONSTRUCTOR_ARG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstructorArg(ConstructorArgType newConstructorArg, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__CONSTRUCTOR_ARG, newConstructorArg, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructorArg(ConstructorArgType newConstructorArg) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__CONSTRUCTOR_ARG, newConstructorArg);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionType getDescription() {
		return (DescriptionType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(DescriptionType newDescription, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__DESCRIPTION, newDescription, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(DescriptionType newDescription) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryType getEntry() {
		return (EntryType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__ENTRY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEntry(EntryType newEntry, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__ENTRY, newEntry, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntry(EntryType newEntry) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__ENTRY, newEntry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdrefType getIdref() {
		return (IdrefType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__IDREF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdref(IdrefType newIdref, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__IDREF, newIdref, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdref(IdrefType newIdref) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__IDREF, newIdref);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportType getImport() {
		return (ImportType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__IMPORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImport(ImportType newImport, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__IMPORT, newImport, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImport(ImportType newImport) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__IMPORT, newImport);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType getKey() {
		return (KeyType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__KEY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKey(KeyType newKey, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__KEY, newKey, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(KeyType newKey) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__KEY, newKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOrSetType getList() {
		return (ListOrSetType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__LIST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetList(ListOrSetType newList, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__LIST, newList, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(ListOrSetType newList) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__LIST, newList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupMethodType getLookupMethod() {
		return (LookupMethodType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__LOOKUP_METHOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLookupMethod(LookupMethodType newLookupMethod, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__LOOKUP_METHOD, newLookupMethod, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLookupMethod(LookupMethodType newLookupMethod) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__LOOKUP_METHOD, newLookupMethod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapType getMap() {
		return (MapType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__MAP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMap(MapType newMap, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__MAP, newMap, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMap(MapType newMap) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__MAP, newMap);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaType getMeta() {
		return (MetaType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__META, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeta(MetaType newMeta, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__META, newMeta, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(MetaType newMeta) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__META, newMeta);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullType getNull() {
		return (NullType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__NULL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNull(NullType newNull, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__NULL, newNull, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNull(NullType newNull) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__NULL, newNull);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropType getProp() {
		return (PropType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__PROP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProp(PropType newProp, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__PROP, newProp, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProp(PropType newProp) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__PROP, newProp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType getProperty() {
		return (PropertyType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(PropertyType newProperty, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__PROPERTY, newProperty, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(PropertyType newProperty) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__PROPERTY, newProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropsType getProps() {
		return (PropsType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__PROPS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProps(PropsType newProps, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__PROPS, newProps, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProps(PropsType newProps) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__PROPS, newProps);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefType getRef() {
		return (RefType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRef(RefType newRef, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__REF, newRef, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(RefType newRef) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__REF, newRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacedMethodType getReplacedMethod() {
		return (ReplacedMethodType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__REPLACED_METHOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReplacedMethod(ReplacedMethodType newReplacedMethod, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__REPLACED_METHOD, newReplacedMethod, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplacedMethod(ReplacedMethodType newReplacedMethod) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__REPLACED_METHOD, newReplacedMethod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOrSetType getSet() {
		return (ListOrSetType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSet(ListOrSetType newSet, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__SET, newSet, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSet(ListOrSetType newSet) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__SET, newSet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueType getValue() {
		return (ValueType)getMixed().get(BeansPackage.Literals.DOCUMENT_ROOT__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(ValueType newValue, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(BeansPackage.Literals.DOCUMENT_ROOT__VALUE, newValue, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ValueType newValue) {
		((FeatureMap.Internal)getMixed()).set(BeansPackage.Literals.DOCUMENT_ROOT__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BeansPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case BeansPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case BeansPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case BeansPackage.DOCUMENT_ROOT__ALIAS:
				return basicSetAlias(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__ARG_TYPE:
				return basicSetArgType(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__BEAN:
				return basicSetBean(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__BEANS:
				return basicSetBeans(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__CONSTRUCTOR_ARG:
				return basicSetConstructorArg(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__ENTRY:
				return basicSetEntry(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__IDREF:
				return basicSetIdref(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__IMPORT:
				return basicSetImport(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__KEY:
				return basicSetKey(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__LIST:
				return basicSetList(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__LOOKUP_METHOD:
				return basicSetLookupMethod(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__MAP:
				return basicSetMap(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__META:
				return basicSetMeta(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__NULL:
				return basicSetNull(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__PROP:
				return basicSetProp(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__PROPERTY:
				return basicSetProperty(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__PROPS:
				return basicSetProps(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__REF:
				return basicSetRef(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__REPLACED_METHOD:
				return basicSetReplacedMethod(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__SET:
				return basicSetSet(null, msgs);
			case BeansPackage.DOCUMENT_ROOT__VALUE:
				return basicSetValue(null, msgs);
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
			case BeansPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case BeansPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case BeansPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case BeansPackage.DOCUMENT_ROOT__ALIAS:
				return getAlias();
			case BeansPackage.DOCUMENT_ROOT__ARG_TYPE:
				return getArgType();
			case BeansPackage.DOCUMENT_ROOT__BEAN:
				return getBean();
			case BeansPackage.DOCUMENT_ROOT__BEANS:
				return getBeans();
			case BeansPackage.DOCUMENT_ROOT__CONSTRUCTOR_ARG:
				return getConstructorArg();
			case BeansPackage.DOCUMENT_ROOT__DESCRIPTION:
				return getDescription();
			case BeansPackage.DOCUMENT_ROOT__ENTRY:
				return getEntry();
			case BeansPackage.DOCUMENT_ROOT__IDREF:
				return getIdref();
			case BeansPackage.DOCUMENT_ROOT__IMPORT:
				return getImport();
			case BeansPackage.DOCUMENT_ROOT__KEY:
				return getKey();
			case BeansPackage.DOCUMENT_ROOT__LIST:
				return getList();
			case BeansPackage.DOCUMENT_ROOT__LOOKUP_METHOD:
				return getLookupMethod();
			case BeansPackage.DOCUMENT_ROOT__MAP:
				return getMap();
			case BeansPackage.DOCUMENT_ROOT__META:
				return getMeta();
			case BeansPackage.DOCUMENT_ROOT__NULL:
				return getNull();
			case BeansPackage.DOCUMENT_ROOT__PROP:
				return getProp();
			case BeansPackage.DOCUMENT_ROOT__PROPERTY:
				return getProperty();
			case BeansPackage.DOCUMENT_ROOT__PROPS:
				return getProps();
			case BeansPackage.DOCUMENT_ROOT__REF:
				return getRef();
			case BeansPackage.DOCUMENT_ROOT__REPLACED_METHOD:
				return getReplacedMethod();
			case BeansPackage.DOCUMENT_ROOT__SET:
				return getSet();
			case BeansPackage.DOCUMENT_ROOT__VALUE:
				return getValue();
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
			case BeansPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__ALIAS:
				setAlias((AliasType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__ARG_TYPE:
				setArgType((ArgTypeType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__BEAN:
				setBean((BeanType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__BEANS:
				setBeans((BeansType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__CONSTRUCTOR_ARG:
				setConstructorArg((ConstructorArgType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__DESCRIPTION:
				setDescription((DescriptionType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__ENTRY:
				setEntry((EntryType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__IDREF:
				setIdref((IdrefType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__IMPORT:
				setImport((ImportType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__KEY:
				setKey((KeyType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__LIST:
				setList((ListOrSetType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__LOOKUP_METHOD:
				setLookupMethod((LookupMethodType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__MAP:
				setMap((MapType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__META:
				setMeta((MetaType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__NULL:
				setNull((NullType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__PROP:
				setProp((PropType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__PROPERTY:
				setProperty((PropertyType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__PROPS:
				setProps((PropsType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__REF:
				setRef((RefType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__REPLACED_METHOD:
				setReplacedMethod((ReplacedMethodType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__SET:
				setSet((ListOrSetType)newValue);
				return;
			case BeansPackage.DOCUMENT_ROOT__VALUE:
				setValue((ValueType)newValue);
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
			case BeansPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case BeansPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case BeansPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case BeansPackage.DOCUMENT_ROOT__ALIAS:
				setAlias((AliasType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__ARG_TYPE:
				setArgType((ArgTypeType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__BEAN:
				setBean((BeanType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__BEANS:
				setBeans((BeansType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__CONSTRUCTOR_ARG:
				setConstructorArg((ConstructorArgType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__DESCRIPTION:
				setDescription((DescriptionType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__ENTRY:
				setEntry((EntryType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__IDREF:
				setIdref((IdrefType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__IMPORT:
				setImport((ImportType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__KEY:
				setKey((KeyType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__LIST:
				setList((ListOrSetType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__LOOKUP_METHOD:
				setLookupMethod((LookupMethodType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__MAP:
				setMap((MapType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__META:
				setMeta((MetaType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__NULL:
				setNull((NullType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__PROP:
				setProp((PropType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__PROPERTY:
				setProperty((PropertyType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__PROPS:
				setProps((PropsType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__REF:
				setRef((RefType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__REPLACED_METHOD:
				setReplacedMethod((ReplacedMethodType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__SET:
				setSet((ListOrSetType)null);
				return;
			case BeansPackage.DOCUMENT_ROOT__VALUE:
				setValue((ValueType)null);
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
			case BeansPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case BeansPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case BeansPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case BeansPackage.DOCUMENT_ROOT__ALIAS:
				return getAlias() != null;
			case BeansPackage.DOCUMENT_ROOT__ARG_TYPE:
				return getArgType() != null;
			case BeansPackage.DOCUMENT_ROOT__BEAN:
				return getBean() != null;
			case BeansPackage.DOCUMENT_ROOT__BEANS:
				return getBeans() != null;
			case BeansPackage.DOCUMENT_ROOT__CONSTRUCTOR_ARG:
				return getConstructorArg() != null;
			case BeansPackage.DOCUMENT_ROOT__DESCRIPTION:
				return getDescription() != null;
			case BeansPackage.DOCUMENT_ROOT__ENTRY:
				return getEntry() != null;
			case BeansPackage.DOCUMENT_ROOT__IDREF:
				return getIdref() != null;
			case BeansPackage.DOCUMENT_ROOT__IMPORT:
				return getImport() != null;
			case BeansPackage.DOCUMENT_ROOT__KEY:
				return getKey() != null;
			case BeansPackage.DOCUMENT_ROOT__LIST:
				return getList() != null;
			case BeansPackage.DOCUMENT_ROOT__LOOKUP_METHOD:
				return getLookupMethod() != null;
			case BeansPackage.DOCUMENT_ROOT__MAP:
				return getMap() != null;
			case BeansPackage.DOCUMENT_ROOT__META:
				return getMeta() != null;
			case BeansPackage.DOCUMENT_ROOT__NULL:
				return getNull() != null;
			case BeansPackage.DOCUMENT_ROOT__PROP:
				return getProp() != null;
			case BeansPackage.DOCUMENT_ROOT__PROPERTY:
				return getProperty() != null;
			case BeansPackage.DOCUMENT_ROOT__PROPS:
				return getProps() != null;
			case BeansPackage.DOCUMENT_ROOT__REF:
				return getRef() != null;
			case BeansPackage.DOCUMENT_ROOT__REPLACED_METHOD:
				return getReplacedMethod() != null;
			case BeansPackage.DOCUMENT_ROOT__SET:
				return getSet() != null;
			case BeansPackage.DOCUMENT_ROOT__VALUE:
				return getValue() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
