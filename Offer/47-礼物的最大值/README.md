# 47. 礼物的最大价值

在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

示例 1:

```
输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
```


提示：

- `0 < grid.length <= 200`
- `0 < grid[0].length <= 200`


## 解析

典型的能用动态规划解决的问题，用递归的思路进行分析。

`f(i,j) = max(f(i - 1, j), f(i, j - 1)) + grid[i][j];`



## 题解

### Java

直接解：

```java
class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for(int i = 0; i < row; i++)
            for(int j = 0; j < column; j++){
                if(i == 0 && j == 0)
                    continue;
                else if(i == 0 && j != 0)
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                else if(i != 0 && j == 0)
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                else
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
            return grid[row - 1][column - 1];
    }
}
```

改进一：

在数组非常大的时候，判断的前三种情况很少遇到，可以在遍历之前完成这些操作。减少在循环中进行判断。

```java
class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
      	for(int j = 1; j < column; j++).//first row
          	grid[0][j] += grid[0][j - 1];
     		for(int i = 1; i < row; i++)//first line
          	grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < row; i++)
            for(int j = 1; j < column; j++)
               grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            return grid[row - 1][column - 1];
    }
}
```

改进二：

使用额外空间，创建一个额外数组。

```java
class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int dp[][] = new int [row + 1][column + 1];
        for(int i = 1; i < row + 1; i++)
            for(int j = 1; j < column + 1; j++)
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1]; 
        return dp[row][column];
    }
```



