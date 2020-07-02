# 448. Find All Numbers Disappeared In An Array

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```



中文题解：

>【笔记】将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
>
>举个例子：
>
>原始数组：[4,3,2,7,8,2,3,1]
>
>重置后为：[-4,-3,-2,-7,8,2,-3,-1]
>
>结论：[8,2] 分别对应的index为[5,6]（消失的数字）



## Solutions (Java)

### 1. Brute Force

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> array = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
           nums[(nums[i] - 1) % n] += n;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= n)
                array.add(i + 1);
        }
        return array;
    }
}
```




