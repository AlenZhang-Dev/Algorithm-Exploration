# 605. Can Place Flowers

Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number **n**, return if **n** new flowers can be planted in it without violating the no-adjacent-flowers rule.

**Example 1:**

```
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
```



**Example 2:**

```
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
```



**Note:**

1. The input array won't violate no-adjacent-flowers rule.
2. The input array size is in the range of [1, 20000].
3. **n** is a non-negative integer which won't exceed the input array size.



## Solutions (Java)

### 1. Brute Force [Improved]

```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0,count = 1;  //假设在数组左边添加0，以解决边界问题，令count初始为1
        for (int i=0;i<flowerbed.length;i++){
            if (flowerbed[i] == 0){
                count++;
            }else{
                count = 0;
            }
            if (count == 3){    //每连续三个0种一次花
                num++;
                count = 1;
            }
        }
        if (count == 2){    //如果最后count为2而不是1，表示最后一个位置可以种花
            num++;
        }
        return n <= num;
    }
}
```
