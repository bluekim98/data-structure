package array.exam;

import java.util.*;

/**
 * LeetCode 88. Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 *
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */

/*
1. p1(nums1 유효수 가장 끝 index), p2(nums2 유효수 가장 끝 index), idx(num1 가장 끝) 설정
2. nums1[p1]과 nums2[p2] 비교하여 더 큰수 index자리에 설정
3. index-- , p1-- or p2--
4. nums1이 먼저 끝나버려서 nums2가 남아있을 경우가 있으니 마무리 처리해준다  

 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int idx = m + n - 1;
        if(p2 < 0) return;

        while(p1 >= 0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[idx--] = nums1[p1--];
            } else {
                nums1[idx--] = nums2[p2--];
            }
        }

        while(p2 >= 0) {
            nums1[idx--] = nums2[p2--];
        }
    }

    static class Node {
        int[] nums;
        int m;
        public Node(int[] nums, int m) {
            this.nums = nums;
            this.m = m;
        }
    }
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        // given
        Node node1 = new Node(new int[] {1,2,3,0,0,0}, 3);
        Node node2 = new Node(new int[] {2,5,6}, 3);
        Node[] q1 = {node1, node2};

        Node node3 = new Node(new int[] {1}, 1);
        Node node4 = new Node(new int[] {}, 0);
        Node[] q2 = {node3, node4};

        List<Node[]> list = new ArrayList<>();
        list.add(q1);
        list.add(q2);

        for(Node[] node : list) {
            Node n1 = node[0];
            Node n2 = node[1];
            int m = n1.m;
            int[] nums1 = n1.nums;
            int n = n2.m;
            int[] nums2 = n2.nums;
            //when
            msa.merge(nums1, m, nums2, n);
            // then
            System.out.println(Arrays.toString(nums1));
        }


    }
}
