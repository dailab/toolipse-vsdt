package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;

/**
 * @generated
 */
public class VsdtEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (VsdtVisualIDRegistry.getVisualID(view)) {

			case BusinessProcessDiagramEditPart.VISUAL_ID:
				return new BusinessProcessDiagramEditPart(view);

			case GroupEditPart.VISUAL_ID:
				return new GroupEditPart(view);

			case TextAnnotationEditPart.VISUAL_ID:
				return new TextAnnotationEditPart(view);

			case TextAnnotationDocumentationEditPart.VISUAL_ID:
				return new TextAnnotationDocumentationEditPart(view);

			case DataObjectEditPart.VISUAL_ID:
				return new DataObjectEditPart(view);

			case DataObjectNameEditPart.VISUAL_ID:
				return new DataObjectNameEditPart(view);

			case PoolEditPart.VISUAL_ID:
				return new PoolEditPart(view);

			case PoolNameEditPart.VISUAL_ID:
				return new PoolNameEditPart(view);

			case LaneEditPart.VISUAL_ID:
				return new LaneEditPart(view);

			case LaneNameEditPart.VISUAL_ID:
				return new LaneNameEditPart(view);

			case StartEditPart.VISUAL_ID:
				return new StartEditPart(view);

			case StartNameEditPart.VISUAL_ID:
				return new StartNameEditPart(view);

			case IntermediateEditPart.VISUAL_ID:
				return new IntermediateEditPart(view);

			case IntermediateNameEditPart.VISUAL_ID:
				return new IntermediateNameEditPart(view);

			case EndEditPart.VISUAL_ID:
				return new EndEditPart(view);

			case EndNameEditPart.VISUAL_ID:
				return new EndNameEditPart(view);

			case ActivityEditPart.VISUAL_ID:
				return new ActivityEditPart(view);

			case ActivityNameEditPart.VISUAL_ID:
				return new ActivityNameEditPart(view);

			case GatewayEditPart.VISUAL_ID:
				return new GatewayEditPart(view);

			case GatewayNameEditPart.VISUAL_ID:
				return new GatewayNameEditPart(view);

			case Intermediate2EditPart.VISUAL_ID:
				return new Intermediate2EditPart(view);

			case PoolPoolCompartmentEditPart.VISUAL_ID:
				return new PoolPoolCompartmentEditPart(view);

			case LaneLaneCompartmentEditPart.VISUAL_ID:
				return new LaneLaneCompartmentEditPart(view);

			case ActivitySubprocessCompartmentEditPart.VISUAL_ID:
				return new ActivitySubprocessCompartmentEditPart(view);

			case SequenceFlowEditPart.VISUAL_ID:
				return new SequenceFlowEditPart(view);

			case SequenceFlowNameEditPart.VISUAL_ID:
				return new SequenceFlowNameEditPart(view);

			case MessageFlowEditPart.VISUAL_ID:
				return new MessageFlowEditPart(view);

			case MessageFlowNameEditPart.VISUAL_ID:
				return new MessageFlowNameEditPart(view);

			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);

			case AssociationNameEditPart.VISUAL_ID:
				return new AssociationNameEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
