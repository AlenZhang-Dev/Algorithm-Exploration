# 19. Remove Nth Node From End of List
- Given the `head` of a linked list, remove the `nth` node from the end of the list and return its head.

   

  **Example 1:**

  ![img](https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg)

  ```
  Input: head = [1,2,3,4,5], n = 2
  Output: [1,2,3,5]
  ```

  **Example 2:**

  ```
  Input: head = [1], n = 1
  Output: []
  ```

  **Example 3:**

  ```
  Input: head = [1,2], n = 1
  Output: [1]
  ```

   

  **Constraints:**

  - The number of nodes in the list is `sz`.
  - `1 <= sz <= 30`
  - `0 <= Node.val <= 100`
  - `1 <= n <= sz`
## Solutions (C++)

### Two-Pointers - without dummyHead

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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *fast = head, *slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast -> next;
        }
        if(!fast)
            return head -> next;
        while (fast -> next) {
            fast = fast -> next;
            slow = slow -> next;
        }
        slow -> next = slow -> next -> next;
        return head;
    }
};
```

### Two Pointer - with dummyHead

```c++
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *fast = head, *slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast -> next;
        }
        if(!fast)
            return head -> next;
        while (fast -> next) {
            fast = fast -> next;
            slow = slow -> next;
        }
        slow -> next = slow -> next -> next;
        return head;
    }
};
```

## Solutions (Java)

### Two-Pointers-without DummyHead

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
```

### Two-Pointers-with DummyHead

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
```





