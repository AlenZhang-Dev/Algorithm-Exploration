# 199. Binary Tree Right Side View

> Given a binary tree, imagine yourself standing on the *right* side of it, return the values of the nodes you can see ordered from top to bottom.
>
> **Example:**
>
> ```
> Input: [1,2,3,null,5,null,4]
> Output: [1, 3, 4]
> Explanation:
> 
>    1            <---
>  /   \
> 2     3         <---
>  \     \
>   5     4       <---
> ```



## Solutions (C++)


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
    vector<int> rightSideView(TreeNode* root) {
       queue<TreeNode*> queue;
        if(root != NULL)
            queue.push(root);
        vector<int> result;
        while(!queue.empty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode* node = queue.front();
                queue.pop();
                if(i == size - 1) 
                    result.push_back(node -> val);
                if(node -> left)
                    queue.push(node -> left);
                if(node -> right)
                    queue.push(node -> right);
            }
        }
        return result;
    }
};
```



## Solutions (Java)

~~~java
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == size - 1)
                    result.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return result;
    }
}
~~~

