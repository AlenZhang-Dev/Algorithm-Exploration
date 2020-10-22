# 48. 最长不含重复字符的子字符串

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

示例 1:

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

示例2：

~~~
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
~~~

示例3:

~~~
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
~~~

提示：

- `s.length <= 40000`


## 解析

直观上看本题可以使用蛮力法进行求解，但蛮力法的劣势为效率，该解法的效率为O(n ^ 3)。

考虑使用动态规划进行效率的提升。如果第i个字符之前没有出现过，那么f(i) = f(i - 1) + 1。

如果第i个字符之前出现过，则需要比较第i个字符上次出现在字符串中的位置和距离d，如果d小于或等于f(i - 1) 的情况，那么当前f(i)更新为d，反之f(i) = f(i - 1) + 1。

返回数组中最大值即可。

## 题解

### Java

**DP + HashMap**

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++){
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1: j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }
}

```





