# 257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

**Note:** A leaf is a node with no children.

**Example:**

```
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
```



## Solutions (Java)

```java
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }
    private void dfs(TreeNode root, String path, List<String> res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        dfs (root.left, path + root.val + "->", res);
        dfs (root.right, path + root.val + "->", res);
    }
}
```



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
private:
    void traversal(TreeNode* cur, string path, vector<string>& result) {
        path += to_string(cur -> val);
        if (cur -> left == NULL && cur -> right == NULL) {
            result.push_back(path);
            return;
        }
        if (cur -> left)
            traversal (cur -> left, path + "->", result);
        if (cur -> right)
            traversal (cur -> right, path + "->", result);
    }
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> result;
        string path;
        if (root == NULL)
            return result;
        traversal (root, path, result);
        return result;
    }
};
```





