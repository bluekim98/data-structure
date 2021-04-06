package array.exam;

import java.util.*;

/**
 * LeetCode 75. Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 */

    /*
        1. zeroPointer, twoPointer, workerPointer 설정
        2. workerPointer가 0인경우 zeroPointer와 스왑하고
        3. zero, worker 각각 한칸씩 전진
        4. workerPointer가 2인경우 twoPointer와 스왑하고 (이때 worker자리에 0이 올 수 있기 때문에 한번 더 검사해야한다)
        5. two 한칸 전진 (two--)
        6. workerPointer가 1인경우 worker만 한칸 전진
     */
public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0;
        int worker = 0;
        int two = nums.length - 1;

        while(worker <= two) {
            if(nums[worker] == 0) {
                swap(nums, zero, worker);
                zero++;
                worker++;
            } else if(nums[worker] == 2) {
                swap(nums, two, worker);
                two--;
            } else {
                worker++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sort = new SortColors();
        // given
        List<int[]> numsList = new ArrayList<>();
        numsList.add(new int[] {2,0,2,1,1,0});
        numsList.add(new int[] {2,0,1});
        numsList.add(new int[] {0});
        numsList.add(new int[] {1});

        for(int [] nums : numsList) {
            // when
            sort.sortColors(nums);
            //then
            System.out.println(Arrays.toString(nums));
        }
    }
}
