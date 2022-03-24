# 15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
```

Example 2:

```
Input: nums = []
Output: []
```


Example 3:

```
Input: nums = [0]
Output: []
```

**Constraints:**

* 0 <= nums.length <= 3000
* -105 <= nums[i] <= 105

## Solutions (C++)

```c++
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.size() - 1;

            while (right > left) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
                else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    result.push_back(vector<int>{nums[i], nums[left], nums[right]});
               
                    while (right > left && nums[right] == nums[right - 1])
                        right--;

                    while (right > left && nums[left] == nums[left + 1]) 
                        left++;

                    left++;
                    right--;
                }
            }
        }
        return result;
    }
};
```



## Solutions (Java)

### 1. Two Pointers

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            // Array is sorted, return if nums[i] > 0
            if (nums[i] > 0)
                return returnList;
            // De-duplication
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int cur = nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int result = cur + nums[left] + nums[right];
                if (result == 0){
                    List<Integer> List = new ArrayList<>();
                    List.add(cur);
                    List.add(nums[left]);
                    List.add(nums[right]);
                    returnList.add(List);
                    while(left < right && nums[left + 1] == nums[left])
                        ++left;
                    while (left < right && nums[right - 1] == nums[right])
                        --right;
                    ++left;
                    --right;
                } else if (result < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return returnList;
    }
}
```
