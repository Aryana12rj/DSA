class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftdepth=maxDepth(root.left);
        int rightdepth=maxDepth(root.right);

        return 1+Math.max(leftdepth,rightdepth);
    }
}