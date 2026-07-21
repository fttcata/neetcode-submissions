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

// Subtree heights, keep track of the maximum left subtree height and maximum right subtree height for every parent
// Diameter of tree is Math.max(maxDiameter, currentNodeLengthLeft + currentNodeLengthRight);

class Solution {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // Keep track of current maxDiameter in this array
        int [] res = new int[1];

        dfs(root,res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res)
    {
        // Base case
        if (root == null)
        return 0;

        int left = dfs(root.left,res);
        int right = dfs(root.right,res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left,right);
    }

}
