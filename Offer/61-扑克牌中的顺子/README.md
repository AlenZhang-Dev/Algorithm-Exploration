# 61. 扑克牌中的顺子

从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

示例1：

```
输入: [1,2,3,4,5]
输出: True
```

示例 2:

    输入: [0,0,1,2,5]
    输出: True

**限制：**

数组长度为 5 

数组的数取值为 [0, 13] .

## 解析

方法一：

大小王可以替代任何数，可以使用大小王对数组进行填补。我们需要有足够的大小王去填补数字之间的空缺。

通过计算数组间相邻数字之间的空缺总数和大小王的总数，如果空缺总数小于或等于大小王的总数，那么这个数字就是连续的。

方法二：

根据数组是需要排序的，因此除大小王之外数据是没有重复的。一共五张牌，因此该数组值的最大值减去该数组最小值小于5。

如果满足以上两个条件，那么便可以称扑克牌是顺子。

## 题解

### C++

**方法一**

~~~c++
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        int numberOfZero = 0;
        int numberOfGap = 0;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < 4; i++){
            if(nums[i] == 0)
                numberOfZero++;
            else if(nums[i + 1] == nums[i])
                return false;
            else
                numberOfGap += (nums[i + 1] - nums[i] - 1);
        }
        return (numberOfGap > numberOfZero) ? false : true;
    }
};
~~~



### Java

**方法一**

```java
class Solution {
    public boolean isStraight(int[] nums) {
        int numberOfZero = 0;
        int numberOfGap = 0;
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++){
            if(nums[i] == 0)
                numberOfZero++;
            else if(nums[i] == nums[i + 1])
                return false;
            else
                numberOfGap += (nums[i + 1] - nums[i] - 1);
        }
        return (numberOfGap > numberOfZero) ? false : true;
    }
}
```

**方法二**

```java
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        int max = 0; 
        int min = 14;
        for(int i : nums){
            if(i == 0)
                continue;
            //get the max and min
            max = (i > max) ? i : max;
            min = (i < min) ? i : min;
            if(tmp.contains(i))
                return false;
            tmp.add(i);
        }
        return (max - min) < 5;
    }
}
```



