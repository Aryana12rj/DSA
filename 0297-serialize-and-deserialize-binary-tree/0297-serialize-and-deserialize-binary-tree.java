/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "null";
        }
        String left=serialize(root.left);
        String right=serialize(root.right);

        return root.val+","+left+","+right;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        Queue<String> q=new LinkedList<>();
        for(String s:arr){
            q.add(s);
        }
        
        return deserialize(q);
    }
        
    
    private static TreeNode deserialize(Queue<String> q){
        if(q.isEmpty())return null;
        String peek=q.poll();
        if(peek.equals("null"))return null;
        TreeNode root=new TreeNode(Integer.parseInt(peek));
        root.left=deserialize(q);
        root.right=deserialize(q);
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));