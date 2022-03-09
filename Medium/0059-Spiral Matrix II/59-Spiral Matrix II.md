# 59. Spiral Matrix II

Given a positive integer `n`, generate an `n x n` `matrix` filled with elements from `1` to `n2` in spiral order.

**Example 1:**

![img](https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg)

```
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
```

**Example 2:**

```
Input: n = 1
Output: [[1]]
```

 

**Constraints:**

- `1 <= n <= 20`



## Solutions(C++)

```java
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res (n, vector<int>(n, 0));
        int xIndex = 0;
        int yIndex = 0;
        int offset = 1;
        int mid = n / 2;
        int loop = n / 2;
        int value = 1;

        while (loop--) {
            int i = xIndex;
            int j = yIndex;
            
            for ( ; j < yIndex + n - offset; j++) {
                res[i][j] = value++;
            }

            for ( ; i < xIndex + n - offset; i++) {
                res[i][j] = value++;
            }

            for ( ; j > yIndex; j--) {
                res[i][j] = value++;
            }
        
            for ( ; i > xIndex; i--) {
                res[i][j] = value++;
            }

            xIndex++;
            yIndex++;
            offset += 2;
        }
        
        if (n % 2) {
            res[mid][mid] = value;
        }
        return res;
    }
};
```



## Solutions(Java)

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int xIndex = 0;
        int yIndex = 0;
        int value = 1;
        int mid = n / 2;
        int loop = n / 2;
        int offset = 1;
    
        while (loop-- != 0) {
            int i = xIndex;
            int j = yIndex;

            for ( ; j < yIndex + n - offset; j++) {
                res[i][j] = value++;
            }

            for ( ; i < xIndex + n - offset; i++) {
                res[i][j] = value++;
            }

            for ( ; j > yIndex; j--) {
                res[i][j] = value++;
            }
            
            for ( ; i > xIndex; i--) {
                res[i][j] = value++;
            }

            xIndex++;
            yIndex++;
            offset += 2;
        }
        if (n % 2 == 1) {
            res[mid][mid] = value;
        }
    return res;
    }
}
```



