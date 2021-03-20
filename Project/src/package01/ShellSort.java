package package01;

import java.util.Arrays;

public class ShellSort {
    //Tradition solution
//    public static void ShellSortTradition(int arr[]) {
//        int i, j, gap, temp;
//        for (gap = arr.length / 2; gap > 0; gap /= 2) {
//            //inseration sort
//            for (i = gap; i <= arr.length; ++i) {
//                temp = arr[i];
//                if(arr[i - gap] > arr[i])
//                    for (j = i; j >= 0 ; j -= gap) {
//                        arr[j] = arr[j - gap];
//                    }
//            }
//        }
//    }

    public static void ShellSort(int arr[]) {
        //exchange
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //每次都与相隔gap位的值进行比较
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //swap the element
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    //move
    public static void ShellSort_move(int arr[]) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //每次都与相隔gap位的值进行比较
                int j = i;
                int temp = arr[i];
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void ShellSortFor(int arr[]) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; ++i) {
                for (int j = i; j - gap >= 0 && arr[j] < arr[j - gap]; j -= gap){
                    swap(arr, j, j - gap);
                }
            }
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
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            ShellSort(arr1);
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
        ShellSort_move(arr);
        final long duration = System.nanoTime() - startTime;
        printArray(arr);
        System.out.println("Algorithms total run time : " + duration + "ms");
    }
}

