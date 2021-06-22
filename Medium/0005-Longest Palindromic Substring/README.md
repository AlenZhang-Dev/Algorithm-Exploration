# 05. Longest Palindromic Substring

Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 1000.

**Example 1:**

```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

**Example 2:**

```
Input: "cbbd"
Output: "bb"
```



## Solutions (Java)

### 1. 

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] status = new int[128];
        for (int i = 0; i < 128; i++) {
            status[i] = -1;
        }
        
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, status[index] + 1);
            max = Math.max(max, i - start + 1);
            status[index] = i;
        }
        return max;
    }
}
```

### 2. Sliding Windows

```java
class Solution{
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int Max = 0;
        int Left = 0;
        for (int i = 0; i < s.length() ; i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                Left = Math.max(Left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i) , i);
            Max = Math.max(Max , i - Left + 1);
        }
        return Max;
    }
}
```

