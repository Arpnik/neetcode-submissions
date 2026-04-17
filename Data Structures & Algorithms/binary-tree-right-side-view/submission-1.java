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
    private static void helper(TreeNode root, List<Integer> result, int currentDepth, int[] maxDepth){
        if(root==null)
            return;

        if(maxDepth[0]<currentDepth){
            result.add(root.val);
            maxDepth[0]=currentDepth;
        }

        helper(root.right, result, currentDepth+1, maxDepth);
        helper(root.left, result, currentDepth+1, maxDepth);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<Integer>();
        
        List<Integer> result = new ArrayList<Integer>();
        int[] maxDepth = new int[1];
        maxDepth[0]=-1;
        helper(root, result, 0, maxDepth);
        return result;
    }
}
