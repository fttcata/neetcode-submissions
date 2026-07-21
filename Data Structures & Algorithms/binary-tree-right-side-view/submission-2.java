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
    public List<Integer> rightSideView(TreeNode root) {
        // Edge case if root is null
        if (root == null)
        return new ArrayList<>();

        // We will use bfs to in-level travers the binary tree
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        // ArrayList for result
        List<Integer> result = new ArrayList<>();
        // BFS
        while (!que.isEmpty())
        {
            int size = que.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode curr = que.poll();
                // If we are at the last node before adding the rest, it means its the one we can see from the right side
                if (i == size - 1)
                result.add(curr.val);
                if (curr.left != null)
                que.add(curr.left);
                if (curr.right != null)
                que.add(curr.right);
            }
        }
        return result;
    }
}
