# 22. 链表中倒数第k个节点

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

示例：

```
给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
```


链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof

## 题解

重点是需要知道链表长度, 但并未给出, 可以通过遍历方式取得, 但是提升了时间复杂度.

使用快慢指针方法提升效率.

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
    ListNode* getKthFromEnd(ListNode* head, int k) {
        ListNode *pFast = head;
        ListNode *pSlow = nullptr;

        for(unsigned int i = 0; i < k - 1; i++){
            pFast = pFast -> next;
        }

        pSlow = head;

        while(pFast -> next != nullptr){
            pFast = pFast -> next;
            pSlow = pSlow -> next;
        }

        return pSlow;
    }
};
```



以上代码在流程上实现了快慢指针解决问题的方式, 但考虑到程序的鲁棒性, 以下三种情况可以导致程序崩溃.

1. 输入head为空指针. 访问空指针内存, 会导致程序崩溃.
2. 链表的节点总数少于k.
3. 输入参数k为0. 由于k是一个无符号整数, 在for循环中 k - 1 得到无符号的 `0xFFFFFFFF`. for循环执行次数大大超出预期, 会导致程序崩溃.



以下为解决后代码

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
    ListNode* getKthFromEnd(ListNode* head, int k) {
        if(head == nullptr || k == 0)
            return nullptr;

        ListNode *pFast = head;
        ListNode *pSlow = nullptr;

        for(unsigned int i = 0; i < k - 1; i++){
            if(pFast -> next == nullptr)
                return nullptr;
            pFast = pFast -> next;
        }

        pSlow = head;

        while(pFast -> next != nullptr){
            pFast = pFast -> next;
            pSlow = pSlow -> next;
        }

        return pSlow;
    }
};
```

