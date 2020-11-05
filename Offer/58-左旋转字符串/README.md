# 58. 左旋转字符串

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

示例1：

```
输入: s = "abcdefg", k = 2
输出: "cdefgab"
```

示例 2:

    输入: s = "lrloseumgh", k = 6
    输出: "umghlrlose"

**限制：**

- `1 <= k < s.length <= 10000`

## 解析

对数组进行三次翻转得到结果。



## 题解

### C++

**多次翻转**

~~~c++
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        reverse(s.begin(), s.begin() + n);
        reverse(s.begin() + n, s.end());
        reverse(s.begin(), s.end());
        return s;
    }
};
~~~



### Java

**字符串切分**

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
```

列表拼接

```java
//使用StringBuilder
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length() + n; i++)
            res.append(s.charAt(i % s.length());
        return res.toString();
    }
}
//使用String                       
class Solution {
    public String reverseLeftWords(String s, int n) {
       String res = "";
        for(int i = n; i < s.length() + n; i++)
            res += s.charAt(i % s.length()) ;
        return res;
    }
}
```



### Kotlin

**字符串切分**

```kotlin
class Solution {
    fun reverseLeftWords(s: String, n: Int): String {
        return s.substring(n, s.length) + s.substring(0, n)
    }
}
```

