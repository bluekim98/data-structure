package array.exam;

import java.util.*;

/**
 * LeetCode 209. Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Constraints:
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        /*
            1. end pointer를 전진시키며 sub-array의 sum 값을 점차 증가시킨다
            2. sum값이 target에 도달한 경우 sub-array의 length값을 취한다
            3. start pointer를 전진시키고 다시 1 ~ 2 작업을 수행한다
         */

        int start = 0;
        int end = 0;
        int sum = nums[start];
        int len = 0;

        while(start <= end && end < nums.length) {
            if(sum < target) {
                // 현재 합계가 타겟에 도달하지 않은 경우 end pointer를 전진시킨다
                end++;
                if(end < nums.length) sum += nums[end];
            } else if(sum >= target){
                // 현재 합계가 타겟에 도달한 경우 sub-array길이를 구하고, min 값을 취한다
                int currentLen = end - start + 1;
                len = len == 0 ? currentLen : Math.min(len, currentLen);

                // 합계가 타겟보다 초과한 경우 start pointer를 전진시켜 length가 더 작은 경우가 있는지 찾는다
                if(sum > target) {
                    sum -= nums[start++];
                } else {
                    // sum == target인 경우 end pointer를 전진시킨다
                    end++;
                    if(end < nums.length) sum += nums[end];
                }
            }
        }

        return len;
    }

    public static void main(String[] args) {
        // given
        Map<Integer, int[]> numsMap = new HashMap<>();
        numsMap.put(7, new int[] {2,3,1,2,4,3});
        numsMap.put(4, new int[] {1,4,4});
        numsMap.put(11, new int[] {1,1,1,1,1,1,1,1});

        for(int target : numsMap.keySet()) {
            // when
            int len = new MinimumSizeSubarraySum().minSubArrayLen(target, numsMap.get(target));

            // then
            System.out.println(Arrays.toString(numsMap.get(target)));
            System.out.println("len : " + len);
        }
    }
}
