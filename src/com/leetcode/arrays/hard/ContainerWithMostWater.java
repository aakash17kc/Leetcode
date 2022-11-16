package com.leetcode.arrays.hard;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {

    int ans = Integer.MIN_VALUE;
    int left=0,right=height.length-1;
    while (left<right){
      int heigh = Math.min(height[left],height[right]);
      int water = heigh * (right-left);
      ans = Math.max(ans, water);
      if(height[left] < height[right])
        left++;
      else
        right--;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
  }
}
