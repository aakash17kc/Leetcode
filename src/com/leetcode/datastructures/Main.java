package com.leetcode.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println(new Main().combine(1,1));
  }
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> out = new ArrayList<>();
    if(k==0){
      out.add(new ArrayList<>(n));
      return out;
    }
  if(k==1){
    for(int i=1;i<=n;i++){
      out.add(new ArrayList<>(i));
    }
    return out;
  }
    List<Integer> list = new ArrayList<>();
    for(int i=1;i<=n;i++){
      list.add(i);
    }
    int last = list.size()-1;

    while(last>=k-1){
      int st =last-k+1;
      while(st>=0){

        List<Integer> temp = new ArrayList<>(list.subList(st,st+k-1));
        temp.add(list.get(last));
        out.add(new ArrayList<>(temp));
        st--;
      }
      last--;
    }

    return out;

  }
}
