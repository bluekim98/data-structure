package array.exam;

import java.util.*;

/**
 * LeetCode 581. Shortest Unsorted Continuous Subarray
 *
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order.
 * Return the shortest such subarray and output its length.
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 */

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0];
        int end = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < max) {
                end = i;
            }
        }

        int min = nums[nums.length - 1];
        int start = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if(nums[i] > min) start = i;
        }

        if(end == 0 && start == nums.length - 1) return 0;
        int subArrayLength = end - start + 1;
        return subArrayLength;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray solution = new ShortestUnsortedContinuousSubarray();
        List<int[]> numsList = new ArrayList<>();
        numsList.add(new int[] {2,6,4,8,10,9,15});
        numsList.add(new int[] {2,6,4,8,10,9,8, 16, 17});
        numsList.add(new int[] {1,2,3,4});
        numsList.add(new int[] {1});
        numsList.add(new int[] {1,3,2,2,2});
        numsList.add(new int[] {1,3,2,3,3});
        numsList.add(new int[] {2,1});
        numsList.add(new int[] {5,4,3,2,1});
        numsList.add(new int[] {3,2,3,2,4});
        numsList.add(new int[] {1,2,5,3,4});

        for(int[] nums : numsList) {
            System.out.println(Arrays.toString(nums));
            int subArrayLen = solution.findUnsortedSubarray(nums);
            System.out.println(subArrayLen);
        }
    }
}
