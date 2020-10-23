# 50. 第一个只出现一次的字符

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

```
s = "abaccdeff"
返回 "b"
s = "" 
返回 " "
```


限制：

`0 <= s 的长度 <= 50000`

## 解析

使用哈希表即可。



## 题解

### Java

```java
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] tmp = s.toCharArray();
        for(char c : tmp)
            map.put(c, !map.containsKey(c));
        for(char c : tmp)
            if(map.get(c))
                return c;
        return ' ';
    }
}
```



