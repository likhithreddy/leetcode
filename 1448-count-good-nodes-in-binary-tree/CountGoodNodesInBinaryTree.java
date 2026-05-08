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

    int countGoodNodes(TreeNode node, int currentMax) {
        if (node == null) {
            return 0;
        }
        int goodNodesCount = (node.val >= currentMax) ? 1 : 0;
        currentMax = (currentMax < node.val) ? node.val : currentMax;
        goodNodesCount += countGoodNodes(node.left, currentMax);
        goodNodesCount += countGoodNodes(node.right, currentMax);
        return goodNodesCount;
    }

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
}