# 206. Reverse Linked List

Reverse a singly linked list.

**Example:**

```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

**Follow up:**

A linked list can be reversed either iteratively or recursively. Could you implement both?



## Solutions (C)

### 1. Recursion

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverse(struct ListNode* pre, struct ListNode* cur){
    if(!cur)
        return pre;
    struct ListNode* next = cur -> next;
    cur -> next = pre;
    return reverse(cur, next);
}

struct ListNode* reverseList(struct ListNode* head){
    return reverse(NULL, head);
}


```



### 2. Iteration

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* reverseList(struct ListNode* head){
    struct ListNode *pre = NULL;
    struct ListNode *cur = head;
    while(cur){
        struct ListNode *next = cur -> next;
        cur -> next = pre;
        pre = cur;
        cur = next;
    }
    return pre;
}
```



## Solutions(C++)

### 1. Recursion

```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        return reverse(nullptr, head);
    }

private:
    ListNode* reverse(ListNode* pre, ListNode* cur) {
        if (cur == nullptr) {
            return pre;
        }
        ListNode* temp = cur -> next;
        cur -> next = pre;
        return reverse(cur, temp);
    }
};
```

### 2. Iteration

```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* cur = head;
        ListNode* pre = nullptr; 
        ListNode* temp = head;

        while (cur != nullptr) {
            temp = temp -> next;
            cur -> next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
};
```




## Solutions (Java)

### 1. Recursion

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
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }
    private ListNode reverse(ListNode pre, ListNode cur) {
        if(cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }
}
```



### 2.Iteration

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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
```



## Solutions (Python)

### 1. Recursion

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        newhead = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return newhead
```



### 2. Iteration

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        pre = None
        cur = head
        while(cur):
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        return pre
```

