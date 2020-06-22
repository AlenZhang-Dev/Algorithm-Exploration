# 217. Contains Duplicate

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

**Example 1:**

```
Input: [1,2,3,1]
Output: true
```

**Example 2:**

```
Input: [1,2,3,4]
Output: false
```

**Example 3:**

```
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```



## Solutions (Java)

### 1. Linear Search

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; ++i){
            for(int j = 0; j < i; j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
```

### 2. Sort

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; ++i){
            if(nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
```

### 3. Hash Table

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int x: nums){
            if(!set.add(x)){
                return true;
            }
        }
        return false;
    }
}
```

