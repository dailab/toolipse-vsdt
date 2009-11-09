/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>TRoles</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTRoles()
 * @model extendedMetaData="name='tRoles'"
 * @generated
 */
public enum TRoles implements Enumerator
{
	/**
	 * The '<em><b>My Role</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MY_ROLE_VALUE
	 * @generated
	 * @ordered
	 */
	MY_ROLE(0, "myRole", "myRole"),
	/**
	 * The '<em><b>Partner Role</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTNER_ROLE_VALUE
	 * @generated
	 * @ordered
	 */
	PARTNER_ROLE(1, "partnerRole", "partnerRole");
	/**
	 * The '<em><b>My Role</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>My Role</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MY_ROLE
	 * @model name="myRole"
	 * @generated
	 * @ordered
	 */
	public static final int MY_ROLE_VALUE = 0;

	/**
	 * The '<em><b>Partner Role</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Partner Role</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTNER_ROLE
	 * @model name="partnerRole"
	 * @generated
	 * @ordered
	 */
	public static final int PARTNER_ROLE_VALUE = 1;

	/**
	 * An array of all the '<em><b>TRoles</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TRoles[] VALUES_ARRAY =
		new TRoles[] {
			MY_ROLE,
			PARTNER_ROLE,
		};

	/**
	 * A public read-only list of all the '<em><b>TRoles</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TRoles> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>TRoles</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TRoles get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TRoles result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TRoles</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TRoles getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TRoles result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TRoles</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TRoles get(int value) {
		switch (value) {
			case MY_ROLE_VALUE: return MY_ROLE;
			case PARTNER_ROLE_VALUE: return PARTNER_ROLE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TRoles(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
}
