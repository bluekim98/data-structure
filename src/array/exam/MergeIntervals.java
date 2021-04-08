package array.exam;

import java.util.*;

/**
 * LeetCode 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Constraints:
 *1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 */

public class MergeIntervals {
// 1. 0 index기준으로 모두 정렬
// 2. 현재와 이전(-1) 비교
// 3. 머지대상 아닌경우 이전(-1) 배열 그대로 입력
// 4. 머지 대상인경우 현재 배열 업데이트
// 5. intervals의 마지막 배열을 입력
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > intervals[i-1][1]) {
                list.add(intervals[i-1]);
            } else {
                intervals[i][0] = Math.min(intervals[i][0], intervals[i-1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i-1][1]);
            }
        }
        list.add(intervals[intervals.length-1]);
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            res[i][0] = cur[0];
            res[i][1] = cur[1];
        }

        return res;
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        List<int[][]> list = new ArrayList<>();
        list.add(new int[][] {{1,3},{2,6},{8,10},{15,18}});
        list.add(new int[][] {{1,4},{4,5}});

        for(int[][] intervals : list) {
            int[][] merged = solution.merge(intervals);
            System.out.println(Arrays.deepToString(merged));
        }
    }
}
