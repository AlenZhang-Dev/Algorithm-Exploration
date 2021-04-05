/**
 * Futher implementations:
 * 1. Traversal without recursion.[Post]
 * 2. Create the tree with random number.
 */
package com.search.Algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    /**
     * Start recursion from the root node.
     *
     * @param value value (to be added)
     */
    public void insertNode(int value) {
        root = insertRecursive(root, value);
    }

    /**
     * Inserting opearting by recursion.
     * Find the current elements also keep the tree sorted.
     *
     * @param curNode current node
     * @param value
     * @return
     */
    private Node insertRecursive(Node curNode, int value) {
        if (curNode == null) {
            return new Node(value);
        }

        if (value < curNode.value) {
            curNode.left = insertRecursive(curNode.left, value);
        } else if (value > curNode.value) {
            curNode.right = insertRecursive(curNode.right, value);
        }

        return curNode;
    }

    /**
     * Check whether tree is empty.
     *
     * @return {@code true} if tree is empty {@code false} if tree isn't empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Search the node.
     *
     * @param value
     * @return {@code true} node exists {@code false} node not exists
     */
    public boolean searchNode(int value) {
        return searchRecursive(root, value);
    }

    /**
     * Search element by recursion.
     *
     * @param curNode current node
     * @param value   value
     * @return find the value return true, otherwise return false.
     */
    private boolean searchRecursive(Node curNode, int value) {
        if (curNode == null)
            return false;
        if (value == curNode.value) {
            return true;
        }
        return value < curNode.value
                ? searchRecursive(curNode.left, value)
                : searchRecursive(curNode.right, value);
    }

    /**
     * Delete the node which contains the element value.
     *
     * @param value value of the node
     */
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    /**
     * Delete the number with recursive.
     *
     * @param curNode current node
     * @param value   deleted value
     * @return
     */
    private Node deleteRecursive(Node curNode, int value) {
        if (curNode == null) {
            return null;
        }
        if (value == curNode.value) {
            // Leaf node
            if (curNode.left == null && curNode.right == null) {
                return null;
            }
            // Node with one subtree
            if (curNode.right == null) {
                return curNode.left;
            }
            if (curNode.left == null) {
                return curNode.right;
            }
            //Node with two subtrees
            int biggestValue = biggestValue(root.left);
            curNode.value = biggestValue;
            curNode.left = deleteRecursive(curNode.left, biggestValue);
            return curNode;
        }
        if (value < curNode.value) {
            curNode.left = deleteRecursive(curNode.left, value);
            return curNode;
        }
        curNode.right = deleteRecursive(curNode.right, value);
        return curNode;
    }

    /**
     * Find the biggest value of the left sub-tree in order to replace the deleted node
     *
     * @param root
     * @return the biggest value of left subtree
     */
    private int biggestValue(Node root) {
        return root.right == null
                ? root.value
                : biggestValue(root.right);
    }

    /**
     * Find the smallest value of the right sub-tree in order to replace the deleted node
     *
     * @param root
     * @return the smallest value of right subtree
     */
    private int smallestValue(Node root) {
        return root.left == null
                ? root.value
                : smallestValue(root.left);
    }

    /**
     * Inorder with recursion.
     *
     * @param node
     */
    public void Inorder(Node node) {
        if (node != null) {
            Inorder(node.left);
            show(node.value);
            Inorder(node.right);
        }
    }

    public void InorderWithIteration() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node top = stack.pop();
            show(top.value);
            current = top.right;
        }
    }

    /**
     * Preorder with recusrion.
     *
     * @param node
     */
    public void PreOrder(Node node) {
        if (node != null) {
            show(node.value);
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    /**
     * PreOrder with traversal.
     */
    public void PreOrderWithTraversal() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);

        while (current != null & !stack.isEmpty()) {
            current = stack.pop();
            show(current.value);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /**
     * Postorder with traversal.
     */
    public void PostOrderWithTraversal() {
        Stack<Node> stack = new Stack<>();
        Node pre = root;
        Node current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPreLastChild = (pre == current
                    || (pre == current.left && current.right == null));

            // current doesn't have child or pre is that last child
            if (!hasChild || isPreLastChild) {
                current = stack.pop();
                show(current.value);
                pre = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    /**
     * Postorder with recursion.
     *
     * @param node
     */
    public void PostOrder(Node node) {
        if (node != null) {
            PostOrder(node.left);
            PostOrder(node.right);
            show(node.value);
        }
    }

    /**
     * Traversal with levelorder, also called bfs.
     */
    public void BFS() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node headNode = queue.remove();

            show(headNode.value);

            if (headNode.left != null) {
                queue.add(headNode.left);
            }

            if (headNode.right != null) {
                queue.add(headNode.right);
            }
        }
        System.out.println();
    }

    private void show(int value) {
        System.out.printf(" " + value);
    }

    /**
     * Creating the tree with custom values.
     *
     * @return
     */
    private BinarySearchTree createBinarySearchTree() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insertNode(6);
        tree.insertNode(4);
        tree.insertNode(8);
        tree.insertNode(3);
        tree.insertNode(5);
        tree.insertNode(7);
        tree.insertNode(9);

        return tree;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst = bst.createBinarySearchTree();
        System.out.println("After inserting: ");
//        bst.BFS();

        //check
        bst.Inorder(bst.root);
        System.out.println();
        bst.InorderWithIteration();
        System.out.println();

        //find
        int findNumder = 4;
        if (bst.searchNode(findNumder)) {
            System.out.println("find the number " + findNumder);
        } else {
            System.out.println("can't find the number " + findNumder);
        }

        //delete
        int deleteNumber = 4;
        bst.delete(deleteNumber);
        System.out.println("After delete " + deleteNumber + ":");
        bst.BFS();
    }
}
