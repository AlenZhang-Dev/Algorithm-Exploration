# 12. 矩阵中的路径

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

```
[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]
```

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

实例一：

```
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
```

示例二：

```
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
```

提示：

1 <= board.length <= 200
1 <= board[i].length <= 200



## 解析

回溯法的经典题目，使用递归实现搜寻。



## 题解

## C

```c
bool isExist(char **board, int rows, int cols, int **arr, int row, int col, int *strLen, char* str)
{
    if (str[*strLen] == '\0') {
        return true;
    } 

    int res = false;
    if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == str[*strLen] && arr[row][col] == 0) {
        (*strLen)++;
        arr[row][col] = 1;
        res = isExist(board, rows, cols, arr, row - 1, col, strLen, str) ||
              isExist(board, rows, cols, arr, row, col + 1, strLen, str) ||
              isExist(board, rows, cols, arr, row + 1, col, strLen, str) ||
              isExist(board, rows, cols, arr, row, col - 1, strLen, str);

        if (!res) {
            (*strLen)--;
            arr[row][col] = 0;
        }              
    }

    return res;
}

bool exist(char** board, int boardSize, int* boardColSize, char* word){
    if (board == NULL || boardSize <= 0 || word == NULL) {
        return false;
    }

    int rows = boardSize;
    int cols = *boardColSize;
    int i, j;
    int **arr = (int **)malloc(sizeof(int *) * rows);
    bool res = false;
    int strLen = 0;

    for (i = 0; i < rows; i++) {   
        arr[i] = (int *)malloc(sizeof(int) * cols);
        memset(arr[i], 0, sizeof(int) * cols);
    }

    for (i = 0; i < rows; i++) {
        for (j = 0; j < cols; j++) {
            if (isExist(board, rows, cols, arr, i, j, &strLen, word)) {
                res = true;
                break;;
            }
        }
    }

    for (i = 0; i < rows; i++) {
        free(arr[i]);
    }
    free(arr);

    if (res) {
        return true;
    } else {
        return false;
    }
}
```



## Java

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || board.length == 0 || board[0].length == 0 || word.equals("")){
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();

        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == words[0]){
                    if(isExist(board, i, j, isVisited, words, 0))
                        return true;
                }
            }
        return false;
    }

    private boolean isExist(char[][] board, int i, int j, boolean[][] isVisited, char[] words, int index){
        if(index == words.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != words[index]) {
            return false;
        }
        isVisited[i][j] = true;
        boolean res = isExist(board, i + 1, j, isVisited, words, index + 1)
                || isExist(board, i - 1, j, isVisited, words, index + 1)
                || isExist(board, i, j + 1, isVisited, words, index + 1)
                || isExist(board, i, j - 1, isVisited, words, index + 1);
        isVisited[i][j] = false;
        return res;
    }
}
```

