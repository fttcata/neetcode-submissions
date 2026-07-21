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
        1 - Level 1 
    2       3 - Level 2
                4 - Level 3
 -- Doing depth first search
 -- This allows us to search the longest depth without wasting time on level <- bfs
 -- In the best case the longest depth is on the left, then O(L) - L <- longest depth
 -- In the worst case it would still be O(n) -- If the longest is on the right side of tree
 
 --  Root -> make my way down the paths of the tree
 --  Keep a count of the length of the current path we are going down on
 -- Compare that count when we reach the end to the maximum

 -- Variables: 2 integers count, max
 -- DFS -> Recursively as the code, in my opinion looks more neatly

 -- Can the input be null? Yes? Then here's our edge case
 -- While traversing the path, if we reach an end we return 0;
*/
class Solution {
    public int maxDepth(TreeNode root) {
       if (root == null)
       return 0;

       return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

/* Visualize an input
            5
        3       2
    8          9    4
             2  
*/