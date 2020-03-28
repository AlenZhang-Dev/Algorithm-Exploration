# 119. Pascal's Triangle II

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)

In Pascal's triangle, each number is the sum of the two numbers directly above it.

```
Example:

Input: 3
Output: [1,3,3,1]
```



## Solutions (C)

```C
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getRow(int rowIndex, int* returnSize){
    int *arr = (int* )malloc((rowIndex + 1) * sizeof(int));
    *returnSize = rowIndex + 1;
    for(int j = 0; j <= rowIndex; j++){
        arr[j] = 1;
        for(int i = j-1; i > 0; i--){
            arr[i] += arr[i - 1];
        }
    }
    return arr;
}
```







