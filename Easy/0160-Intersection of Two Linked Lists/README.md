# 160. Intersection of Two Linked Lists



1. Write a program to find the node at which the intersection of two singly linked lists begins.

   For example, the following two linked lists:

   [![img](https://assets.leetcode.com/uploads/2018/12/13/160_statement.png)](https://assets.leetcode.com/uploads/2018/12/13/160_statement.png)

   begin to intersect at node c1.

    

   **Example 1:**

   [![img](https://assets.leetcode.com/uploads/2020/06/29/160_example_1_1.png)](https://assets.leetcode.com/uploads/2020/06/29/160_example_1_1.png)

   ```
   Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
   Output: Reference of the node with value = 8
   Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
   ```

    

   **Example 2:**

   [![img](https://assets.leetcode.com/uploads/2020/06/29/160_example_2.png)](https://assets.leetcode.com/uploads/2020/06/29/160_example_2.png)

   ```
   Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
   Output: Reference of the node with value = 2
   Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
   ```

    

   **Example 3:**

   [![img](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)

   ```
   Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
   Output: null
   Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
   Explanation: The two lists do not intersect, so return null.
   ```

    

   **Notes:**

   - If the two linked lists have no intersection at all, return `null`.
   - The linked lists must retain their original structure after the function returns.
   - You may assume there are no cycles anywhere in the entire linked structure.
   - Each value on each linked list is in the range `[1, 10^9]`.
   - Your code should preferably run in O(n) time and use only O(1) memory.



## Solutions (Java)


#### 1.Set Collection

~~~java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //create a set collection
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }
}
~~~

#### 2. Stack 

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        ListNode peek = null;
    
        while(headA != null){
            stack1.push(headA);
            headA = headA.next;
        }
        while(headB != null){
            stack2.push(headB);
            headB = headB.next;
        }

        while(!stack1.empty() && !stack2.empty() && stack1.peek() == stack2.peek()){
            peek = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return peek;
    }
}
```

#### 3. Mathematic

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lengthA = ListLength(headA);
        int lengthB = ListLength(headB);

        while(lengthA != lengthB){
            if(lengthA > lengthB){
                headA = headA.next;
                lengthA--;
            }else{
                headB = headB.next;
                lengthB--;
            }
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;   
    }
    
    private int ListLength(ListNode list){
        int length = 0;
        while(list != null){
            length++;
            list = list.next;
        }
        return length;
    }
}
```

#### 4. Two Pointer

~~~java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;       

        ListNode A = headA;
        ListNode B = headB;

        while(A != B){
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
}
}
~~~



