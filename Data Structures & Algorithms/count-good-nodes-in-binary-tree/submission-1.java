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
    int count = 1;
    public int goodNodes(TreeNode root) {
        if (root == null)
        return 0;

        dfs(root.left,root.val);
        dfs(root.right,root.val);
        return count;
    }
    private int dfs(TreeNode root, int maxNode)
    {
        if (root == null)
        return count;

        if (root.val >= maxNode)
        count++;

        maxNode = Math.max(root.val,maxNode);
        return dfs(root.left,maxNode) + dfs(root.right,maxNode);
    }
}
