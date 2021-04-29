# 041. First Missing Positive

Given an unsorted integer array `nums`, find the smallest missing positive integer.

**Example 1:**

```
Input: nums = [1,2,0]
Output: 3
```

**Example 2:**

```
Input: nums = [3,4,-1,1]
Output: 2
```

**Example 3:**

```
Input: nums = [7,8,9,11,12]
Output: 1
```

**Constraints:**

- `1 <= nums.length <= 300`
- `-231 <= nums[i] <= 231 - 1`

## Solutions (C)

**Array**

```c
int firstMissingPositive(int* nums, int numsSize){
    int i, num[numsSize];
    memset(num, 0, sizeof(int) * numsSize);
    for(i = 0; i < numsSize; i++){
        if(nums[i] > 0 && nums[i] <= numsSize)
            num[nums[i] - 1] = 1;
    }
    for(i = 0; i < numsSize; i++){
        if(!num[i])
            break;
    }
    return i + 1;
}
```

## Solutions (Java)

**Array**

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] numsCopy = new int[nums.length];
        int index;
        for(int num : nums){
            if(num > nums.length || num <= 0)
                continue;
            numsCopy[num - 1] = 1;  
        }
        for(index = 0; index < nums.length; index++){
            if(numsCopy[index] == 0)
                break;
        }
        return index + 1;
    }
}
```

**Only use one Array**

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        //find the element which smaller than zero and one. set to 1.
        int index;
        boolean flag = false;
        for(index = 0; index < nums.length; index++){
            if(nums[index] == 1)
                flag = true;
            if(nums[index] <= 0)
                nums[index] = 1;//set the negative element to length.
        }
        if(!flag)
            return 1;
        //make sure can access any element.
        for(index = 0; index < nums.length; index++){
            if(nums[Math.abs(index)] > nums.length){
                continue;
            }   
            else{
                if(nums[Math.abs(nums[index]) - 1] > 0){
                    nums[Math.abs(nums[index]) - 1] *= -1;  
                }
            }
        }
        for(index = 0; index < nums.length; index++){
            if(nums[index] > 0)
                return index + 1;
        }
        return nums.length + 1;
    }
}
```

**HashSet**

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int num : nums){
            //add to specified element if it's not already present
            map.add(num);
        }
        for(int i = 1; i <= nums.length; i++){
            //return true if contains. find the first element which hasn't add to set
            if(!map.contains(i)){
                return i;
            }
        }
        return nums.length + 1;
    }
}
```

