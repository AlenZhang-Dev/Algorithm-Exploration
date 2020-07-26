# 867. Transpose Matrix



- Given a matrix `A`, return the transpose of `A`.

  The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.


  ![img](https://assets.leetcode.com/uploads/2019/10/20/hint_transpose.png)

   

  **Example 1:**

  ```
  Input: [[1,2,3],[4,5,6],[7,8,9]]
  Output: [[1,4,7],[2,5,8],[3,6,9]]
  ```

  **Example 2:**

  ```
  Input: [[1,2,3],[4,5,6]]
  Output: [[1,4],[2,5],[3,6]]
  ```

   

  **Note:**

  1. `1 <= A.length <= 1000`
  2. `1 <= A[0].length <= 1000`



## Solutions(C)

### 1.Brute Force [Reversal]

```c
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** transpose(int** A, int ASize, int* AColSize, int* returnSize, int** returnColumnSizes){
    int i, j;
    //allocate the row first, then the column
    int** ans = (int**) malloc (sizeof(int*) * (*AColSize));
    for(i = 0; i < *AColSize; i++){
        ans[i] = (int*) malloc (sizeof(int) * ASize);
    }

    for(i = 0; i < ASize; i++)
        for(j = 0; j < *AColSize; j++)
            ans[j][i] = A[i][j];
        
    *returnSize = *AColSize;
    *returnColumnSizes = (int*) malloc (sizeof(int) * (*AColSize));

    for(i = 0; i < *AColSize; i++)
        (*returnColumnSizes)[i] = ASize;

    return ans;
}
```



## Solutions (Java)

### 1. Brute Force [Reversal]

~~~java
class Solution {
    public int[][] transpose(int[][] A) {
        int raw = A.length;
        int col = A[0].length;
        int [][] ans= new int[col][raw]; // reverse the column and the raw
        for(int i = 0; i < col; i++){
            for(int j = 0; j < raw; j++){
                ans[i][j] = A[j][i];
            }
        }
        return ans;
    }
}
~~~



