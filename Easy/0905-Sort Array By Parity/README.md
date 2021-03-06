# 905. Sort Array By Parity



- Given an array `A` of non-negative integers, return an array consisting of all the even elements of `A`, followed by all the odd elements of `A`.

  You may return any answer array that satisfies this condition.

   

  **Example 1:**

  ```
  Input: [3,1,2,4]
  Output: [2,4,3,1]
  The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
  ```

   

  **Note:**

  1. `1 <= A.length <= 5000`
  2. `0 <= A[i] <= 5000`



## Solutions (Java)


#### 1.Tow Pointer

~~~java
class Solution {
    public int[] sortArrayByParity(int[] A) {
        //Two Pointers
        int length = A.length;
        int i = 0, j = length - 1, tmp = 0;
        while(i < j){
            if(A[j] % 2 == 0 && A[i] % 2 == 1){
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }else if(A[j] % 2 == 0){
                i++;
            }else{
                j--;
            }
        }
        return A;
    }
}
~~~



