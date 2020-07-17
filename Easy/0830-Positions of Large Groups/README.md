# 830. Positions of Large Groups



In a string `S` of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like `S = "abbxxxxzyy"` has the groups `"a"`, `"bb"`, `"xxxx"`, `"z"` and `"yy"`.

Call a group *large* if it has 3 or more characters. We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.

**Example 1:**

```
Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
```

**Example 2:**

```
Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
```

**Example 3:**

```
Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
```



## Solutions (Java)

### 1. Brute Force

```java
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        S = S + "A";
        List<List<Integer>> result = new ArrayList<>();
        int begin = 0;
        for(int i = 1;i<S.length();i++){
            if(S.charAt(i) != S.charAt(i - 1)){
                if(i - begin >= 3){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(begin);
                    temp.add(i - 1);
                    result.add(temp);
                }
                begin = i;
            }
        }
        return result;
    }
}
```

