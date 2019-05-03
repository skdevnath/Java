package com.sandip.TreeBreadthFirstSearch;
import java.util.*;

public class TreeNode {
	List<TreeNode> children = new ArrayList<TreeNode>();
	int depth;
	boolean visited;
	int	value;
	TreeNode(int value) {
		this.value = value;
		depth = 0;
		visited = false;
	}
}
