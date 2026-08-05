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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode root,TreeNode root1){
           if(root==null && root1==null) return true;
           if(root==null || root1==null) return false;
           return (root.val==root1.val)&&check(root.left,root1.right)&&check(root.right,root1.left);
    }
}