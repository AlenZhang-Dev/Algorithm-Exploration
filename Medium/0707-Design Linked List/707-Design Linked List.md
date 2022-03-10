# 707. Design Linked List

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: `val` and `next`. `val` is the value of the current node, and `next` is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute `prev` to indicate the previous node in the linked list. Assume all nodes in the linked list are **0-indexed**.

Implement the `MyLinkedList` class:

- `MyLinkedList()` Initializes the `MyLinkedList` object.
- `int get(int index)` Get the value of the `indexth` node in the linked list. If the index is invalid, return `-1`.
- `void addAtHead(int val)` Add a node of value `val` before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
- `void addAtTail(int val)` Append a node of value `val` as the last element of the linked list.
- `void addAtIndex(int index, int val)` Add a node of value `val` before the `indexth` node in the linked list. If `index` equals the length of the linked list, the node will be appended to the end of the linked list. If `index` is greater than the length, the node **will not be inserted**.
- `void deleteAtIndex(int index)` Delete the `indexth` node in the linked list, if the index is valid.

 

**Example 1:**

```
Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
```

 

**Constraints:**

- `0 <= index, val <= 1000`
- Please do not use the built-in LinkedList library.
- At most `2000` calls will be made to `get`, `addAtHead`, `addAtTail`, `addAtIndex` and `deleteAtIndex`.



## Solutions(C++)

```c++
class MyLinkedList {
public:
    struct Node {
        int val;
        Node* next;
        Node(int a) : val(a), next(nullptr){}
    };

    MyLinkedList() {
        dummyHead = new Node(0);
        size = 0;
    }
    
    int get(int index) {
        if (index > (size - 1) || index < 0) {
            return -1;
        }
        Node* cur = dummyHead -> next;
        while(index--) {
            cur = cur -> next;
        }
        return cur -> val;
    }
    
    void addAtHead(int val) {
        Node* newNode = new Node(val);
        newNode -> next = dummyHead -> next;
        dummyHead -> next = newNode;
        size++;
    }
    
    void addAtTail(int val) {
        Node* cur = dummyHead;
        Node* newNode = new Node(val);
        while (cur -> next != nullptr) {
            cur = cur -> next;
        }
        cur -> next = newNode;
        size++;
    }
    
    void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node* newNode = new Node(val);
        Node* cur = dummyHead; //cur should at previous of the index.
        while (index--) {
            cur = cur -> next;
        }
        newNode -> next = cur -> next;
        cur -> next = newNode;
        size++;
    }
    
    void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        Node* cur = dummyHead;
        while(index--) {
            cur = cur -> next;
        }
        Node* temp = cur -> next;
        cur -> next = temp -> next;
        delete temp;
        size--;
    }

private:
    int size;
    Node* dummyHead;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */
```



## Solutions(Java)

```java
class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        } 
    }

    Node pseudoHead;
    int size;

    public MyLinkedList() {
        pseudoHead = new Node(0);
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur = pseudoHead.next;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = pseudoHead.next;
        pseudoHead.next = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node cur = pseudoHead;
        Node newNode = new Node(val);
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index >  size) {
            return;
        }
        Node newNode = new Node(val);
        Node cur = pseudoHead;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node cur = pseudoHead;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        cur.next = cur.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```

