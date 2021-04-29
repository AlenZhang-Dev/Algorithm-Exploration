# 169. Majority Element

Given an array of size *n*, find the majority element. The majority element is the element that appears **more than** `⌊ n/2 ⌋` times.

You may assume that the array is non-empty and the majority element always exist in the array.

**Example 1:**

```
Input: [3,2,3]
Output: 3
```

**Example 2:**

```
Input: [2,2,1,1,1,2,2]
Output: 2
```



## Solutions (C)

1. **Boyer-Moore Voting** 

```c
int majorityElement(int* nums, int numsSize){
    int count = 0, major = 0;
    for (int i = 0; i < numsSize; i++){
        if(count == 0)
            major = nums[i];
        count += (major == nums[i] ? 1 : -1);
    }
    return major;
}
```



## Solutions (C++)

**Boyer-Moore Voting**

```c++
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count = 0, major = 0;
        for(auto& num : nums){
            if(count == 0)
                major = num;
            count += (major == num ? 1 : -1);
        }
        return major;
    }
};
```

**Map**

```c++
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int, int> count;
        for(int i = 0; i < nums.size(); i++){
            count[nums[i]]++;
            if(count[nums[i]] > nums.size() / 2)
                return nums[i];
        }
        return -1;
    }
};
```

**Sort**

```c++
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        return nums[nums.size() / 2];
    }
};
```



## Solutions(Java)

**Boyer-Moore Voting **

```java
class Solution {
    public int majorityElement(int[] nums) {
				int count = 0, major = 0;
      	for(int num : nums){
          	if(count == 0)
              	major = num;
          	count += major == num ? 1 : -1;
        }
      	return major;
    }
}
```

**Sort**

```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
```

**Hashmap**

```java
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums){
            //return the number of num stored in hashmap
            int count = counts.getOrDefault(num, 0) + 1;
            if(count > nums.length / 2)
                return num;
            counts.put(num, count); 
        }
        return -1;
    }
}
```

