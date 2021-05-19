package com.sort.Algorithms;

public class CountingSort {
    public static int[] countingSort(int[] A) {
        int[] B = new int[A.length];
        int k = 100;
        countingSort(A, B, k);
        return B;
    }

    public static int[] countingSort_improved(int[] A) {
        int B[] = new int[A.length];
        int max = A[0], min = A[0];
        for (int i : A) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int k = max - min + 1;
        int C[] = new int[k];
        for (int i = 0; i < A.length; i++) {
            C[A[i] - min] += 1;
        }
        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }
        for (int i = A.length - 1; i >= 0; i--) {
            B[--C[A[i] - min]] = A[i];
        }
        return B;
    }

    private static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        for (int j = 0; j < A.length; j++) {
            C[A[j]] += 1;
        }
        for (int i = 1; i < k; i++) {
            C[i] += C[i - 1];
        }
        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] -= 1;
        }
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int maxSize = 1000;
        int minSize = 100;
        int[] A = generateRandomArray(maxSize, minSize);
        int[] res = CountingSort.countingSort_improved(A);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
