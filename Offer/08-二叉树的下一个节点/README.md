# 8. 二叉树的下一个节点

给定一颗二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。



## 解析

根据特定例子分析各种情况。当前节点分为多种情况。「左子树叶子，带右子树的结点，子树右节点」

画出二叉树样例进行分析。

如果节点存在右子树，那么下一个节点就是右子树中最左节点。

如果节点没有右子树：1. 节点为其父节点的左子节点，那么父节点就是下一个节点。	2.节点为其父节点的右子节点，那么需要沿着父指针一直向上遍历，知道找到某个节点是其父节点的左子节点，那么这个节点的父节点便是下一个需要寻找的点。

## 题解

### C++

```c++
/*
struct TreeLinkNode {
    int val;
    struct TreeLinkNode *left;
    struct TreeLinkNode *right;
    struct TreeLinkNode *next;
    TreeLinkNode(int x) :val(x), left(NULL), right(NULL), next(NULL) {

    }
};
*/
class Solution {
public:
    TreeLinkNode* GetNext(TreeLinkNode* pNode)
    {
        if(pNode == nullptr) return nullptr;

        TreeLinkNode* pNext = nullptr;
        if(pNode->right != nullptr){
            TreeLinkNode* pRight = pNode->right;
            while(pRight->left != nullptr)
                pRight = pRight->left;

            pNext = pRight;
        }
        else if(pNode->next != nullptr){
            TreeLinkNode* pCurrent = pNode;
            TreeLinkNode* pParent = pNode->next;
            while(pParent != nullptr && pCurrent == pParent->right){
                pCurrent = pParent;
                pParent = pParent->next;
            }

            pNext = pParent;
        }

        return pNext;
    }
};
```

