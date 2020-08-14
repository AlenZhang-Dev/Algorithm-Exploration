# 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：

```
输入：head = [1,3,2]
输出：[2,3,1]
```


限制：

`0 <= 链表长度 <= 10000`

## 题解

### 1. 递归

容易理解，但效率低。

#### C

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* reversePrint(struct ListNode* head, int* returnSize){
    if(head == NULL){
        *returnSize = 0;
        return malloc(sizeof(int) * 10000);
    }
    int *list = reversePrint(head->next, returnSize);
    list[(*returnSize)++] = head->val;
    return list;
}
```

### 2.数组

模仿栈的形式，创建对应长度数组，从尾到头进行赋值。

#### C

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int listLength(struct ListNode* node){
    int length = 0;
    while(node != NULL){
        length++;
        node = node->next;
    }
    return length;
}

int* reversePrint(struct ListNode* head, int* returnSize){
    if(head = NULL){
        *returnSize = 0;
        return NULL;
    }

    int length = listLength(head);
    int i = length;

    int *list = (int *)malloc(sizeof(int) * length);
    *returnSize = length; 
    while(head != NULL){
        list[--i] = head->val;
        head = head->next;
    }
    return list;
}
```

#### Java

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
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        int []nums = new int[count];
        node = head;
        for(int i = count - 1; i >= 0; --i){
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }
}
```

### 3.栈

先进后出

#### Java

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
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}

```

