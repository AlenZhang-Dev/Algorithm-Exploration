# 46. 把数字翻译成字符串

给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

示例 1:

```
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
```


提示：

`0 <= num < 231`


## 解析

本质上是一个递归问题。

参考Leetcode中Krahets的题解：

![Picture1.png](https://pic.leetcode-cn.com/e231fde16304948251633cfc65d04396f117239ea2d13896b1d2678de9067b42-Picture1.png)

得出递归公式。可知其本质与青蛙跳台阶问题并没有什么不同，只是判断条件有所区别。

待补充...



## 题解

### Java

```java
class Solution {
    public int translateNum(int num) {
        //取出数字各位
        int a = 1, b = 1; 
        int x, y = num % 10;
        
        while(num != 0){
            num /= 10;
            x = num % 10;//x位高位，y保存低位
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
```

```java
class Solution {
    public int translateNum(int num) {
        //使用字符串进行判断
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2; i <= s.length(); ++i){
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
```

