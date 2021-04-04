package array.sort;

import java.util.Arrays;

public class MergeSort {
    private static int[] temp;

    public static void sort(int[] arr) {
        temp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if(start < end) {
            int middle = (start + end) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        for(int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int part1 = start;
        int part2 = middle + 1;
        int idx = start;

        while(part1 <= middle && part2 <= end) {
            if(temp[part1] <= temp[part2]) {
                arr[idx++] = temp[part1++];
            } else {
                arr[idx++] = temp[part2++];
            }
        }

        for(int i = part1; i <= middle; i++) {
            arr[idx++] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 4, 14, 5,  9, 20, 3};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
