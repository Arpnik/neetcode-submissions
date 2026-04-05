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

    private static void kthSmallestHelper(TreeNode root, int[] arr){
        
        if(Objects.isNull(root))
            return;

        if(Objects.nonNull(root.left)) {
            kthSmallestHelper(root.left, arr);
        }

        if(arr[0]<=0) {
            return;
        }

        if(arr[0]>1) {
            arr[0] = arr[0]-1;
        } else {
            arr[1] = root.val;
            arr[0] = 0;
            return;
        }

        if(Objects.nonNull(root.right)){
            kthSmallestHelper(root.right, arr);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[2];
        arr[0]=k;
        kthSmallestHelper(root, arr);
        return arr[1];
    }
}
