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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;

        return dfs(root,sum,targetSum);
    }

    private boolean dfs(TreeNode root, int sum, int targetSum)
    {
        // If we reached a null node and we haven't return true yet, return false
        if (root == null)
        return false;
        
        sum += root.val;

        // if its a leaf node, we return sum == targetSum
        if (root.left == null && root.right == null)
        return sum == targetSum;

        // dfs
        return dfs(root.left,sum,targetSum) || dfs(root.right,sum,targetSum);
    }
}