package com.leetcode.arrays.medium;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int j = Integer.MAX_VALUE;
        int k = Integer.MAX_VALUE;
        for(int n:nums){
            if(n<=j)
                j=n;
            else if (n<=k) {
                k=n;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1,5,0,4,1,3}));

    }
}
