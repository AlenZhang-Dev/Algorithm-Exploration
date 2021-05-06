package com.sort.Algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPriorityQueue<Key> implements Iterable<Key> {
    private Key[] priorityQueue;
    private int number; //numbers in priority queue
    private Comparator<Key> comparator;

    /**
     * Initializes an empty priority queue.
     */
    public MaxPriorityQueue() {
        this(1);
    }

    /**
     * Initialize a priority queue with initCapacity size.
     *
     * @param capacity
     */
    public MaxPriorityQueue(int capacity) {
        priorityQueue = (Key[]) new Object[capacity + 1];
        number = 0;
    }

    /**
     * Initialize a priority queue with given comparator and initial capacity.
     *
     * @param capacity
     * @param comparator
     */
    public MaxPriorityQueue(int capacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        priorityQueue = (Key[]) new Object[capacity + 1];
        number = 0;
    }

    public MaxPriorityQueue(Comparator<Key> comparator) {
        this(1, comparator);
    }

    /**
     * Initialize a priority queue an exists keys[]
     *
     * @param keys
     */
    public MaxPriorityQueue(Key[] keys) {
        number = keys.length;
        priorityQueue = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < number; i++) {
            priorityQueue[i + 1] = keys[i];
        }
        for (int k = number / 2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }

    public boolean isEmpty() {
        return number == 0;
    }

    public int size() {
        return number;
    }

    /**
     * Return the largest key on the priority queue.
     *
     * @return
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority is empty");
        return priorityQueue[1];
    }

    private void resize(int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= number; i++) {
            temp[i] = priorityQueue[i];
        }
        priorityQueue = temp;
    }

    public void insert(Key key) {
        if (number == priorityQueue.length - 1)
            resize(2 * priorityQueue.length);
        //put the key to the end of the array.
        priorityQueue[++number] = key;
        swim(number);
        assert isMaxHeap();
    }

    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("no elements");
        Key max = priorityQueue[1];
        exchange(1, number--);
        sink(1);
        priorityQueue[number + 1] = null;
        if ((number > 0) && (number == priorityQueue.length / 4))
            resize(priorityQueue.length / 2);
        assert isMaxHeap();
        return max;
    }

    private void sink(int k) {
        //2 * k == number which means k
        while (2 * k <= number) {
            int j = 2 * k;
            // j == number means j is the last element.
            if (j < number && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exchange(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k /= 2;
        }
    }

    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) priorityQueue[i]).compareTo(priorityQueue[j]) < 0;
        } else {
            return comparator.compare(priorityQueue[i], priorityQueue[j]) < 0;
        }
    }

    private void exchange(int i, int j) {
        Key temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
    }

    private boolean isMaxHeap() {
        for (int i = 0; i <= number; i++) {
            if (priorityQueue[i] == null)
                return false;
        }
        for (int i = number + 1; i < priorityQueue.length; i++) {
            if (priorityQueue[i] != null)
                return false;
        }
        if (priorityQueue[0] != null)
            return false;
        return isMaxHeapOrdered(1);
    }

    private boolean isMaxHeapOrdered(int k) {
        if (k > number)
            return true;
        int left = 2 * k;
        int right = left + 1;
        if (left <= number && less(k, left))
            return false;
        if (right < number && less(k, right))
            return false;
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        private MaxPriorityQueue<Key> temp;

        //add all the element to the temp.
        public HeapIterator() {
            if (comparator == null)
                temp = new MaxPriorityQueue<Key>(size());
            else
                temp = new MaxPriorityQueue<Key>(size(), comparator);
            for (int i = 0; i <= number; i++)
                temp.insert(priorityQueue[i]);
        }

        public boolean hasNext() {
            return !temp.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return temp.delMax();
        }
    }

    /**
     * input: P Q E - X A M - P L E -
     */
    public static void main(String[] args) {
        MaxPriorityQueue<String> priorityQueue = new MaxPriorityQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                priorityQueue.insert(item);
            else if (!priorityQueue.isEmpty())
                StdOut.print(priorityQueue.delMax() + " ");
        }
//        priorityQueue.insert("Hello");
//        priorityQueue.insert("world");
//        priorityQueue.insert("e");
//        priorityQueue.insert("r");
//        priorityQueue.delMax();
        StdOut.println("(" + priorityQueue.size() + " left on pq)");
    }
}



