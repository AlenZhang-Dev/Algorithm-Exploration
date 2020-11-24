# 104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Note:** A leaf is a node with no children.

**Example:**

Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its depth = 3.

## Solutions (C)

**DFS**

```c
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


int maxDepth(struct TreeNode* root){
    if(root == NULL)
        return 0;

    int left = maxDepth(root ->left);
    int right = maxDepth(root -> right);

    return fmax(left, right) + 1;
}
```

**BFS**

```c
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct QueueNode{
    struct TreeNode *node;
    struct TreeNode *next;
};

void inQueue(struct QueueNode **node, struct QueueNode *newNode){
    (*node) = (struct QueueNode *)malloc(sizeof(struct QueueNode));
    (*node) -> node = newNode;
    (*node) -> next = NULL;
}

int maxDepth(struct TreeNode* root){
    if(root == NULL)
        return 0;
    struct QueueNode *head, *tail;
    inQueue(&head, root);
    tail = head;
    int depth = 0, size = 1, countPerLayer = 0;
    while(head != NULL){
        countPerLayer = 0;
        while(size != 0){
            if(head -> node -> left != NULL){
                inQueue(&tail -> next, head -> node -> left);
                tail = tail -> next;
                countPerLayer++;
            }
            if(head -> node -> right != NULL){
                inQueue(&tail -> next, head -> node -> right);
                tail = tail -> next;
                countPerLayer++;
            }
            head = head -> next;
            size--;
        }
        size += countPerLayer;
        depth++;
    }
    return depth;
}
```



## Solutions (Java)

**DFS**

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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}
```

**BFS**

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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            while(length != 0){
                TreeNode temp = queue.poll();
                length--;
                if(temp.left != null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
            }
            depth++;
        }
        return depth;
    }
}
~~~



## Solutions (C++)

**DFS**

```c
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
    int maxDepth(TreeNode* root) {
        if(root == NULL)
            return 0;
        
        int left = maxDepth(root -> left);
        int right = maxDepth(root -> right);

        return max(left, right) + 1;
    }
};
```

**BFS**

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
    int maxDepth(TreeNode* root) {
        if(root == NULL)
            return 0;
        queue<TreeNode*> queue; 
        queue.push(root);
        int depth = 0;
        while(!queue.empty()){
            int length = queue.size();
            while(length != 0){
                TreeNode *node = queue.front();
                queue.pop();
                length--;
                if(node -> left != NULL)
                    queue.push(node -> left);
                if(node -> right != NULL)
                    queue.push(node -> right);
            }
            depth++;
        }
        return depth;
    }
};
```



## Solutions (Python)

**DFS**

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if root == None: return 0
        
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)

        return max(left, right) + 1

```

**BFS**

```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if root is None: return 0

        queue = deque([root])
        depth = 0
        while queue:
            length = len(queue)
            while length:
                node = queue.popleft()
                length -= 1
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            depth += 1
        return depth

```



## Solutions (Kotlin)

**DFS**

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
    fun maxDepth(root: TreeNode?): Int {
        if(null == root)
            return 0
        val queue: Queue<TreeNode> = LinkedList()
        var depth = 0
        queue.offer(root)
        while(queue.isNotEmpty()){
            for(index in 0 until queue.size){
                val node = queue.poll()
                if(null != node.left)
                    queue.offer(node.left)
                if(null != node.right)
                    queue.offer(node.right)
            }
            depth++
        }
        return depth
    }
}
```

**BFS**

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
    fun maxDepth(root: TreeNode?): Int {
        if(null == root)
            return 0
        
        var left = maxDepth(root.left)
        var right = maxDepth(root.right)

        return Math.max(left, right) + 1
    }
}
```

