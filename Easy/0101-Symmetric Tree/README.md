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



