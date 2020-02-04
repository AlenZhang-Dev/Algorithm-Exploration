# 67. Add Binary

Given two binary strings, return their sum (also a binary string).

The input strings are both **non-empty** and contains only characters `1` or `0`.

**Example 1:**

```
Input: a = "11", b = "1"
Output: "100"
```

**Example 2:**

```
Input: a = "1010", b = "1011"
Output: "10101"
```



## Solutions (C)

### 1. Math

```c
char * addBinary(char * a, char * b){
    int alen = strlen(a);
    int blen = strlen(b);
    int length = (alen > blen) ? alen + 2 : blen + 2;
    char* c = (char*)malloc(length*(sizeof(char)));
    memset(c, '0', length);
    c[length - 1] = '\0';
    for(length -= 2; length > 0; length--){
        int an = (alen > 0) ? a[--alen] - '0'  : 0;
        int bn = (blen > 0) ? b[--blen] - '0' : 0;
        c[length] += (an + bn);
        if(c[length] == '2'){
            c[length] = '0';
            c[length - 1] ++;
        }
        else if(c[length] == '3'){
            c[length] = '1';
            c[length - 1] ++;
        }
    }
    if(c[0] == '0')
        c++;
    return c;
}
```

> Runtime: **0 ms** Memory Usage: **6.9 MB**
