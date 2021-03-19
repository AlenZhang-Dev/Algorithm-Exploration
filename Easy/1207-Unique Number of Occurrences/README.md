# 1207. Unique Number of Occurrences

Given an array of integers `arr`, write a function that returns `true` if and only if the number of occurrences of each value in the array is unique.

**Example 1:**

```
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
```

**Example 2:**

```
Input: arr = [1,2]
Output: false
```

**Example 3:**

```
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
```

**Constraints:**

- `1 <= arr.length <= 1000`
- `-1000 <= arr[i] <= 1000`





## Solutions (C++)

```c++
class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        int count[2002] = {0};
        //count the time.
        for (int i = 0; i < arr.size(); i++) {
            count[arr[i] + 1000]++;
        }
        //check if duplication
        bool check[1002] = {false};
        for (int i = 0; i <= 2000; i++) {
            if(count[i]) {
                if(check[count[i]] == false)
                    check[count[i]] = true;
                else
                    return false;
            }
        }
        return true;
    }
};
```

## Solutions (Java)

```java
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //use map to count.
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(int m : map.keySet()){
            set.add(map.get(m));
        }
        return map.size() == set.size();
    }
}
```





