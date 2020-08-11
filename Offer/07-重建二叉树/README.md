# 07. 重建二叉树

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

```
    3
   / \
  9  20
    /  \
   15   7
```


限制：

0 <= 节点个数 <= 5000



## 1.递归

前序遍历找到每颗子树的根节点。然后中序遍历找到根节点位置，可知左右子树的长度和结束【开始】位置。并分别构建左右子树。

```java
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

















考点：

考察应聘者对二叉树前序遍历和中序遍历的理解程度。只有对二叉树的不同遍历算法有深刻的了解，应聘者才有可能在遍历序列中划分出左、右子树对应的子序列。

考察对问题分解的能力，把构建二叉树的大问题分解为构建左右子树两个小问题。