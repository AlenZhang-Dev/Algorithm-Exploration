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

### 1. Ergodic Inference

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