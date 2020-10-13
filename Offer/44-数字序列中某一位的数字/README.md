# 44. 数字序列中某一位的数字

数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。 

示例 1：

```
输入：n = 3
输出：3
```

示例 2：

```
输入：n = 11
输出：0
```

限制：

`0 <= n < 2^31`




## 解析

具有找规律的成分。

| 范围(range) | 位数(digit) | 数字数量(nums) | 数字位数(count)   |
| ----------- | ----------- | -------------- | ----------------- |
| 1 ~ 9       | 1           | 9              | 9                 |
| 10 ~ 99     | 2           | 90             | 180               |
| 100 ~ 999   | 3           | 900            | 2700              |
| start ~ end | digit       | 9 * start      | 9 * start * digit |



需要确定数列中某一位的数字主要分以下几个步骤：

1. 确定数字所在的位数(digit)。
2. 缩小范围到数字。`num = start + (n - 1) / digit `
3. 确定数字的位数，返回。 数字在num的第 `(n - 1) % digit`位。





## 题解

### Java

```java
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
      	//step 1: 确定n所在的位数范围
        while(n > count){
            n -= count;
            ++digit;
            start *= 10;
            count = 9 * digit * start;
        }
        //确定n所在的具体数字
        long num = start + (n - 1) / digit;
      	//返回具体位数。
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
```

