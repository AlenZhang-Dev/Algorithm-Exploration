# 117. Populating Next Right Pointers in Each Node II

Given a binary tree

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.

Initially, all next pointers are set to `NULL`.

 

**Follow up:**

- You may only use constant extra space.
- Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2019/02/15/117_sample.png)

```
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
```



**Constraints:**

- The number of nodes in the given tree is less than `6000`.
- `-100 <= node.val <= 100`



## Solutions (C++)

```C++
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        queue<Node*> queue;
        if(root == nullptr)
            return nullptr;
        queue.push(root);
        while(!queue.empty()){
            int size = queue.size();
            Node* node = nullptr;
            Node* pre = nullptr;
            for(int i = 0; i < size; i++){
                if(i == 0){
                    node = queue.front();
                    pre = node;
                }
                else{
                    node = queue.front();
                    pre -> next = node;
                }
                if(node -> left)
                    queue.push(node -> left);
                if(node -> right)
                    queue.push(node -> right);
                queue.pop();
                pre = node;
            }
            node -> next = nullptr;
        }
        return root;
    }
};
```



## Solutions (Java)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null)
            return null;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node node = null;
            Node pre = null;
            for(int i = 0; i < size; i++){
                if(i == 0){
                    node = queue.poll();
                    pre = node;
                }else{
                    node = queue.poll();
                    pre.next = node;
                }
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                pre = node;
            }
            node.next = null;  
        }
        return root;
    }
}
```
