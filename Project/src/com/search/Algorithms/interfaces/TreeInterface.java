package com.search.Algorithms.interfaces;

public interface TreeInterface<T> {
    /**
     * Add value to the tree. Tree can contain multiple equal values.
     *
     * @param value to add to the tree.
     * @return True if successfully added to tree.
     */
    public boolean add(T value);

    /**
     * Remove first occurrence of value in the tree.
     *
     * @param value to remove from the tree.
     * @return T value removed from tree.
     */
    public T remove(T value);

    /**
     * Clear the entire stack.
     */
    public void clear();

    /**
     * Does the tree contain the value.
     *
     * @param value to locate in the tree.
     * @return True if tree contains value.
     */
    public boolean contains(T value);

    /**
     * Get number of nodes in the tree.
     *
     * @return Number of nodes in the tree.
     */
    public int size();

    /**
     * Validate the tree according to the invariants.
     *
     * @return True if the tree is valid.
     */
    public boolean validate();

    /**
     * Get Tree as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    public java.util.Collection<T> toCollection();
}
