# 515. Find Largest Value in Each Tree Row

- Given the `root` of a binary tree, return *an array of the largest value in each row* of the tree **(0-indexed)**.

   

  **Example 1:**

  ![img](https://assets.leetcode.com/uploads/2020/08/21/largest_e1.jpg)

  ```
  Input: root = [1,3,2,5,3,null,9]
  Output: [1,3,9]
  ```

  **Example 2:**

  ```
  Input: root = [1,2,3]
  Output: [1,3]
  ```

  **Example 3:**

  ```
  Input: root = [1]
  Output: [1]
  ```

  **Example 4:**

  ```
  Input: root = [1,null,2]
  Output: [1,2]
  ```

  **Example 5:**

  ```
  Input: root = []
  Output: []
  ```

   

  **Constraints:**

  - The number of nodes in the tree will be in the range `[0, 104]`.
  - `-231 <= Node.val <= 231 - 1`





## Solutions (C++)

```c++
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> result;
        queue<TreeNode*> queue;
        if(root == nullptr)
            return result;
        queue.push(root);
        while(!queue.empty()){
            int size = queue.size();
            int max = INT_MIN;
            for(int i = 0; i < size; i++){
                TreeNode* node = queue.front();
                queue.pop();
                if(node -> val > max)
                    max = node -> val;
                if(node -> left)
                    queue.push(node -> left);
                if(node -> right)
                    queue.push(node -> right);
            }
            result.push_back(max);
        }
        return result;
    }
};
```



## Solutions (Java)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); 
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.val > max)
                    max = node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(max);
        }
        return result;
    }
}
````

