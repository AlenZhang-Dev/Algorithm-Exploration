# 23. Merge k Sorted Lists

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.

*Merge all the linked-lists into one sorted linked-list and return it.*

**Example 1:**

```
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
```

**Example 2:**

```
Input: lists = []
Output: []
```

**Example 3:**

```
Input: lists = [[]]
Output: []
```

**Constraints:**

- `k == lists.length`
- `0 <= k <= 10^4`
- `0 <= lists[i].length <= 500`
- `-10^4 <= lists[i][j] <= 10^4`
- `lists[i]` is sorted in **ascending order**.
- The sum of `lists[i].length` won't exceed `10^4`.



## Solutions (Java)

**K-pointer**

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int minPointer = 0;
        while(minPointer != -1){
            ListNode minNode = null;
            minPointer = -1;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] == null)
                    continue;
                if(minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minPointer = i;
                }
            }
            if(minPointer != -1){
                tail.next = minNode;
                tail = tail.next;
                lists[minPointer] = lists[minPointer].next;
            }
        }
        return head.next;
    }
}
```

**Priority Queue**

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode cur = new ListNode();
        ListNode res = cur;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                pq.offer(lists[i]);
        }
        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next != null)
                pq.offer(cur.next);
        }
        return res.next;
    }
}
```



**Merge by two**

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null; 
        for (ListNode list : lists) {
            res = merge2List(res, list);
        }
        return res;
    }

    private ListNode merge2List_recursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2List_recursion(l1.next, l2);
            return l1;
        }
        l2.next = merge2List_recursion(l1, l2.next);
        return l2;
    }

    private ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
```

