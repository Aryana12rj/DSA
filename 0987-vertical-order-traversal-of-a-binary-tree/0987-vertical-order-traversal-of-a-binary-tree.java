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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> mp = new TreeMap<>();
        traverse(mp, 0, 0, root);

        List<List<Integer>> res = new ArrayList<>();

        for (List<int[]> list : mp.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1]; 
                return a[0] - b[0]; 
            });

            List<Integer> col = new ArrayList<>();
            for (int[] arr : list) {
                col.add(arr[1]);
            }
            res.add(col);
        }

        return res;
    }

    public void traverse(Map<Integer, List<int[]>> mp, int col, int level, TreeNode root) {
        if (root == null) return;

        mp.putIfAbsent(col, new ArrayList<>());
        mp.get(col).add(new int[]{level, root.val});

        traverse(mp, col - 1, level + 1, root.left);
        traverse(mp, col + 1, level + 1, root.right);
    }
}