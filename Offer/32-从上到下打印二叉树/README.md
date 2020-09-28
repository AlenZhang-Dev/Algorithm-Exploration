# 32. 从上到下打印二叉树

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    		3
       / \
      9  20
        /  \
       15   7

返回：

`[3,9,20,15,7]`


提示：

`节点总数 <= 1000`



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof

## 解析

使用数据结构：队列。

规律：每次打印一个节点的时候，如果该节点有子节点，则该把该节点的子节点放到一个队列的末尾。接下来到队列的头部取出最早进入队列的节点，重复前面的打印操作，知道队列何中所有节点都被打印出来。



## 题解

### Java

```java
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) 
              	queue.add(node.left);
            if(node.right != null) 
              	queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}

```



### C++

```c++
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    vector<int> levelOrder(TreeNode* root) {

        queue<TreeNode *> dequeTreeNode;
        vector<int> res;
        if(!root)
            return res;
        
        dequeTreeNode.push(root);

        while(dequeTreeNode.size()){
            TreeNode* pNode = dequeTreeNode.front();//take out the first element
            dequeTreeNode.pop();//eject the first element
            res.push_back(pNode -> val);//save inorder to return
            
            if(pNode -> left){
                dequeTreeNode.push(pNode -> left);
            }

            if(pNode -> right){
                dequeTreeNode.push(pNode -> right);
            }
        }
        return res;
    }
};
```

