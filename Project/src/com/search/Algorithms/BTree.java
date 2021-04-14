package com.search.Algorithms;

import com.search.Algorithms.interfaces.TreeInterface;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class BTree<Key extends Comparable<Key>, Value> {
    //Set the order of B-Tree.
    private static final int M = 4;

    private Node root;
    private int height; //The height of B-Tree.
    private int number; //The number of key-value pairs of B-Tree.

    private static final class Node {
        private int childNum;//The chldren number of a Node.
        private Entry[] children = new Entry[M];//Every node contains M Entries.

        //Set childNum of a Node.
        private Node(int k) {
            childNum = k;
        }
    }

    //Internal nodes: only use key and next
    //External nodes: only use key and value
    private static class Entry {
        private Comparable key;
        private Object val;
        private Node next;

        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Initializes an empty B-Tree.
     */
    public BTree() {
        root = new Node(0);
    }

    /**
     * Return true if table is empty.
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return the number of Key-Value pairs.
     * @return
     */
    public int size() {
        return number;
    }

    /**
     * Return the height of B-Tree.
     * @return
     */
    public int height() {
        return height;
    }

    /**
     * Return the value associated with the given key.
     *
     * @param key the key
     * @return the value in the table.
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return search(root, key, height);
    }

    /**
     * Search the key of a B-Tree which from the root to the leafnode.
     * @param x
     * @param key
     * @param height
     * @return
     */
    private Value search(Node x, Key key, int height) {
        Entry[] children = x.children;
        if (height == 0) {
            for (int j = 0; j < x.childNum; ++j) {
                if (eq(key, children[j].key)) {
                    return (Value) children[j].val;
                }
            }
        }
        else {
            for (int j = 0; j < x.childNum; ++j) {
                //fint the index and search into next level.
                if (j + 1 == x.childNum || less(key, children[j + 1].key))
                    return search(children[j].next, key, height - 1);
            }
        }
        return null;
    }

    /**
     * Insert the key-value into table.
     * Overwrite when key exists.
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null");
        //if newNode is not null means the tree need to grow a new level.[root node is full]
        Node newNode = insert(root, key, val, height);
        number++;
        if (newNode == null)
            return;
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(newNode.children[0].key, null, newNode);
        root = t;
        height++;
    }

    /**
     * Insertion with Iteration. If the node is not full, create a new entry and put the Key-Value pair on it.
     * Otherwise, split the node into half, and return to the level above... until the root node.
     *
     * @param h
     * @param key
     * @param val
     * @param height height of the tree. means search from the top[root]
     * @return
     */
    private Node insert(Node h, Key key, Value val, int height) {
        int j;
        Entry t = new Entry(key, val, null);

        if (height == 0) {
            for (j = 0; j < h.childNum; j++) {
                //find the right index of the tree.
                if (less(key, h.children[j].key))
                    break;
            }
        }
        else {
            for (j = 0; j < h.childNum; j++) {
                if ((j + 1 == h.childNum) || less(key, h.children[j + 1].key)) {
                    //Node u is null means insert successfully at the lower level. Otherwise, Node u is the half split of the node h.
                    Node u = insert(h.children[j++].next, key, val, height - 1);
                    //insert successfully and without any other movements.
                    if (u == null)
                        return null;
                    //execute when Node u is not null, connect the Entry to the Node u.
                    t.key = u.children[0].key;
                    t.val = null;
                    t.next = u;
                    break;
                }
            }
        }
        //Put the enrty into right position.
        for (int i = h.childNum; i > j; i--)
            h.children[i] = h.children[i - 1];
        h.children[j] = t;
        h.childNum++;
        //Node is full or not.
        if (h.childNum < M)
            return null;
        else
            return split(h);
    }

    /**
     * Splict the node h into half, and create a new node t contains remaining elements.
     * @param h node h which needs to split
     * @return node t
     */
    private Node split(Node h) {
        Node t = new Node(M / 2);
        h.childNum = M / 2;
        for (int j = 0; j < M / 2; ++j)
            t.children[j] = h.children[M / 2 + j];
        return t;
    }

    public String toString() {
        return toString(root, height, "") + "\n";
    }

    public String toString(Node h, int height, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;

        if (height == 0) {
            for (int j = 0; j < h.childNum; j++) {
                s.append(indent + children[j].key + " --> " + children[j].val + "\n");
            }
        } else {
            for (int j = 0; j < h.childNum; j++) {
                if (j > 0)
                    s.append(indent + "(" + children[j].key + ")\n");
                s.append(toString(children[j].next, height - 1, indent + "     "));
            }
        }
        return s.toString();
    }

    //Comparison functions - make Comparable instead of key to avoid casts.
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    public static void main(String[] args) {
        com.search.Algorithms.BTree<String, String> st = new com.search.Algorithms.BTree<String, String>();

        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu", "128.112.128.15");
        st.put("www.yale.edu", "130.132.143.21");
        st.put("www.simpsons.com", "209.052.165.60");
        st.put("www.apple.com", "17.112.152.32");
        st.put("www.amazon.com", "207.171.182.16");
        st.put("www.ebay.com", "66.135.192.87");
        st.put("www.cnn.com", "64.236.16.20");
        st.put("www.google.com", "216.239.41.99");
        st.put("www.nytimes.com", "199.239.136.200");
        st.put("www.microsoft.com", "207.126.99.140");
        st.put("www.dell.com", "143.166.224.230");
        st.put("www.slashdot.org", "66.35.250.151");
        st.put("www.espn.com", "199.181.135.201");
        st.put("www.weather.com", "63.111.66.11");
        st.put("www.yahoo.com", "216.109.118.65");
        st.put("www.baidu.com", "216.139.138.61");

//        st.put("5", "128.112.136.12");
//        st.put("3", "128.112.136.11");
//        st.put("21", "128.112.128.15");
//        st.put("9", "130.132.143.21");
//        st.put("1", "209.052.165.60");
//        st.put("13", "17.112.152.32");
//        st.put("2", "207.171.182.16");
//        st.put("7", "66.135.192.87");
//        st.put("10", "64.236.16.20");
//        st.put("12", "216.239.41.99");
//        st.put("4", "199.239.136.200");
//        st.put("8", "207.126.99.140");


        StdOut.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
        StdOut.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
        StdOut.println("simpsons.com:      " + st.get("www.simpsons.com"));
        StdOut.println("apple.com:         " + st.get("www.apple.com"));
        StdOut.println("ebay.com:          " + st.get("www.ebay.com"));
        StdOut.println("dell.com:          " + st.get("www.dell.com"));
        StdOut.println();

        StdOut.println("size:    " + st.size());
        StdOut.println("height:  " + st.height());
        StdOut.println(st);
        StdOut.println();
    }
}