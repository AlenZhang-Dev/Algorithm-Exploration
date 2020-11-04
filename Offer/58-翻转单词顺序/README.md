# 58. 翻转单词顺序

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

示例1：

```
输入: "the sky is blue"
输出: "blue is sky the"
```

示例 2:

    输入: "  hello world!  "
    输出: "world! hello"
    解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：

```
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

说明：

* 无空格字符构成一个单词。
* 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
* 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

**限制：**

- `1 <= target <= 10^5`

## 解析

* 对数组进行分割，然后逆序输出。
* 双指针。



## 题解

### Java

**逆序**

```java
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");//split by space
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--){
            if(strs[i].equals(""))
                continue;
            res.append(strs[i] + " ");
        }
        return res.toString().trim();
    }
}
```

**双指针**

```java
class Solution {
    public String reverseWords(String s) {
        //Two-pointer
        s = s.trim();
        int left = s.length() - 1;
        int right = left;
        StringBuilder res = new StringBuilder();
        while(right >= 0){
            //找到第一个空格
            while(right >= 0 && s.charAt(right) != ' ')
                right--;
            res.append(s.substring(right + 1, left + 1) + " ");
            while(right >= 0 && s.charAt(right) == ' ')
                right--;
            left = right;
        }
        return res.toString().trim();
    }
}
```



### Kotlin

**双指针**

```kotlin
class Solution {
    fun reverseWords(s: String): String {
        var s = s.trim {it <= ' ' }
        var right = s.length - 1
        var left = s.length - 1
        val res = StringBuilder()
        
        while(left >= 0){
            while(left >= 0 && s[left] != ' ')
                left--
            res.append(s.substring(left + 1, right + 1) + " ")
            
            while(left >= 0 && s[left] == ' ')
                left--

            right = left
        }
        return res.toString().trim{it <= ' '}
    }
}
```

