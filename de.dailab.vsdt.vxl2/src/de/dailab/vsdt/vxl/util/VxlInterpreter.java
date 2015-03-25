package de.dailab.vsdt.vxl.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import de.dailab.vsdt.vxl.util.TermOrdering.TermLeaf;
import de.dailab.vsdt.vxl.util.TermOrdering.TermNode;
import de.dailab.vsdt.vxl.util.TermOrdering.TermTree;
import de.dailab.vsdt.vxl.vxl.VxlAccessor;
import de.dailab.vsdt.vxl.vxl.VxlArrayAccessor;
import de.dailab.vsdt.vxl.vxl.VxlBooleanConst;
import de.dailab.vsdt.vxl.vxl.VxlBracketTerm;
import de.dailab.vsdt.vxl.vxl.VxlCardinality;
import de.dailab.vsdt.vxl.vxl.VxlElement;
import de.dailab.vsdt.vxl.vxl.VxlFieldAccessor;
import de.dailab.vsdt.vxl.vxl.VxlList;
import de.dailab.vsdt.vxl.vxl.VxlListElement;
import de.dailab.vsdt.vxl.vxl.VxlMinus;
import de.dailab.vsdt.vxl.vxl.VxlNegation;
import de.dailab.vsdt.vxl.vxl.VxlNullConst;
import de.dailab.vsdt.vxl.vxl.VxlNumericConst;
import de.dailab.vsdt.vxl.vxl.VxlOperator;
import de.dailab.vsdt.vxl.vxl.VxlStringConst;
import de.dailab.vsdt.vxl.vxl.VxlTerm;
import de.dailab.vsdt.vxl.vxl.VxlValue;
import de.dailab.vsdt.vxl.vxl.VxlVariable;

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
	public Serializable evaluateTerm(VxlTerm term, Map<String, Serializable> context) {
		this.errors= new HashMap<Object, String>();
		this.context= context;
		return evalTerm(term);
	}
	
	/**
	 * Term:			head = Head (tail = Tail)?;
	 * The term is transcribed to an ordered TermTree and evaluated.
	 */
	protected Serializable evalTerm(VxlTerm term) {
		TermTree orderedTermTree= TermOrdering.createOrderedTermTree(term);
//		TermOrdering.print(orderedTermTree, 0);
		return evalTermTree(orderedTermTree);
	}
	
	/**
	 * Evaluate the TermTree. In case of a Leaf, evaluate the encapsulated term;
	 * otherwise evaluate the left and right terms and try to apply the operation.
	 * 
	 * @param term	Some ordered TermTree
	 * @return		Evaluation result (e.g. a Sting, Number, or Boolean)
	 */
	protected Serializable evalTermTree(TermTree term) {
		if (term instanceof TermLeaf) {
			TermLeaf leaf= (TermLeaf) term;
			return evalElement(leaf.term);
		}
		if (term instanceof TermNode) {
			TermNode node= (TermNode) term;
			
			Object head= evalTermTree(node.left);
			Object tail= evalTermTree(node.right);
			VxlOperator op= node.operator;
			
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
	 * Head:			BracketTerm | Negation | Minus | Value | Variable | List | Cardinality;
	 */
	protected Serializable evalElement(VxlElement head) {
		if (head instanceof VxlBracketTerm) {
			return evalTerm(((VxlBracketTerm) head).getTerm());
		}
		if (head instanceof VxlNegation) {
			return evalNegation((VxlNegation) head);
		}
		if (head instanceof VxlMinus) {
			return evalMinus((VxlMinus) head);
		}
		if (head instanceof VxlVariable) {
			return evalVariable((VxlVariable) head);
		}
		if (head instanceof VxlValue) {
			return evalValue((VxlValue) head);
		}
		if (head instanceof VxlList) {
			return evalList((VxlList) head);
		}
		if (head instanceof VxlCardinality) {
			return evalCardinality((VxlCardinality) head);
		}
		return null;
	}

	/**
	 * Negation:		"!" term = Element;
	 */
	protected Serializable evalNegation(VxlNegation negation) {
		Serializable result= evalElement(negation.getElement());
		if (result instanceof Boolean) {
			return ! (Boolean) result;
		} else {
			errors.put(negation, "Negation only applicable to Boolean");
			return null;
		}
	}

	/**
	 * Minus:		"-" term = Element;
	 */
	protected Serializable evalMinus(VxlMinus minus) {
		Serializable result= evalElement(minus.getElement());
		if (result instanceof Number) {
			return - ((Number) result).doubleValue();
		} else {
			errors.put(minus, "Minus only applicable to Numeric");
			return null;
		}
	}
	
	/**
	 * Cardinality:		"#" term = Element
	 */
	protected Double evalCardinality(VxlCardinality cardinality) {
		Serializable value = evalElement(cardinality.getElement());
		if (value instanceof Double) {
			return Math.abs((Double) value);
		}
		if (value instanceof List<?>) {
			return (double) ((List<?>) value).size();
		}
		if (value instanceof Boolean) {
			return ((Boolean) value) ? 1. : 0.;
		}
		if (value instanceof String) {
			return (double) ((String) value).length();
		}
		return null;
	}
	
	/**
	 * Variable:		name = ID (accessor = Accessor)?;
	 */
	protected Serializable evalVariable(VxlVariable variable) {
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
				value = evalAccessor(variable.getAccessor(), value);
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
	protected Serializable evalAccessor(VxlAccessor accessor, Serializable value) {
		if (accessor instanceof VxlArrayAccessor) {
			return evalArrayAccessor((VxlArrayAccessor) accessor, value);
		}
		if (accessor instanceof VxlFieldAccessor) {
			return evalFieldAccessor((VxlFieldAccessor) accessor, value);
		}
		return null;
	}

	/**
	 * TODO test
	 * ArrayAccessor:	"[" index = Term "]" (accessor = Accessor)?;
	 */
	@SuppressWarnings("unchecked")
	protected Serializable evalArrayAccessor(VxlArrayAccessor accessor, Serializable value) {
		// evaluate index
		Serializable index = evalTerm(accessor.getIndex());
		if (index instanceof Number) {
			int i = ((Number) index).intValue();
			
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
				value = evalAccessor(accessor.getAccessor(), value);
			}
		}
		return value;
	}
	
	/**
	 * TODO
	 * FieldAccessor:	"." name = ID (accessor = Accessor)?;
	 */
	protected Serializable evalFieldAccessor(VxlFieldAccessor accessor, Serializable value) {
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
	protected Serializable evalValue(VxlValue value) {
		if (value instanceof VxlStringConst) {
			return ((VxlStringConst) value).getConst();
		}
		if (value instanceof VxlBooleanConst) {
			return "true".equals(((VxlBooleanConst) value).getConst());
		}
		if (value instanceof VxlNumericConst) {
			return Double.parseDouble(((VxlNumericConst) value).getConst());
		}
		if (value instanceof VxlNullConst) {
			return null;
		}
		return null;
	}
	
	/**
	 * List:			"[" (body = VxlListElement)? "]";
	 */
	protected Vector<Serializable> evalList(VxlList list) {
		if (list.getBody() != null) {
			return evalListElement(list.getBody());
		} else {
			return new Vector<Serializable>();
		}
	}
	
	/**
	 * ListElement:		first = VxlTerm ("," rest = VxlListElement)?;
	 */
	protected Vector<Serializable> evalListElement(VxlListElement listElement) {
		Vector<Serializable> list = new Vector<Serializable>();
		list.add(evalTerm(listElement.getFirst()));
		if (listElement.getRest() != null) {
			list.addAll(evalListElement(listElement.getRest()));
		}
		return list;
	}
	
	/**
	 * Evaluate the operation with the given terms.
	 * 
	 * @param operator	the operation
	 * @param head		the head term (to the left)
	 * @param tail		the tail term (to the right)
	 * @return			result of the operation, applied to the given terms
	 */
	@SuppressWarnings({"unchecked","rawtypes"})
	private Serializable evaluateOperation(VxlOperator operator, Object head, Object tail) {
		switch (operator) {
		case CONCAT:
			if (head instanceof List && tail instanceof List) {
				Vector result = new Vector((List) head);
				result.addAll((Vector) tail);
				return result;
			} else if (head instanceof String || tail instanceof String) {
				return new StringBuffer().append(head).append(tail).toString();
			}
		case ADD:
			if (head instanceof List) {
				Vector result = new Vector((List) head);
				result.add(tail);
				return result;
			} else if (head instanceof Number && tail instanceof Number) {
				return toDouble((Number) head) + toDouble((Number) tail);
			}
		case MULT:
			if (head instanceof List && tail instanceof Number) {
				Vector result = new Vector();
				double t = (Double) tail;
				for (int i=0; i < t; i++) {
					result.addAll((Vector) head);
				}
				return result;
			} else if (head instanceof String && tail instanceof Number) {
				StringBuffer result = new StringBuffer();
				double t = (Double) tail;
				for (int i=0; i < t; i++) {
					result.append((String) head);
				}
				return result.toString();
			} else if (head instanceof Number && tail instanceof Number) {
				return toDouble((Number) head) * toDouble((Number) tail);
			}
		case SUB:
			return toDouble((Number) head) - toDouble((Number) tail);
		case DIV:
			return toDouble((Number) head) / toDouble((Number) tail);
		case MOD:
			return toDouble((Number) head) % toDouble((Number) tail);
		case AND:
			return (Boolean) head && (Boolean) tail;
		case OR:
			return (Boolean) head || (Boolean) tail;
		case GE:
			return (toDoubleIfNumber(head)).compareTo(toDoubleIfNumber(tail)) >= 0;
		case GT:
			return (toDoubleIfNumber(head)).compareTo(toDoubleIfNumber(tail)) >  0;
		case LE:
			return (toDoubleIfNumber(head)).compareTo(toDoubleIfNumber(tail)) <= 0;
		case LT:
			return (toDoubleIfNumber(head)).compareTo(toDoubleIfNumber(tail)) <  0;
		case EQ:
			return head.equals(tail);
		case NEQ:
			return ! head.equals(tail);
		default: 
			return null;
		}
	}
	
	/**
	 * This is used for comparing different kinds of numbers: If it's a number,
	 * cast it to double, otherwise just return the object in its own class.
	 * 
	 * @param o		some comparable object
	 * @return		object cast to double, if a number, else the object itself
	 */
	@SuppressWarnings("rawtypes")
	private Comparable toDoubleIfNumber(Object o) {
		if (o instanceof Number) {
			return toDoubleIfNumber((Number) o);
		}
		return (Comparable) o;
	}
	
	private double toDouble(Number n) {
		if (n instanceof Integer) {
			return ((Integer) n).doubleValue();
		}
		if (n instanceof Long) {
			return ((Long) n).doubleValue();
		}
		if (n instanceof Double) {
			return (Double) n;
		}
		return 0;
	}

	/**
	 * Check whether the given terms match the operator.
	 *  
	 * @param operator	the operator
	 * @param head		the head term (to the left)
	 * @param tail		the tail term (to the right)
	 * @return			terms match operator?
	 */
	private boolean checkType(VxlOperator operator, Object head, Object tail) {
		try {
			switch (operator) {
			case CONCAT:
				return (head instanceof List && tail instanceof List) || 
						(head instanceof String || tail instanceof String);
			case ADD:
				return head instanceof List || 
						(head instanceof Number && tail instanceof Number);
			case MULT:
				return ((head instanceof List || head instanceof String) && tail instanceof Number) || 
						(head instanceof Number && tail instanceof Number);
			case SUB:
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
