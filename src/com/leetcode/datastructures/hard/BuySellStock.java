package com.leetcode.datastructures.hard;

public class BuySellStock {

  int maxProfit(int []prices){
    int t1cost=Integer.MAX_VALUE,t1profit = 0;
    int t2cost=Integer.MAX_VALUE,t2profit=0;

    int []leftP = new int[prices.length];
    int []rightP = new int[prices.length];
    int leftMin=0,rightMax=0;
    for (int i = 1; i < prices.length; i++) {
      leftP[i] = Math.max(leftP[i],prices[i] - leftMin);
      leftMin = Math.min(leftMin,prices[i]);

      int r = prices.length - i - 1;

      rightP[i] = Math.max(rightP[r+1],rightMax - prices[r]);
      rightMax = Math.max(rightMax,prices[r]);
    }
    int max=0;
    for (int i = 0; i < prices.length; i++) {
      max = Math.max(max, leftP[i] + rightP[i]);
    }
    return max;

  }
}
