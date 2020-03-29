# 167. Two Sum II - Input array is sorted

Given an array of integers that is already ***sorted in ascending order\***, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

**Note:**

- Your returned answers (both index1 and index2) are not zero-based.
- You may assume that each input would have *exactly* one solution and you may not use the *same* element twice.

**Example:**

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```



## Solutions (C)

```C
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* numbers, int numbersSize, int target, int* returnSize){
    int* returnArr = (int* )malloc((sizeof(int)) * 2);
    *returnSize = 2;
    int head = 0, tail = numbersSize - 1;
    while(tail > head){
        int sum = numbers[head] + numbers[tail];
        if(sum == target)
            break;
        else if(sum > target)
            tail--;
        else
            head++;
    }
    returnArr[0] = head + 1;
    returnArr[1] = tail + 1;
    return returnArr;
}
```



## Solutions (Java)

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0, tail = numbers.length - 1;
        while (head < tail) {
            int sum = numbers[head] + numbers[tail];
            if (sum == target)
                break;
            else if (sum < target)
                head++;
            else 
                tail--;
        }
        return new int[]{head + 1, tail + 1};
    }
}
```

