# 566. Reshape the Matrix

1. In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

   You're given a matrix represented by a two-dimensional array, and two **positive** integers **r** and **c** representing the **row** number and **column** number of the wanted reshaped matrix, respectively.

   The reshaped matrix need to be filled with all the elements of the original matrix in the same **row-traversing** order as they were.

   If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

   **Example 1:**

   ```
   Input: 
   nums = 
   [[1,2],
    [3,4]]
   r = 1, c = 4
   Output: 
   [[1,2,3,4]]
   Explanation:
   The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
   ```

   

   **Example 2:**

   ```
   Input: 
   nums = 
   [[1,2],
    [3,4]]
   r = 2, c = 4
   Output: 
   [[1,2],
    [3,4]]
   Explanation:
   There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
   ```

   

   **Note:**

   1. The height and width of the given matrix is in range [1, 100].
   2. The given r and c are all positive.



## Solutions (Java)

### 1. Brute Force

```java
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r * c  != nums.length * nums[0].length){
            return nums;
        }
        int n = 0;
        int [][]res = new int[r][c];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length; j++){
                res[n / c][n % c] = nums[i][j];
                n++;
            }
        }
        return res;
    }
}
```



## Solutions (C)

### 1. Brute Force

~~~java
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** matrixReshape(int** nums, int numsSize, int* numsColSize, int r, int c, int* returnSize, int** returnColumnSizes){
    if(numsSize * (*numsColSize) != r * c){
        *returnSize = numsSize;
        *returnColumnSizes = numsColSize;
        return nums;
    }
  
    int ** res = malloc(sizeof(int *) * r);
    int v = 0;
    *returnColumnSizes = malloc(sizeof(int) * r);
    for(int i = 0;i<r;i++){
        res[i] = malloc(sizeof(int)*c);
        (*returnColumnSizes)[i] = c;
    }
        
    for(int i = 0;i < numsSize;i++){
        for(int j = 0;j< *numsColSize; j++){
            v = i * (*numsColSize) + j;
            res[v / c][v % c] = nums[i][j];
        }
    }
    *returnSize = r;
    return res;
}
~~~

