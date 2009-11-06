/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.springframework.schema.beans.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.springframework.schema.beans.AliasType;
import org.springframework.schema.beans.ArgTypeType;
import org.springframework.schema.beans.AutowireType;
import org.springframework.schema.beans.BaseCollectionType;
import org.springframework.schema.beans.BeanType;
import org.springframework.schema.beans.BeansFactory;
import org.springframework.schema.beans.BeansPackage;
import org.springframework.schema.beans.BeansType;
import org.springframework.schema.beans.ConstructorArgType;
import org.springframework.schema.beans.DefaultAutowireType;
import org.springframework.schema.beans.DefaultDependencyCheckType;
import org.springframework.schema.beans.DefaultableBoolean;
import org.springframework.schema.beans.DependencyCheckType;
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
import org.springframework.schema.beans.TypedCollectionType;
import org.springframework.schema.beans.ValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BeansFactoryImpl extends EFactoryImpl implements BeansFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BeansFactory init() {
		try {
			BeansFactory theBeansFactory = (BeansFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.springframework.org/schema/beans"); 
			if (theBeansFactory != null) {
				return theBeansFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BeansFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeansFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BeansPackage.ALIAS_TYPE: return createAliasType();
			case BeansPackage.ARG_TYPE_TYPE: return createArgTypeType();
			case BeansPackage.BASE_COLLECTION_TYPE: return createBaseCollectionType();
			case BeansPackage.BEANS_TYPE: return createBeansType();
			case BeansPackage.BEAN_TYPE: return createBeanType();
			case BeansPackage.CONSTRUCTOR_ARG_TYPE: return createConstructorArgType();
			case BeansPackage.DESCRIPTION_TYPE: return createDescriptionType();
			case BeansPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case BeansPackage.ENTRY_TYPE: return createEntryType();
			case BeansPackage.IDREF_TYPE: return createIdrefType();
			case BeansPackage.IMPORT_TYPE: return createImportType();
			case BeansPackage.KEY_TYPE: return createKeyType();
			case BeansPackage.LIST_OR_SET_TYPE: return createListOrSetType();
			case BeansPackage.LOOKUP_METHOD_TYPE: return createLookupMethodType();
			case BeansPackage.MAP_TYPE: return createMapType();
			case BeansPackage.META_TYPE: return createMetaType();
			case BeansPackage.NULL_TYPE: return createNullType();
			case BeansPackage.PROPERTY_TYPE: return createPropertyType();
			case BeansPackage.PROPS_TYPE: return createPropsType();
			case BeansPackage.PROP_TYPE: return createPropType();
			case BeansPackage.REF_TYPE: return createRefType();
			case BeansPackage.REPLACED_METHOD_TYPE: return createReplacedMethodType();
			case BeansPackage.TYPED_COLLECTION_TYPE: return createTypedCollectionType();
			case BeansPackage.VALUE_TYPE: return createValueType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BeansPackage.AUTOWIRE_TYPE:
				return createAutowireTypeFromString(eDataType, initialValue);
			case BeansPackage.DEFAULTABLE_BOOLEAN:
				return createDefaultableBooleanFromString(eDataType, initialValue);
			case BeansPackage.DEFAULT_AUTOWIRE_TYPE:
				return createDefaultAutowireTypeFromString(eDataType, initialValue);
			case BeansPackage.DEFAULT_DEPENDENCY_CHECK_TYPE:
				return createDefaultDependencyCheckTypeFromString(eDataType, initialValue);
			case BeansPackage.DEPENDENCY_CHECK_TYPE:
				return createDependencyCheckTypeFromString(eDataType, initialValue);
			case BeansPackage.AUTOWIRE_TYPE_OBJECT:
				return createAutowireTypeObjectFromString(eDataType, initialValue);
			case BeansPackage.DEFAULTABLE_BOOLEAN_OBJECT:
				return createDefaultableBooleanObjectFromString(eDataType, initialValue);
			case BeansPackage.DEFAULT_AUTOWIRE_TYPE_OBJECT:
				return createDefaultAutowireTypeObjectFromString(eDataType, initialValue);
			case BeansPackage.DEFAULT_DEPENDENCY_CHECK_TYPE_OBJECT:
				return createDefaultDependencyCheckTypeObjectFromString(eDataType, initialValue);
			case BeansPackage.DEPENDENCY_CHECK_TYPE_OBJECT:
				return createDependencyCheckTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BeansPackage.AUTOWIRE_TYPE:
				return convertAutowireTypeToString(eDataType, instanceValue);
			case BeansPackage.DEFAULTABLE_BOOLEAN:
				return convertDefaultableBooleanToString(eDataType, instanceValue);
			case BeansPackage.DEFAULT_AUTOWIRE_TYPE:
				return convertDefaultAutowireTypeToString(eDataType, instanceValue);
			case BeansPackage.DEFAULT_DEPENDENCY_CHECK_TYPE:
				return convertDefaultDependencyCheckTypeToString(eDataType, instanceValue);
			case BeansPackage.DEPENDENCY_CHECK_TYPE:
				return convertDependencyCheckTypeToString(eDataType, instanceValue);
			case BeansPackage.AUTOWIRE_TYPE_OBJECT:
				return convertAutowireTypeObjectToString(eDataType, instanceValue);
			case BeansPackage.DEFAULTABLE_BOOLEAN_OBJECT:
				return convertDefaultableBooleanObjectToString(eDataType, instanceValue);
			case BeansPackage.DEFAULT_AUTOWIRE_TYPE_OBJECT:
				return convertDefaultAutowireTypeObjectToString(eDataType, instanceValue);
			case BeansPackage.DEFAULT_DEPENDENCY_CHECK_TYPE_OBJECT:
				return convertDefaultDependencyCheckTypeObjectToString(eDataType, instanceValue);
			case BeansPackage.DEPENDENCY_CHECK_TYPE_OBJECT:
				return convertDependencyCheckTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AliasType createAliasType() {
		AliasTypeImpl aliasType = new AliasTypeImpl();
		return aliasType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArgTypeType createArgTypeType() {
		ArgTypeTypeImpl argTypeType = new ArgTypeTypeImpl();
		return argTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCollectionType createBaseCollectionType() {
		BaseCollectionTypeImpl baseCollectionType = new BaseCollectionTypeImpl();
		return baseCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeansType createBeansType() {
		BeansTypeImpl beansType = new BeansTypeImpl();
		return beansType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanType createBeanType() {
		BeanTypeImpl beanType = new BeanTypeImpl();
		return beanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorArgType createConstructorArgType() {
		ConstructorArgTypeImpl constructorArgType = new ConstructorArgTypeImpl();
		return constructorArgType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionType createDescriptionType() {
		DescriptionTypeImpl descriptionType = new DescriptionTypeImpl();
		return descriptionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryType createEntryType() {
		EntryTypeImpl entryType = new EntryTypeImpl();
		return entryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdrefType createIdrefType() {
		IdrefTypeImpl idrefType = new IdrefTypeImpl();
		return idrefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportType createImportType() {
		ImportTypeImpl importType = new ImportTypeImpl();
		return importType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyType createKeyType() {
		KeyTypeImpl keyType = new KeyTypeImpl();
		return keyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListOrSetType createListOrSetType() {
		ListOrSetTypeImpl listOrSetType = new ListOrSetTypeImpl();
		return listOrSetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupMethodType createLookupMethodType() {
		LookupMethodTypeImpl lookupMethodType = new LookupMethodTypeImpl();
		return lookupMethodType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapType createMapType() {
		MapTypeImpl mapType = new MapTypeImpl();
		return mapType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaType createMetaType() {
		MetaTypeImpl metaType = new MetaTypeImpl();
		return metaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullType createNullType() {
		NullTypeImpl nullType = new NullTypeImpl();
		return nullType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType createPropertyType() {
		PropertyTypeImpl propertyType = new PropertyTypeImpl();
		return propertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropsType createPropsType() {
		PropsTypeImpl propsType = new PropsTypeImpl();
		return propsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropType createPropType() {
		PropTypeImpl propType = new PropTypeImpl();
		return propType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefType createRefType() {
		RefTypeImpl refType = new RefTypeImpl();
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplacedMethodType createReplacedMethodType() {
		ReplacedMethodTypeImpl replacedMethodType = new ReplacedMethodTypeImpl();
		return replacedMethodType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedCollectionType createTypedCollectionType() {
		TypedCollectionTypeImpl typedCollectionType = new TypedCollectionTypeImpl();
		return typedCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueType createValueType() {
		ValueTypeImpl valueType = new ValueTypeImpl();
		return valueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutowireType createAutowireTypeFromString(EDataType eDataType, String initialValue) {
		AutowireType result = AutowireType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAutowireTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultableBoolean createDefaultableBooleanFromString(EDataType eDataType, String initialValue) {
		DefaultableBoolean result = DefaultableBoolean.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultableBooleanToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAutowireType createDefaultAutowireTypeFromString(EDataType eDataType, String initialValue) {
		DefaultAutowireType result = DefaultAutowireType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultAutowireTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultDependencyCheckType createDefaultDependencyCheckTypeFromString(EDataType eDataType, String initialValue) {
		DefaultDependencyCheckType result = DefaultDependencyCheckType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultDependencyCheckTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyCheckType createDependencyCheckTypeFromString(EDataType eDataType, String initialValue) {
		DependencyCheckType result = DependencyCheckType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependencyCheckTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutowireType createAutowireTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createAutowireTypeFromString(BeansPackage.Literals.AUTOWIRE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAutowireTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAutowireTypeToString(BeansPackage.Literals.AUTOWIRE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultableBoolean createDefaultableBooleanObjectFromString(EDataType eDataType, String initialValue) {
		return createDefaultableBooleanFromString(BeansPackage.Literals.DEFAULTABLE_BOOLEAN, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultableBooleanObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDefaultableBooleanToString(BeansPackage.Literals.DEFAULTABLE_BOOLEAN, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAutowireType createDefaultAutowireTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDefaultAutowireTypeFromString(BeansPackage.Literals.DEFAULT_AUTOWIRE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultAutowireTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDefaultAutowireTypeToString(BeansPackage.Literals.DEFAULT_AUTOWIRE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultDependencyCheckType createDefaultDependencyCheckTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDefaultDependencyCheckTypeFromString(BeansPackage.Literals.DEFAULT_DEPENDENCY_CHECK_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDefaultDependencyCheckTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDefaultDependencyCheckTypeToString(BeansPackage.Literals.DEFAULT_DEPENDENCY_CHECK_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyCheckType createDependencyCheckTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDependencyCheckTypeFromString(BeansPackage.Literals.DEPENDENCY_CHECK_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependencyCheckTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDependencyCheckTypeToString(BeansPackage.Literals.DEPENDENCY_CHECK_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeansPackage getBeansPackage() {
		return (BeansPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BeansPackage getPackage() {
		return BeansPackage.eINSTANCE;
	}

} //BeansFactoryImpl
