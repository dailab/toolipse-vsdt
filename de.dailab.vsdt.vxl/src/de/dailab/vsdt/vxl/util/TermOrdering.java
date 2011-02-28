package de.dailab.vsdt.vxl.util;

import java.util.HashMap;
import java.util.Map;

import de.dailab.vsdt.vxl.vxl.VxlHead;
import de.dailab.vsdt.vxl.vxl.VxlOperator;
import de.dailab.vsdt.vxl.vxl.VxlTerm;

/**
 * This helper class is for ordering Terms w.r.t. the operators. Right after
 * being parsed by the generic XText parser, the Term will be right-combed, 
 * meaning that, if no brackets are used, the operation will be evaluated from 
 * left to right, which is highly counter-intuitive. With this class the Terms
 * can be transcribed to another representation, which can then be combed to the
 * left (serving as the more intuitive default ordering) and then be ordered 
 * properly w.r.t. the operators priorities.  
 * 
 * @author kuester
 */
public class TermOrdering {

	/** this list holds the order of the operators */
	static Map<VxlOperator, Integer> priorityMap;
	
	/** initialize priority map */
	static {
		priorityMap= new HashMap<VxlOperator, Integer>();
		// modulo has highest priority / strongest binding
		priorityMap.put(VxlOperator.MOD, 5);
		// next goes multiplication, division, and power
		priorityMap.put(VxlOperator.MULT, 4);
		priorityMap.put(VxlOperator.DIV, 4);
		// then addition, subtraction, and concatenation (on strings)
		priorityMap.put(VxlOperator.CONCAT, 3);
		priorityMap.put(VxlOperator.ADD, 3);
		priorityMap.put(VxlOperator.SUB, 3);
		// now all kinds of comparisons and equations
		priorityMap.put(VxlOperator.GT, 2);
		priorityMap.put(VxlOperator.GE, 2);
		priorityMap.put(VxlOperator.LT, 2);
		priorityMap.put(VxlOperator.LE, 2);
		priorityMap.put(VxlOperator.EQ, 2);
		priorityMap.put(VxlOperator.NEQ, 2);
		// disjunction
		priorityMap.put(VxlOperator.AND, 1);
		// and finally conjunction
		priorityMap.put(VxlOperator.OR, 0);
	}

	/**
	 * Determines whether Operator 1 has priority over Operator 2, meaning that
	 * Operator 1 is stronger binding than Operator 2.
	 * 
	 * @param operator1		First Operator
	 * @param operator2		Second Operator
	 * @return				true, if operator 1 has priority over operator 2
	 */
	protected static boolean hasPriorityOver(VxlOperator operator1, VxlOperator operator2) {
		return priorityMap.get(operator1) > priorityMap.get(operator2);
	}
	
	/**
	 * Creates an ordered TermTree from the given VXL Term. First, the Term is 
	 * transcribed to a TermTree, so it can be ordered. Next, the TermTree is 
	 * combed to the Left, so the default ordering is from left to right. 
	 * Finally, the TermTree is ordered w.r.t. to priority of the operations.
	 * 
	 * @param term	some VXL Term
	 * @return		ordered TermTree version of the Term
	 */
	public static TermTree createOrderedTermTree(VxlTerm term) {
		TermTree termTree= TermOrdering.transcribe(term);
		termTree= TermOrdering.combLeft(termTree);
		termTree= TermOrdering.order(termTree);
		return termTree;
	}
	
	/**
	 * Transcribe a Term of VXL to a TreeTerm. Like the original VXL term, the 
	 * TermTree will still 'right-combed', so that if two operators next to each 
	 * other have the same priority they would be evaluated from right to left, 
	 * i.e. for the term '1 - 2 + 3' the result would be '-4'.
	 *  
	 * @param term	some VXL Term
	 * @return		right-combed TermTree
	 */
	protected static TermTree transcribe(VxlTerm term) {
		if (term.getTail() == null) {
			// wrap Head in a TermLeaf
			return new TermLeaf(term.getHead());
		} else {
			// wrap Term in a TermNode
			VxlOperator operator= term.getTail().getOperator();
			TermLeaf head= new TermLeaf(term.getHead());
			TermTree tail= transcribe(term.getTail().getTerm());
			return new TermNode(head, operator, tail);
		}
	}
	
