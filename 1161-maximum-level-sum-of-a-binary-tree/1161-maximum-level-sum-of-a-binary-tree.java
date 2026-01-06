/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 1;          // current level
        int maxLevel = 1;       // level with max sum
        int maxSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            int curSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                curSum += node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            if (curSum > maxSum) {
                maxSum = curSum;
                maxLevel = level;
            }
            level++;
        }

        return maxLevel;
    }
}
