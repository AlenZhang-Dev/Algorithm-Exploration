# 57. 和为s的数字

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

示例1：

```
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
```

示例 2:

    输入：nums = [10,26,30,31,47,60], target = 40
    输出：[10,30] 或者 [30,10]

**限制：**

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^6`

## 解析

因为数组是顺序排列，使用双指针法



## 题解

### Java

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index1 = 0;
        int index2 = nums.length - 1;
        if(index2 < 2)
            return new int[]{};
        int twoSum = nums[index1] + nums[index2];
        while(twoSum != target){
            if(twoSum > target)
                index2--;
            else
                index1++;
            twoSum = nums[index1] + nums[index2];
        }
        return new int[]{nums[index1], nums[index2]};
    }
}
```



### Kotlin

```kotlin
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var index1 = 0
        var index2 = nums.size - 1
        var twoSum = nums[index1] + nums[index2]
        while(twoSum != target){
            if(twoSum > target)
                index2--
            else
                index1++
            twoSum = nums[index1] + nums[index2]
        }
        return intArrayOf(nums[index1], nums[index2])
    }
}
```

