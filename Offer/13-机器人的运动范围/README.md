# 13. 机器人的运动范围

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：

```
输入：m = 2, n = 3, k = 1
输出：3
```

示例 2：

```
输入：m = 3, n = 1, k = 0
输出：1
```

提示：

```
1 <= n,m <= 100
0 <= k <= 20
```



## 解析

依旧是一道典型的回溯问题。与12题类似。

重点：

避免重复，使用一个bool类型的数组标记，记录过为设为true，默认false。

判断函数编写。



## 题解

### C

```c++
//注： Leetcode显示内存相关报错，bug未解决
class Solution {
public:
    int movingCount(int m, int n, int k) {
        if(k < 0 || n <= 0 || m <= 0)
            return 0;
        
        bool *visited = new bool[m * n];
        for(int i = 0; i < m * n; ++i)
            visited[i] = false;
        
        int count = movingCountCore(k, m, n, 0, 0, visited);

        delete[] visited;

        return count;
    }

    int movingCountCore(int k, int rows, int cols, int row, int col, bool* visited){
        int count = 0;
        if(check(k, rows, cols, row, col, visited)){//check
            visited[row * cols + col] = true;

            count = 1 + movingCountCore(k, rows, cols, row - 1, col, visited)
                    + movingCountCore(k, rows, cols, row, col - 1, visited)
                    + movingCountCore(k, rows, cols, row + 1, col, visited)
                    + movingCountCore(k, rows, cols, row, col + 1, visited);
        }

        return count;
    }

    //function check if the robot can move or not
    bool check(int k, int rows, int cols, int row, int col, bool* visited){
        if(getSum(col) + getSum(row) <= k && !visited[row * cols + col] && col < cols && col >= 0 && row < rows && row >= 0)
            return true;
        
        return false;
    }

    int getSum(int number){
        int sum = 0; 
        while(number > 0){
            sum += number % 10;
            number /= 10;   
        }
        return sum;
    }
};
```



### Java

```java
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return movingCountCore(0, 0, m, n, k, visited);
    }

    private int movingCountCore(int i, int j, int m, int n, int k, boolean visited[][]){
        if(i < 0 || j < 0 || i >= m || j >= n || (i / 10 + i % 10 + j / 10 + j % 10) > k || visited[i][j])
            return 0;
        
        visited[i][j] = true;
        
        return movingCountCore(i + 1, j, m, n, k, visited) + 
            movingCountCore(i - 1, j, m, n, k, visited) + 
            movingCountCore(i, j - 1, m, n, k, visited) + 
            movingCountCore(i, j + 1, m, n, k, visited) + 1;
    }
}
```

