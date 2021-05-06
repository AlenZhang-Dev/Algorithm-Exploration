package com.sort.Algorithms;

import java.util.Arrays;

public class HeapSort {
    /**
     * build heap，the heap start from the index 0.
     * @param arr the sorting array
     */
//    public static void heapSort(int arr[]) {
//        //build a maxheap, from first non-leaf node.
//        for (int i = arr.length / 2 - 1; i >= 0; --i) {
//            maxHeapify(arr, i, arr.length);
//        }
//        //where heapsort happened
//        for (int j = arr.length - 1; j > 0; --j) {
//            swap(arr, 0, j);
//            maxHeapify(arr, 0, j);
//        }
//    }

    public static void heapSort(int arr[]) {
        int i = parent(arr.length);
        while(i >= 0) {
            maxHeapify(arr, i, arr.length);
            --i;
        }
        int j = arr.length - 1;
        while(j > 0) {
            swap(arr,0, j);
            maxHeapify(arr, 0, j);
            --j;
        }
    }

    /**
     * Assume subtree start from start, maintain the arr[start] element to the right place.[sink]
     * @param arr
     * @param start
     * @param end
     */
    public static void maxHeapify(int arr[], int start, int end) {
        int temp = arr[start];
        for (int i = leftChild(start); i < end; i = i * 2 + 1) {
            //find largest among root, left child and right child
            if (i + 1 < end && arr[i] < arr[i + 1]) {
                i++;
            }
            //swap and continue heapifying if root isn't largest
            if (arr[i] > temp) {
                swap(arr, start, i);
                start = i;
                temp = arr[i];
            } else {
                break;
            }
        }
    }

    /**
     * maintain heap, recursion.
     * @param arr
     * @param start
     * @param end
     */
    public static void maxHeapifyRecursion(int arr[], int start, int end) {
        //save the current root in case the child is bigger than root.
        int temp = arr[start];
        int left = leftChild(start);
        int right = rightChild(start);
        int max = left;
        //if one's right child is bigger than end, definatly his left child is invalid
        if(right > end) {
            return;
        }
        //if one's right child is valid.
        if(right < end && arr[right] > arr[left]) {
            max = right;
        }
        if(arr[max] > temp){
            swap(arr, max, start);
            maxHeapifyRecursion(arr, max, end);
        }
    }

    //The array start from index 0, there are some different with index start from 1.
    private static int parent(int i){
        return (i / 2 - 1);
    }

    private static int leftChild(int i){
        return (i * 2 + 1);
    }

    private static int rightChild(int i) {
        return (i * 2 + 2);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /*
    The generator which is generate number from [0, maxValue] in an array.
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            //make sure generate number from negative to positive.
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 200;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "What a sexy algorithms!" : "bug bug bug fucking bug!");

        System.out.println("Generate an random array ");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        System.out.println("After sorting");
        final long startTime = System.nanoTime();
        heapSort(arr);
        final long duration = System.nanoTime() - startTime;
        printArray(arr);
        System.out.println("Algorithms total run time : " + duration + "ms");
    }
}
