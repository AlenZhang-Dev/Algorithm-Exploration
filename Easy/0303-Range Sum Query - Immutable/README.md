# 303. Range Sum Query-Immutable

Given an integer array *nums*, find the sum of the elements between indices *i* and *j* (*i* ≤ *j*), inclusive.

**Example:**

```
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```

**Note:**

1. You may assume that the array does not change.
2. There are many calls to *sumRange* function.

> **It's a classic example of dynamic programming.**



## Solutions (C)

### 1. Dynamic programming

```c
typedef struct {
    int *nums;
    int *sums;
} NumArray;

NumArray* numArrayCreate(int* nums, int numsSize) {
    if(numsSize == 0)
        return NULL;
    NumArray *myArray = (NumArray *)malloc(sizeof(NumArray));
    myArray->nums = nums;
    myArray->sums = (int *)malloc(numsSize * sizeof(int));
    myArray->sums[0] = nums[0];
    for(int i = 1; i < numsSize; i++){
        myArray->sums[i] = myArray->sums[i-1] + nums[i];
    }
    return myArray;
}

int numArraySumRange(NumArray* obj, int i, int j) {
    return(obj->sums[j] - obj->sums[i] + obj->nums[i]);
}

void numArrayFree(NumArray* obj) {
    if(obj != NULL){
        free(obj->sums);
        free(obj);
    }
}

/**
 * Your NumArray struct will be instantiated and called as such:
 * NumArray* obj = numArrayCreate(nums, numsSize);
 * int param_1 = numArraySumRange(obj, i, j);
 
 * numArrayFree(obj);
*/

```



## Solutions (Java)

### 1. Dynamic programming

```java
class NumArray {
    private int sum[];

    public NumArray(int[] nums) {
        sum = new int[nums.length +1];
        for( int i = 0; i < nums.length; i++){
            sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
```




