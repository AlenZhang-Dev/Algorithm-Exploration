# 746. Min Cost Climbing Stairs

On a staircase, the `i`-th step has some non-negative cost `cost[i]` assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

**Example 1:**

```
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
```

**Example 2:**

```
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
```

**Note:**

1. `cost` will have a length in the range `[2, 1000]`.
2. Every `cost[i]` will be an integer in the range `[0, 999]`.

> **It's a classic example of dynamic programming.**



## Solutions (C)

### 1. Dynamic programming

```c
int minCostClimbingStairs(int* cost, int costSize){
    int Pre = cost[0], Cur = cost[1],Temp;
    for(int i = 2; i < costSize; i++){
        Temp = Cur;
        Cur = ((Cur < Pre) ? Cur : Pre) + cost[i];
        Pre = Temp;
    }
    return (Cur < Pre) ? Cur : Pre;
}
```



## Solutions (Java)

### 1. Dynamic programming

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int Pre = cost[0], Cur = cost[1], Temp;
        for(int i = 2; i < cost.length; i++){
                Temp = Cur;
                Cur = cost[i] + Math.min(Cur, Pre);
                Pre = Temp;        
        }
        return Math.min(Cur, Pre);
    }
}
```




