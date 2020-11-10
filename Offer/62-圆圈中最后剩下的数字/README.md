# 62. 圆圈中最后剩下的数字

0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

示例1：

```
输入: n = 5, m = 3
输出: 3
```

示例 2:

    输入: n = 10, m = 17
    输出: 2

**限制：**

- `1 <= n <= 10^5`
- `1 <= m <= 10^6`

## 解析

使用ArrayList模拟圆圈。根据要求对圆圈进行相关操作。执行效率很低。

## 题解

### C++

**方法一**

~~~c++
class Solution {
public:
    int lastRemaining(int n, int m) {
        int index = 0;
        for(int i = 2; i <= n; i++)
            index = (index + m) % i;
        return index;
    }
};
~~~



### Java

**方法一**

```java
class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            list.add(i);
        int index = 0;
        while(n > 1){
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
```

**方法二**

数学

```java
class Solution {
    public int lastRemaining(int n, int m) {
        int index = 0;
        for(int i = 2; i <= n; i++){
            index = (index + m) % i;
        }
        return index;
    }
}
```

**方法三**

递归

```java
class Solution {
    public int lastRemaining(int n, int m) {
        return solve(n, m);
    }
    private int solve(int n, int m){
        if(n == 0)
            return 0;
        int index = solve(n - 1, m);
        return (index + m) % n; 
    }
}
```

