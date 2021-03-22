package com.sort.Algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int Index = partition(arr, low, high);

            quickSort(arr, low, Index - 1);
            quickSort(arr, Index + 1, high);
        }
    }
    //The goal of partition function: find the right position of pivot.
    // Both partition functions is acceptable.
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        //find every number which is lower than pivot, then put those to the low side.
        for (int j = low; j < high; ++j) {
            if (arr[j] < pivot) {
                ++i;
                swap(arr, i, j);
            }
        }
        //swap the last time
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static int moveBothPartition(int arr[], int low, int high) {
        int pivot = arr[high];
        while (low < high) {
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            swap(arr, low, high);
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            swap(arr, low, high);
        }
        return low;
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
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1, 0, arr1.length - 1);
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
        quickSort(arr, 0, arr.length - 1);
        final long duration = System.nanoTime() - startTime;
        printArray(arr);
        System.out.println("Algorithms total run time : " + duration + "ms");
    }
}
