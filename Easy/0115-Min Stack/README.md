# 155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

 


Example 1:

```
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

Constraints:

    Methods pop, top and getMin operations will always be called on non-empty stacks.



## Solutions (C++)

### Auxiliary Stack (non-Sync)

```c++
class MinStack {
public:
    /** initialize your data structure here. */
    MinStack() {
        
    }
    
    void push(int x) {
        mainStack.push(x);
        if(minStack.empty() || x <= minStack.top())
            minStack.push(x);
    }
    
    void pop() {
        int peek = mainStack.top();
        mainStack.pop();
        if(minStack.top() == peek)
            minStack.pop();
    }
    
    int top() {
        return mainStack.top();
    }
    
    int getMin() {
        return minStack.top();
    }

private:
    stack<int> mainStack;
    stack<int> minStack;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
```



### LinkedList

```c++
class MinStack {
private: 
    struct Node{
        int val;
        int min;
        Node *next;

        Node() : val(0), min(0) , next(nullptr){}
        Node(int val, int min) : val(val), min(min), next(next){}
        Node(int val, int min, Node* next) : val(val), min(min), next(next){}
    };
    Node *head;

public:
    /** initialize your data structure here. */
    MinStack() {
       head = nullptr;
    }
    
    void push(int x) {
        if(head == nullptr){
            head = new Node(x, x, head);
        }
        else{
            head = new Node(x, min(x, head -> min), head);
        }
    }
    
    void pop() {
        Node* tmp = head;
        head = head -> next;
        delete tmp;
    }
    
    int top() {
        return head -> val;
    }
    
    int getMin() {
        return head -> min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
```



## Solutions (Java)

### Auxiliary stack（Sync）

```Java
class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        mainStack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        else
            minStack.push(minStack.peek());
    }
    
    public void pop() {
        if(!mainStack.isEmpty()){
            mainStack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```



### Auxiliary stack (non-Sync)


```java
class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        mainStack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }
    
    public void pop() {
        int peek = mainStack.pop();
        if(peek == minStack.peek())
            minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```



### LinkedList 

```java
class MinStack {
    private Node head;
    /** initialize your data structure here. */
    public MinStack() {
      
    }
    
    public void push(int x) {
        if(head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```



## Solutions (Python)

### Auxiliary Stack (non-Sync)

```python
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.Stack = []
        self.minStack = []

    def push(self, x: int) -> None:
        self.Stack.append(x)
        if not self.minStack or x <= self.minStack[-1]:
            self.minStack.append(x)

    def pop(self) -> None:
        if self.Stack.pop() == self.minStack[-1]:
            self.minStack.pop()

    def top(self) -> int:
        return self.Stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
```

