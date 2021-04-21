package com.search.Algorithms;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import jdk.nashorn.internal.runtime.arrays.IntElements;

public class SequentialSearchST<Key, Value> {
    private int n; //number of key-value pairs
    private Node head;

    //linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SequentialSearchST() {

    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        return get(key) != null;
    }


    /**
     * return the value associated with the given key in this symbol table.
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        for (Node node = head; node != null; node = node.next) {
            if (key.equals(node.key))
                return node.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (val == null) {
            delete(key);
            return;
        }
        //Hit and coverage
        for (Node node = head; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.val = val;
                return;
            }
        }
        head = new Node(key, val, head);
        n++;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        head = delete(head, key);
    }

    public Node delete(Node node, Key key) {
        if (node == null)
            return null;
        if (key.equals(node.key)) {
            n--;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }

    /**
     * Return all keys in the symbol table as an Iterable.
     * FIFO
     *
     * @return
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = head; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
