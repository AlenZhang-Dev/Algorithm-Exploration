# 16. 3Sum Closest

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

Example 2:

```
Input: nums = []
Output: []
```


Example 3:

```
Input: nums = [0]
Output: []
```

**Constraints:**

* 0 <= nums.length <= 3000
* -105 <= nums[i] <= 105



## Solutions (Java)

### 1. Two Pointers

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int count = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int newCount = nums[i] + nums[left] + nums[right];
                count = Math.abs(newCount - target) < Math.abs(count - target) ? newCount : count;
                if (newCount > target) {
                    right--;
                } else if (newCount < target) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return count;
    }
}
```
