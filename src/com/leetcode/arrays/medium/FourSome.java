package com.leetcode.arrays.medium;

import java.util.*;

public class FourSome {
    //Given an array, return list of 4(also K) unique items that add to target.
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums,target,0,4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(start==nums.length)
            return res;
        long avg = target/k;
        if(nums[start] > avg || nums[nums.length-1] < avg){
            return res;
        }
        if(k==2){
            return twoSum(nums,target,start);
        }
        for (int i = start; i < nums.length; i++) {
            if(i==start || nums[i]!=nums[i-1]){
                for(List<Integer> subset : kSum(nums,target-nums[i],i+1,k-1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();

        for (int i = start; i < nums.length; ++i) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    res.add(Arrays.asList((int)target - nums[i], nums[i]));
                }
            }
            s.add((long)nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FourSome().fourSum(new int[]{1,0,-1,0,-2,2},0));
    }
}
