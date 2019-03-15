package com.ansou.leetcode;

import org.junit.Assert;

import static org.junit.Assert.*;

public class MainTest {

    private Main test;

    public MainTest() {
        test = new Main();
    }

    @org.junit.Test
    public void twoSum() {
        int[] nums = {2, 7, 11, 15};
        Main test = new Main();
        Assert.assertArrayEquals(new int[]{0, 1}, test.twoSum(nums, 9));
    }

    @org.junit.Test
    public void addTwoNumbers() {
        Main.ListNode myList = test.new ListNode(2);
        Main.ListNode myList2 = test.new ListNode(5);

        myList.next = test.new ListNode(4);
        myList2.next = test.new ListNode(6);

        myList.next.next = test.new ListNode(3);
        myList2.next.next = test.new ListNode(4);

        Main.ListNode result = test.addTwoNumbers(myList, myList2);

        Assert.assertEquals(7, result.val);
        result = result.next;
        Assert.assertEquals(0, result.val);
        result = result.next;
        Assert.assertEquals(8, result.val);

    }

    @org.junit.Test
    public void lengthOfLongestSubstring() {
        Assert.assertEquals(3, test.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, test.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, test.lengthOfLongestSubstring("pwwkew"));
    }

    @org.junit.Test
    public void findMedianSortedArrays() {
        int [] nums1 = {1, 3};
        int [] nums2 = {2};
        Assert.assertEquals(2.0, test.findMedianSortedArrays(nums1, nums2), 0.1);
        Assert.assertEquals(2.0, test.findMedianSortedArrays2(nums1, nums2), 0.1);

        int [] nums3 = {1, 3};
        int [] nums4 = {2};
        Assert.assertEquals(2.0, test.findMedianSortedArrays(nums3, nums4), 0.1);
        Assert.assertEquals(2.0, test.findMedianSortedArrays2(nums3, nums4), 0.1);

        int [] nums5 = {1, 3};
        int [] nums6 = {};
        Assert.assertEquals(2.0, test.findMedianSortedArrays(nums5, nums6), 0.1);
        Assert.assertEquals(2.0, test.findMedianSortedArrays2(nums5, nums6), 0.1);

        int [] nums7 = {1};
        int [] nums8 = {};
        Assert.assertEquals(1.0, test.findMedianSortedArrays(nums7, nums8), 0.1);
        Assert.assertEquals(1.0, test.findMedianSortedArrays2(nums7, nums8), 0.1);
    }


    @org.junit.Test
    public void longestPalindrome() {
        Assert.assertTrue(test.longestPalindrome("babad").equals("aba"));
        Assert.assertTrue(test.longestPalindrome("cbbd").equals("bb"));
    }

    @org.junit.Test
    public void convert() {
        Assert.assertTrue(test.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        Assert.assertTrue(test.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    }

    @org.junit.Test
    public void reverse() {
        Assert.assertEquals(321, test.reverse(123));
        Assert.assertEquals(-321, test.reverse(-123));
        Assert.assertEquals(21, test.reverse(120));
        Assert.assertEquals(0, test.reverse(-0));
    }

    @org.junit.Test
    public void myAtoi() {
        Assert.assertEquals(1,test.myAtoi("+1"));
        Assert.assertEquals(0,test.myAtoi("-"));
        Assert.assertEquals(0,test.myAtoi("+"));
        Assert.assertEquals(0,test.myAtoi("-+1"));
        Assert.assertEquals(42,test.myAtoi("42"));
        Assert.assertEquals(-42,test.myAtoi("         -42"));
        Assert.assertEquals(4193,test.myAtoi("4193  with words"));
        Assert.assertEquals(0,test.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648,test.myAtoi("-91283472332"));
        Assert.assertEquals(2147483647,test.myAtoi("91283472332"));
    }

    @org.junit.Test
    public void isPalindrome() {
        Assert.assertTrue(test.isPalindrome(121));
        Assert.assertFalse(test.isPalindrome(120));
        Assert.assertFalse(test.isPalindrome(12));
        Assert.assertTrue(test.isPalindrome(1));
    }
}