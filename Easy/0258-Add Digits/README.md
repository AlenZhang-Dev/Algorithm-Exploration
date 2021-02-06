# 258. Add Digits

Given a non-negative integer `num`, repeatedly add all its digits until the result has only one digit.

**Example:**

```
Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
```

**Follow up:**
Could you do it without any loop/recursion in O(1) runtime?



## Solutions (Java)

### 1. Recursion

```java
class Solution {
    public int addDigits(int num) {
        if(num < 10)
            return num;
        int newNum = 0;
        while(num != 0) {
            newNum += num % 10;
            num /= 10;
        }
        return addDigits(newNum);
    }
}
```

### 2. Iteration

```java
class Solution {
    public int addDigits(int num) {
        int newNum = 0;
        while(num >= 10) {
            while(num != 0) {
                newNum += num % 10;
                num /= 10;
            }
            num = newNum;    
            newNum = 0;        
        }
        return num;
    }
}
```

### 3. Math

```java
class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
```



## Solutions (C++)

### 1. Recursion

```c++
class Solution {
public:
    int addDigits(int num) {
        if(num < 10)
            return num;
        int newNum = 0;
        while(num != 0) {
            newNum += num % 10;
            num /= 10;
        }
        return addDigits(newNum);
    }
};
```

### 2. Iteration

```c++
class Solution {
public:
    int addDigits(int num) {
        int newNum = 0;
        while(num >= 10) {
            while(num != 0) {
                newNum += num % 10;
                num /= 10;
            }
            num = newNum;    
            newNum = 0;        
        }
        return num;
    }
};
```

### 3. Math

```c++
class Solution {
public:
    int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
};
```

