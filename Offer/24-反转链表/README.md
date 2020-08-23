# 24. 反转链表

定义一个函数, 输入一个链表的头节点, 反转该链表并输出反转后的链表的头节点. 链表的节点定义如下:

```c++
struct ListNode{
		int m_nKey;
		ListNode* m_pNext;
}
```





## 题解

定义三个指针进行**局部反转**, 分别指向当前节点, 前序节点以及后序节点. 

同时定义一个反转后链表头指针(pReverseHead)用于返回.

```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* pReverseHead = nullptr;
        ListNode* pNode = head;
        ListNode* pPre = nullptr;

        while(pNode != nullptr){
            ListNode* pNext = pNode -> next;

            if(pNext == nullptr)
                pReverseHead = pNode;
            
            pNode -> next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }
};
```



为了抱着程序的鲁棒性, 我们需要以下几类测试用例对代码进行测试

* 输入的链表头指针为nullptr
* 输入链表只有一个节点
* 输入链表有多个节点

