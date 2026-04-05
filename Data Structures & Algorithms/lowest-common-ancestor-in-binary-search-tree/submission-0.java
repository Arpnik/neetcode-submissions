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
// low root high
class Solution {

    private TreeNode lcaHelper(TreeNode root, TreeNode low, TreeNode high){

        if(root.val >= low.val){
            if(root.val<=high.val)
                return root;
            
            return lcaHelper(root.left, low, high);
        }

        return lcaHelper(root.right, low, high);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(Objects.isNull(root)|| Objects.isNull(p) || Objects.isNull(q))
            return root;

        if(p.val > q.val)
            return lcaHelper(root, q, p);
        
        return lcaHelper(root, p, q);
    }
}
