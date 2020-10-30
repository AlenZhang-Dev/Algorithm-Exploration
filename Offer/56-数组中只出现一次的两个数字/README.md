# 56. 数组中数字出现的次数

一个整型数组 `nums` 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

示例1：

```
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
```

示例 2:

    输入：nums = [1,2,10,4,1,4,3,3]
    输出：[2,10] 或 [10,2]

**限制：**

- `2 <= nums.length <= 10000`

## 解析

借用特性：两个相同的数字亦或的结果为0。

1. 从头到尾依次异或数组中的每个值。得到的结果即两个只出现一次的数字的异或结果。
2. 该结果的二进制结果中肯定有一位为1，找到其中为1的一位标记为index。【表示两个数字在该位是不同的】
3. 根据2中的结果，对于数组中所有数据index位是否为1进行分组并再次异或处理，得到的两个结果即两个只出现一次的数字。



## 题解

### Java

```java
class Solution {
    public int[] singleNumbers(int[] nums) {
        int resultXor = 0;
        for(int n : nums)
            resultXor ^= n;
    
        int indexOf1 = 1;
        while((indexOf1 & resultXor) == 0){
            indexOf1 <<= 1;
        }

        int num1 = 0, num2 = 0;
        for(int n : nums){
            if((indexOf1 & n) != 0)
                num1 ^= n;
            else
                num2 ^= n; 
        }
        
        return new int[]{num1, num2};
    }
}
```



### Kotlin

```kotlin
class Solution {
    fun singleNumbers(nums: IntArray): IntArray {
        var resultXor = 0
        var num1 = 0
        var num2 = 0
        for(n in nums)
            resultXor = resultXor xor n
    
        var indexOf1 = 1
        while((indexOf1 and resultXor) == 0){
            indexOf1 = indexOf1 shl 1
        }

        for(n in nums){
            if((indexOf1 and n) != 0)
                num1 = num1 xor n
            else
                num2 = num2 xor n
        }
        val res = intArrayOf(num1, num2)

        return  res
    }
}
```

