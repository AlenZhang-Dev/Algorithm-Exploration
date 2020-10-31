# 56. 数组中数字出现的次数II

在一个数组 `nums` 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

示例1：

```
输入：nums = [3,4,3,3]
输出：4
```

示例 2:

    输入：nums = [9,1,7,9,7,9,7]
    输出：1

**限制：**

- `1 <= nums.length <= 10000`
- `1 <= nums[i] < 2^31`

## 解析

依旧采用位运算的方式进行问题的解决。

核心：相同的数字出现三次，将数字拆成二进制，则其对应的每一个位之和能够被3整除。如果不能被3整除，那么只出现一次的数字在该位上一定为1。如果能被3整除，则该数字在该位上位0。

1. 建立长度为32的数组，用于统计每一位出现1的次数。
2. 遍历判断数组每个数字能否被3整除，得出结果。

## 题解

### Java

```java
class Solution {
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for(int n : nums) {
            for(int j = 0; j < 32; j++) {
                bitSum[j] += n & 1;
                n >>= 1;
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= bitSum[31 - i] % 3;
        }
        return res;
    }
}
```



### Kotlin

```kotlin
class Solution {
    fun singleNumber(nums: IntArray): Int {
        var bitSum = IntArray(32)
        var num = 0
        for(index in nums){
            num = index
            for(i in 0 until 32){
                bitSum[i] += (num and 1);
                num = num shr 1
            }
        }
        var res = 0
        for(i in 0 until 32){
            res = res shl 1
            res = res or bitSum[31 - i] % 3
        }
        return res
    }
}
```

