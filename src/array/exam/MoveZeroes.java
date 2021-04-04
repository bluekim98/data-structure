package array.exam;

import java.util.Arrays;

/**
 * LeetCode 283. Move Zeroes
 *
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroIdx = 0;
        for(int anotherIdx = 0; anotherIdx < nums.length; anotherIdx++) {
            if(nums[anotherIdx] != 0) {
                nums[zeroIdx] = nums[anotherIdx];
                zeroIdx++;
            }
        }
        Arrays.fill(nums, zeroIdx, nums.length, 0);
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0};

        int[] nums = nums1;
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
