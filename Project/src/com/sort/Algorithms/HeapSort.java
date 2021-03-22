package com.sort.Algorithms;

import java.util.Arrays;

public class HeapSort {
    /**
     * build heap
     * @param arr the sorting array
     */
    public static void heapSort(int arr[]) {
        //build a maxheap
        for (int i = arr.length / 2 - 1; i >= 0; --i) {
            maxHeapify(arr, i, arr.length);
        }
        //where heapsort happened
        for (int j = arr.length - 1; j > 0; --j) {
            swap(arr, 0, j);
            maxHeapify(arr, 0, j);
        }
    }

    /**
     * maintain heap, iteration.
     * @param arr
     * @param start
     * @param end
     */
    public static void maxHeapify(int arr[], int start, int end) {
        int temp = arr[start];
        for (int i = start * 2 + 1; i < end; i = i * 2 + 1) {
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
        int temp = arr[start];
        int rightChild = start * 2 + 1;
        int leftChild = rightChild + 1;
        int maxIndex = rightChild;
        //find largest among root, left child and right child
        if (leftChild > end){
            return ;
        }
        if (leftChild < end && arr[rightChild] < arr[leftChild]) {
            maxIndex = leftChild;
        }
        //swap and continue heapifying if root isn't largest
        if (arr[maxIndex] > temp) {
            swap(arr, maxIndex, start);
            maxHeapifyRecursion(arr, maxIndex, end);
        }
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
