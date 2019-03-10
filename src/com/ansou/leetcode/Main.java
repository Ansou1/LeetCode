package com.ansou.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    /* Two sum  */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /* Add Two Number */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;

        for (int i = 0; l1 != null || l2 != null || i > 0; ) {
            int n1 = l1 != null ? l1.val : 0;
            l1 = l1 != null ? l1.next : null;
            int n2 = l2 != null ? l2.val : 0;
            l2 = l2 != null ? l2.next : null;

            int sum = n1 + n2 + i;
            ListNode node = new ListNode(sum % 10);
            i = sum / 10;
            cur.next = node;
            cur = node;
        }

        return result.next;
    }

    /* 3. Longest Substring Without Repeating Characters */

    public int lengthOfLongestSubstring(String s) {
        int result = 0, j = 0, i = 0;
        int totalLength = s.length();
        Set<Character> set = new HashSet<>();

        while (i < totalLength && j < totalLength) {
            if (set.contains(s.charAt(j)))
                set.remove(s.charAt(i++));
            else {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }
        }

        return result;
    }

    /* 4. Median of Two Sorted Arrays */
    public static double median(int[] m) {
        int middle = m.length/2;
        if (m.length % 2 == 1) {
            return m[middle];
        } else {
            return (m[middle-1] + m[middle]) / 2.0;
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        return median(result);
    }



    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m+n)/2;
        int mod = (m+n)%2;
        int count = 0;
        int x = 0;
        int y = 0;
        double firstNum = 0;
        double secondNum = 0;

        while (count <= mid) {
            if (x == m) {
                if (count == mid-1)
                    firstNum = nums2[y];
                secondNum = nums2[y];
                y++;
            } else if (y == n) {
                if (count == mid-1)
                    firstNum = nums1[x];
                secondNum = nums1[x];
                x++;
            } else if (nums1[x]<=nums2[y]) {
                if (count == mid-1)
                    firstNum = nums1[x];
                secondNum = nums1[x];
                x++;
            } else {
                if (count == mid-1)
                    firstNum = nums2[y];
                secondNum = nums2[y];
                y++;
            }
            count++;
        }
        if (mod>0){
            return secondNum;
        }
        return (firstNum+secondNum)/2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 3};
        int[] nums4 = {2};
        System.out.println(findMedianSortedArrays(nums3, nums4));

        int[] nums5 = {2};
        int[] nums6 = {};
        System.out.println(findMedianSortedArrays(nums5, nums6));

        int[] nums7 = {3};
        int[] nums8 = {-2, -1};
        System.out.println(findMedianSortedArrays(nums7, nums8));
    }
}
