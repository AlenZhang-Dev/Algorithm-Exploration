# 26. 树的子结构

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     			3
    		/ \
       4   5
      / \
     1   2

给定的树 B：

```
   4 
  /
 1
```


返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：

```
输入：A = [1,2,3], B = [3,1]
输出：false
```


示例 2：

```
输入：A = [3,4,5,1,2], B = [4,1]
输出：true
```

限制：

`0 <= 节点个数 <= 10000`

## 解析

对题目进行相关的拆解，分两步走。

首先需要找到A中是否有子节点为树B的根节点，如果有，则进行下一步探索。

第二步则是如何判断A的子树中包含树B，此处需要分多种情况讨论。

## 题解

```c++
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //if there is the same root point
        if(A == null || B == null)
            return false;

        return DoesTreeAHavaTreeB(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    
    public boolean DoesTreeAHavaTreeB(TreeNode A, TreeNode B){
        if(B == null)
            return true;
        if(A == null)
            return false;
        
        return A.val == B.val && DoesTreeAHavaTreeB(A.left, B.left) && DoesTreeAHavaTreeB(A.right, B.right);
    }
}

```



