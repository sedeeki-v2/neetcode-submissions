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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        StringBuilder sbRoot = new StringBuilder();
        StringBuilder sbSubRoot =  new StringBuilder();
        inOrderStringOfNumbers(root, sbRoot);
        inOrderStringOfNumbers(subRoot, sbSubRoot);

        System.out.println("Root: " + sbRoot.toString() + ", SubRoot: " + sbSubRoot.toString());

        return sbRoot.toString().contains(sbSubRoot.toString());
    }

    private void inOrderStringOfNumbers(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#");
            return;
        }

        sb.append("," + String.valueOf(root.val));
        inOrderStringOfNumbers(root.left, sb);
        inOrderStringOfNumbers(root.right, sb);        
    }
}
