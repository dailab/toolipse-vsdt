package de.dailab.vsdt.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class VsdtElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private VsdtElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType BusinessProcessDiagram_79 = getElementType("de.dailab.vsdt.diagram.BusinessProcessDiagram_79"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Group_1001 = getElementType("de.dailab.vsdt.diagram.Group_1001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType TextAnnotation_1002 = getElementType("de.dailab.vsdt.diagram.TextAnnotation_1002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DataObject_1003 = getElementType("de.dailab.vsdt.diagram.DataObject_1003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pool_1004 = getElementType("de.dailab.vsdt.diagram.Pool_1004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Lane_2001 = getElementType("de.dailab.vsdt.diagram.Lane_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Start_2002 = getElementType("de.dailab.vsdt.diagram.Start_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Intermediate_2003 = getElementType("de.dailab.vsdt.diagram.Intermediate_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType End_2004 = getElementType("de.dailab.vsdt.diagram.End_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Activity_2005 = getElementType("de.dailab.vsdt.diagram.Activity_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Gateway_2006 = getElementType("de.dailab.vsdt.diagram.Gateway_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Intermediate_2007 = getElementType("de.dailab.vsdt.diagram.Intermediate_2007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SequenceFlow_3001 = getElementType("de.dailab.vsdt.diagram.SequenceFlow_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MessageFlow_3002 = getElementType("de.dailab.vsdt.diagram.MessageFlow_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_3003 = getElementType("de.dailab.vsdt.diagram.Association_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return VsdtDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(BusinessProcessDiagram_79, VsdtPackage.eINSTANCE
					.getBusinessProcessDiagram());

			elements.put(Group_1001, VsdtPackage.eINSTANCE.getGroup());

			elements.put(TextAnnotation_1002, VsdtPackage.eINSTANCE
					.getTextAnnotation());

			elements
					.put(DataObject_1003, VsdtPackage.eINSTANCE.getDataObject());

			elements.put(Pool_1004, VsdtPackage.eINSTANCE.getPool());

			elements.put(Lane_2001, VsdtPackage.eINSTANCE.getLane());

			elements.put(Start_2002, VsdtPackage.eINSTANCE.getStart());

			elements.put(Intermediate_2003, VsdtPackage.eINSTANCE
					.getIntermediate());

			elements.put(End_2004, VsdtPackage.eINSTANCE.getEnd());

			elements.put(Activity_2005, VsdtPackage.eINSTANCE.getActivity());

			elements.put(Gateway_2006, VsdtPackage.eINSTANCE.getGateway());

			elements.put(Intermediate_2007, VsdtPackage.eINSTANCE
					.getIntermediate());

			elements.put(SequenceFlow_3001, VsdtPackage.eINSTANCE
					.getSequenceFlow());

			elements.put(MessageFlow_3002, VsdtPackage.eINSTANCE
					.getMessageFlow());

			elements.put(Association_3003, VsdtPackage.eINSTANCE
					.getAssociation());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(BusinessProcessDiagram_79);
			KNOWN_ELEMENT_TYPES.add(Group_1001);
			KNOWN_ELEMENT_TYPES.add(TextAnnotation_1002);
			KNOWN_ELEMENT_TYPES.add(DataObject_1003);
			KNOWN_ELEMENT_TYPES.add(Pool_1004);
			KNOWN_ELEMENT_TYPES.add(Lane_2001);
			KNOWN_ELEMENT_TYPES.add(Start_2002);
			KNOWN_ELEMENT_TYPES.add(Intermediate_2003);
			KNOWN_ELEMENT_TYPES.add(End_2004);
			KNOWN_ELEMENT_TYPES.add(Activity_2005);
			KNOWN_ELEMENT_TYPES.add(Gateway_2006);
			KNOWN_ELEMENT_TYPES.add(Intermediate_2007);
			KNOWN_ELEMENT_TYPES.add(SequenceFlow_3001);
			KNOWN_ELEMENT_TYPES.add(MessageFlow_3002);
			KNOWN_ELEMENT_TYPES.add(Association_3003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
