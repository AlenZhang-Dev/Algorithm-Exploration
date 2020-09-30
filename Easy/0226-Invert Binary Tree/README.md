# 226. Invert Binary Tree

Invert a binary tree.

**Example:**

Input:

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

Output:

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

**Trivia:**
This problem was inspired by [this original tweet](https://twitter.com/mxcl/status/608682016205344768) by [Max Howell](https://twitter.com/mxcl):

> Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.



### Defination:

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
```



## Solutions (Java)

### Pre-order(NLR)

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        //copy the RightNode.
        TreeNode RightNode = root.right;
        //exchange the right and left node.
        root.right = invertTree(root.left);
        root.left = invertTree(RightNode);

        return root; 
    }
}
```

### In-order(LNR)

```java
class Solution{
  	public TreeNode invertTree(TreeNode root){
      	if(root == null)
          	return null;
        invertTree(root.left);
      	TreeNode RightNode = root.right;
      	root.right = root.left;
      	root.left = RightNode;
      	invertTree(root.left);//indeed, it's the rightnode.
      
      	return root;
    }
}
```

### Post-order(LRN)

```java
class Solution{
  	public TreeNode invertTree(TreeNode root){
      	if(root == null)
          	return null;
        //find the far left node and far right node, and save the copy.
      	TreeNode LeftNode = invertTree(root.left);
      	TreeNode RightNode = invertTree(root.right);
      	root.right = LeftNode;
      	root.left = RightNode;
      
      	return root;
    }
}
```

### Level-order / BFS

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode RightTree = node.right;
            node.right = node.left;
            node.left = RightTree;
            if(node.left != null)   
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return root;
    }
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

