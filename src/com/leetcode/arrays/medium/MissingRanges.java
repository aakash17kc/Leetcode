package com.leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<>();
        int start = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (start + 1 <= curr - 1) {
                res.add(formatRange(start + 1, curr - 1));
            }
            start = curr;

        }
        return res;

    }
    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }

    public static void main(String[] args) {
        System.out.println(new MissingRanges().findMissingRanges(new int[]{}, -1000000000, 1000000000));
    }
}
