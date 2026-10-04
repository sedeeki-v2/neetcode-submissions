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
    public int kthSmallest(TreeNode root, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        inOrder(root, set);
        return new ArrayList<>(set).get(k - 1);
    }

    private void inOrder(TreeNode root, TreeSet<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        inOrder(root.left, set);
        inOrder(root.right, set);
    }
}
