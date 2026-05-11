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
    private static int calculateDiameter(TreeNode root, int[] result){
        if(root == null)
            return 0;
        
        int leftHeight = calculateDiameter(root.left, result);
        int rightHeight = calculateDiameter(root.right, result);
        int current = leftHeight + rightHeight;
        result[0] = (result[0]<current)?current:result[0];
        return ((leftHeight<rightHeight)?rightHeight:leftHeight)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int[] result = new int[1];
        calculateDiameter(root, result);
        return result[0];
    }
}
