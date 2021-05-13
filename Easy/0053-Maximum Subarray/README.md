# 53. Maximum Subarray

Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

**Follow up:**

If you have figured out the O(*n*) solution, try coding another solution using the divide and conquer approach, which is more subtle.

## Solutions (C)

### 1. Greedy Algorithm

```c
int maxSubArray(int* nums, int numsSize){
        int max = nums[0], cur_max = nums[0];
        for(int i = 1; i < numsSize; i++){
            cur_max += nums[i];
            if(cur_max < nums[i])
                cur_max = nums[i];
            if(max < cur_max)
                max = cur_max;
        }
        return max;
}
```

> Runtime: **4 ms** Memory Usage: **7.5 MB**

### 2. Kadane's Algorithm

```c

int maxSubArray(int* nums, int numsSize){
        int max = nums[0];
        for(int i = 1; i < numsSize; i++){
            if(nums[i-1] > 0) 
                nums[i] += nums[i-1];
            if(nums[i] > max)
                max = nums[i];
        }
        return max;
}
```

> Runtime: **4 ms** Memory Usage: **7.5 MB**

### 3. Ergodic Inference

```c
int maxSubArray(int* nums, int numsSize){
        int max = nums[0];
        if(numsSize == 0) 
            return 0;  
        for(int i = 0; i < numsSize; i++){
                int sum = 0;
                for(int j = i; j < numsSize; j++){
                    sum += nums[j];
                    if(sum > max)
                        max = sum;
                }
        }
        return max;
}
```

> Runtime: **292 ms** Memory Usage: **7.5 MB**

## Solutions (Java)

### 1. Greedy Algorithm

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], sum = 0;
        for(int num : nums) {
        	sum += num;
        	if(sum > res)
            	res = sum;
        	if(sum < 0)
            	sum = 0;
      }
      return res;
    }
}
```

> Runtime: **1 ms** Memory Usage: **41.5 MB**



### 2. Kadane's Algorithm

```java
class Solution {
  public int maxSubArray(int[] nums) {
    int n = nums.length, maxSum = nums[0];
    for(int i = 1; i < n; ++i) {
      if (nums[i - 1] > 0) nums[i] += nums[i - 1];
      maxSum = Math.max(nums[i], maxSum);
    }
    return maxSum;
  }
}
```

> Runtime: **1 ms** Memory Usage: **41.8 MB**



## Solutions (Python)

### 1. Greedy Algorithm

```python
class Solution:
    def maxSubArray(self, nums: 'List[int]') -> 'int':
        n = len(nums)
        curr_sum = max_sum = nums[0]

        for i in range(1, n):
            curr_sum = max(nums[i], curr_sum + nums[i])
            max_sum = max(max_sum, curr_sum)
            
        return max_sum
```

> Runtime: **76 ms** Memory Usage: **13.6 MB**



### 2. Kadane's Algorithm

```python
class Solution:
    def maxSubArray(self, nums: 'List[int]') -> 'int':
        n = len(nums)
        max_sum = nums[0]
        for i in range(1, n):
            if nums[i - 1] > 0:
                nums[i] += nums[i - 1] 
            max_sum = max(nums[i], max_sum)

        return max_sum
```

> Runtime: **76 ms** Memory Usage: **13.7 MB**