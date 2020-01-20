# 28.  Implement strStr()

Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack.

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

**Clarification:**

What should we return when `needle` is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's [strstr()](http://www.cplusplus.com/reference/cstring/strstr/) and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)).



## Solutions (C)

### 1. Brute Force

```c
int strStr(char * haystack, char * needle){
        int i = 0, j = 0, temp;
        bool flag = true;
        if(needle[0] == '\0')
            return 0;
        while(haystack[i] != '\0'){
            if(haystack[i] == needle[j]){
                if(flag){
                    temp = i;
                    flag = false;
                }
                j++;
                if(needle[j] == '\0')
                    return temp;
            }
            else{
                if(!flag){
                    flag = true;
                    j = 0;
                    i = temp;
                }
            }
            i++;
        }
        return -1;
}
```

> Runtime: **4 ms** Memory Usage: **7.1 MB**