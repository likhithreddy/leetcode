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
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        int value = 0;
        if (root == null) {
            return 0;
        }
        int left = kthSmallest(root.left, k);
        if (left != 0) {
            return left;
        }
        count += 1;
        if (count == k) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }
}