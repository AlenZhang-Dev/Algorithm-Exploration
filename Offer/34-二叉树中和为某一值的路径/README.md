# 34. 二叉树中和为某一值的路径 

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



示例:
给定如下二叉树，以及目标和 sum = 22，

                5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
返回：

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```

提示：

`数组长度 <= 10000`


链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 解析

回溯法求解。

## 题解

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>(); //动态数组
        findPath(root, sum, new ArrayList<>());
        return res;
    }

    private void findPath(TreeNode node, int sum, List<Integer> collector){
        //boolean isLeaf = (node.left == null && node.right == null);//判断当前节点是否为叶子节点。
        if(node == null)
            return;
        
        sum -= node.val;
        collector.add(node.val);
        
        if(sum == 0 && node.left == null && node. right == null){
            res.add(new ArrayList<>(collector));
        }else{
            findPath(node.left, sum, collector);
            findPath(node.right, sum, collector);
        }   
        collector.remove(collector.size() - 1);
    }
}
```



