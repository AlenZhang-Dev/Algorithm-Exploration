# 268. Missing Number

- Given an array containing *n* distinct numbers taken from `0, 1, 2, ..., n`, find the one that is missing from the array.

  **Example 1:**

  ```
  Input: [3,0,1]
  Output: 2
  ```

  **Example 2:**

  ```
  Input: [9,6,4,2,3,5,7,0,1]
  Output: 8
  ```

  **Note**:
  Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?



## Solutions (Java)

### 1.Bitwise operation

```Java
class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
```

### 2.Sort

```java
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i)
                return i;
        }
        return nums.length;
    }
}
```

### 3.Math

```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
```

### 4.Hash Table

```java
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) 
            set.add(nums[i]);   
        for(int i = 0; i <= nums.length; i++)
            if(!set.contains(i)) 
                return i;
        return -1;
    }
}
```
