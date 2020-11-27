# 1022. Sum of Root To Leaf Binary Numbers

You are given the `root` of a binary tree where each node has a value `0` or `1`. Each root-to-leaf path represents a binary number starting with the most significant bit. For example, if the path is `0 -> 1 -> 1 -> 0 -> 1`, then this could represent `01101` in binary, which is `13`.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return *the sum of these numbers*. The answer is **guaranteed** to fit in a **32-bits** integer.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2019/04/04/sum-of-root-to-leaf-binary-numbers.png)

```
Input: root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
```

**Example 2:**

```
Input: root = [0]
Output: 0
```

**Example 3:**

```
Input: root = [1]
Output: 1
```

**Example 4:**

```
Input: root = [1,1]
Output: 3
```

 

**Constraints:**

- The number of nodes in the tree is in the range `[1, 1000]`.
- `Node.val` is `0` or `1`.



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

int sumRootToLeaf(struct TreeNode* root){
    return sumRootToLeafCount(root, 0);
}
int sumRootToLeafCount(struct TreeNode* root, int sum){
    if(root == NULL)
        return 0;
    sum = sum * 2 + root -> val;
    if(root -> right == NULL && root -> left == NULL)
        return sum;
    return sumRootToLeafCount(root -> left, sum) + sumRootToLeafCount(root -> right, sum);
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
    int sumRootToLeaf(TreeNode* root) {
        return sumRootToLeaf(root, 0);
    }
    int sumRootToLeaf(TreeNode* root, int sum){
        if(root == nullptr)
            return 0;
        sum = sum * 2 + root -> val;
        if(root -> left == nullptr && root -> right == nullptr)
            return sum;
        return sumRootToLeaf(root -> right, sum) + sumRootToLeaf(root -> left, sum);
    }
};
```



## Solutions (Java)

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
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }
    private int sumRootToLeaf(TreeNode root, int sum){
        if(root == null)
            return 0;
        sum = sum * 2 + root.val;
        if(root.left == null && root.right == null)
            return sum;
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }
}
```



## Solutions (Python)

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: TreeNode) -> int:
        return self.sumRootToLeafCount(root, 0)
    def sumRootToLeafCount(self, root : TreeNode, sum: int) -> int:
        if not root: return 0
        sum = sum * 2 + root.val
        if not root.left and not root.right:
            return sum
        return (self.sumRootToLeafCount(root.left, sum) + self.sumRootToLeafCount(root.right, sum))
```

