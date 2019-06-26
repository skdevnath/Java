package com.sandip.stack;
import java.util.*;

public class InFixTraversalMainMethod {
	
	public static void main(String args[]) {
		
		/* build the data 
		 *       6
		 *   4       8
		 * 3   5   7   9 
		 * */
		Node root = new Node(6);
		root.right = new Node(8);
		root.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left = new Node(3);
		root.right.right = new Node(9);
		root.right.left = new Node(7);
		
		/* Sandip:
		   Not sure we want to push left first. My google doc says push right first in the stack so that left element 
		   get pulled, when we accss top of the stack.
		Stack collection is deprecated it's usage is discouraged in favor of
		 * Deque, ArrayDeque. The ArrayDeque and the Deque interface are faster
		 * and newer collection.*/
	    Deque<Node> stack = new ArrayDeque<Node>();
		Node current = root;
		do {
			stack.push(current);
			while (current.left != null) {
				// System.out.printf("  adding current's left(%d) to the stack\n", current.left.val);
				stack.push(current.left);	
				current = current.left;
			}

			/* 
			 * System.out.printf("first left: ");
			 * for (Node e:stack) {
			 *	 System.out.printf("%d,", e.val);
			 * }
			 * System.out.println("");
			 */

			while (!stack.isEmpty()) {
				Node elm = stack.pop();
				System.out.println(elm.val + ", ");
				current = elm.right;

				if (current != null) {
					/* break if any stack Node has right node.
					 * If any right element then we need to go to left most element in that right tree */
					// System.out.println(" elm's left node to be seen: " + current.val);
					break;
				}
			}
		} while (current != null);
	}
}
