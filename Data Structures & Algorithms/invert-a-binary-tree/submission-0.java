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
    public TreeNode invertTree(TreeNode root) {
        if(Objects.isNull(root))
            return root;
        
        TreeNode leftTreeHead = invertTree(root.left);
        TreeNode rightTreeHead = invertTree(root.right);
        root.left = rightTreeHead;
        root.right = leftTreeHead;
        return root;
    }
}
