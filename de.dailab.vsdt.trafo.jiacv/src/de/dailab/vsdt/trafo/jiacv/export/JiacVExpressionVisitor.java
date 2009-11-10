package de.dailab.vsdt.trafo.jiacv.export;

import de.dailab.vsdt.util.VsdtExpressionVisitor;
import de.dailab.vsdt.vxl.Operator;

public class JiacVExpressionVisitor extends VsdtExpressionVisitor {

	public JiacVExpressionVisitor(boolean translateExpression, boolean replaceVariableNames) {
		super(translateExpression, replaceVariableNames);
	}
	
	@Override
	protected void visit(Operator operator) {
		switch (operator) {
		case CONCAT:
			buffer.append("+");
			break;
		default:
			super.visit(operator);
		}
	}

}
