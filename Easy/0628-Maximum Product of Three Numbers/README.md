# 628. Maximum Product of Three Numbers

Given an integer array, find three numbers whose product is maximum and output the maximum product.

**Example 1:**

```
Input: [1,2,3]
Output: 6
```

 

**Example 2:**

```
Input: [1,2,3,4]
Output: 24
```

 

**Note:**

1. The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
2. Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.



## Solutions (Java)

### 1. Sort

```java
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],nums[0]*nums[1]*nums[nums.length-1]);
    }
}
```



### 2.Linear Scan

```java
class Solution {
    public int maximumProduct(int[] nums) {
    int len = nums.length;
    int cur = 0;
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

    for(int i = 0; i < len; i++){
        cur = nums[i];
        if(cur <= min1){
            min2 = min1;
            min1 = cur;
        }else if(cur <= min2){
            min2 = cur;
        }
        if(cur >= max3){
            max1 = max2;
            max2 = max3; 
            max3 = cur;
        }
        else if(cur >= max2){
            max1 = max2;
            max2 = cur;
        }
        else if(cur >= max1){
            max1 = cur;
        }
    }
    return Math.max(max1 * max2 * max3, min1 * min2 * max3);
    }
}
```

