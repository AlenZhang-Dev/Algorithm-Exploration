# 704. Binary Search

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

**Example 1:**

```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

**Example 2:**

```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

 

**Constraints:**

- `1 <= nums.length <= 104`
- `-9999 <= nums[i], target <= 9999`
- All the integers in `nums` are **unique**.
- `nums` is sorted in an ascending order.



## Solutions (C)

```c
int search(int* nums, int numsSize, int target){
    int low = 0;
    int high = numsSize - 1;
    int mid;
    while (low <= high) {
        mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}
```



## Solutions(C++)

```c++
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0; 
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
};
```



```c++
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0; 
        int right = nums.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
};
```





## Solutions (Java)

```java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
```



```java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }
}
```



