# 20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

#### **Example 1:**

```html
Input: "()"
Output: true
```

#### **Example 2:**

```
Input: "()[]{}"
Output: true
```

#### **Example 3:**

```
Input: "(]"
Output: false
```

#### **Example 4:**

```
Input: "([)]"
Output: false
```

#### **Example 5:**

```
Input: "{[]}"
```



## Solutions (C)

### 1.Stacks

```c
bool isValid(char * s){
    int len = 0; 
    while(*(s+len))
        len++;
    if(!len)
        return true;
    if(len == 1)
        return false;
    char a[len/2+1];
    int i,j;     
    for(i=0,j=0; i<len; i++)
    {
        if(s[i] =='(' || s[i] == '{' || s[i] == '[')
            {
            		a[j] = s[i];
           			j++;
            }
        else if(j!=0 && ( s[i]-1 == a[j-1] || s[i]-2 == a[j-1]))
            j--;
        else
        		return false;
    }
    if(j)
        return false;
    return true;
}
```



## Solutions (C++) 

```c++
class Solution {
public:
    bool isValid(string s) {
        stack<int> st;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') 
                st.push(')');
            else if (s[i] == '[')
                st.push(']');
            else if (s[i] == '{')
                st.push('}');
            else if (st.empty() || st.top() != s[i]) 
                return false;
            else 
                st.pop();
        }
        return st.empty();
    }
};
```

