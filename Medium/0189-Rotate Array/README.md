# 189. Rotate Array

Given an array, rotate the array to the right by `k` steps, where `k` is non-negative.

**Example 1:**

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

**Example 2:**

```
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```

**Constraints:**

- `1 <= nums.length <= 105`
- `-231 <= nums[i] <= 231 - 1`
- `0 <= k <= 105`



## Solutions (C)

**Brute Force**

```c
void rotate(int* nums, int numsSize, int k){
    k %= numsSize;
    for(int i = 0; i < k; i++){
        int temp = nums[numsSize - 1];
        for(int j = numsSize - 1; j > 0; j--){
            nums[j] = nums[j - 1];
        }
        nums[0] = temp;
    }
}
```

**Swap**

```c
void rotate(int* nums, int numsSize, int k){
    int n = numsSize;
    k %= n;
    for(int index = 0; index < numsSize && k != 0; n -= k, index += k, k %= n)
        for(int i = 0; i < k; i++)
            swap(nums, index + i, numsSize - k + i);
        //updata index and numsSize.
}

void swap(int* nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

//if nums[i] and nums[j] point to the same address, this swap is useless
// void swap(int* nums, int i, int j){
//     nums[i] = nums[i] ^ nums[j]; 
//     nums[j] = nums[i] ^ nums[j];
//     nums[i] = nums[i] ^ nums[j];
// }
```

**Circle**

```c
void rotate(int* nums, int numsSize, int k){
    k = k % numsSize;
    int count = 0;
    for(int index = 0; count < numsSize; index++){
        int pre = nums[index];
        int next = (index + k) % numsSize;
        int cur = nums[next];
        do{
            nums[next] = pre;
            pre = cur;
            next = (next + k) % numsSize;
            cur = nums[next];
            count++;
        }while(next != (index + k));
    }
}
```

**Reverse Array**

```c
void rotate(int* nums, int numsSize, int k){
    k %= numsSize;
    reverse(nums, 0, numsSize - k - 1);
    reverse(nums, numsSize - k, numsSize - 1);
    reverse(nums, 0, numsSize - 1);
    // reverse(nums, 0, numsSize - 1);
    // reverse(nums, 0, k - 1);
    // reverse(nums, k, numsSize - 1);
}

void reverse(int* nums, int low, int high){
    while(low < high){
        nums[low] = nums[low] ^ nums[high];
        nums[high] = nums[low] ^ nums[high];
        nums[low] = nums[low] ^ nums[high];
        low++;
        high--;
    }
}
```

## Solutions (Java)

**Brute Force**

> Beyond time limit.

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int temp;
        k %= length;
        for(int i = 0; i < k; i++){
            temp = nums[length - 1];
            for(int j = length - 1; j > 0; j--){
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
```

