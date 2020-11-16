# 83. Remove Duplicates from Sorted List 

Given a sorted linked list, delete all duplicates such that each element appear only *once*.

**Example 1:**

```
Input: 1->1->2
Output: 1->2
```

**Example 2:**

```
Input: 1->1->2->3->3
Output: 1->2->3
```



## Solutions (C++)

### 1. Recursion

~~~c++
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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head == nullptr || head -> next == nullptr)
            return head;
        head -> next = deleteDuplicates(head -> next);
        if(head -> val == head -> next -> val){
            ListNode *del = head;
            head = head -> next;
            delete del;
        }
        return head;
    }
};
~~~

### 2. Iteration

```c
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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *cur = head;
        while(cur && cur -> next){
            if(cur -> val == cur -> next -> val){
                ListNode *del = cur -> next;
                cur -> next = cur -> next -> next;
                delete del;
            }
            else{
                cur = cur -> next;
            }
        }
        return head;
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
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val)
            head = head.next;
        return head;
    }
}
```

### 2. Iteration

~~~java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else
                cur = cur.next;
        }
        return head;
    }
}
~~~




