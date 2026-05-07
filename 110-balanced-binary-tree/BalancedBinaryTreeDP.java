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
    int relativeHeightOfTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = relativeHeightOfTree(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = relativeHeightOfTree(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : (1 + Math.max(leftHeight, rightHeight));
    }

    public boolean isBalanced(TreeNode root) {
        return relativeHeightOfTree(root) != -1;
    }
}