package com.leetcode.datastructures.graph;

import java.util.Arrays;

public class BellmanFord {

  public static void main(String[] args) {


    int[][] graph = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
    int n = 4;
    int atMost = 1;

    int[] prev = new int[n];
    int[] curr = new int[n];
    int src = 0, dest = 3;
    if (src == dest) {
    }

    Arrays.fill(prev, Integer.MAX_VALUE);
    Arrays.fill(curr, Integer.MAX_VALUE);
    prev[src] = 0;
    //loop on the input k+2 times where we can have k most stops(for 0, 2 vertices will be visisited)
    for (int i = 1; i < atMost + 2; i++) {
      curr[src] = 0;
      for (int[] flight : graph) {
        int prev_flight = flight[0];
        int curr_flight = flight[1];
        int cost = flight[2];
        if (prev[prev_flight] < Integer.MAX_VALUE) {
          curr[curr_flight] = Math.min(curr[curr_flight], prev[prev_flight] + cost);
        }
      }
      prev = curr.clone();
    }

    System.out.println(curr[dest] == Integer.MAX_VALUE ? -1:curr[dest] );
    int ans = Integer.MIN_VALUE;

//    for (int i = 1; i <= n; i++) {
//      ans = Math.max(ans, visited[i]);
//    }

  }
}
