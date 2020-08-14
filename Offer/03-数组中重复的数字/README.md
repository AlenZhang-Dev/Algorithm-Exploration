# 03. 数组中重复的数字
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

```
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```


限制：

`2 <= n <= 100000`



## 题解（Java）

### 1. 排序

将数组重新排序，从头到尾扫描即可。

局限：排序数组的时间复杂度为O(nlogn)。

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        return -1;
    }
}
```

### 2.  使用HashSet

因为加入数据不能重复，有重复的返回即可。

局限：效率不高，时间效率是一个大小为`O(n)`的哈希表为代价的。

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return num;
        }
        return -1;
    }
}
```

### 3.  Swap

如果数组中没有重复数字，那么数组的下标对应数组的值。遍历数组，判断当前数组下标与值是否相等，如果不相等，将当前值和当前值对应下标处的值进行交换。

退出条件：当前数组值对应的下标处的值和对应下标处的值相等。

时间复杂度：`O(n)` ；空间复杂度`O(1)`

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]])
                    return nums[i];
                //swap the nums to the right position
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            } 
        }
        return -1;
    }
}
```

### 4. 辅助数组

空间换时间。

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        int[] temp = new int [length];
        for(int num : nums){
            temp[num]++;
            if(temp[num] > 1)
                return num;
        }
        return -1;
    }
}
```





## 改进：不修改数组找出重复的数字

在一个长度为n+1的数组里的所有数字都在1～n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入数组，例如，如果输入长度为8的数组{2，3，5，4，3，2，6，7}，那么对应输出的重复数字2或3。

1. 辅助数组
2. 二分查找算法