# 04. Median of Two Sorted Arrays

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return **the median** of the two sorted arrays.

**Example 1:**

```
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
```

**Example 2:**

```
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
```

**Example 3:**

```
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
```

**Example 4:**

```
Input: nums1 = [], nums2 = [1]
Output: 1.00000
```

**Example 5:**

```
Input: nums1 = [2], nums2 = []
Output: 2.00000 
```

**Constraints:**

- `nums1.length == m`
- `nums2.length == n`
- `0 <= m <= 1000`
- `0 <= n <= 1000`
- `1 <= m + n <= 2000`
- `-106 <= nums1[i], nums2[i] <= 106`

**Follow up:** The overall run time complexity should be `O(log (m+n))`.

## Solutions (Java)

**Array**

`T(n) = O(log(m + n)) , S(n) = O(log(m + n))`

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int newLength = nums1.length + nums2.length;
        int[] extendNums = new int[newLength];
        int index = 0, index1 = 0, index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length){
            extendNums[index++] = nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
        }
        while(index1 < nums1.length){
            extendNums[index++] = nums1[index1++];
        }
        while(index2 < nums2.length){
            extendNums[index++] = nums2[index2++];
        }
        if(newLength % 2 == 1){
            return extendNums[newLength / 2] / 1.0;
        } 
        return (extendNums[newLength / 2] + extendNums[newLength / 2 - 1]) / 2.0;
    }
}
```

**Two pointers**

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int len = l1 + l2;
        int pre = -1, cur = -1;
        int point1 = 0, point2 = 0;
        for(int i = 0; i <= len / 2; i++) {
            pre = cur;
            //point >= l2 must put ahead. otherwise it will cause out of bound exception
            if(point2 >= l2 || (point1 < l1 && nums1[point1] < nums2[point2])){
                cur = nums1[point1++];
            }else{
                cur = nums2[point2++];
            }
        }
        return (len % 2 == 0) ? (pre + cur) / 2.0 : cur;
    }
}
```

**Dichotomy**

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int pre = (l1 + l2 + 1) / 2;
        int cur = (l1 + l2 + 2) / 2;
        return (findKthNumber(nums1, 0, l1 - 1, nums2, 0, l2 - 1, pre) + findKthNumber(nums1, 0, l1 - 1, nums2, 0, l2 - 1, cur)) * 0.5;
    }

    private int findKthNumber(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k){
        int l1 = e1 - s1 + 1;
        int l2 = e2 - s2 + 1;
        //make sure l1 is always larger than l2.
        if(l1 > l2)
            return findKthNumber(nums2, s2, e2, nums1, s1, e1, k);
        if(l1 == 0)
            return nums2[s2 + k - 1];
        
        if(k == 1)
            return Math.min(nums1[s1], nums2[s2]);

        int i = s1 + Math.min(l1, k / 2) - 1;
        int j = s2 + Math.min(l2, k / 2) - 1;

        if(nums1[i] > nums2[j]){
            return findKthNumber(nums1, s1, e1, nums2, j + 1, e2, k - (j - s2 + 1));    
        }else{
            return findKthNumber(nums1, i + 1, e1, nums2, s2, e2, k - (i - s1 + 1));
        }
    }
}
```

