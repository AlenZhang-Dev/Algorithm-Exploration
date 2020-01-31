# Length of Last Word



Given a string *s* consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

**Note:** A word is defined as a **maximal substring** consisting of non-space characters only.

**Example:**

```
Input: "Hello World"
Output: 5
```



## Solutions (C)

```C
int lengthOfLastWord(char * s){
    if(!s || s == "")
        return 0;
    int len = strlen(s);
    int i, j;
    for(i = len - 1; i >= 0 && s[i] == ' ';i--);
    for(j = i; j >= 0 && s[j] != ' ';j--);
    return i - j;
}

```

> Runtime: **4 ms** Memory Usage: **6.9 MB**