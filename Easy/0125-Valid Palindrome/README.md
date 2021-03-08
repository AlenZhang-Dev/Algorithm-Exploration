# 125. Valid Palindrome

Given a string `s`, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

**Example 1:**

```
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```

**Example 2:**

```
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
```

 

**Constraints:**

- `1 <= s.length <= 2 * 105`
- `s` consists only of printable ASCII characters.



## Solutions (Java)

```java
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null)
            return true;
        s = s.toLowerCase();
        int length = s.length();
        StringBuilder str = new StringBuilder(length);
        //ignore the mark
        for (char letter : s.toCharArray()) {
            if ((letter >= '0' && letter <= '9') || (letter >= 'a' && letter<= 'z')) {
                str.append(letter);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}
```



