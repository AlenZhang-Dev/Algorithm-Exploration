# 27. 二叉树的镜像

请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     			4
        /   \
      2     7
     / \   / \
    1   3 6   9

镜像输出：

     			4
        /   \
      7     2
     / \   / \
    9   6 3   1
示例 1：

```
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
```

限制：

```
0 <= 节点个数 <= 1000
```



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof



## 解析

求一颗树镜像的过程: 先前序遍历这棵树的每个节点, 如果遍历到的节点有子节点, 就交换它的两个子节点。当交换完所有非叶节点的左右子节点之后， 就得到了树的镜像。



## 题解

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
    TreeNode* mirrorTree(TreeNode* root) {
        if(root == nullptr)
            return nullptr;
        if(root -> left == nullptr && root -> right == nullptr)
            return root;
        
        TreeNode *pTemp = root -> left;
        root -> left = root -> right;
        root -> right = pTemp;
                
        if(root -> left)
            mirrorTree(root -> left);

        if(root -> right)
            mirrorTree(root -> right);
        
        return root;
    }
};
```



