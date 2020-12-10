# 102. Binary Tree Level Order Traversal 

Given a binary tree, return the *bottom-up level order* traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```



return its bottom-up level order traversal as:

```
[
  [3],
  [9,20],
  [15,7]
]
```



## Solutions (Java)

```Java
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
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> Layer = new ArrayList<>();
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                Layer.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(Layer);
        }
        return result;
    }
}
```



##Solutions(C++)

~~~c++
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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        queue<TreeNode*> queue;
        if(root != NULL)
            queue.push(root);
        while(!queue.empty()){
            int size = queue.size();
            vector<int> Layer;
            for(int i = 0; i < size; i++){
                TreeNode *node = queue.front();
                queue.pop();
                Layer.push_back(node -> val);
                if(node -> left)
                    queue.push(node -> left);
                if(node -> right)
                    queue.push(node -> right);
            } 
            result.push_back(Layer);  
        }
        return result;
    }
};
~~~

