# 589. N-ary Tree Preorder Traversal

Given an n-ary tree, return the *preorder* traversal of its nodes' values.

*Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).*

 

**Follow up:**

Recursive solution is trivial, could you do it iteratively?

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

```
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png)

```
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
```

 

**Constraints:**

- The height of the n-ary tree is less than or equal to `1000`
- The total number of nodes is between `[0, 10^4]`



## Solutions (Java)

### 1. Recursion

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root == null)
            return res;
        res.add(root.val);
        for(Node child : root.children)
            preorder(child);
        
        return res;
    }
}
```

### 2. Iterative

```java
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if(root == null)
            return res;
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            for(int i = node.children.size() - 1; i >= 0; i--){
                stack.add(node.children.get(i));
            }
        }
        return res;
    }
}
```



## Solutions (Python)

### 1. Recursion

```python
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        def dfs(root):
            if not root:
                return
            res.append(root.val)
            for child in root.children:   
                dfs(child)
           
        res = []
        dfs(root)
        return res
```



### 2. Iterative

```python
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        s = [root] # s.append(root)
        res = []
        while s:
            node = s.pop()
            res.append(node.val)
            # for child in node.children[::-1]:
            #     s.append(child)
            s.extend(node.children[::-1])
        return res

```

