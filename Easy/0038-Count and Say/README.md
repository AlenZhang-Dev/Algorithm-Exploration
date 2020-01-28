# 35. Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```

`1` is read off as `"one 1"` or `11`.
`11` is read off as `"two 1s"` or `21`.
`21` is read off as `"one 2`, then `one 1"` or `1211`.

Given an integer *n* where 1 ≤ *n* ≤ 30, generate the *n*th term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.

 

**Example 1:**

```
Input: 1
Output: "1"
Explanation: This is the base case.
```

**Example 2:**

```
Input: 4
Output: "1211"
Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
```



## Solutions (C)

### Brute Force 

```c
char * countAndSay(int n){
    char *res = (char*)malloc(sizeof(char) * 5000);
    char *tmp = (char*)malloc(sizeof(char) * 5000);
    res[0] = '1'; res[1] = '\0';    
    int len = 1;                     
    while (--n) {
        int i = 0, j = 0;
        while(i < len) {             
            int count = 1;
            char c = res[i++];
            while (i < len && res[i] == c)    
                i++,count++;
            tmp[j++] = count + '0';          
            tmp[j++] = c;
        }
        tmp[j] = '\0';
        strcpy(res, tmp);                   
        len = j;
    }
    return res;
}
```

> Runtime: **0 ms** Memory Usage: **7.3 MB**