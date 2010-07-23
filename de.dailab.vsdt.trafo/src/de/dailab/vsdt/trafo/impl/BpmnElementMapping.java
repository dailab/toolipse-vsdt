package de.dailab.vsdt.trafo.impl;

import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.util.VsdtExpressionVisitor;

/**
 * This class can be used as super class for all Element Mapping Stages.  Is 
 * provides a number of useful methods, and most importantly takes care of 
 * translating the expressions to the target language.
 * 
 * @author kuester
 */
public abstract class BpmnElementMapping extends MappingStage {

	/**
	 * visitor used for translating VXL expressions to the target expression language
	 */
	protected VsdtExpressionVisitor expressionVisitor= null;
	
	@Override
	protected final boolean internalApply() {
		BusinessProcessSystem bps= (BusinessProcessSystem) wrapper.getSourceModel();
		if (expressionVisitor != null) {
			visitExpressions(bps);
		}
		visitBusinessProcessSystem(bps);
		return true;
	}
	
	protected abstract void visitBusinessProcessSystem(BusinessProcessSystem bps);
	
	/**
	 * Translate Expressions to target Language
	 * @param expression
	 */
	protected final void visitExpressions(BusinessProcessSystem bps) {
		Queue<EObject> queue= new LinkedList<EObject>();
		queue.add(bps);

		// for every Expression in the model...
		while (! queue.isEmpty()) {
			EObject current= queue.remove();
			if (current instanceof Expression) {
				Expression expression= (Expression) current;
				// ... translate expression using ExpressionVisitor
				String newExpression= expressionVisitor.getTranslation(expression);
				if (expressionVisitor.getLastErrorMessage() == null) {
					if (newExpression != null && ! newExpression.equals(expression.getExpression())) {
						TrafoLog.info("Changed Expression '" + expression.getExpression() + "' to '" + newExpression + "'");
						expression.setExpression(newExpression);
					}
				} else {
					TrafoLog.warn(expressionVisitor.getLastErrorMessage());
				}
			} else {
				queue.addAll(current.eContents());
			}
		}
	}
	
}
