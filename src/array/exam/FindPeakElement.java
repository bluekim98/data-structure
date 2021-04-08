package array.exam;

import java.util.*;


/**
 * LeetCode 162. Find Peak Element
 *
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Constraints:
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;

        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while(leftIdx < rightIdx) {
            int pivotIdx = (leftIdx + rightIdx) / 2;
            int current = nums[pivotIdx];
            int next = nums[pivotIdx + 1];

            if(current < next) {
                leftIdx = pivotIdx + 1;
            } else {
                rightIdx = pivotIdx;
            }
        }

        return leftIdx;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        List<int[]> numsList = new ArrayList<>();
        numsList.add(new int[] {1,2,3,1});
        numsList.add(new int[] {1,2,1,3,5,6,4});
        numsList.add(new int[] {-2147483647,-2147483648});

        for(int[] nums : numsList) {
            int peekElement = solution.findPeakElement(nums);
            System.out.println(peekElement);
        }
    }
}
