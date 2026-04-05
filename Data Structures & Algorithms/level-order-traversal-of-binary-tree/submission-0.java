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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode centinel = new TreeNode(-1);
        queue.add(centinel);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if(current != centinel){
                if(Objects.nonNull(current))
                    level.add(current.val);
                if(Objects.nonNull(current) && Objects.nonNull(current.left))
                    queue.add(current.left);
                if(Objects.nonNull(current) && Objects.nonNull(current.right))
                    queue.add(current.right);
            } else {
                System.out.println(level);
                if(level.size()==0)
                    break;
                result.add(level);
                level = new LinkedList<>();
                queue.add(centinel);
            }

        }
        return result;
    }
}
