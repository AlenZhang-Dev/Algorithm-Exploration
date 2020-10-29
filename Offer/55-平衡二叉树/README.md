# 55. 平衡二叉树

输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。例如：

给定二叉树 `[3,9,20,null,null,15,7]`，

```
    3
   / \
  9  20
    /  \
   15   7
```

返回 `true` 。

示例 2:

给定二叉树``[1,2,2,3,3,null,null,4,4]``

           1
          / \
         2   2
        / \
       3   3
      / \
     4   4

返回` false `。

**限制：**

- `1 <= 树的结点个数 <= 10000`

## 解析



## 题解

### Java

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
    public boolean isBalanced(TreeNode root) {
        if(root == null)    
            return true;
            
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);
        int diff = nLeft - nRight;
        if(diff > 1 || diff < -1)
            return false;
        
        return isBalanced(root.right) && isBalanced(root.left);
    }

    int TreeDepth(TreeNode root){
        if(root == null)
            return 0;
        
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);

        return (nLeft > nRight) ? ++nLeft : ++nRight;
    }
}
```

改进：只遍历一次。

```java
class Solution {
    int depth = 0, nLeft = 0, nRight = 0;
    public boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;

        int nLeft = dfs(root.left);
        if(nLeft == -1)
            return -1;
        int nRight = dfs(root.right);
        if(nRight == -1)
            return -1;
        return Math.abs(nLeft - nRight) <= 1 ? Math.max(nRight, nLeft) + 1 : -1;
    } 
}
```



