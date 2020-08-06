# 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."


限制：

0 <= s 的长度 <= 10000



### 1. 字符数组

使用额外空间。

```java
class Solution {
    public String replaceSpace(String s) {
        // create a new string 
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                newString.append("%20");
            }else{
                newString.append(ch);
            }
        }
        return newString.toString();
    }
}
```

### 2. 变长数组

使用`O(n)`的解法，不利用额外空间，总体思路如书本介绍。

Java

```java
class Solution {
    public String replaceSpace(String str) {
   		 	int len1 = str.length() - 1;
        for(int i = 0; i <= len1; i++){
            if(str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        int len2 = str.length() - 1;
        while(len2 > len1 && len1 >= 0){
            char c = str.charAt(len1--);
            if(c == ' '){
                str.setCharAt(len2--, '0');
                str.setCharAt(len2--, '2');
                str.setCharAt(len2--, '%');
            }else{
                str.setCharAt(len2--, c);
            }
        }
        return str.toString();    
    }
}
```

C++

```c++
class Solution {
public:
	void replaceSpace(char *str,int length) {
        if(str == NULL)
                return;
        //count the really string length
        int originalLength = 0;
        int numberOfBlank = 0;
        int i = 0;
        
        while(str[i] != '\0'){
            originalLength++;
            if(str[i] == ' '){
                numberOfBlank++;
            }       
            i++;
        }
        
        int newLength = originalLength + numberOfBlank * 2;
        if(newLength > length)
            return;
        
        int indexOfOrignial = originalLength;
        int indexOfNew = newLength;
        while(indexOfOrignial >= 0 && indexOfNew > indexOfOrignial){
               if(str[indexOfOrignial] == ' '){
                   str[indexOfNew --] = '0';
                   str[indexOfNew --] = '2';
                   str[indexOfNew --] = '%';
               }else{
                   str[indexOfNew --] = str[indexOfOrignial];
               }
               --indexOfOrignial;
	    }
    }
};
```

