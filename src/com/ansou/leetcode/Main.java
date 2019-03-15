package com.ansou.leetcode;

import java.math.BigInteger;
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
    private double median(int[] m) {
        int middle = m.length / 2;
        if (m.length % 2 == 1) {
            return m[middle];
        } else {
            return (m[middle - 1] + m[middle]) / 2.0;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        return median(result);
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        int mod = (m + n) % 2;
        int count = 0;
        int x = 0;
        int y = 0;
        double firstNum = 0;
        double secondNum = 0;

        while (count <= mid) {
            if (x == m) {
                if (count == mid - 1)
                    firstNum = nums2[y];
                secondNum = nums2[y];
                y++;
            } else if (y == n) {
                if (count == mid - 1)
                    firstNum = nums1[x];
                secondNum = nums1[x];
                x++;
            } else if (nums1[x] <= nums2[y]) {
                if (count == mid - 1)
                    firstNum = nums1[x];
                secondNum = nums1[x];
                x++;
            } else {
                if (count == mid - 1)
                    firstNum = nums2[y];
                secondNum = nums2[y];
                y++;
            }
            count++;
        }
        if (mod > 0) {
            return secondNum;
        }
        return (firstNum + secondNum) / 2;
    }

    /* 5. Longest Palindromic Substring */
    private int expandToSide(String s, int indexLeft, int indexRight) {
        int L = indexLeft, R = indexRight;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandToSide(s, i, i);
            int len2 = expandToSide(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /* 6. ZigZag Conversion */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder();
        int pas = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += pas) {
                result.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + pas - i < s.length())
                    result.append(s.charAt(j + pas - i));
            }
        }
        return result.toString();
    }

    /* 7. Reverse Integer */
    public int reverse(int number) {
        if (number > Integer.MAX_VALUE) return 0;
        if (number < Integer.MIN_VALUE) return 0;
        Boolean isMinus = number < 0;
        number = Math.abs(number);
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb = sb.reverse();
        String intermediateString = sb.toString();
        int result = 0;
        try {
            result = Integer.parseInt(intermediateString);
        } catch (Exception e) {
            return 0;
        }

        return (isMinus) ? result * -1 : result;
    }

    /* 8. String to Integer (atoi) */
    public int myAtoi(String str) {
        int sign = 1;
        int i = 0;
        long v = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            v = v * 10 + (long) (str.charAt(i) - '0');
            if (v > Integer.MAX_VALUE || v < Integer.MIN_VALUE) break;
            i++;
        }
        v = v * sign;
        if (v > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (v < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) v;
    }

    /* 9. Palindrome Number */
    public boolean isPalindrome(int x) {
        Integer number = new Integer(x);
        StringBuilder input1 = new StringBuilder();
        input1.append(number.toString());
        input1.reverse();
        return number.toString().equals(input1.toString());
    }

    /* Swap Nodes in Pairs */
    private  void swap(ListNode l1, ListNode l2) {
        int tmp = l1.val;
        l1.val = l2.val;
        l2.val = tmp;
    }

    public  ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null)
        {
            swap(head, head.next);
            swapPairs(head.next.next);
        }
        return head;
    }

    /* Reverse String */
    public void reverseString(char[] s) {
      helper(0, s.length - 1, s);
    }

    private void helper(int start, int end, char [] s) {
      if (start >= end) {
        return;
      }
      char tmp = s[start];
      s[start] = s[end];
      s[end] = tmp;

      helper(start + 1, end - 1, s);
   }

    /* Pascal's Triangle */
    public int calcPascal(int row, int column) {
        if (row == column || row == 0 || column == 0)
            return 1;
        else
            return calcPascal(row - 1, column - 1) + calcPascal(row - 1, column);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> columns = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                columns.add(calcPascal(i, j));
            }
            rows.add(columns);
        }
        return rows;
    }

    /* Pascal's Triangle II */
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
