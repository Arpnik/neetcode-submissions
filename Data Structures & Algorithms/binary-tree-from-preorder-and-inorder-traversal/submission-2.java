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
    private TreeNode construct(int[] preorder, int[] inorder, int startIn, int endIn, int startPre, int endPre){
        if(startPre>endPre || startIn>endIn)
            return null;
        if(startPre==endPre || startIn==endIn){
            return new TreeNode(inorder[startIn]);
        }

        int i, num = preorder[startPre], newStartPre, newStartIn;
        TreeNode head = new TreeNode(num);
        for(i=startIn;i<=endIn;i++){
            if(inorder[i]==num)
                break;
        }
        int leftTreeCount = i-startIn;
        System.out.println(num+" "+leftTreeCount+" "+ i+ " "+ startIn +" "+startPre);
        head.left = construct(preorder, inorder, startIn, i-1, startPre+1, startPre+1+leftTreeCount);
        head.right = construct(preorder, inorder, i+1, endIn, startPre+1+leftTreeCount, endPre);
        return head;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length<=0 || inorder.length<=0){
            return null;
        }

        return construct(preorder, inorder, 0, inorder.length-1, 0, preorder.length-1);
    }
}
