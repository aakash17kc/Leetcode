package com.leetcode.datastructures.graph;

public class ConnectedProvince2DMatrix {

  public static void main(String[] args) {
    int [][]isConnected = {{1,1,0},{1,1,0},{0,0,1}};

    if(isConnected.length == 0){
      System.out.println(0);
    }

    int n = isConnected.length;
    DisjointSet disjointSet = new DisjointSet(n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(isConnected[i][j] == 1){
          disjointSet.union(i,j);
        }

      }

    }

    System.out.println(disjointSet.getCount());
  }
}
