# 42. Trapping rain water

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining. 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

**Example 2:**

```
Input: height = [4,2,0,3,2,5]
Output: 9
```

 

**Constraints:**

- `n == height.length`
- `1 <= n <= 2 * 104`
- `0 <= height[i] <= 105`

## Solutions (C++)

### Two pointers

```c++
class Solution {
public:
    int trap(vector<int>& height) {
        int total = 0;
        for (int i = 1; i < height.size() - 1; i++) {
            int rHeight = height[i];
            int lHeight = height[i];
            for (int r = i + 1; r < height.size(); r++) {
                if (height[r] > rHeight) {
                    rHeight = height[r];
                }
            }
            for (int l = 0; l < i; l++) {
                if (height[l] > lHeight) {
                    lHeight = height[l];
                }
            }
            int h = min(lHeight, rHeight) - height[i];
            total += h;
        }
        return total;
    }
};
```

DP

```c++
class Solution {
public:
    int trap(vector<int>& height) {
        int sum = 0;
        if (height.size() <= 2)
            return sum;
        vector<int> maxLeft(height.size(), 0);
        vector<int> maxRight(height.size(), 0);
        int size = height.size();

        maxLeft[0] = height[0];
        for (int i = 1; i < size; i++) {
            maxLeft[i] = max(height[i], maxLeft[i - 1]);
        }
        maxRight[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxRight[i] = max(height[i], maxRight[i + 1]);
        }
        for (int i = 0; i < size; i++) {
            int count = min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0)
                sum += count;
        }
        return sum;
    }
};
```

