# 36. 二叉树搜索树与双向链表 

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

为了让您更好地理解问题，以下面的二叉搜索树为例：

![img](https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png) 

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

![img](https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png) 

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。


链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



## 解析

思路：二叉搜索树本身是一个排序树，通过中序遍历可以得到一个顺序结构；题目要求转换成有序的双向递增链表，根据性质可以达成目的。

**如何构成排序的链表？**

对二叉搜索树进行中序遍历，即为递增序列。

```java
void inOrder(TreeNode root){
  	if(root == null)
      	return;
  	inOrder(root.left);//left.
  	System.out.println(root.val);//current is root.
  	inOrder(root.right);//right.
}
```

**如何在遍历过程中形成双向链表？**

记录当前节点(current)的前序节点(pre)，前序节点的右链链接后续节点，后续节点的左链链接前序节点。

`pre.right = current; `

`current.left = pre;`

**如何构成循环链表？**

需要保存链表的首节点和尾节点，在链表完成基本操作之后，将两者进行链接。

`head.left = tail;`

`tail.right = head;`

**综上**，为一个中序遍历树的递归问题，递归函数总体流程如下：

1. 判断终止条件: `current == null`， 节点为空表示越过叶节点，直接返回。
2. 递归左子树。
3. 找到首节点并记录。
   1. 如果pre为空，即为首节点(head)，记录。
4. 构建双向链表。
   1. 如果pre不为空，构造双向节点。`pre.right = current; current.left = pre;`
   2. 更新节点。`pre = cur`，将当前节点标记，继续向后访问。
5. 递归右子树。

## 题解

### Solutions(Java)

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



### Solutions(C++)

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



