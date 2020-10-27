# 34. Find First and Last Position of Element in Sorted Array

Given an array of integers `nums` sorted in ascending order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

**Follow up:** Could you write an algorithm with `O(log n)` runtime complexity?

**Example 1:**

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

**Example 2:**

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

**Example 3:**

```
Input: nums = [], target = 0
Output: [-1,-1]
```

**Constraints:**

- `0 <= nums.length <= 105`
- `-109 <= nums[i] <= 109`
- `nums` is a non-decreasing array.
- `-109 <= target <= 109`

 

## Solutions (Java)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] temp = {-1, -1};
        if(nums == null || nums.length == 0)
            return temp;
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int m = (i + j) / 2;
            if(nums[m] <= target)
                i = m + 1;
            else 
                j = m - 1;
        }
        if(j >= 0 && nums[j] != target || j < 0)
            return temp;
        temp[1] = i - 1; 
  
        i = 0; 
        j = nums.length - 1;
        while(i <= j){
            int m = (i + j) / 2;
            if(nums[m] < target)
                i = m + 1;
            else 
                j = m - 1;
        }
        temp[0] = j + 1;
        return temp;
    }
}
```

