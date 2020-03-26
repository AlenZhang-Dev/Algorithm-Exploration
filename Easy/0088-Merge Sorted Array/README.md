# 88. Merge Sorted Array

Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**

- The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.
- You may assume that *nums1* has enough space (size that is greater or equal to *m* + *n*) to hold additional elements from *nums2*.

**Example:**

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```



## Solutions (C)

```C
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    //array merge 
    for(int i = 0; i < n; i++, m++){
        nums1[m] = nums2[i];
    }
    //Sort
    insertion_sort(nums1, m);
}

void insertion_sort(int *arr, int len){
    int i,j,temp;
    for (i=1;i<len;i++){
            temp = arr[i];
            for (j=i;j>0 && arr[j-1]>temp;j--)
                    arr[j] = arr[j-1];
            arr[j] = temp;
    }
}
```



```c
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    int  p2 = n - 1;
    for(int p3 = m + n - 1, p1 = m - 1; p1 >= 0 && p2 >= 0; p3--){
        bool judge = (nums2[p2] >= nums1[p1]) ? true : false; 
        if(judge){
            nums1[p3] = nums2[p2];
            p2--;
        }
        else{
            nums1[p3] = nums1[p1];
            p1--;
        }
    }
    //special case
    while(p2 >= 0)
    {
        nums1[p2] = nums2[p2];
        p2--;
    }
}
```



