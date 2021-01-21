# 204. Count Primes

Count the number of prime numbers less than a non-negative number, `n`.

**Example 1:**

```
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
```

**Example 2:**

```
Input: n = 0
Output: 0
```

**Example 3:**

```
Input: n = 1
Output: 0
```

 

**Constraints:**

- `0 <= n <= 5 * 106`



## Solutions (C)

### 1. Brute Force


```c
int countPrimes(int n){
    int res = 0;
    for(int i = 2; i < n; i++){
        if(isPrime(i))
            res++;
    }
    return res;
}

int isPrime(int num){
    for(int i = 2; i * i <= num; i++){
        if(num % i == 0){
            return false;
        }
    }
    return true;
}
```

### 2. the Sieve of Eratosthenes

```c
int countPrimes(int n){
    if(n < 1)
        return 0;
    bool isPrime[n];
    memset(isPrime, true, n);
    for(int i = 2; i * i < n; i++){
        if(isPrime[i]){
            for(int j = i * i; j < n; j += i){
                isPrime[j] = false;
            }
        }
    }
    int res = 0;
    for(int i = 2; i < n; i++){
        if(isPrime[i])
            res++;
    }
    return res;
}
```



## Solutions (Java)

### 1. Brute Force

```c
class Solution {
    public int countPrimes(int n) {
        int res = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i))
                res++;
        }
        return res;
    }
    
    boolean isPrime(int num){
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
```

### 2. the Sieve of Eratosthenes

```java
class Solution {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i = 2; i * i < n; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2; i < n; i++) {
            if(isPrime[i]){
                res++;
            }
        }
        return res;
    }
}
```

