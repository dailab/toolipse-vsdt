package de.dailab.vsdt.vxl.util;

import java.util.HashMap;
import java.util.Map;

import de.dailab.vsdt.vxl.Atom;
import de.dailab.vsdt.vxl.BooleanConst;
import de.dailab.vsdt.vxl.BracketTerm;
import de.dailab.vsdt.vxl.Head;
import de.dailab.vsdt.vxl.Minus;
import de.dailab.vsdt.vxl.Negation;
import de.dailab.vsdt.vxl.NullConst;
import de.dailab.vsdt.vxl.NumericConst;
import de.dailab.vsdt.vxl.Operator;
import de.dailab.vsdt.vxl.StringConst;
import de.dailab.vsdt.vxl.Term;
import de.dailab.vsdt.vxl.Value;
import de.dailab.vsdt.vxl.Variable;
import de.dailab.vsdt.vxl.util.TermOrdering.TermLeaf;
import de.dailab.vsdt.vxl.util.TermOrdering.TermNode;
import de.dailab.vsdt.vxl.util.TermOrdering.TermTree;

/**
 * A very simple Interpreter for the VSDT Expression Language.
 * 
 * @author kuester
 */
public class VxlInterpreter {
	
	/** errors that occurred during the evaluation, e.g. non-matching operations */
	protected Map<Object, String> errors= null;
	
	/** the context, e.g. the association of variables to actual values */
	protected Map<String, Object> context= null;
	
	public Map<Object, String> getErrors() {
		return errors;
	}

	/**
	 * Evaluate the given Term and return the result.
	 * 
	 * @param term		Some Term
	 * @return			Result, e.g. a String, Number, or Boolean, or whatever else
	 */
	public Object evaluateTerm(Term term, Map<String, Object> context) {
		this.errors= new HashMap<Object, String>();
		this.context= context;
		return eval(term);
	}
	
	/**
	 * Term:			head = Head (tail = Tail)?;
	 * The term is transcribed to an ordered TermTree and evaluated.
	 */
	protected Object eval(Term term) {
		TermTree orderedTermTree= TermOrdering.createOrderedTermTree(term);
//		TermOrdering.print(orderedTermTree, 0);
		return eval(orderedTermTree);
	}
	
	/**
	 * Evaluate the TermTree. In case of a Leaf, evaluate the encapsulated term;
	 * otherwise evaluate the left and right terms and try to apply the operation.
	 * 
	 * @param term	Some ordered TermTree
	 * @return		Evaluation result (e.g. a Sting, Number, or Boolean)
	 */
	protected Object eval(TermTree term) {
		if (term instanceof TermLeaf) {
			TermLeaf leaf= (TermLeaf) term;
			return eval(leaf.term);
		}
		if (term instanceof TermNode) {
			TermNode node= (TermNode) term;
			
			Object head= eval(node.left);
			Object tail= eval(node.right);
			Operator op= node.operator;
			
			if (checkType(op, head, tail)) {
				return evaluateOperation(op, head, tail);
			} else {
				errors.put(term, "Types do not match operator");
				return null;
			}
		}
		return null;
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
		if (head instanceof Minus) {
			return eval((Minus) head);
			
		}
		if (head instanceof Atom) {
			return eval((Atom) head);
		}
		return null;
	}

	/**
	 * Negation:		"!" head = Head;
	 */
	protected Object eval(Negation negation) {
		Object result= eval(negation.getHead());
		if (result instanceof Boolean) {
			return ! (Boolean) result;
		} else {
			errors.put(negation, "Negation only applicable to Boolean");
			return null;
		}
	}

	/**
	 * Minus:		"-" head = Head;
	 */
	protected Object eval(Minus minus) {
		Object result= eval(minus.getHead());
		if (result instanceof Number) {
			return - ((Number) result).doubleValue();
		} else {
			errors.put(minus, "Minus only applicable to Numeric");
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
			return "true".equals(((BooleanConst) value).getConst());
		}
		if (value instanceof NumericConst) {
			return Double.parseDouble(((NumericConst) value).getConst());
		}
		if (value instanceof NullConst) {
			return null;
		}
		return null;
	}
	
	/**
	 * Evaluate the operation with the given terms.
	 * 
	 * @param operator	the operation
	 * @param head		the head term (to the left)
	 * @param tail		the tail term (to the right)
	 * @return			result of the operation, applied to the given terms
	 */
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

	/**
	 * Check whether the given terms match the operator.
	 *  
	 * @param operator	the operator
	 * @param head		the head term (to the left)
	 * @param tail		the tail term (to the right)
	 * @return			terms match operator?
	 */
	private boolean checkType(Operator operator, Object head, Object tail) {
		try {
			switch (operator) {
			case CONCAT:
				return true; // everything can be concatenated somehow
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
