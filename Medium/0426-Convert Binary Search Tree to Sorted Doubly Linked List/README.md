# 426. Convert Binary Search Tree to Sorted Doubly Linked List

Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:

 ![img](https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png)

We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list. ![img](https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png)

Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.

The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

 

## Solutions (Java)

### Inorder

Inorder will make binary search tree sorted.

```java
class Solution{
  	Node pre, head;
  	public Node treeToDoublyList(Node root){
      	if(root == null)
          	return null;
      	ConvertNode(root);
      	//link the head and tail.
      	head.left = pre;
      	pre.right = head;
      
      	return head;
    }
  	void  ConvertNode(Node Current){
      	//end condition
      	if(Current == null)
          	return;
      	ConvertNode(Current.left);
      	//Link to DoublyList
      	if(pre == null)
          	head = Current;//find the head; only use once;
      	else
      			pre.right = Current;
      	Current.left = pre;
      	pre = Current;
      	
      	ConvertNode(Current.right);
    }
}
```

**Use ArrayList to assist**

```java
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) 
          	return null;
        ArrayList<Node> nodes = new ArrayList<>();
        Inorder(nodes, root);
        Node head = nodes.get(0);
        Node pre = head;  
      	//link to list.
        for(int i = 1; i < nodes.size(); i++){
            Node node = nodes.get(i);
            pre.right = node;
            node.left = pre;
            pre = pre.right;
        }
        pre.right = head;
        head.left = pre;
        return head;
    }
    //save the ordered data into ArrayList
    public void Inorder(ArrayList<Node> nodes, Node root){
        if(root.left != null)
            Inorder(nodes, root.left);
        nodes.add(root);
        if(root.right != null)
            Inorder(nodes, root.right);
    }
}
```



## Solutions (C++)

```c++
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;

    Node() {}

    Node(int _val) {
        val = _val;
        left = NULL;
        right = NULL;
    }

    Node(int _val, Node* _left, Node* _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
public:
    Node* head;
    Node* pre;
    Node* treeToDoublyList(Node* root) {
        head = NULL;
        pre = NULL;
        if(root == NULL)
            return head;
        ConvertNode(root);
        head -> left = pre;
        pre -> right = head;

        return head;
    }

    void ConvertNode(Node* Current){
        if(Current == NULL)
            return;     
        ConvertNode(Current -> left);
        if(pre == NULL)
            head = Current;
        else
            pre -> right = Current;
        Current -> left = pre; 
        pre = Current;
        ConvertNode(Current -> right);
    }
};
```
