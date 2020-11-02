# 57. 和为s的连续正数序列

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

示例1：

```
输入：target = 9
输出：[[2,3,4],[4,5]]
```

示例 2:

    输入：target = 15
    输出：[[1,2,3,4,5],[4,5,6],[7,8]]

**限制：**

- `1 <= target <= 10^5`

## 解析

借鉴上一题双指针的方法，维护一个滑动窗口。



## 题解

### Java

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        int small = 1;
        int big = 2;
        int mid = (1 + target) / 2;
        int curSum = small + big;
        while(small < mid){
            while(curSum >= target){
                if(curSum == target){
                    int[] tmp = new int[big - small + 1];
                        for(int i = small; i <= big; i++){
                            tmp[i - small] = i;
                        }
                    res.add(tmp);
                }     
                curSum -= small;
                small++;
            }
            big++;
            curSum += big;
        }
        return res.toArray(new int[res.size()][]);
    }
}
```



### Kotlin

```kotlin
class Solution {
    fun findContinuousSequence(target: Int): Array<IntArray> {
        var res = ArrayList<IntArray>()
        var small = 1
        var big = 2
        var mid = (1 + target) / 2
        var curSum = small + big
        while(small < mid){
            while(curSum >= target){
                if(curSum == target){
                    var tmp = IntArray(big - small + 1)
                    for(i in small..big )
                        tmp[i - small] = i
                    res.add(tmp)
                }
                curSum -= small
                small++
            }
            big++
            curSum += big
        }
        return res.toTypedArray()   
    }
}
```

