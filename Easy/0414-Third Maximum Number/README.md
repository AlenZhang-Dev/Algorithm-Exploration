# 414. Third Maximum Number

Given a **non-empty** array of integers, return the **third** maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

**Example 1:**

```
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
```

**Example 2:**

```
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
```

**Example 3:**

```
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
```



中文题解：

> 依次找出最大数，每找到一个，将该最大值覆盖为Integer.MIN_VALUE，直到找到第三个返回。
> 设置变量count控制寻找次数，确保找到第三大时停止。
> 处理特殊情况：去重后数组数量小于3的数组，比如[1],[1,2],[1,1,1,2]...。此处通过sum控制覆盖次数，若覆盖次数等于数组长度，则为特殊情况，返回第一次找到的最大值bpmax。
>

## Solutions (Java)

### 1. Brute Force

```java
class Solution {
    public int thirdMax(int[] nums) {
        int sum = 0;
        int i = 0;
        int bpmax = 0;
    
        for(int count = 0; count < 3; count++){
            int max = nums[0];
            for(i = 1; i < nums.length; i++){
                if(nums[i] > max)
                    max = nums[i];
            }
            
            if(count == 2 && sum < nums.length)
                return max;
            else if(count == 0)
                bpmax =max;
          
            for(i = 0; i < nums.length; i++){
                if(nums[i] == max){
                    nums[i] = Integer.MIN_VALUE;
                    sum++;
                }
            }
        }
        return bpmax;
    }
}
```



### 2. Compare

```java
class Solution {
		public int thirdMax(int[] nums) {
      	long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;
      	for (int num : nums) {
          	if (thirdMax >= num || secondMax == num || firstMax == num)
       					continue;
        		if (firstMax < num) {
              	thirdMax = secondMax;
              	secondMax = firstMax;
              	firstMax = num;
            } else if (secondMax < num) {
              	thirdMax = secondMax;
              	secondMax = num;
            } else if (thirdMax < num){
              	thirdMax = num;
            }
        }
      	return (int)(thirdMax == Long.MIN_VALUE ? (int)firstMax : (int)thirdMax); 
    }
}
```



