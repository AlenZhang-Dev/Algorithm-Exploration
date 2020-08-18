# 16. 数值的整数次方



实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

示例 1:

```
输入: 2.00000, 10
输出: 1024.00000
```


示例 2:

```
输入: 2.10000, 3
输出: 9.26100
```

示例 3:

```
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
```


说明:

* -100.0 < x < 100.0
* n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。



链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof




## 解析

主要分三种情况考虑:

* 当exponent是0的时候，返回1.

* 当exponent小于0的时候，需要把它转化为正数才能更方便计算，同时base变为1/base.

* 当exponent大于0的时候要分为两种情况，一种是偶数，一种是奇数; 偶数相对容易, 奇数需要先提取一位出来再进行运算.



## 题解

### 递归

#### C++

```c++
class Solution {
public:
    double myPow(double x, long int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / x * myPow(1 / x, -n - 1);

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
};
```

> 注,原题给出函数为`double myPow(double x, int n)`, 但测试用例有`0.00001 2147483647`, 后者越界, 需要改为`long int `.

### 循环

#### C++

```c++
class Solution {
public:
    double myPow(double x, long int n) {
    double result = 1.0;
    for (int i = n; i != 0; i /= 2, x *= x) {
        if (i % 2 != 0) {
            result *= x;
        }
    }

    return n < 0 ? 1.0 / result : result;
    }
};
```

