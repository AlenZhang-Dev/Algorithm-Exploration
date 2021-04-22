package com.search.Algorithms;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int size; //subtree count

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackTree() {

    }

    /**
     * ture when node is red, otherwise is false;
     *
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    /**
     * Return number of node in subtree.
     *
     * @param x
     * @return
     */
    private int size(Node x) {
        if (x == null)
            return 0;
        return x.size;
    }

    /**
     * Return the number of key-value pairs in the symbol table
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0)
                return x.val;
            x = cmp < 0 ? x.left : x.right;
        }
        return null;
    }



    public void put (Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (val == null) {

        }


    }

    // insert the key-value pair in the subtree rooted at h
    private Node put (Node h, Key key, Value val) {
        if (h == null)
            return new Node(key, val, RED, 1);
        //find the place to insert.
        int cmp = key.compareTo(h.key);
        if (cmp < 0)
            h.left = put(h.left, key, val);
        else if (cmp > 0)
            h.right = put(h.right, key,val);
        else
            h.val = val;

        //rotation and flipColors
        if(isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.right) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }


    private Node rotateRight (Node h) {
        //rotate
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        //color update
        x.color = h.color;
        h.color = RED;
        //size update
        x.size = h.size;
        h.size = size(h.right) + size(h.left) + 1;
        return x;
    }

    private Node rotateLeft (Node h) {
        //rotate
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        //color update
        x.color = h.color;
        h.color = RED;
        //size update
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }
    // reverse the color of node and its parent.
    private void flipColors (Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public static void main(String[] args) {
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        StdOut.println();
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        StdOut.println();
    }


}
