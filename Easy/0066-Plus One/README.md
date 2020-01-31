# 66. Plus One



Given a **non-empty** array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

**Example 1:**

```
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
```

**Example 2:**

```
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
```



## Solutions (C)

### 1. Math

```c
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
        int i;
        for(i = digitsSize - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                *returnSize = digitsSize;
                return digits;
            }
            else 
                digits[i] = 0;
        }
        int* digitsplus = (int*) malloc ((digitsSize + 1) * sizeof(int));
        digitsplus[0] = 1;
        for(i = 1; i < (digitsSize + 1); i++)
            digitsplus[i] = 0;
        *returnSize = digitsSize + 1;
        return digitsplus;
}
```

> Runtime: **0 ms** Memory Usage: **7 MB**



## Solutions (Java)

### 1. Math 

```java
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) 
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```

> Runtime: **0 ms** Memory Usage: **37.9 MB**