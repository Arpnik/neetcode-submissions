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

    private static int isBalancedHelper(TreeNode root, boolean[] isBalanced){
        if(root==null)
            return 0;

        int leftHeight = isBalancedHelper(root.left, isBalanced);
        int rightHeight = isBalancedHelper(root.right, isBalanced);

        if(leftHeight-rightHeight > 1 || leftHeight - rightHeight < -1){
            isBalanced[0] = false;
        }

        return ((leftHeight<rightHeight)?rightHeight:leftHeight)+1;
    }

    public boolean isBalanced(TreeNode root) {
        boolean[] isBalanced = new boolean[1];
        isBalanced[0] = true;
        isBalancedHelper(root, isBalanced);
        return isBalanced[0];
    }
}
