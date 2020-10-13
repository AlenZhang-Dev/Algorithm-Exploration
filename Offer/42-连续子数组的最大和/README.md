# 42. 连续子数组的最大和

输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

示例1:

```
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

提示：

```
1 <= arr.length <= 10^5
-100 <= arr[i] <= 100
```


## 解析

非常典型的动态规划例题，且为本题的最优解。

假设原数组内容可以修改，对nums[i]数组内容进行递归修改，用nums[i]表示以nums[i]为结束的连续数组最大和的值。

```java
在F(i - 1) <= 0 或者 i = 0的情况下 
		F[i] = nums[i]; 
在F(i - 1) > 0 且 i != 0的情况下
		F[i] = F[i - 1] + nums[i];
```



## 题解

### Java

**动态规划**

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
      	/*不使用库函数
      	for(int i = 1; i < nums.length; i++){
            nums[i] += (nums[i - 1] > 0 ? nums[i - 1] : 0);
            res = nums[i] > res ? nums[i] : res; 
        }
        **/
        return res;
    }
}
```

**贪婪算法**

```java
class Solution {
    public int maxSubArray(int[] nums){
        int sum = 0;
        int res = 0x80000000;
        for(int i = 0; i < nums.length; i++){
           //贪婪算法
           //遇到sum<0的情况时，sum以下一个num开始重现计算
            sum += nums[i];
            res = Math.max(res, sum);
            if(sum < 0)
                sum = 0;
        }
        return res;
    }
}
```





