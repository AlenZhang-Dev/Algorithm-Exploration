# 28. 对称二叉树

请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    		1
       / \
      2   2
     / \ / \
    3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    		1
       / \
      2   2
       \   \
       3    3
 示例 1：

```
输入：root = [1,2,2,3,4,4,3]
输出：true
```

示例 2：

```
输入：root = [1,2,2,null,3,null,3]
输出：false
```

限制：

`0 <= 节点个数 <= 1000`



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof



## 解析

求一颗树镜像的过程: 先前序遍历这棵树的每个节点, 如果遍历到的节点有子节点, 就交换它的两个子节点。当交换完所有非叶节点的左右子节点之后， 就得到了树的镜像。

根据二叉树的定义，树中任意对称节点L和R。

* 两个节点值相等。`L.val = R.val`
* L的左子节点和R的右子节点对称。`L.left.val = R.right.val`
* L的右子节点和R的左子节点对称。`L.right.val = R.left.val`

前序遍历顺序为：``根节点 -> 左节点 -> 右节点``

前序镜像遍历：`根节点 -> 右节点 -> 左节点`

通过一种全新的遍历方式，与前序遍历进行对比，如果两者从根节点开始遍历，到叶子结点都没有出现问题，便是对称二叉树。

**递归终止条件：**

* L和R同时来到叶子结点，表明在该叶子结点之上的节点与镜像均对称，返回true。`if(root1 == null && root2 == null) return true;`「注意，此处三个条件的顺序不能调换」
* L和R中只有一个来到了叶子结点，则不对称，返回false。`if(root1 == null || root2 == null) return false;`
* L和R的值不相等，便返回false。`if(root1.val != root2.val) return false;`

**递归返回：**

因为二叉树具有两个节点，需要同时比较左右子树之间的镜像值是否相等,中间通过`&&`连接。`return mirrorTree(root1.left, root2.right) && mirrorTree(root1.right, root2.left);`



## 题解

### Java

```java
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
        return isSymmetric(root, root);
    }
    boolean isSymmetric(TreeNode root1, TreeNode root2){
        //the ending conditions
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
```



### C++

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
    bool isSymmetric(TreeNode* root) {
        return isSymmetric(root, root);
    }

    bool isSymmetric(TreeNode* root1, TreeNode* root2){
        if(root1 == nullptr && root2 == nullptr)
            return true;

        if(root1 == nullptr || root2 == nullptr)
            return false;

        if(root1 -> val != root2 -> val)
            return false;

        return isSymmetric(root1 -> left, root2 -> right) && isSymmetric(root1 -> right, root2 -> left);
    }
};
```



