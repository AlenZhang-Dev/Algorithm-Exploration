# 111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

**Note:** A leaf is a node with no children. 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg)

```
Input: root = [3,9,20,null,null,15,7]
Output: 2
```

**Example 2:**

```
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5 
```

**Constraints:**

- The number of nodes in the tree is in the range `[0, 105]`.
- `-1000 <= Node.val <= 1000`



## Solutions (Java)

```Java
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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right != null)
            return 1 + minDepth(root.right);
        if(root.right == null && root.left != null)
            return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

// Different return
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        return (left != 0 && right != 0) ? 1 + Math.min(left, right) : 1 + left + right;
    }
}
```



## Solutions (C)

```c
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


int minDepth(struct TreeNode* root){
    if(root == NULL)
        return 0;

    int right = minDepth(root -> right);
    int left = minDepth(root -> left);

    return (right && left) ? 1 + fmin(right, left) : 1 + right + left;
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
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root == nullptr)
            return 0;
            
        int left = minDepth(root -> left);
        int right = minDepth(root -> right);

        return (left && right) ? 1 + min(left, right) : 1 + left + right;
    }
};
```



## Solutions (Python3)

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0 
        if not root.left and root.right: # 左子树空，右子树非空
            return 1 + self.minDepth(root.right)
        if not root.right and root.left:
            return 1 + self.minDepth(root.left)
        
        return 1 + min(self.minDepth(root.left), self.minDepth(root.right))
```



## Solutions(Kotlin)

```kotlin
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun minDepth(root: TreeNode?): Int {
        if(root == null)
            return 0
        
        val left = minDepth(root.left)
        var right = minDepth(root.right)

        return if(left != 0 && right != 0)  1 + Math.min(left, right) else 1 + right + left
    }
}
```



