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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }
        TreeNode iterator = root;
        while (true) {
            if (iterator.val > val) {
                if (iterator.left == null) {
                    iterator.left = node;
                    return root;
                }
                iterator = iterator.left;
            } else {
                if (iterator.right == null) {
                    iterator.right = node;
                    return root;
                }
                iterator = iterator.right;
            }
        }
    }
}