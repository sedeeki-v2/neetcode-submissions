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

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode root, int diameter) {
        if (root == null) return 0;

        int longestLength = longestLength(root, diameter);
        if (diameter < longestLength) diameter = longestLength;

        int leftNodeLongestLength = traverse(root.left, diameter);
        int rightNodeLongestLength = traverse(root.right, diameter);

        if (leftNodeLongestLength > diameter) diameter = leftNodeLongestLength;
        if (rightNodeLongestLength > diameter) diameter = rightNodeLongestLength;
        return diameter;
    }

    private int longestLength(TreeNode root, int diameter) {
        if (root == null) return 0;
        
        int leftSide = depth(root.left);
        int rightSide = depth(root.right);

        if (leftSide + rightSide > diameter) {
            diameter = leftSide + rightSide;
        } 

        return diameter;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if (leftDepth < rightDepth) {
            return rightDepth + 1;
        }

        return leftDepth + 1;
    }

    
}
