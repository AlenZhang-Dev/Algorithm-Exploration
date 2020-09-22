# 79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

**Example:**

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false. 
```

**Constraints:**

- `board` and `word` consists only of lowercase and uppercase English letters.
- `1 <= board.length <= 200`
- `1 <= board[i].length <= 200`
- `1 <= word.length <= 10^3`



## Solutions (Java)

```Rust
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



## Solutions (C)

```c
bool myExist(char **board, int rows, int cols, int **arr, int row, int col, int *strLen, char* str)
{
    if (str[*strLen] == '\0') {
        return true;
    } 

    int res = false;
    if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == str[*strLen] && arr[row][col] == 0) {
        (*strLen)++;
        arr[row][col] = 1;
        res = myExist(board, rows, cols, arr, row - 1, col, strLen, str) ||
              myExist(board, rows, cols, arr, row, col + 1, strLen, str) ||
              myExist(board, rows, cols, arr, row + 1, col, strLen, str) ||
              myExist(board, rows, cols, arr, row, col - 1, strLen, str);

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
            if (myExist(board, rows, cols, arr, i, j, &strLen, word)) {
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
