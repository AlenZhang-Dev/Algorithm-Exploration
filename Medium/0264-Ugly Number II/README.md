# 264. Ugly Number II

Write a program to find the `n`-th ugly number.

Ugly numbers are **positive numbers** whose prime factors only include `2, 3, 5`. 

**Example:**

```
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
```

**Note:** 

1. `1` is typically treated as an ugly number.
2. `n` **does not exceed 1690**.

 

## Solutions (Java)

```java
class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int arr[] = new int[n];
        arr[0] = 1;
        int i = 1;
        while(i < n){
            int min = Math.min(Math.min(arr[p2] * 2,arr[p3] * 3), arr[p5] * 5);
            arr[i] = min;
            if(arr[p2] * 2 == arr[i])
                p2++;
            if(arr[p3] * 3 == arr[i])
                p3++;
            if(arr[p5] * 5 == arr[i])
                p5++;
            ++i;
        }
        return arr[n - 1];
    }
}
```

## Solutions (Python)

```python
class Solution(object):
    def nthUglyNumber(self, n):
        dp, a, b, c = [1] * n, 0, 0, 0
        for i in range(1, n):
            n2, n3, n5 = dp[a] * 2, dp[b] * 3, dp[c] * 5
            dp[i] = min(n2, n3, n5)
            if dp[i] == n2 : a += 1
            if dp[i] == n3 : b += 1
            if dp[i] == n5 : c += 1
        return dp[-1]
```

