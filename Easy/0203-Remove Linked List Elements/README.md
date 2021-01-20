# 203. Remove Linked List Elements

Remove all elements from a linked list of integers that have value **val**.

**Example:**

```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```



## Solutions (Java)

### 1. Iterative [Sentinel]

```c
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
        if(head == null) 
            return head;
        ListNode pre = head;
        while(pre.next != null) {
            if(pre.next.val == val)
                pre.next = pre.next.next;
            else
                pre = pre.next;
        }
        return head;
    }
}
```

### 2. Recursion

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
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

struct ListNode* removeElements(struct ListNode* head, int val){
    while(head && head -> val == val)
        head = head -> next;
    if(!head)
        return head;
    struct ListNode *pre = head;
    while(pre -> next){
        if(pre -> next -> val == val)
            pre -> next = pre -> next -> next;
        else
            pre = pre -> next;
    }
    return head;
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

struct ListNode* removeElements(struct ListNode* head, int val){
    if(!head)
        return head;
    head -> next = removeElements(head -> next, val);
    return head -> val == val ? head -> next : head;
}
```

