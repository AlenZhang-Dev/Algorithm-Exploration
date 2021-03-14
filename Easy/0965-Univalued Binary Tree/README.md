# 965. Univalued Binary Tree

A binary tree is *univalued* if every node in the tree has the same value.

Return `true` if and only if the given tree is univalued.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2018/12/28/unival_bst_1.png)

```
Input: [1,1,1,1,1,null,1]
Output: true
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2018/12/28/unival_bst_2.png)

```
Input: [2,2,2,5,2]
Output: false
```

 

**Note:**

1. The number of nodes in the given tree will be in the range `[1, 100]`.
2. Each node's value will be an integer in the range `[0, 99]`.



## Solutions (Java)


#### 1.Recursion

~~~java
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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
           return true;
        if (root.left != null && root.left.val != root.val)
            return false;
        if (root.right != null && root.right.val != root.val)
            return false;
        return isUnivalTree(root.right) && isUnivalTree(root.left);
    }
}
~~~



