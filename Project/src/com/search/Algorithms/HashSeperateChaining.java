package com.search.Algorithms;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HashSeperateChaining<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    //Use array M < N linked list.
    private int N; //number of key-value pairs
    private int M; //hash table size
    private SequentialSearchST<Key, Value>[] st; //array of linked-list symbol tables

    public HashSeperateChaining() {
        this(INIT_CAPACITY);
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Initializes an empty symbol table with m chains.
     *
     * @param M
     */
    public HashSeperateChaining(int M) {
        //Creating M chains.
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {
        //hash function for keys - return value between 0 and m - 1
        //return (key.hashCode() & 0x7fffffff) % M;
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (M - 1);
    }

    /**
     * Return the value associated with specified key.
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        return (Value) st[hash(key)].get(key);
    }

    /**
     * Insert the specified key-value into the table.
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (val == null) {
            delete(key);
            return;
        }
        //double table size if average length of list >= 10;
        if (N >= 10 * M)
            resize(2 * M);
        int i = hash(key);
        if (st[i].contains(key))
            N++;
        st[i].put(key, val);
    }


    /**
     * Remove the specified key and its associated value.
     *
     * @param key
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        int i = hash(key);
        if (st[i].contains(key))
            N--;
        st[i].delete(key);
        //resize if average length of list <= 2;
        if (M > INIT_CAPACITY & N <= 2 * M)
            resize(M / 2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }

    /**
     * Resize the hash table with the given chains
     *
     * @param chains
     */
    private void resize(int chains) {
        HashSeperateChaining<Key, Value> tempArray = new HashSeperateChaining<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            for (Key key : st[i].keys()) {
                tempArray.put(key, st[i].get(key));
            }
        }
        this.M = tempArray.M;
        this.N = tempArray.N;
        this.st = tempArray.st;
    }

    /**
     * StdIn: use CTRL + D to terminate.
     *
     * @param args
     */
    public static void main(String[] args) {
        HashSeperateChaining<String, Integer> st = new HashSeperateChaining<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
