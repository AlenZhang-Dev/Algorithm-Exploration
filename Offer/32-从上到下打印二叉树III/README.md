# 32. 从上到下打印二叉树III

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

    		3
       / \
      9  20
        /  \
       15   7

返回：

```
[
  [3],
  [9,20],
  [15,7]
]
```


提示：

`节点总数 <= 1000`



## 解析

使用数据结构：队列

采用之字形进行树的遍历，较为复杂。

## 题解

### Java

层序遍历 + 双端队列

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //initialize
        Queue<TreeNode> deque  = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)
            deque.add(root);
        while(!deque.isEmpty()){
            //tmp to save every layer
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = deque.size(); i > 0; i--){
                TreeNode node = deque.poll();
                if(res.size() % 2 == 0){
                    tmp.addLast(node.val);//add to the head
                }
                else{
                    tmp.addFirst(node.val);//add to the tail
                }
                if(node.left != null)
                    deque.add(node.left);
                if(node.right != null)
                    deque.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
```

层序遍历 + 奇偶分离

> 代码量有所增加，但程序运行效率有所提高
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //initialize
        Deque<TreeNode> deque  = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)
            deque.add(root);
        while(!deque.isEmpty()){
            //LinkedList tmp in order to save each layer
            //odd layer fisrt, direction: from left to right
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--){
                TreeNode node = deque.removeFirst();
                tmp.add(node.val);
                //save the next layer
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            res.add(tmp);
            if(deque.isEmpty())
                break;
            tmp = new ArrayList<>();
            //even layer
            //direction: from right to left
            for(int i = deque.size(); i > 0; i--){
                TreeNode node = deque.removeLast();
                tmp.add(node.val);
                if(node.right != null)
                    deque.addFirst(node.right);
                if(node.left != null)
                    deque.addFirst(node.left);
            }
            res.add(tmp);
        }
        return res;
    }
}
```