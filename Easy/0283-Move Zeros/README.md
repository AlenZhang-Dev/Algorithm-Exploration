# 283. Move Zeroes

- Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

  **Example:**

  ```
  Input: [0,1,0,3,12]
  Output: [1,3,12,0,0]
  ```

  **Note**:

  1. You must do this **in-place** without making a copy of the array.
  2. Minimize the total number of operations.



## Solutions (C)

```c
void swap(int *a, int *b) {
    int t = *a;
    *a = *b;
    *b = t;
}
void moveZeroes(int* nums, int numsSize) {
    int index = 0, i = 0;
    while (i < numsSize) {
        if (nums[i]) {
            swap(nums + index, nums + i);
            index++;
        }
        i++;
    }
}
```



## Solutions (Java)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
```



```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
```



