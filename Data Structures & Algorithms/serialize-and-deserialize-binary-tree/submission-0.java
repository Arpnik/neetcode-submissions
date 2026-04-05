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

public class Codec {

    private static char seperator = '#';
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(Objects.isNull(root))
            return "";
        
        String leftChild = serialize(root.left);
        String rightChild = serialize(root.right);
        return String.valueOf(root.val)+"#"+String.valueOf(leftChild.length())+
        "#"+leftChild+"#"+String.valueOf(rightChild.length())+"#"+rightChild;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if(data.isEmpty())
            return null;
        
        //main node 
        int start = 0, end=0;
        for(;end<data.length();end++){
            if(data.charAt(end)=='#')
                break;
        }
        TreeNode head = new TreeNode(Integer.parseInt(data.substring(start, end)));
        
        //left child
        start = end+1;
        end = end+1;
        for(;end<data.length();end++){
            if(data.charAt(end)=='#')
                break;
        }
        int leftChildLength=0;
        if(start!=end){
            leftChildLength = Integer.parseInt(data.substring(start, end));
        }
        head.left = deserialize(data.substring(end+1, end+1+leftChildLength));
        
        //right child
        start = end+2+leftChildLength;
        end = end+2+leftChildLength;
        System.out.println("right start:"+start);
        for(;end<data.length();end++){
            if(data.charAt(end)=='#')
                break;
        }
        int rightChildLength = 0;
        if(start!=end){
            rightChildLength = Integer.parseInt(data.substring(start, end));
        }
        head.right = deserialize(data.substring(end+1, end+1+rightChildLength));

        return head;

    }
}
