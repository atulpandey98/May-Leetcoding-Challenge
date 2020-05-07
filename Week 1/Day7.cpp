// Cousins in binary tree
// Do a preorder dfs of the binary tree.
// store the depth of x and y and their parent node.
// if the depth is same and both a different parent node return true, else retun false.
// time compleity = O(n) n = number of nodes.

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* xParent;
    TreeNode* yParent;
    int xDepth;
    int yDepth;
    
    bool isCousins(TreeNode* root, int x, int y) {
        dfs(root, x, y, 0);        
        if(xDepth == yDepth && xParent != yParent) {
            return true;
        }
        return false;
    }
    
    void dfs(TreeNode* root, int x, int y, int h) {        
        if(root == nullptr) {
            return;
        }
        if(root->left != nullptr && root->left->val == x) {
            xDepth = h + 1;
            xParent = root;
        }
        else if(root->right != nullptr && root->right->val == x) {
            xDepth = h + 1;
            xParent = root;
        }
        if(root->right != nullptr && root->right->val == y) {
            yDepth = h + 1;
            yParent = root;
        }
        else if(root->left != nullptr && root->left->val == y) {
            yDepth = h + 1;
            yParent = root;
        }
        dfs(root->left, x, y, h + 1);
        dfs(root->right, x, y, h + 1);
    }
};
