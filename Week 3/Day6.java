// Kth smallest element in a BST
// time complexity - O(H + K), where H is the height of BST.

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
    int k;
    TreeNode result = null;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return result.val;
    }
    public void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        k--;
        if(k == 0) {
            result = root;
        }
        if(result == null) {
            inorder(root.right);
        }
    }
}
