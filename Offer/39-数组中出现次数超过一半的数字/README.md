# 39. 数组中出现次数超过一半的数字 

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

```
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
```

限制：

`1 <= 数组长度 <= 50000`


链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof

## 解析

方法一：摩尔投票

使用数组的特征找出相关的解决办法，即摩尔投票法，两者一旦不同就同归于尽。

摩尔投票法即不同的数则相互抵消，最后留下来的一定占半数以上。

方法二：基于Partition函数

受到快速排序的启发，使用Partition函数对数组进行排序，首先以begin作为数组的pivot，进行排序，如果排序后pivot位于数组中间点，返回即为结果。

## 题解

### Java

#### 摩尔投票

```java
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                res = nums[i];
                count++;
            }
            else if(res == nums[i])
                count++;
            else 
                count--;
        }
        return res;
    }
}

//简单写法：
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, vote = 0, count = 0;
        for(int num : nums){
            if(vote == 0)
                x = num;
            vote += num == x ? 1 : -1;
        }
        return x;
    }
}
```



### C

#### 摩尔投票

```c
int majorityElement(int* nums, int numsSize){
    int count = 0, res = 0;
    for(int i = 0; i < numsSize; i++)
    {
        if(count == 0
        {
            res = nums[i];
            count++;
        }
        else if(res == nums[i])
            count++;
        else
            count--;
    }
    return res;
}
```



### C++

#### 使用partition函数

~~~java
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        if(nums.empty())  
            return 0;

        int length = nums.size();
        int start = 0;
        int end = length;
        int middle = length >> 1;
        int index = 0;

        while(index != middle){
            index = partition(nums, start, end);
            if(index > middle)
                end = index;
            else 
                start = index + 1;
        }
        return nums[middle];
    }
    int partition(vector<int>&arr, int begin, int end){
        int pivot = arr[begin];
        // Last position where puts the no_larger element.
        int pos = begin;
        for(int i=begin+1; i!=end; i++){
            if(arr[i] <= pivot){
                pos++;
                if(i!=pos){
                    swap(arr[pos], arr[i]);
                }
            }
        }
        swap(arr[begin], arr[pos]);
        return pos;
    }
};
~~~

