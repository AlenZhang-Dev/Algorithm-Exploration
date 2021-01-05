# 101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following `[1,2,2,null,3,null,3]` is not:

```
    1
   / \
  2   2
   \   \
   3    3
```

**Follow up:** Solve it both recursively and iteratively.



## Solutions (Java)

**Recursively：**

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

**Iteration：**

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
```



## Solutions (C++)

**Recursively：**

```c
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    int  p2 = n - 1;
    for(int p3 = m + n - 1, p1 = m - 1; p1 >= 0 && p2 >= 0; p3--){
        bool judge = (nums2[p2] >= nums1[p1]) ? true : false; 
        if(judge){
            nums1[p3] = nums2[p2];
            p2--;
        }
        else{
            nums1[p3] = nums1[p1];
            p1--;
        }
    }
    //special case
    while(p2 >= 0)
    {
        nums1[p2] = nums2[p2];
        p2--;
    }
}
```

**Iteration:**

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
        if(root == nullptr){
            return true;
        }
        queue<TreeNode*> queue;
        queue.push(root -> left);
        queue.push(root -> right);

        while(!queue.empty()){
            TreeNode* Node1 = queue.front();
            queue.pop();
            TreeNode* Node2 = queue.front();
            queue.pop();
            if(Node1 == nullptr && Node2 == nullptr){
                continue;
            }
            if(Node1 == nullptr || Node2 == nullptr || (Node1 -> val != Node2 -> val)){
                return false;
            }
            queue.push(Node1 -> left);
            queue.push(Node2 -> right);
            queue.push(Node1 -> right);
            queue.push(Node2 -> left);
        }
        return true;
    }
};
```



## Solutions (Python)

**Recursive**

```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        def isSymmetric(root1, root2):
            if not root1 and not root2:
                return True
            if root1 and root2 and root1.val == root2.val:
                return isSymmetric(root1.left, root2.right) and isSymmetric(root1.right, root2.left)
                return False
        return isSymmetric(root.left, root.right)
```

