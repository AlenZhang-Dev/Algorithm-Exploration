# 53. 在排序数组中查找数字

统计一个数字在排序数组中出现的次数。

示例 1:

```
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
```

示例 2:

```
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
```


限制：

`0 <= 数组长度 <= 50000`

## 解析

通过两次二分查找找到数字的左右节点。



## 题解

### Java

```java
class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            int m = (i + j) / 2;
            if(nums[m] <= target)
                i = m + 1;
            else 
                j = m - 1;
        }
        int right = i;
    
        i = 0; 
        j = nums.length - 1;
        while(i <= j){
            int m = (i + j) / 2;
            if(nums[m] < target)
                i = m + 1;
            else 
                j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
}
```

Java改进

```java
class Solution {
    public int search(int[] nums, int target) {
        return classify(nums, target) - classify(nums, target - 1);
    }

    int classify(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int m = (i + j) / 2;
            if(nums[m] <= target)
                i = m + 1;
            else 
                j = m - 1;
        }
        return i;
    }
}
```

### Pthon

```python
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            if nums[m] <= target: i = m + 1
            else: j = m - 1
        right = i
        i = 0
        while i <= j:
            m = (i + j) // 2
            if nums[m] < target: i = m + 1
            else: j = m - 1
        left = j
        return right - left - 1
```

