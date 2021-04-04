package array.search;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int pivot = (left + right) / 2;
            if(target == arr[pivot]) {
                return pivot;
            } else if(target < arr[pivot]) {
                right = pivot - 1;
            } else if(target > arr[pivot]) {
                left = pivot + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 10, 15, 19};
        int target = 5;

        int targetIndex = BinarySearch.search(arr, target);

        System.out.println(arr[targetIndex] == target);
    }

}
