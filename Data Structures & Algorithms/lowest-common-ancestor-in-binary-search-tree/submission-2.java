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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null)
        {
            // If currValue is less than both, go right
            if (root.val < p.val && root.val < q.val)
            root = root.right;
            // if currValue is higher than both, go left
            else if (root.val > p.val && root.val > q.val)
            root = root.left;
            // Else we reached LCA
            else return root;
        }
        return new TreeNode(0,null,null);
    }
}
