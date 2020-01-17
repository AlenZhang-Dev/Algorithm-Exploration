# 21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```



## Solutions (C)



### 1. Iteration

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
        if(l1 == NULL)
            return l2;
        if(l2 == NULL)
            return l1;  
        struct ListNode* head = (struct ListNode*)malloc(sizeof (struct ListNode));
        struct ListNode* pre ;
        pre = head;
        while(l1 && l2){
            if(l1->val <= l2->val){
                pre->next = l1;
                l1 = l1->next;
            }
            else{
                pre->next =l2;
                l2 = l2->next;
            }
            pre = pre->next;
        }
        if(l1 == NULL)
            pre->next = l2;
        else
            pre->next = l1;
        return head->next;
}
```



### 2. Recursion

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if(l1 == NULL)
        return l2;
    if(l2 == NULL)
        return l1;
    if(l1->val < l2->val){
        l1->next = mergeTwoLists(l1->next, l2);
        return l1;
        }
    else{
        l2->next = mergeTwoLists(l1, l2->next);
        return l2;
    }
}
```

