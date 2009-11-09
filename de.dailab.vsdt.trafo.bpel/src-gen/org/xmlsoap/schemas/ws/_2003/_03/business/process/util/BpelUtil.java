package org.xmlsoap.schemas.ws._2003._03.business.process.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;

public class BpelUtil {

	/**
	 * Get the single activity in one of those classes having multiple activity-attributes
	 * of which only one is actually holding a value 
	 * 
	 * @generated NOT
	 */
	public static TActivity getActivity(EObject parent) {
		List<EReference> references= parent.eClass().getEAllReferences();
		EClass clazz= ProcessPackage.eINSTANCE.getTActivity();
		for (EReference ref : references) {
			if (clazz.isSuperTypeOf(ref.getEReferenceType())) {
				Object object= parent.eGet(ref);
				if (object != null) {
					return (TActivity) object;
				}
			}
		}
		return null;
	}
	
}
