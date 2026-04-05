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
    private int maxSumHelper(TreeNode root, int[] result){
        if(Objects.isNull(root))
            return Integer.MIN_VALUE;

        if(Objects.isNull(root.left) && Objects.isNull(root.right)){
            System.out.println(root.val+" "+result[0]);
            if(result[0]<root.val)
                result[0] = root.val;
            return root.val;
        }
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int maxChainSum = root.val;

        if(Objects.nonNull(root.left)){
            leftSum = maxSumHelper(root.left, result);
            if(maxChainSum < leftSum+root.val)
                maxChainSum = leftSum+root.val;
        }
        
        if(Objects.nonNull(root.right)){
            rightSum = maxSumHelper(root.right, result);
            if(maxChainSum < rightSum+root.val)
                maxChainSum = rightSum+root.val;
        }

        System.out.println(root.val+" "+leftSum+" "+rightSum);

    
        if(Objects.nonNull(root.left) && Objects.nonNull(root.right)){
            if(maxChainSum < leftSum+rightSum+root.val)
                maxChainSum = leftSum+rightSum+root.val;
        }
        
        if(result[0]<maxChainSum)
            result[0] = maxChainSum;

        int max = (leftSum > rightSum)? leftSum: rightSum;
        // System.out.println((max+root.val)>root.val?(max+root.val):root.val);
        return (max+root.val)>root.val?(max+root.val):root.val;
    }

    public int maxPathSum(TreeNode root) {
        if(Objects.isNull(root))
            return 0;

        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        maxSumHelper(root, result);

        return result[0];
    }
}
