package de.dailab.vsdt.vxl.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.dailab.vsdt.vxl.util.TermOrdering.TermLeaf;
import de.dailab.vsdt.vxl.util.TermOrdering.TermNode;
import de.dailab.vsdt.vxl.util.TermOrdering.TermTree;
import de.dailab.vsdt.vxl.vxl.Accessor;
import de.dailab.vsdt.vxl.vxl.ArrayAccessor;
import de.dailab.vsdt.vxl.vxl.Atom;
import de.dailab.vsdt.vxl.vxl.BooleanConst;
import de.dailab.vsdt.vxl.vxl.BracketTerm;
import de.dailab.vsdt.vxl.vxl.FieldAccessor;
import de.dailab.vsdt.vxl.vxl.Head;
import de.dailab.vsdt.vxl.vxl.Minus;
import de.dailab.vsdt.vxl.vxl.Negation;
import de.dailab.vsdt.vxl.vxl.NullConst;
import de.dailab.vsdt.vxl.vxl.NumericConst;
import de.dailab.vsdt.vxl.vxl.Operator;
import de.dailab.vsdt.vxl.vxl.StringConst;
import de.dailab.vsdt.vxl.vxl.Term;
import de.dailab.vsdt.vxl.vxl.Value;
import de.dailab.vsdt.vxl.vxl.Variable;

/**
 * A very simple Interpreter for the VSDT Expression Language.
 * 
 * @author kuester
 */
public class VxlInterpreter {
	
	/** errors that occurred during the evaluation, e.g. non-matching operations */
	protected Map<Object, String> errors= null;
	
	/** the context, e.g. the association of variables to actual values */
	protected Map<String, Serializable> context= null;
	
	public Map<Object, String> getErrors() {
		return errors;
	}

	/**
	 * Evaluate the given Term and return the result.
	 * 
	 * @param term		Some Term
	 * @return			Result, e.g. a String, Number, or Boolean, or whatever else
	 */
	public Serializable evaluateTerm(Term term, Map<String, Serializable> context) {
		this.errors= new HashMap<Object, String>();
		this.context= context;
		return eval(term);
	}
	
	/**
	 * Term:			head = Head (tail = Tail)?;
	 * The term is transcribed to an ordered TermTree and evaluated.
	 */
	protected Serializable eval(Term term) {
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
	protected Serializable eval(TermTree term) {
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
	protected Serializable eval(Head head) {
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
	protected Serializable eval(Negation negation) {
		Serializable result= eval(negation.getHead());
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
	protected Serializable eval(Minus minus) {
		Serializable result= eval(minus.getHead());
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
	protected Serializable eval(Atom atom) {
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
	protected Serializable eval(Variable variable) {
		// get value from context
		if (context != null) {
			Serializable value= context.get(variable.getName());
			//XXX why does context.get not work here?
			for (String key : context.keySet()) {
				if (key.equals(variable.getName())) {
					value= context.get(key);
					if (value==null) {
						errors.put(variable, "Variable has not been initialized");
					}
				}
			}
			if (variable.getAccessor() != null) {
				value = eval(variable.getAccessor(), value);
			}
			return value;
		} else {
			errors.put(variable, "Can not evaluate a Variable without a context");
			return null;
		}
	}
	
	/**
	 * Accessor:		ArrayAccessor | FieldAccessor;
	 */
	protected Serializable eval(Accessor accessor, Serializable value) {
		if (accessor instanceof ArrayAccessor) {
			return eval((ArrayAccessor) accessor, value);
		}
		if (accessor instanceof FieldAccessor) {
			return eval((FieldAccessor) accessor, value);
		}
		return null;
	}

	/**
	 * TODO test
	 * ArrayAccessor:	"[" index = Term "]" (accessor = Accessor)?;
	 */
	@SuppressWarnings("unchecked")
	protected Serializable eval(ArrayAccessor accessor, Serializable value) {
		// evaluate index
		Serializable index = eval(accessor.getIndex());
		if (index instanceof Integer) {
			int i = (Integer) index;
			
			// access element
			if (value instanceof Serializable[]) {
				Serializable[] asArray = (Serializable[]) value;
				if (asArray.length >= i) {
					value = asArray[i];
				} else {
					errors.put(accessor, "Array Index out of range");
				}
			} else
			if (value instanceof List) {
				List<Serializable> asList = (List<Serializable>) value;
				if (asList.size() >= i) {
					value = asList.get(i);
				} else {
					errors.put(accessor, "List Index out of range");
				}
			}
			
			// another accessor?
			if (accessor.getAccessor() != null) {
				value = eval(accessor.getAccessor(), value);
			}
		}
		return value;
	}
	
	/**
	 * TODO
	 * FieldAccessor:	"." name = ID (accessor = Accessor)?;
	 */
	protected Serializable eval(FieldAccessor accessor, Serializable value) {
		throw new UnsupportedOperationException();
		
		// another accessor?
//		if (accessor.getAccessor() != null) {
//			value = eval(accessor.getAccessor(), value);
//		}
//		return value;
	}

	/**
	 * Value:			StringConst | BooleanConst | NumericConst | Null;
	 */
	protected Serializable eval(Value value) {
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
	@SuppressWarnings("unchecked")
	private Serializable evaluateOperation(Operator operator, Object head, Object tail) {
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
	@SuppressWarnings("unchecked")
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
