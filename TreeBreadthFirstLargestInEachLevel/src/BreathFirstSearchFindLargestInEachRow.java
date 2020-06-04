import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/submissions/
You need to find the largest value in each row of a binary tree.

Example:
Input:

          1
         / \
        3   2
       / \   \
      5   3   9

Output: [1, 3, 9]
* */

public class BreathFirstSearchFindLargestInEachRow {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public static List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.add(root);
        Queue<TreeNode> q = q1;

        int q1Max = Integer.MIN_VALUE;
        int q2Max = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }
        do {
            while (!q.isEmpty()) {
                TreeNode c = q.remove();
                if (q == q1) {
                    if (c != null) {
                        if (q1Max < c.val) {
                            q1Max = c.val;
                        }
                        if (c.left != null) {
                            q2.add(c.left);
                        }
                        if (c.right != null) {
                            q2.add(c.right);
                        }
                    }
                } else { // q2 case
                    if (c != null) {
                        if (q2Max < c.val) {
                            q2Max = c.val;
                        }
                        if (c.left != null) {
                            q1.add(c.left);
                        }
                        if (c.right != null) {
                            q1.add(c.right);
                        }
                    }
                }
            }
            if (q == q1) {
                if (q1Max != Integer.MIN_VALUE) {
                    result.add(q1Max);
                }
                q1Max = Integer.MIN_VALUE;
            } else {
                if (q2Max != Integer.MIN_VALUE) {
                    result.add(q2Max);
                }
                q2Max = Integer.MIN_VALUE;
            }
            if (q == q1) {
                q = q2;
            } else {
                q = q1;
            }
        } while (!q.isEmpty());

        return result;
    }

    public static void main(String [] args) {
        TreeNode root = new TreeNode(2);
        List<Integer> result = largestValues(root);
        for (Integer i: result) {
            System.out.println(i);
        }
    }
}
