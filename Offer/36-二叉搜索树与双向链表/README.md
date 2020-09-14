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

中序遍历。

## 题解

```java
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        ArrayList<Node> nodes = new ArrayList<>();
        Inorder(nodes, root);
        Node head = nodes.get(0);
        Node pre = head;  //记录上一个节点
        for(int i = 1;i < nodes.size();i++){
            Node node = nodes.get(i);
            pre.right = node;
            node.left = pre;
            pre = pre.right;
        }
        pre.right = head;
        head.left = pre;
        return head;
    }
    
    public void Inorder(ArrayList<Node> nodes, Node root){
        if(root.left != null)
            Inorder(nodes, root.left);
        nodes.add(root);
        if(root.right != null)
            Inorder(nodes, root.right);
    }
}
```



