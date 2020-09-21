# 39. 数组中出现次数超过一半的数字 

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

```
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
```

限制：

`1 <= 数组长度 <= 50000`


链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof

## 解析

使用数组的特征找出相关的解决办法，即摩尔投票法，两者一旦不同就同归于尽。

## 题解

```java
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                res = nums[i];
                count++;
            }
            else if(res == nums[i])
                count++;
            else 
                count--;
        }
        return res;
    }
}
```



