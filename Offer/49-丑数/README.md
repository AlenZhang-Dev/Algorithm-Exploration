# 49. 丑数

我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

示例 :

```
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
```

说明：

1. `1` 是丑数。
2. `n` **不超过**1690。

## 解析

首先需要明白什么是丑数。

利用丑数的特性：任何一个丑数乘2、3、5都会成为一个新的丑数。

因此创建一个数组，里面存储排序的丑数，那么第n个丑数也就是数组第n个中的数据。

我们如何让数组内的数据排序？

维护三个指针，用于将当前指针指向的数据乘2，3，5。每一次遍历得到一个排序丑数，也就是当前最小的丑数。同时更新三个指针。直到数组填至数组第n-1位。

> 该思路需要用大量空间以换取程序的执行效率。

## 题解

### Java

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++){
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1: j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }
}

```

### Python

```python
class Solution(object):
    def nthUglyNumber(self, n):
        dp, a, b, c = [1] * n, 0, 0, 0
        for i in range(1, n):
            n2, n3, n5 = dp[a] * 2, dp[b] * 3, dp[c] * 5
            dp[i] = min(n2, n3, n5)
            if dp[i] == n2 : a += 1
            if dp[i] == n3 : b += 1
            if dp[i] == n5 : c += 1
        return dp[-1]
```



