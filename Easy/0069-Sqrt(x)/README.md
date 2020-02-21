# 69. Sqrt(x)

Implement `int sqrt(int x)`.

Compute and return the square root of *x*, where *x* is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```
Input: 4
Output: 2
```

**Example 2:**

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```



## Solutions (C)

### 1. Binary Search Algorithm

```c
int mySqrt(int x){
    if(x == 1)
        return 1;
    int min = 0;
    int max = x;
    while(max - min > 1){
        int middle = (max + min) / 2;
        if(x / middle < middle)
            max = middle;
        else 
            min = middle;
    }
    return min;
}
```

> Runtime: **4 ms** Memory Usage: **6.9 MB**
