# 14. 剪绳子

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 `m` 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为` k[0],k[1]...k[m-1] `。请问 `k[0]*k[1]*...*k[m-1] `可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

```
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
```

示例 2:

```
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
```


提示：

`2 <= n <= 58`


链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof

## 解析

动态规划的理念：需要求解长度为n的绳子的最大乘积，将问题分解，每次求出长度为i的绳子剪成若干段后乘积的最大值，直到i=length时，返回值即可。

贪婪算法：当n>=5时，我们尽可能多剪长度为3的绳子，当剩下绳子长度为4的时候，尽可能多剪长度为2的绳子，这样得到各段绳子的长度最大。因为当n>=5的时候，剪3段是最佳选择，当绳子为4的时候，剪两段是最佳选择。

## 题解

### 动态规划

#### C++

```C++
class Solution {
public:
    int cuttingRope(int length) {
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;
        
        int* products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        
        for(int i = 4; i <= length; ++i){
            max = 0;
            for(int j = 1; j <= i / 2; ++j){
                int product = products[j] * products[i - j];
                if(max < product)
                    max = product;

                products[i] = max;
            }
        }

        max = products[length];
        delete[] products;

        return max;
    }
};
```



### 贪婪算法

#### C++

```c++
class Solution {
public:
    int cuttingRope(int length) {
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;
        
        //尽可能多的减去长度为3的绳子
        int timesOf3 = length/3;
        
        if(length - timesOf3 * 3 == 1)
            timesOf3--;
        
        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int)(pow(3, timesOf3)) * (int)(pow(2, timesOf2));
    }
};
```

#### Java

```java
class Solution {
    public int cuttingRope(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (n == 3)
            return 2;
        int sum = 1;
        while (n > 4){
            sum *= 3;
            n -= 3;
        }

        return sum*n;
    }
}
```

