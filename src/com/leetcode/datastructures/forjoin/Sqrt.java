package com.leetcode.datastructures.forjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Sqrt extends RecursiveAction {
  final int sqT = 1000;

  public Sqrt(int start, int end, double[] vals) {
    this.start = start;
    this.end = end;
    this.vals = vals;
  }

  int start;
  int end;
  double[] vals;

  @Override
  protected void compute() {
    if(end-start < sqT){
      for (int i = start; i < end; i++) {
        vals[i] = Math.sqrt(vals[i]);
      }
    }else {
      int mid = (start + end)/2;
      invokeAll(new Sqrt(start,mid,vals),new Sqrt(mid,end,vals));
    }
  }
}

class ForkJoinDemo{
  public static void main(String[] args) {
    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    double[] vals = new double[10000];
    for (int i = 0; i < 10000 ; i++) {
      vals[i] = i;
    }
    Sqrt sqrt = new Sqrt(0,vals.length,vals);

    forkJoinPool.invoke(sqrt);

    for (int i = 0; i < 10; i++) {
      System.out.format("%.4f , ",vals[i]);

    }
  }

}
