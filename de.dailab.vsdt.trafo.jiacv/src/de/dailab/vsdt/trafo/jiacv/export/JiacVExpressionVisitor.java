package de.dailab.vsdt.trafo.jiacv.export;

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.util.VsdtExpressionVisitor;
import de.dailab.vsdt.vxl.vxl.VxlNegation;
import de.dailab.vsdt.vxl.vxl.VxlOperator;
import de.dailab.vsdt.vxl.vxl.VxlVariable;

public class JiacVExpressionVisitor extends VsdtExpressionVisitor {

	public JiacVExpressionVisitor(boolean translateExpression, boolean replaceVariableNames) {
		super(translateExpression, replaceVariableNames);
	}
	
	@Override
	protected boolean excludeFromTranslation(Expression expression) {
		return expression.eContainer() instanceof MessageChannel;
	}

	@Override
	protected void visit(VxlVariable variable) {
		buffer.append("$");
		super.visit(variable);
	}
	
	@Override
	protected void visit(VxlNegation negation) {
		buffer.append("! ");
		visit(negation.getHead());
	}
	
	@Override
	protected void visit(VxlOperator operator) {
		switch (operator) {
		case CONCAT:
			buffer.append("+");
			break;
		case AND:
			buffer.append("&&");
			break;
		case OR:
			buffer.append("||");
			break;
		default:
			super.visit(operator);
		}
	}

}
