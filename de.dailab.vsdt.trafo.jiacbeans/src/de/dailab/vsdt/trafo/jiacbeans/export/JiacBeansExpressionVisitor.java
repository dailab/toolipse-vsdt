package de.dailab.vsdt.trafo.jiacbeans.export;

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.util.VsdtExpressionVisitor;
import de.dailab.vsdt.vxl.vxl.VxlArrayAccessor;
import de.dailab.vsdt.vxl.vxl.VxlCardinality;
import de.dailab.vsdt.vxl.vxl.VxlList;
import de.dailab.vsdt.vxl.vxl.VxlMap;
import de.dailab.vsdt.vxl.vxl.VxlMapElement;
import de.dailab.vsdt.vxl.vxl.VxlNegation;
import de.dailab.vsdt.vxl.vxl.VxlOperator;

public class JiacBeansExpressionVisitor extends VsdtExpressionVisitor {

	public JiacBeansExpressionVisitor(boolean translateExpression, boolean replaceVariableNames) {
		super(translateExpression, replaceVariableNames);
	}
	
	@Override
	protected boolean excludeFromTranslation(Expression expression) {
		return expression.eContainer() instanceof MessageChannel;
	}

	@Override
	protected void visitNegation(VxlNegation negation) {
		buffer.append("! ");
		visitElement(negation.getElement());
	}
	
	@Override
	protected void visitArrayAccessor(VxlArrayAccessor accessor) {
		buffer.append(".get(");
		visitTerm(accessor.getIndex());
		buffer.append(")");
		if (accessor.getAccessor() != null) {
			visitAccessor(accessor.getAccessor());
		}
	}

	@Override
	protected void visitCardinality(VxlCardinality cardinality) {
		visitElement(cardinality.getElement());
		buffer.append(".size()");
	}
	
	@Override
	protected void visitList(VxlList list) {
		buffer.append("Arrays.asList(");
		if (list.getBody() != null) {
			visitListElement(list.getBody());
		}
		buffer.append(")");
	}
	
	@Override
	protected void visitMap(VxlMap map) {
		if (map.getBody() != null) {
			buffer.append("Stream.of(");
			visitMapElement(map.getBody());
			buffer.append(").collect(Collectors.toMap(Entry::getKey, Entry::getValue))");
		} else {
			buffer.append("new HashMap<>()");
		}
	}
	
	@Override
	protected void visitMapElement(VxlMapElement mapElement) {
		buffer.append("new SimpleEntry(");
		visitTerm(mapElement.getKey());
		buffer.append(", ");
		visitTerm(mapElement.getValue());
		buffer.append(")");
		if (mapElement.getRest() != null) {
			buffer.append(", ");
			visitMapElement(mapElement.getRest());
		}
	}
	
	@Override
	protected void visitOperator(VxlOperator operator) {
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
			super.visitOperator(operator);
		}
	}

}
