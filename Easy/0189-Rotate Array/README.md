# 189. Rotate Array

Given an array, rotate the array to the right by *k* steps, where *k* is non-negative.

**Example 1:**

```
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

**Example 2:**

```
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

**Note:**

- Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
- Could you do it in-place with O(1) extra space?



## Solutions (Java)

### 1.Brute Force

```Java
class Solution {
    public void rotate(int[] nums, int k) {
        int temp;
        for(int i = 0; i < k; i++){
            temp = nums[nums.length - 1];
            for(int j = nums.length - 1; j > 0; j--){
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
```

### 2.additional Array

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }
}
```

### 3.Reverse Array

```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

### 4.Annular Replacement

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        k %= nums.length;
        for(int start = 0; count < nums.length; start++){
            int cur = start;
            int pre = nums[start];
            do{
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while(start != cur);
        }
    }
}
```



