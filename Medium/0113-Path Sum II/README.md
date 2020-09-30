# 113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

**Note:** A leaf is a node with no children.

**Example:**

Given the below binary tree and `sum = 22`,

```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
```

Return:

```
[
   [5,4,11,2],
   [5,8,4,5]
]
```





## Solutions (Java)

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
    vector<vector<int>> res;
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<int> path;//record the path.
        int currentSum = 0;
        FindPath(root, currentSum, path, sum);
        return res;
    }
    void FindPath(TreeNode* root, int currentSum, vector<int>& path, int TotalSum){
        if(root == NULL)
            return;

        currentSum += root -> val;
        path.push_back(root -> val);

        //decide
        bool isLeaf = (root -> right == NULL && root -> left == NULL);
        if(currentSum == TotalSum && isLeaf){
            res.push_back(path);
            path.pop_back();
            return;
        }

        //if not, continue
        if(root -> left != NULL)
            FindPath(root -> left, currentSum, path, TotalSum);
        if(root -> right != NULL)
            FindPath(root -> right, currentSum, path, TotalSum);
        
        //after all, pop the top stack
        path.pop_back();
    }
};
```
