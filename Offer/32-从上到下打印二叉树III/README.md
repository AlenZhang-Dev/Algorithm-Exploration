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

使用数据结构：队列、链表

辅助结构：

1. `Queue<TreeNode> deque  = new LinkedList<>();`: 双端队列的使用，两端都可以进出，用于保存正常树遍历顺序时的节点。

1. `List<List<Integer>> res = new ArrayList<>();`: LinkList 类型 tmp 临时存储遍历时每一层的遍历顺序。

2. `List<List<Integer>> res = new ArrayList<>();` : 返回结果，结构tmp传来的每层数据。

核心：遍历时顺序根据层的奇偶性变化。

解决：

1. 从队列传输至tmp时，改变插入顺序，即前插和后插，即可在内容上改变遍历顺序。【题解一、二】

2. 对奇偶层进行判断，每层的数据在deque和tmp之间正常传递，在偶数层时对tmp进行reverse，即可达到效果。【题解三】



## 题解

### 层序遍历 + 双端队列

#### Java

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

### 层序遍历 + 奇偶分离

> 代码量较方法一有所增加，但程序运行效率有所提高
#### Java

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

#### C++

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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if(root == NULL)
            return res;
        int flag = 0;//mark the layer
        int current = 1;//the number of current layer
        int next = 0;//the number of next layer
        deque<TreeNode*> queue;
        queue.push_back(root);
        vector<int> tmp;
        
        while(!queue.empty()){
            TreeNode* node;
            //even layer, put from left to right.
            if(flag == 0){
                node = queue.front();//put the first element into node.
                queue.pop_front();//eject the first element.
                if(node -> left != NULL){
                    queue.push_back(node -> left);
                    ++next;
                }
                if(node -> right != NULL){
                     queue.push_back(node -> right);
                     ++next;
                }
            }
            else{
                node = queue.back();//put the last element into node.
                queue.pop_back();//eject the last element.
                if(node -> right){
                    queue.push_front(node -> right);
                    ++next;
                }
                if(node -> left){
                    queue.push_front(node -> left);
                    ++next;
                }
            }
            --current;
            tmp.push_back(node -> val);
            if(current == 0){
                current = next;
                next = 0;
                flag = 1 - flag;
                res.push_back(tmp);
                tmp.clear();
            }
        }
        return res;
    }
};
```





### 层序遍历 + 倒叙数组

> 调用reverse在面对海量数据是效率并不高。

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
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)
            queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            //if odd, reverse the tmp
            if(res.size() % 2 == 1)
                Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}
```



### 两个辅助栈

一个用于存放奇数层的数据，一个用于存放偶数层的数据。

打印奇数层时，子节点存入存放偶数层的栈中，从左到右进行数据存放。

打印偶数层时， 子节点存入存放奇数层的栈中，从右到左进行数据存放。

数据结构在C++中都有提供，做好以上两个细节即可。

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
        vector<vector<int>> res;
        if(root == NULL)
            return res;

        stack<TreeNode*> level[2];
        int current = 0;//which stack in useage, flag.
        int next = 1;//opposite to the current.
        vector<int> tmp;//save elements each layer.

        level[current].push(root);
        while(!level[0].empty() || !level[1].empty()){
            TreeNode* node = level[current].top();
            level[current].pop();//eject the top element.
            tmp.push_back(node -> val);
            //odd, from left to right
            if(current == 0){
                if(node -> left)
                    level[next].push(node -> left);
                if(node -> right)
                    level[next].push(node -> right);
            }
            else{
                if(node -> right)
                    level[next].push(node -> right);
                if(node -> left)
                    level[next].push(node -> left);
            }

            if(level[current].empty()){
                res.push_back(tmp);
                tmp.clear();
                current = 1 - current;
                next = 1 - next;
            }
        }
        return res;
    }
};
~~~



