# 171. Excel Sheet COlumn Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
```

**Example 1:**

```
Input: "A"
Output: 1
```

**Example 2:**

```
Input: "AB"
Output: 28
```

**Example 3:**

```
Input: "ZY"
Output: 701
```

 

**Constraints:**

- `1 <= s.length <= 7`
- `s` consists only of uppercase English letters.
- `s` is between "A" and "FXSHRXW".



## Solutions (Java)

```java
class Solution {
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        for(int i = 0; i < charArray.length; i++) {
            res = res * 26 + (charArray[i] - 'A' + 1);
        }
        return res;
    }
}
```



## Solutions (Python)

```python
class Solution:
    def titleToNumber(self, s: str) -> int:
        res = 0
        for i in s:
            res *= 26
            res += ord(i) - ord('A') + 1
        return res
```

