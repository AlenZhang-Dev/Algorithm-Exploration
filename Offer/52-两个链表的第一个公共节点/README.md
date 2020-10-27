# 52. 两个链表的第一个公共节点

输入两个链表，找出它们的第一个公共节点。

如下面的两个链表：

[![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png)

在节点 c1 开始相交。

**示例 1：**

[![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_1.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)

```
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
```

示例 2：

[![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_2.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png)

```
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
```

示例 3：

[![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)

```
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。
```


注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。



## 解析

本题的核心是通过各种方式剔除两链表长度之间的差异。



## 题解

### Java

方法一：使用集合set

> 将一段链表放入Set中，然后在set中查找另一段链表的数据，返回第一个存在的数据。
>
> 效率很低。

```java
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
```

方法二：使用Stack进行解决

> 鉴于两段链表从公共节点开始后的数据是相等的，如果分别从末尾开始遍历两个链表，找到第一次不相等处，即是第一个公共节点。借助Stack**先入后出**的性质可以解决。
>
> 效率略有提升。

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

方法三：缩小长链表的长度

> 先遍历两链表得出长度，长度较长的链表先遍历，直到遍历到两个链表的长度相等，两个链表同时向后进行遍历，找到第一个相等的节点。
>
> 效率很高。

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

方法四：使用双指针

> 分别创建两个指针指向两个链表，从首节点同时开始遍历，首先遍历结束的链表接着从未遍历完的首节点开始，后遍历完的链表在遍历结束后指向先遍历完的链表，用于消除两个链表长度差带来的影响。
>
> 效率很高。

```java
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
```



