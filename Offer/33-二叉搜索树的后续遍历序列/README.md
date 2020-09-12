# 33. 二叉搜索树的后续遍历序列 

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 参考以下这颗二叉搜索树：

         5
        / \
       2   6
      / \
     1   3
示例 1：

```
输入: [1,6,3,2,5]
输出: false
```

示例 2：

```
输入: [1,3,2,6,5]
输出: true
```

提示：

`数组长度 <= 1000`


链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 解析

主要根据二叉搜索树以及后续遍历的特性进行讨论，找出数组中二叉搜索树左右子树之间分界点，然后判断右子树序列是否符合二叉搜索树的特征。

## 题解

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return verify(postorder, 0, postorder.length - 1); 
    }

    // 递归实现
    private boolean verify(int[] postorder, int left, int right){
        if (left >= right) 
            return true; //区域不合法，返沪true。

        int rootValue = postorder[right]; //当前树的根节点的值

        int k = left;
        //找出当前子树中左右子树的分界点，记录为k
        while (k < right && postorder[k] < rootValue){
            k++;
        }
        //判断当前树的右树是否有违规节点，违规则直接返回false
        for (int i = k; i < right; i++){ 
            if (postorder[i] < rootValue) 
                return false;
        }

        //检查紫薯的左右子树
        if (!verify(postorder, left, k - 1)) 
            return false; // 检查左子树

        if (!verify(postorder, k, right - 1)) 
            return false; // 检查右子树

        return true; // 最终都没问题就返回true
    }
}
```



