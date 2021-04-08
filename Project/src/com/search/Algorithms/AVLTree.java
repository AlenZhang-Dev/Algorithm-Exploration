/**
 * How to balance an AVL Tree?
 * The AVL Tree checks the balance factor of its nodes after the inseration and deletion of a node.
 * if the BF of a node is greater than one or less than -2, the tree need to rebalanced.
 * Two operations to rebalance a tree.
 * 1. Right rotation.
 * 2. Left rotation.
 *
 * Future implementation:
 * 1. Random generate the tree. [Robust]
 * 2. AVL Tree visualization.
 */

package com.search.Algorithms;

import java.util.Scanner;

public class AVLTree {
    private Node root;

    public static class Node {
        int value;
        int height;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * InsertNode operation for root.
     *
     * @param value value
     */
    public void insertNode(int value) {
        root = insertNode(root, value);
    }

    /**
     * Insert the node first and then rebalanced the tree.
     *
     * @param node  node
     * @param value inserted value
     * @return rebalance(node)
     */
    private Node insertNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else if (node.value > value) {
            node.left = insertNode(node.left, value);
        } else if (node.value < value) {
            node.right = insertNode(node.right, value);
        } else {
            return node;
//            throw new RuntimeException("Duplicate value");
        }
        return rebalance(node);
    }

    /**
     * Return root.
     *
     * @return
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Update the height of the tree.
     *
     * @param n node
     */
    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    /**
     * Return the height of the node.
     *
     * @param n
     * @return
     */
    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    /**
     * Count the balance factor of the Node.
     *
     * @param n current node
     * @return
     */
    private int getBalanceFactor(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    /**
     * Right rotation the node y.
     *
     * @param y node
     * @return
     */
    private Node rightRotation(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(x);
        updateHeight(y);
        return x;
    }

    /**
     * Left rotation the node y.
     *
     * @param y node
     * @return
     */
    private Node leftRotation(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     * Rebalance the AVL tree.
     *
     * @param node node
     * @return node
     */
    private Node rebalance(Node node) {
        updateHeight(node);
        int balanceFactor = getBalanceFactor(node);
        //Left rebalance
        if (balanceFactor > 1) {
            if (height(node.right.right) > height(node.right.left)) {
                node = leftRotation(node);
            } else {
                node.right = rightRotation(node.right);
                node = leftRotation(node);
            }
        } else if (balanceFactor < -1) {
            if (height(node.left.left) > height(node.left.right)) {
                node = rightRotation(node);
            } else {
                node.left = leftRotation(node.left);
                node = rightRotation(node);
            }
        }
        return node;
    }

    /**
     * Delete fucntion for public.
     *
     * @param value value
     */
    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    /**
     * Delete the node.
     *
     * @param node  node
     * @param value value
     * @return node
     */
    private Node deleteNode(Node node, int value) {
        if (node == null) {
            return node;
        } else if (node.value > value) {
            node.left = deleteNode(node.left, value);
        } else if (node.value < value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node smallestValue = smallestValue(node.right);
                node.value = smallestValue.value;
                node.right = deleteNode(node.right, node.value);

//                Node biggestValue = biggestValue(node.left);
//                node.value = biggestValue.value;
//                node.left = deleteNode(node.left, node.value);
            }
        }
        //Rebalance after deleting.
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    /**
     * Find the biggest value of the left sub-tree.
     *
     * @param node
     * @return
     */
    private Node biggestValue(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    /**
     * Find the smallest value of the right sub-tree.
     *
     * @param node
     * @return
     */
    private Node smallestValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Serach the node.
     *
     * @param value
     * @return
     */
    private Node searchNode(int value) {
        Node current = root;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.value < value ? current.right : current.left;
        }
        return current;
    }

    /**
     * Test for create the AVL.
     * @return
     */
    private AVLTree createAVLTree() {
        AVLTree tree = new AVLTree();

        tree.insertNode(3);
        tree.insertNode(2);
        tree.insertNode(1);
        tree.insertNode(4);
        tree.insertNode(5);
        tree.insertNode(6);
        tree.insertNode(7);
        tree.insertNode(10);
        tree.insertNode(9);
        tree.insertNode(8);
        insertNode(11);

        return tree;
    }

    public void Inorder(Node node) {
        if (node != null) {
            Inorder(node.left);
            System.out.print(node.value + ", ");
            Inorder(node.right);
        }
    }

    /**
     * Generate random numbers to build an AVL tree.
     *
     * @param maxNumber max number of tree
     * @param maxValue  max value of tree
     * @return
     */
    public AVLTree generateRandomAVL(int maxNumber, int maxValue) {
        return generate(maxNumber, maxValue);
    }

    private AVLTree generate(int maxNumber, int maxValue) {
        AVLTree tree = new AVLTree();

        for (int i = 0; i < maxNumber; ++i) {
            if (Math.random() < 0.003) {
                return tree;
            }
            int value = (int) (Math.random() * maxValue);
            tree.insertNode(value);
        }

        return tree;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int maxNumber = 50;
        int maxValue = 500;
        AVLTree randomTree = new AVLTree();
        randomTree = randomTree.generateRandomAVL(maxNumber, maxValue);
        randomTree.Inorder(randomTree.root);
        System.out.println();

        int deleteValue = Integer.MIN_VALUE;

        //Deleting test
        while (deleteValue != -1) {
            System.out.println("\nInput the number to be deleted [-1 to quit]");
            deleteValue = scan.nextInt();
            randomTree.deleteNode(deleteValue);
            System.out.println("Delete the number :" + deleteValue);
            randomTree.Inorder(randomTree.root);
        }

        System.out.println("\nSearching test......");
        int searchValue = Integer.MIN_VALUE;
        while (searchValue != -1) {
            randomTree.Inorder(randomTree.root);
            System.out.println("\nEnter the number to be searched [-1 to quit]");
            searchValue = scan.nextInt();
            Node node = randomTree.searchNode(searchValue);
            if (node != null) {
                System.out.println("Got the number:" +  searchValue);
            } else {
                System.out.println("Can't find the number:" +  searchValue);
            }
        }
    }
}
