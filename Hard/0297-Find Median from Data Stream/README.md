# 295. Find Median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,

```
[2,3,4]`, the median is `3
[2,3]`, the median is `(2 + 3) / 2 = 2.5
```

Design a data structure that supports the following two operations:

- void addNum(int num) - Add a integer number from the data stream to the data structure.
- double findMedian() - Return the median of all elements so far.

**Example:**

```
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2 
```

**Follow up:**

1. If all integer numbers from the stream are between 0 and 100, how would you optimize it?
2. If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?


## Solutions (Java)

```java
class MedianFinder {
    Queue<Integer> HeapA, HeapB;
    /** initialize your data structure here. */
    public MedianFinder() {
        HeapA = new PriorityQueue<>();//创建小顶堆
        HeapB = new PriorityQueue<>((x, y) -> (y - x));//创建大顶堆
    }
    
    public void addNum(int num) {
      	//两者不等加到大根堆
        if(HeapA.size() != HeapB.size()){
            HeapA.add(num);
            HeapB.add(HeapA.poll());
        }else{//两者相等加到小根堆
            HeapB.add(num);
            HeapA.add(HeapB.poll());
        }
    }
    
    public double findMedian() {
        if(HeapA.size() != HeapB.size())
            return HeapA.peek();
        else
            return (HeapB.peek() + HeapA.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//其中 findMedian方法可以简写为如下：
public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
   }


```

## Solutions(C++)

~~~c++
class MedianFinder {
public:
   
    /** initialize your data structure here. */
    MedianFinder() {
        //Nothing Here
    }
    
    void addNum(int num) {
            //小根堆元素大于大根堆，将元素放入小根堆
            // if(HeapA.size() >= HeapB.size()){
            //     HeapB.push(num);
            // }else{
            //     HeapA.push(num);
            // }
            HeapA.size() > HeapB.size() ? HeapB.push(num) : HeapA.push(num);

            //交换元素，并删除对应元素
            if(!HeapB.empty() && HeapA.top() < HeapB.top()){
                HeapA.push(HeapB.top());
                HeapB.push(HeapA.top());
                HeapA.pop();
                HeapB.pop();
            }
        }
    
    double findMedian() {
        // int n1 = HeapA.size();
        // int n2 = HeapB.size();
        // if((n1 + n2) % 2 == 0){
        //     return (HeapA.top() + HeapB.top()) * 1.0 / 2;
        // }
				//通关判断数组是否相等来判断数量奇偶
        return HeapA.size() == HeapB.size() ? (HeapA.top() + HeapB.top()) * 1.0 / 2 : HeapA.top();
        // if(HeapA.size() == HeapB.size())
        //     return (HeapA.top() + HeapB.top()) * 1.0 / 2;
        // // return n1 > n2 ? HeapA.top() : HeapB.top();
        // return HeapA.top();
    }
private:
    priority_queue<int, vector<int>, greater<int>> HeapA;//创建小顶堆
    priority_queue<int, vector<int>, less<int>> HeapB;//创建大顶堆
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
~~~

