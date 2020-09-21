# 105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

**Note:**
You may assume that duplicates do not exist in the tree.

For example, given

```
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
```

Return the following binary tree:

```
    3
   / \
  9  20
    /  \
   15   7
```





## Solutions (Java)

```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if(length == 0) 
            return null;
        //通过前序遍历，记录根节点。
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        //找根节点在中序遍历中的位置
        int offset = 0;
        for(int i = 0; i < length; i++){
            if(inorder[i] == rootValue){
                offset = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + offset), Arrays.copyOfRange(inorder, 0, offset));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + offset, length), Arrays.copyOfRange(inorder, offset + 1, length));

        return root;
    }
}
```



## Solutions (C++)

```c++
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0)
            return nullptr;
        if(inorder.size() != preorder.size())
            return nullptr;
        return buildCore(preorder, inorder, 0, 0,inorder.size() - 1);
    }

    TreeNode* buildCore(vector<int>& preorder, vector<int>& inorder, int root, int start, int end){
        if(start > end)
            return NULL;
        TreeNode *tree = new TreeNode(preorder[root]);//建立根节点
        int i = start;
        while(i < end && preorder[root] != inorder[i])
            i++;
        tree->left = buildCore(preorder, inorder, root + 1, start, i - 1);
        tree->right = buildCore(preorder, inorder, root + 1 + i - start, i + 1, end);
        return tree;
    }
};
```





