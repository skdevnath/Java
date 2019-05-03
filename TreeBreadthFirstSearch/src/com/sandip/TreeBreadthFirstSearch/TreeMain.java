package com.sandip.TreeBreadthFirstSearch;
import java.util.*;

public class TreeMain {

	public static void main(String[] args) {
		// Build a test tree
		TreeNode tree = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		tree.children.add(node2);
		tree.children.add(node3);

		node2.children.add(node5);
		node2.children.add(node4);

		printBreadthFirst(tree);
	}
	
	static void printBreadthFirst(TreeNode tree) {
		Queue<TreeNode> q = new LinkedList<TreeNode>(); 
		int oldDepth = tree.depth = 0;
		tree.visited = true;
		q.add(tree);
		
		while(q.size() > 0) {
			TreeNode elem = (TreeNode) q.poll();
			int depth = elem.depth; 
			if (depth > oldDepth) {
				System.out.printf("\n");
			}
			System.out.printf(" %d ", elem.value);
			oldDepth = depth; 
			for (TreeNode child: elem.children) {
				if (!child.visited) {
					child.depth = depth + 1;
					child.visited = true;
					q.add(child);
				}
			}
		}
	}
}