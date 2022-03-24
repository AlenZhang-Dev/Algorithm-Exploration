# 242.  Valid Anagram

Given two strings *s* and *t* , write a function to determine if *t* is an anagram of *s*.

**Example 1:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**

```
Input: s = "rat", t = "car"
Output: false
```

**Note:**
You may assume the string contains only lowercase alphabets.

**Follow up:**
What if the inputs contain unicode characters? How would you adapt your solution to such case?



## Solutions (C++)

```c++
class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size())
            return false;
        int records[26] = {0};
        for (int i = 0; i < s.size(); i++) {
            records[s[i] - 'a']++;
            records[t[i] - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if (records[i] != 0)
                return false;
        }
        return true;
    }
};
```



## Solutions (Java)

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] records = new int[26];
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
            records[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(records[i] != 0)
                return false;
        }
        return true;
    }
}
```







