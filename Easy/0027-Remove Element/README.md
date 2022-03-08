# 27. Remove Element
Given an array *nums* and a value *val*, remove all instances of that value [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) and return the new length.

Do not allocate extra space for another array, you must do this by **modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

**Example 1:**

```
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
```

**Example 2:**

```
Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
```

**Clarification:**

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by **reference**, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

```
// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```



## Solutions (C)

### 1. Two Pointers [1]

```c
int removeElement(int* nums, int numsSize, int val){
        if(numsSize == 0)
            return 0;
        int i = 0, j;
        for( j = 0; j < numsSize; j++){
                if( nums[j] != val){
                    nums[i] = nums[j];
                    i++;
                }
            }
        return i;
}
```



### 2. Two Pointers [2]

```c
int removeElement(int* nums, int numsSize, int val){
        int j;
        for( j = 0; j < numsSize; j++){
                if( nums[j] == val){
                    nums[j--] = nums[numsSize-1];
                    numsSize--;
                }
            }
        return numsSize;
}
```



## Solution(C++)

~~~java
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.size(); fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
};
~~~



