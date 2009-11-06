package de.dailab.vsdt.vxl.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.vxl.Atom;
import de.dailab.vsdt.vxl.BooleanConst;
import de.dailab.vsdt.vxl.BracketTerm;
import de.dailab.vsdt.vxl.Head;
import de.dailab.vsdt.vxl.Negation;
import de.dailab.vsdt.vxl.NullConst;
import de.dailab.vsdt.vxl.NumericConst;
import de.dailab.vsdt.vxl.Operator;
import de.dailab.vsdt.vxl.StringConst;
import de.dailab.vsdt.vxl.Term;
import de.dailab.vsdt.vxl.Value;
import de.dailab.vsdt.vxl.Variable;

public class VxlInterpreter {
	
	protected Map<EObject, String> errors= null;
	
	protected Map<String, Object> context= null;
	
	public Map<EObject, String> getErrors() {
		return errors;
	}

	/**
	 * Visit the given Term and return its String representation.
	 * 
	 * @param term		Some Term
	 * @return			Its String representation
	 */
	public Object evaluateTerm(Term term, Map<String, Object> context) {
		this.errors= new HashMap<EObject, String>();
		this.context= context;
		return eval(term);
	}

	/**
	 * Term:			head = Head (tail = Tail)?;
	 */
	protected Object eval(Term term) {
		Object head= eval(term.getHead());
		if (term.getTail() != null) {
			Object tail= eval(term.getTail().getTerm());
			Operator op= term.getTail().getOperator();
			if (checkType(op, head, tail)) {
				return evaluateOperation(term.getTail().getOperator(), head, tail);
			} else {
				errors.put(term, "Types do not match operator");
				return null;
			}
		} else {
			return head;
		}
	}
	
	/**
	 * Head:			BracketTerm | Negation | Atom;
	 */
	protected Object eval(Head head) {
		if (head instanceof BracketTerm) {
			return eval(((BracketTerm) head).getTerm());
		}
		if (head instanceof Negation) {
			return eval((Negation) head);
		}
		if (head instanceof Atom) {
			return eval((Atom) head);
		}
		return null;
	}

	/**
	 * Negation:		"!" term = Term;
	 */
	protected Object eval(Negation negation) {
		Object result= eval(negation.getTerm());
		if (result instanceof Boolean) {
			return ! (Boolean) result;
		} else {
			errors.put(negation, "Negation only applicable to Boolean");
			return null;
		}
	}

	/**
	 * Atom:			Variable | Value;
	 */
	protected Object eval(Atom atom) {
		if (atom instanceof Variable) {
			return eval((Variable) atom);
		}
		if (atom instanceof Value) {
			return eval((Value) atom);
		}
		return null;
	}

	/**
	 * Variable:		"$" name = ID (accessor = Accessor)?;
	 */
	protected Object eval(Variable variable) {
		// get value from context
		if (context != null) {
			Object value= context.get(variable.getName());
			//XXX why does context.get not work here?
			for (Object key : context.keySet()) {
				if (key.equals(variable.getName())) {
					value= context.get(key);
					if (value==null) {
						errors.put(variable, "Variable has not been initialized");
					}
				}
			}
			if (variable.getAccessor() != null) {
	//			visit(variable.getAccessor());
			}
			return value;
		} else {
			errors.put(variable, "Can not evaluate a Variable without a context");
			return null;
		}
	}
	
	/**
	 * TODO
	 * Accessor:		ArrayAccessor | FieldAccessor;
	 */
//	protected Object eval(Accessor accessor) {
//		if (accessor instanceof ArrayAccessor) {
//			visit((ArrayAccessor) accessor);
//		}
//		if (accessor instanceof FieldAccessor) {
//			visit((FieldAccessor) accessor);
//		}
//	}

	/**
	 * TODO
	 * ArrayAccessor:	"[" index = Term "]" (accessor = Accessor)?;
	 */
//	protected Object eval(ArrayAccessor accessor) {
//		buffer.append("[");
//		visit(accessor.getIndex());
//		buffer.append("]");
//		if (accessor.getAccessor() != null) {
//			visit(accessor.getAccessor());
//		}
//	}
	
	/**
	 * TODO
	 * FieldAccessor:	"." name = ID (accessor = Accessor)?;
	 */
//	protected Object visit(FieldAccessor accessor) {
//		buffer.append(".");
//		buffer.append(accessor.getName());
//		if (accessor.getAccessor() != null) {
//			visit(accessor.getAccessor());
//		}
//	}

	/**
	 * Value:			StringConst | BooleanConst | NumericConst | Null;
	 */
	protected Object eval(Value value) {
		if (value instanceof StringConst) {
			return ((StringConst) value).getConst();
		}
		if (value instanceof BooleanConst) {
			return ((BooleanConst) value).isIsTrue();
		}
		if (value instanceof NumericConst) {
			return Double.parseDouble(((NumericConst) value).getConst());
		}
		if (value instanceof NullConst) {
			return null;
		}
		return null;
	}
	
	
	private Object evaluateOperation(Operator operator, Object head, Object tail) {
		switch (operator) {
		case CONCAT:
			return new StringBuffer().append(head).append(tail).toString();
		case ADD:
			return (Double) head + (Double) tail;
		case SUB:
			return (Double) head - (Double) tail;
		case MULT:
			return (Double) head * (Double) tail;
		case DIV:
			return (Double) head / (Double) tail;
		case MOD:
			return (Double) head % (Double) tail;
		case AND:
			return (Boolean) head && (Boolean) tail;
		case OR:
			return (Boolean) head || (Boolean) tail;
		case GE:
			return ((Comparable) head).compareTo(tail) >= 0;
		case GT:
			return ((Comparable) head).compareTo(tail) >  0;
		case LE:
			return ((Comparable) head).compareTo(tail) <= 0;
		case LT:
			return ((Comparable) head).compareTo(tail) <  0;
		case EQ:
			return head.equals(tail);
		case NEQ:
			return ! head.equals(tail);
		default: 
			return null;
		}
	}
	
	private boolean checkType(Operator operator, Object head, Object tail) {
		try {
			switch (operator) {
			case CONCAT:
//				return head instanceof String && tail instanceof String;
				return true; // everything can be concatenated
			case ADD:
			case SUB:
			case MULT:
			case DIV:
			case MOD:
				return head instanceof Number && tail instanceof Number;
			case AND:
			case OR:
				return head instanceof Boolean && tail instanceof Boolean;
			case GE:
			case GT:
			case LE:
			case LT:
				return head instanceof Comparable && tail instanceof Comparable;
			case EQ:
			case NEQ:
				return head != null && tail != null;
			}
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	
}
