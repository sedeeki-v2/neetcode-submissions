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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> arr = new ArrayList<>();
        serializeHelper(root, arr);
        return String.join(",", arr);
    }

    private void serializeHelper(TreeNode root, List<String> arr) {
        if (root == null) {
            arr.add("n");
            return;
        }

        arr.add(String.valueOf(root.val));
        serializeHelper(root.left, arr);
        serializeHelper(root.right, arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] position = {0};
        return deserializeHelper(vals, position);
    }

    private TreeNode deserializeHelper(String[] vals, int[] position) {
        if (vals[position[0]].equals("n")) {
            position[0] += 1;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[position[0]]));
        position[0] += 1;
        root.left = deserializeHelper(vals, position);
        root.right = deserializeHelper(vals, position);

        return root;
    }
}
