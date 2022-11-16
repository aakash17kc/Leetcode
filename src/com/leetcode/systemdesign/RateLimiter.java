package com.leetcode.systemdesign;

import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {
  Queue<Integer> queue = new LinkedList<>();
  int num,time;
  public RateLimiter(int n, int t) {
  this.num = n;
  this.time = t;
  }

  public boolean shouldAllow(int timestamp) {
    while (!queue.isEmpty() && queue.peek() <= timestamp - time){
      queue.poll();
    }
    if(queue.size() < num){
      queue.offer(timestamp);
      return true;
    }
    return false;
  }
}
