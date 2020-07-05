# 485. Max Consecutive Ones


Given a binary array, find the maximum number of consecutive 1s in this array.

**Example 1:**

```
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
```

**Note:**

- The input array will only contain `0` and `1`.
- The length of input array is a positive integer and will not exceed 10,000



---

中文题解：

1. 使用一次遍历。
2. 使用滑动窗口。



## Solutions (C)

### 1. Traversal

```c
int findMaxConsecutiveOnes(int* nums, int numsSize){
    int max = 0;
    int count = 0; 
    for(int i = 0; i < numsSize; i++){
        if(nums[i])
            count++;
        else{
            max = max > count ? max : count;
            count = 0;
        }
    }
    max = max > count ? max : count;
    return max;
}
```



## Solutions (Java)

### 1. Traversal

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0 , count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) 
                count++;
            else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
```

 

### 2. Sliding Window

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int right = 0;
        int left = 0;
        int max = 0;

        while(right < nums.length){
            if(nums[right++] == 0){
                max = Math.max(max, right - left - 1);
                left = right;
            }
        }
        return Math.max(max, right - left);
    }
}
```


