package com.leetcode.arrays.medium;

public class LongestPalindromicString {
    int maxLen = -1;
    String res = "";

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int n = s.length();
        for (int i = 0; i < n ; i++) {
            getPalingLength(s, i, i);
            getPalingLength(s, i, i + 1);
        }
        return res;
    }

    private void getPalingLength(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;

        }
        if(l<0) {
            l = 0;
        }else {
            l=l+1;
        }
        if(r>s.length()-1) {
            r = s.length();
        }
        if (maxLen < r - l - 1) {
            maxLen = r - l - 1;
            res = s.substring(l, r);
        }
    }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicString().longestPalindrome("babab"));
    }
}
