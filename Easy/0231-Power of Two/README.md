# 231. Power of Two

Given an integer `n`, return *`true` if it is a power of two. Otherwise, return `false`*.

An integer `n` is a power of two, if there exists an integer `x` such that `n == 2x`.

 

**Example 1:**

```
Input: n = 1
Output: true
Explanation: 20 = 1
```

**Example 2:**

```
Input: n = 16
Output: true
Explanation: 24 = 16
```

**Example 3:**

```
Input: n = 3
Output: false
```

**Example 4:**

```
Input: n = 4
Output: true
```

**Example 5:**

```
Input: n = 5
Output: false
```

 

**Constraints:**

- `-231 <= n <= 231 - 1`



## Solutions (C)

### 1. Travel

```c
bool isPowerOfTwo(int n){
    if(n <= 0)
        return false;
    int count = 2;
    while(n != 0 && count){
        if(n & 0x01)
            count--;
        n = ((unsigned int)n) >> 1;
    }
    return count == 1 ? true : false;
}
```

### 2. Math

```c
## Math I
bool isPowerOfTwo(int n){
    if(n <= 0)
        return false;
    return (n & n - 1) == 0 ? true : false;
}


## Math II
bool isPowerOfTwo(int n){
    if(n <= 0)
        return false;
    return (n & - n) == n ? true : false;
}
```



## Soutions (Java)

### 1. Travel

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        while(n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
```



### 2. Math

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
```



## Solutions (Python)

### 1. Travel

```python
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0:
            return False
        while n % 2 == 0:
            n /= 2
        return n == 1
```



### 2. Math

```python
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and n & (n - 1) == 0
```

