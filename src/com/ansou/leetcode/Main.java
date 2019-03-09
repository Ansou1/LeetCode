package com.ansou.leetcode;

import java.util.*;
import java.util.stream.Collectors;

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
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
