# 54. 二叉搜索树最大k节点

给定一棵二叉搜索树，请找出其中第k大的节点。

示例 1:

```
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
```

示例 2:

```
输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4
```


限制：

`1 ≤ k ≤ 二叉搜索树元素个数`

## 解析

根据二叉搜索树的特性，使用中序遍历得到的结果即为正向排序的，题目需要第k大的节点，因此需要对其进行逆向排序，逆置中序遍历。

中序遍历算法如下：

```java
void dfs (TreeNode root){
  	if(root == null)
      	return;
  	dfs(root.left);
  	System.out.println(root.val);
  	dfs(root.right);
}
```

同理，逆置中序遍历算法如下：

~~~java
void dfs(TreeNode root){
  	if(root == null)
      	return;
  	dfs(root.right);
  	System.out.println(root.val);
  	dfs(root.left);
}
~~~



## 题解

### Java

```java
class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        kthLargestCore(root);
        return res;
    }
    // //by return int
    void kthLargestCore(TreeNode root){
        if(root == null)
            return;
        //1.right
        kthLargestCore(root.right);
        if(--k == 0){
            res = root.val;
            return;
        }
        kthLargestCore(root.left); 
    }
}
```



