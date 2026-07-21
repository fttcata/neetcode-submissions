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
    public List<List<Integer>> levelOrder(TreeNode root) {
    // Queue for bfs
    Queue<TreeNode> que = new LinkedList<>();

    // Output list
    List<List<Integer>> result = new ArrayList<>();

    if (root == null)
    return result;

    // bfs on the tree
    que.add(root);
    int index = 0;
    while (!que.isEmpty())
    {
        int size = que.size();
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i < size)
        {
            TreeNode curr = que.poll();
            list.add(curr.val);
            if (curr.left != null)
            que.add(curr.left);
            if (curr.right != null)
            que.add(curr.right);
            i++;
        }
        result.add(list);
    }
    return result;
    }
}
