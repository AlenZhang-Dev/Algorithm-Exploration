# 63. 股票的最大利润

假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

示例1：

```
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
```

示例 2:

    输入: [7,6,4,3,1]
    输出: 0
    解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

**限制：**

- `0 <= 数组长度 <= 10^5`

## 解析

使用ArrayList模拟圆圈。根据要求对圆圈进行相关操作。执行效率很低。

## 题解

### C++

```c++
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        int curMin = INT_MAX;
        for(int i = 0; i < prices.size(); i++){
            curMin = min(curMin, prices[i]);
            profit = max(profit, prices[i] - curMin);
        }
        return profit;
    }
};
```



### Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int Profit = 0;
        int Cost = Integer.MAX_VALUE;
        for(int price : prices){
            Cost = Math.Min(Cost, price);
            Profit = Math.Max(Profit, price - Cost);
        }
        return Profit;
    }
}
```



### Kotlin

```kotlin
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var curMin = Int.MAX_VALUE
        var maxProfit = 0
        for(price in prices){
            if(price < curMin)
                curMin = price;
            if(price - curMin > maxProfit)
                maxProfit = price - curMin
        }
        return maxProfit
    }
}
```

