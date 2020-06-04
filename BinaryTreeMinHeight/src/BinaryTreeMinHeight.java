/*
 *  Leetcode: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * e.g.
 * Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 */


public class BinaryTreeMinHeight {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
    public void test() {
        TreeNode root = new TreeNode(6);
        int height = this.minDepth(root);
        System.out.println("Minimum height: " + height);
    }

    public static  void main(String args[]) {
        BinaryTreeMinHeight binaryTreeMinHeight = new BinaryTreeMinHeight();
        binaryTreeMinHeight.test();
    }
}
