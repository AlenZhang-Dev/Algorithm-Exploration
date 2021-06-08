# 18. 4Sum
Given an array `nums` of `n` integers, return *an array of all the **unique** quadruplets* `[nums[a], nums[b], nums[c], nums[d]]` such that:

- `0 <= a, b, c, d < n`
- `a`, `b`, `c`, and `d` are **distinct**.
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

You may return the answer in **any order**.

**Example 1:**

```
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

**Example 2:**

```
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
```

**Constraints:**

- `1 <= nums.length <= 200`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`

## Solutions (Java)

### Pointers

```c
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int c, d;
        for (int i = 0; i <= length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j <= length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                c = j + 1;
                d = length - 1;
                while (c < d) {
                    if (c > j + 1 && nums[c] == nums[c - 1]) {
                        c++;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[c] + nums[d] > target) {
                        d--;
                    }
                    else if (nums[i] + nums[j] + nums[c] + nums[d] < target) {
                        c++;
                    }
                    else {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[c], nums[d])));
                        c++;
                        d--;
                    }
                }
            }
        }
        return res;
    }
}
```



## Solutions (C++)

### pointers

```c++
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        int size = nums.size();
        for (int a = 0; a < size - 3; ++a) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (int b = a + 1; b < size - 2; ++b) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                int c = b + 1, d = size - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum < target)
                        while (c < d && nums[c] == nums[++c]);
                    else if (sum > target)
                        while (c < d && nums[d] == nums[--d]);
                    else {
                        result.push_back(vector<int>{nums[a], nums[b], nums[c], nums[d]});
                        while (c < d && nums[c] == nums[++c]);
                        while (c < d && nums[d] == nums[--d]);
                    }
                }
            }
        }
        return result;
    }
};
```

