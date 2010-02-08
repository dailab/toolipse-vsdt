package de.dailab.vsdt.trafo.bpel.export;

import de.dailab.vsdt.Property;
import de.dailab.vsdt.trafo.bpel.util.BpelStaticHelper;
import de.dailab.vsdt.util.VsdtExpressionVisitor;
import de.dailab.vsdt.vxl.BooleanConst;
import de.dailab.vsdt.vxl.FieldAccessor;
import de.dailab.vsdt.vxl.Negation;
import de.dailab.vsdt.vxl.NullConst;
import de.dailab.vsdt.vxl.Operator;
import de.dailab.vsdt.vxl.StringConst;
import de.dailab.vsdt.vxl.Term;
import de.dailab.vsdt.vxl.Variable;

public class BpelExpressionVisitor extends VsdtExpressionVisitor {

	public BpelExpressionVisitor(boolean translateExpression, boolean replaceVariableNames) {
		super(translateExpression, replaceVariableNames);
	}
	
	@Override
	protected void visit(Term term) {
		if (term.getTail() != null && term.getTail().getOperator() == Operator.CONCAT) {
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
	protected void visit(Negation negation) {
		buffer.append("not(");
		visit(negation.getHead());
		buffer.append(")");
	}

	@Override
	protected void visit(Variable variable) {
		String query= null;
		if (variable.getAccessor() instanceof FieldAccessor) {
			query= ((FieldAccessor) variable.getAccessor()).getName();
		}
		buffer.append(getFullVarName(variable.getName(), query));
	}
	
	@Override
	protected void visit(BooleanConst booleanConst) {
		buffer.append(booleanConst.getConst() + "()");
	}
	
	@Override
	protected void visit(StringConst stringConst) {
		buffer.append("'");
		buffer.append(stringConst.getConst());
		buffer.append("'");
	}
	
	@Override
	protected void visit(NullConst nll) {
		// XXX null in BPEL?
		buffer.append("null");
	}

	@Override
	protected void visit(Operator operator) {
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
