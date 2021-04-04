package array.exam;

import java.util.*;

/**
 * LeetCode 724. Find Pivot Index
 *
 *
 * Given an array of integers nums, calculate the pivot index of this array.
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        // nums의 전체 value 합 구한다
        int allSum = 0;
        for (int val : nums) allSum += val;

        // 초기값을 설정한다 (왼쪽 파트의 합과 , 오른쪽 파트의 합)
        int leftSum = 0;
        int rightSum = allSum - nums[0];

        // index 한칸씩 전진하며 pivot 조건에 맞는지 확인한다
        for(int idx = 0; idx < nums.length; idx++) {
            if(idx != 0) {
                leftSum = leftSum + nums[idx - 1];
                rightSum = rightSum - nums[idx];
            }
            // pivot조건에 부합하면 해당 index를 리턴한다
            if(leftSum == rightSum) return idx;
        }
        // pivot index가 존재하지 않으면 return -1 처리한다
        return -1;
    }

    public static void main(String[] args) {
        // given
        List<int[]> numsList = new ArrayList<>();
        numsList.add(new int[] {1,7,3,6,5,6});
        numsList.add(new int[] {1,2,3});
        numsList.add(new int[] {2, 1, -1});

        for(int[] nums : numsList) {
            // when
            int pivotIndex = new FindPivotIndex().pivotIndex(nums);

            // then
            System.out.println(Arrays.toString(nums));
            System.out.println("pivotIndex : " + pivotIndex);
        }

    }
}
