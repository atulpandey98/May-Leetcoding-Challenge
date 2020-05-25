// Construct Binary Search Tree from Preorder Traversal
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
 
// Time Complexity - O(n^2)
class Solution {
    int[] arr;
    public TreeNode bstFromPreorder(int[] preorder) {
        arr = preorder;
        int n = preorder.length;
        int index = 0;
        TreeNode root = new TreeNode(preorder[index++]);
        while(index < n) {
            preorder(root, index);
            index++;
        }
        return root;
    }
    void preorder(TreeNode root, int index) {
        if(root.val > arr[index]) {
            if(root.left != null) {
                preorder(root.left, index);
            }
            else {
                root.left = new TreeNode(arr[index]);
            }
        }
        else {
            if(root.right != null) {
                preorder(root.right , index);
            }
            else {
                root.right = new TreeNode(arr[index]);
            }
        }
    }
}
 
// Time Complexity - O(n)
class Solution {
    int[] arr;
    int index = 0;
    int n;
    public TreeNode bstFromPreorder(int[] preorder) {
        arr = preorder;
        n = arr.length;
        int upperBound = Integer.MAX_VALUE;        
        return preorder(upperBound);
    }
    TreeNode preorder(int upperBound) {
        if(index == n || arr[index] > upperBound) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index++]);
        root.left = preorder(root.val);
        root.right = preorder(upperBound);
        return root;
    }
}

