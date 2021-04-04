package array.sort;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int partIdx = partition(arr, start, end);
        if(start < partIdx - 1) {
            quickSort(arr, start, partIdx - 1);
        }
        if(end > partIdx) {
            quickSort(arr, partIdx, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int middleIndex = (start + end) / 2;
        int pivot = arr[middleIndex];

        while(start <= end) {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;

            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {4, 2, 1, 6, 10, 17, 10, 3};
        QuickSort.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
