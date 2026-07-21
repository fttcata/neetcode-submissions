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
/*
Can binary tree be empty? Yes
Can k go out of bounds? as in k < 1 || k > nr of nodes No
So therefore the only edge case is when root is null
*/
// 4,3,5,2. What I can do is traverse the tree once, and calculating the total length of the tree, the number of nodes
// After I traverse the tree once, I check if k is higher than length/2 or lower than length/2
// if k is lower, we go on the left subtree and we continue to check the condition
// if k is higher, we go on the right subtree and we continue to check the condition

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs(root,tmp);
        return tmp[1];
    }

    private void dfs(TreeNode node, int[] tmp)
    {
        // Base case. Return null
        if (node == null)
        return;

        // We explore in order DFS, since doing that we will get values in ascending order
        dfs(node.left,tmp);
        if(tmp[0] == 0) return;


        tmp[0] -= 1;
        if (tmp[0] == 0)
        {   tmp[1] = node.val;
            return;}

         dfs(node.right,tmp);
    }  
}
