package com.leetcode.arrays.hard;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int prod = 1;
        boolean flag=false;
        int pos=-1;
        int zero_count=0;
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                flag=true;
                pos=i;
                zero_count++;
            }
            else
                prod=prod*nums[i];
        }
        if(flag){
            Arrays.fill(res,0);
            //if there is only one zero, the respective postion will have the product of remaning items
            //if there are more than one zeros, result will include only zero values.
            if(zero_count==1)
                res[pos]=prod;
        }else{
            for(int i=0;i<nums.length;i++){
                res[i] = prod/nums[i];
            }
        }
        return res;

    }
}
