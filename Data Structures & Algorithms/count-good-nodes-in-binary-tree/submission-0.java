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
    private static int getGoodNodesHelper(TreeNode root, int max){
        if(root==null)
            return 0;
        int countGoodNodes = 0;
        if(root.val>=max){
            countGoodNodes += 1;
            max = root.val;
        }

        countGoodNodes += getGoodNodesHelper(root.left, max);
        countGoodNodes += getGoodNodesHelper(root.right, max);
        return countGoodNodes;
    }
    public int goodNodes(TreeNode root) {
        return getGoodNodesHelper(root, Integer.MIN_VALUE);
    }
}
