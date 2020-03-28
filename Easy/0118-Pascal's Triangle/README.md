# 118. Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```



## Solutions (C)

```C
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** generate(int numRows, int* returnSize, int** returnColumnSizes){
    int i, j;
    *returnColumnSizes =(int *)malloc(numRows * sizeof(int *));
    int **res = (int** )malloc(numRows * sizeof(int *));
    *returnSize = numRows;
    for(i = 0; i < numRows; i++)
        (*returnColumnSizes)[i] = i + 1;
    for(i = 0; i < numRows; i++){
        res[i] = (int* )malloc((i+1) * sizeof(int));
        res[i][0] = 1;
        res[i][i] = 1;
        for(j = 1; j < i; j++){
            res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
        }
    } 
    return res;
}
```