	/**
	 * Combs an initially right-combed term over to the left, so that if two 
	 * operators next to each other have the same priority they are evaluated 
	 * from left to right, i.e. for the term '1 - 2 + 3' the result will be '2'.
	 * 
	 * @param term	some right-combed TermTree
	 * @return		left-combed TermTree
	 */
	protected static TermTree combLeft(TermTree term) {
		// Term is Leaf -> return the Leaf 
		if (term instanceof TermLeaf) {
			return term;
		}
		// Term is Node -> check if the Term needs to be ordered
		if (term instanceof TermNode) {
			TermNode node= (TermNode) term;
			
			// a left combed tree may not have a subtree to the right
			if (node.right instanceof TermNode) {
				TermNode rightChild = (TermNode) node.right;
				// rotate left and repeat for the new tree
				node.right= rightChild.left;
				rightChild.left= node;
				return combLeft(rightChild);
			}
			
			// no node at the right -> return it
			return node;
		}
		return null;
		
	}

	/**
	 * Order a TermTree according to the involved operations. The result is a 
	 * Term Tree that yields the same result when doing an in-order pass, but in
	 * which for each subtree the priority of the operation is higher than in its
	 * parent tree.
	 * 
	 * @param term		some unordered TermTree
	 * @return			ordered TermTree
	 */
	protected static TermTree order(TermTree term) {
		// Term is Leaf -> return the Leaf 
		if (term instanceof TermLeaf) {
			return term;
		}
		// Term is Node -> check if the Term needs to be ordered
		if (term instanceof TermNode) {
			TermNode node= (TermNode) term;
			// order left and right subtrees, if necessary
			node.left= order(node.left);
			node.right= order(node.right);
			
			// if the left subtree is a node, its top-level operator should have higher priority
			if (node.left instanceof TermNode) {
				TermNode leftChild = (TermNode) node.left;
				if ( hasPriorityOver(node.operator, leftChild.operator)) {
					// rotate right and order the rotated tree
					node.left= leftChild.right;
					leftChild.right= node;
					return order(leftChild);
				}
			}
			
			// if the right subtree is a node, its top-level operator should have higher priority
			if (node.right instanceof TermNode) {
				TermNode rightChild = (TermNode) node.right;
				if ( hasPriorityOver(node.operator, rightChild.operator)) {
					// rotate left and order the rotated tree
					node.right= rightChild.left;
					rightChild.left= node;
					return order(rightChild);
				}
			}
			
			// term appears to be ordered -> return it
			return node;
		}
		return null;
	}

	/**
	 * Print the TermTree. For debugging purposes.
	 * @param term		some Term Tree
	 * @param n			current level of indentation (start with 0)
	 */
	public static void print(TermTree term, int n) {
		for (int i=0; i<n; i++) {
			System.out.print("   ");
		}
		if (term instanceof TermLeaf) {
			TermLeaf leaf = (TermLeaf) term;
			System.out.println(leaf.term);
		}
		if (term instanceof TermNode) {
			TermNode node= (TermNode) term;
			System.out.println(node.operator.getName());
			print(node.left, n+1);
			print(node.right, n+1);
		}
	}

	/**
	 * A Tree of Terms. Other than the regular Term as it is parsed from the VXL
	 * language, the TermTree can be rearranged according to the priorities of
	 * the involved operators.
	 * 
	 * @author kuester
	 */
	public interface TermTree { }
	
	/**
	 * A Leaf in the Tree of Terms is encapsulating a Head term, i.e. an Atom, a
	 * Negation, or a Bracket Term.
	 * 
	 * @author kuester
	 */
	public static class TermLeaf implements TermTree {
		VxlHead term;
		public TermLeaf(VxlHead term) {
			this.term= term;
		}
	}
	
	/**
	 * A Node in the Tree of Terms in encapsulating an Operator and two other
	 * TermTrees.
	 * 
	 * @author kuester
	 */
	public static class TermNode implements TermTree {
		VxlOperator operator;
		TermTree left;
		TermTree right;
		public TermNode(TermTree left, VxlOperator operator, TermTree right) {
			this.left= left;
			this.right= right;
			this.operator= operator;
		}
	}
	
}
