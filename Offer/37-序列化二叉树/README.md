# 37. 序列化二叉树

请实现两个函数，分别用来序列化和反序列化二叉树。

示例: 

你可以将以下二叉树：

    		1
       / \
      2   3
         / \
        4   5
        
    序列化为 "[1,2,3,null,null,4,5]"


## 解析

本题主旨便是让你正向存储一棵树，然后通过数组逆向再复原一棵树。

可以从先序遍历和层序遍历两个方向进行考虑，基本思路就是把序列化的过程分为三个部分：根节点，左子树和右子树。典型的递归问题，在处理树的根节点之后再去处理他的左子树，右子树。「逐个分解，然后逐个解决」

## 题解

### Solutions(Java)

**DFS**

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
public class Codec {
    int start = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return new String("$");
        StringBuffer res = new StringBuffer("");
        preOrder(root, res);
        res.append("$");
        return res.toString();
    }
    void preOrder(TreeNode root, StringBuffer res){
        if(root == null){
            res.append("#,");
            return;
        }else{
            res.append(root.val);
            res.append(",");
        }
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("$"))
            return null;
        String [] res = data.split(",");
        return preOrderReverse(res);
    }

    TreeNode preOrderReverse(String[] res){
        TreeNode root;
        if(res[start].equals("#")){
            ++start;
            return null;
        }
        else{
            root = new TreeNode(Integer.parseInt(res[start]));
            ++start;
        }
        root.left = preOrderReverse(res);
        root.right = preOrderReverse(res);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
~~~



**BFS：**

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>(){
            {add(root);}
        };
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else
                res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]"))
            return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));    
        Queue<TreeNode> queue = new LinkedList<>(){{add(root);}};
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            ++i;
            if(!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            ++i;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
```


