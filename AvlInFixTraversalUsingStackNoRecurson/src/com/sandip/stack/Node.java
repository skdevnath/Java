package com.sandip.stack;

public class Node extends InFixTraversalMainMethod {
	Node left;
	Node right;
	Node parent;
	int	 val;
	
	Node(int val) {
		this.val = val;
		left = null;
		right = null;
		parent = null;
	}
}
