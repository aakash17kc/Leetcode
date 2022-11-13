package com.leetcode.arrays.medium;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum_TwoPointer(int[] nums) {
        // 0 sum cannot be achived when nums[i] >0
        //loop till nums[i]<=0
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumII(nums, i, res);
            }
        }
        return new ArrayList<>(res);
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }

    public List<List<Integer>> threeSum_NoSort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < n; j++) {
                    int comp = -nums[i] - nums[j];
                    if (map.containsKey(comp) && map.get(comp) == i) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], comp);
                        Collections.sort(list);
                        res.add(list);
                    }
                    map.put(nums[j], i);

                }
            }
        }
        return new ArrayList<>(res);

    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum_NoSort(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum_TwoPointer(new int[]{-1, 0, 1, 2, -1, -4}));

    }
}
