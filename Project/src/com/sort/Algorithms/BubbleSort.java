package com.sort.Algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void BubbleSort(int arr[]) {
        //Easily improvement.
        int i, j;
        boolean flag = true;
        for (i = 1; i < arr.length && flag; ++i) {
            flag = false;
            for (j = arr.length - 1; j > i - 1; --j) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                    flag = true;
            }
        }
//        //Sorting from tail to head.
//
//        for (i = 1; i < arr.length; ++i) {
//            for(j = 0; j < arr.length - i; ++j) {
//                if (arr[j] > arr[j + 1]) {
//                    swap (arr, j, j + 1);
//                }
//            }
//        }
//        //Sorting from head to tail
//        for (i = 1; i < arr.length; ++i) {
//            for (j = arr.length - 1; j >= i; --j) {
//                if (arr[j] < arr[j - 1])
//                    swap(arr, j, j - 1);
//            }
//        }
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
            BubbleSort(arr1);
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
        BubbleSort(arr);
        final long duration = System.nanoTime() - startTime;
        printArray(arr);
        System.out.println("Algorithms total run time : " + duration + "ms");
    }
}

