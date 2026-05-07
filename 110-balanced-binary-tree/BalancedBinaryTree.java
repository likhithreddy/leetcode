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
    int heightOfTree(TreeNode root) {
        return (root == null) ? 0 : (1 + Math.max(heightOfTree(root.left), heightOfTree(root.right)));
    }

    public boolean isBalanced(TreeNode root) {
        return (root == null) ? true
                : Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) > 1 ? false
                        : (isBalanced(root.left) && isBalanced(root.right)) ? true : false;
    }
}