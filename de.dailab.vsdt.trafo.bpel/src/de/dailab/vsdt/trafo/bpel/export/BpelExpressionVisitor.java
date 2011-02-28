package de.dailab.vsdt.trafo.bpel.export;

import de.dailab.vsdt.Property;
import de.dailab.vsdt.trafo.bpel.util.BpelStaticHelper;
import de.dailab.vsdt.util.VsdtExpressionVisitor;
import de.dailab.vsdt.vxl.vxl.VxlBooleanConst;
import de.dailab.vsdt.vxl.vxl.VxlFieldAccessor;
import de.dailab.vsdt.vxl.vxl.VxlNegation;
import de.dailab.vsdt.vxl.vxl.VxlNullConst;
import de.dailab.vsdt.vxl.vxl.VxlOperator;
import de.dailab.vsdt.vxl.vxl.VxlStringConst;
import de.dailab.vsdt.vxl.vxl.VxlTerm;
import de.dailab.vsdt.vxl.vxl.VxlVariable;

public class BpelExpressionVisitor extends VsdtExpressionVisitor {

	public BpelExpressionVisitor(boolean translateExpression, boolean replaceVariableNames) {
		super(translateExpression, replaceVariableNames);
	}
	
	@Override
	protected void visit(VxlTerm term) {
		if (term.getTail() != null && term.getTail().getOperator() == VxlOperator.CONCAT) {
			buffer.append("concat(");
			visit(term.getHead());
			buffer.append(",");
			visit(term.getTail().getTerm());
			buffer.append(")");
		} else {
			super.visit(term);
		}
	}

	@Override
	protected void visit(VxlNegation negation) {
		buffer.append("not(");
		visit(negation.getHead());
		buffer.append(")");
	}

	@Override
	protected void visit(VxlVariable variable) {
		String query= null;
		if (variable.getAccessor() instanceof VxlFieldAccessor) {
			query= ((VxlFieldAccessor) variable.getAccessor()).getName();
		}
		buffer.append(getFullVarName(variable.getName(), query));
	}
	
	@Override
	protected void visit(VxlBooleanConst booleanConst) {
		buffer.append(booleanConst.getConst() + "()");
	}
	
	@Override
	protected void visit(VxlStringConst stringConst) {
		buffer.append("'");
		buffer.append(stringConst.getConst());
		buffer.append("'");
	}
	
	@Override
	protected void visit(VxlNullConst nll) {
		// XXX null in BPEL?
		buffer.append("null");
	}

	@Override
	protected void visit(VxlOperator operator) {
		switch (operator) {
		case EQ:
			buffer.append("=");
			break;
		case MOD:
			// XXX MOD in BPEL?
			buffer.append("%");
			break;
		case DIV:
			buffer.append("div");
			break;
		case AND:
			buffer.append("and");
			break;
		case OR:
			buffer.append("or");
			break;
		case CONCAT:
			// in BPEL, concatenation is a special case, being a built-in function, no binary operator
			break;
		default:
			super.visit(operator);
		}
	}

	@Override
	protected String getFullVarName(String varName, String query) {
		Property property= getProperty(varName);
		if (property != null) {
			return BpelStaticHelper.getFullVarName(property, query);
		} else {
			return super.getFullVarName(varName, query);
		}
	}
	
}
