# 429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the *level order* traversal of its nodes' values.

*Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).*

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

```
Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png)

```
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
```

 

**Constraints:**

- The height of the n-ary tree is less than or equal to `1000`
- The total number of nodes is between `[0, 104]`

 

## Solutions (Java)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                layer.add(node.val);
                List<Node> childList = node.children;
                for(Node childnode : childList)
                    queue.offer(childnode);
            }
            result.add(layer);
        }
        return result;
    }
}
```



## Solutions (C++)

```c++
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> result;
        if(root == NULL)
            return  result;
        queue<Node*> queue;
        queue.push(root);
        while(!queue.empty()){
            int size = queue.size();
            vector<int> layer;
            for(int i = 0; i < size; i++){
                Node *node = queue.front();
                queue.pop();
                layer.push_back(node -> val);
                for(int i = 0; i < node -> children.size(); i++){
                    queue.push(node -> children[i]);
                }
            }
            result.push_back(layer);
        }
        return result; 
    }
};
```
