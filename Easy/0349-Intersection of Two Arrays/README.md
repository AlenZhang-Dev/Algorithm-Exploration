# 349. Intersection of Two Arrays

Given two integer arrays `nums1` and `nums2`, return *an array of their intersection*. Each element in the result must be **unique** and you may return the result in **any order**.

 

**Example 1:**

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
```

**Example 2:**

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
```

 

**Constraints:**

- `1 <= nums1.length, nums2.length <= 1000`
- `0 <= nums1[i], nums2[i] <= 1000`



## Solutions (C++)

```c
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> result;
        unordered_set<int> nums(nums1.begin(), nums1.end());
        for (int num : nums2) {
            if (nums.find(num) != nums.end()){
                result.insert(num);
            }
        }
        return vector<int>(result.begin(), result.end());
    }
};
```





## Solutions (Java)

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> nums = new HashSet<>();

        for (int num : nums1) {
            nums.add(num);
        }

        for (int i : nums2) {
            if (nums.contains(i)) {
                result.add(i);
            }
        }
        
        int[] res = new int[result.size()];
        int index = 0;
        for (int i : result) {
            res[index++] = i;
        }
        return res;

    }
}
```

