package com.search.Algorithms;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HashLinearProbing<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int N; // number of key-value pairs
    private int M; // size of linear probing table
    private Key[] keys;
    private Value[] vals;

    public HashLinearProbing() {
        this(INIT_CAPACITY);
    }

    public HashLinearProbing(int capacity) {
        M = capacity;
        N = 0;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        return get(key) != null;
    }

    private int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (M - 1);
    }

    /**
     * Resize the hash table with the given chains
     *
     * @param chains
     */
    private void resize(int chains) {
        HashLinearProbing<Key, Value> tempArray = new HashLinearProbing<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                tempArray.put(keys[i], vals[i]);
        }
        keys = tempArray.keys;
        vals = tempArray.vals;
        M = tempArray.M;
    }

    /**
     * Put the key and val to the table.
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

        //double size if 50% full
        if (N > M / 2)
            resize(2 * M);
        int i;

        //Coverage when exists. find null to insert
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    /**
     * Return the values associated with the key.
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    /**
     * Delete the values associated with the key.
     *
     * @param key
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("get() is null");
        if (!contains(key))
            return;

        //find the position of key.
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        //clear
        keys[i] = null;
        vals[i] = null;
        //can't search the next element if we only set the keys and vals to null.
        //we need rehash and reinsert again.
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key RehashKey = keys[i];
            Value RehashVal = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(RehashKey, RehashVal);
            i = (i + 1) % M;
        }
        N--;
        //halves size of array if it's 12.5% full or less.
        if (N > 0 && N <= M / 8)
            resize(M / 2);
        assert check();
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    private boolean check() {
        if (M < 2 * N) {
            System.err.println("Hash table size M is " + M + "; Array size N is " + N);
            return false;
        }

        //wether each key can be found by get()
        for (int i = 0; i < M; i++) {
            if (keys[i] == null)
                continue;
            else if (get(keys[i]) != vals[i]) {
                //report error.
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HashLinearProbing<String, Integer> st = new HashLinearProbing<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
