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

    public boolean isSubTreeHelper(TreeNode root, TreeNode subRoot, boolean isPreviousMatch) {
    if(Objects.isNull(root) && Objects.isNull(subRoot))
            return true;
        
        if(Objects.isNull(subRoot) || Objects.isNull(root))
            return false;

        if(isPreviousMatch && root.val != subRoot.val)
            return false;

        // System.out.println(root.val);
        if(root.val == subRoot.val){
            boolean leftCondition = isSubTreeHelper(root.left, subRoot.left, true);
            boolean rightCondition = isSubTreeHelper(root.right, subRoot.right, true);
            if(leftCondition & rightCondition)
                return true;
        } 

        return isSubTreeHelper(root.left, subRoot, false) || isSubTreeHelper(root.right, subRoot, false);

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubTreeHelper(root, subRoot, false);
    }
}
