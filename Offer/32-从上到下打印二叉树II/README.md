# 32. 从上到下打印二叉树II

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

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

辅助元素：需要两个元素，一个用于记录当前层的节点数，一个用于下一层的节点数。

整体思路与上题类似，主要考察每一层打印到每一行。



## 题解

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

//toBePrinted created to count the numbers of current printing layer.
//nextLevel created to count the numbers of next layer.
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        //create two-dimemsional vector to return
        vector<vector<int>> vec;
        vector<int> res;
        if(root == NULL)
            return vec;
        queue<TreeNode *> nodes;
        nodes.push(root);
        int toBePrinted = 1; 
        int nextLevel = 0;

        while(!nodes.empty()){
            TreeNode* pNode = nodes.front();//save the first element
            res.push_back(pNode -> val);
            if(pNode -> left){
                nodes.push(pNode -> left);
                ++nextLevel;
            }
            if(pNode -> right){
                nodes.push(pNode -> right);
                ++nextLevel;
            }
            nodes.pop();//eject the first element;
            --toBePrinted;
            //the most essential process
            if(!toBePrinted){
                vec.push_back(res);
                res.clear();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return vec;
    }
};
```

