package de.dailab.vsdt.meta.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.meta.diagram.edit.policies.ParticipantAssociatedProcessesItemSemanticEditPolicy;
import de.dailab.vsdt.meta.diagram.figures.ParticipantProcessAssociationFigure;

/**
 * @generated
 */
public class ParticipantAssociatedProcessesEditPart extends
		ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

	/**
	 * @generated
	 */
	public ParticipantAssociatedProcessesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ParticipantAssociatedProcessesItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * + using extended figure
	 * 
	 * @generated NOT
	 */
	protected Connection createConnectionFigure() {
		return new ParticipantProcessAssociationFigureEx();
	}

	/**
	 * @generated
	 */
	public ParticipantProcessAssociationFigure getPrimaryShape() {
		return (ParticipantProcessAssociationFigure) getFigure();
	}

	/**
	 * @generated NOT
	 */
	public class ParticipantProcessAssociationFigureEx extends
			ParticipantProcessAssociationFigure {

		/**
		 * @generated
		 */
		public ParticipantProcessAssociationFigureEx() {

			this.setForegroundColor(ColorConstants.black);
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

}
