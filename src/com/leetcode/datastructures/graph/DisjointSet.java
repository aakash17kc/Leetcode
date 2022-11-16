package com.leetcode.datastructures.graph;

public class DisjointSet {
  int []root;
  int []rank;

  int count;

  public DisjointSet(int n){
    root = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = i;
      rank[i] = 1;
    }
    count = n;
  }
  public static void main(String[] args) {


    DisjointSet disjointSet = new DisjointSet(10);
    disjointSet.union(1, 2);
    disjointSet.union(2, 5);
    disjointSet.union(5, 6);
    disjointSet.union(6, 7);
    disjointSet.union(3, 8);
    disjointSet.union(8, 9);

    System.out.println(disjointSet.connected(1, 5)); // true
    System.out.println(disjointSet.connected(5, 7)); // true
    System.out.println(disjointSet.connected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    disjointSet.union(9, 4);
    System.out.println(disjointSet.connected(4, 9)); // true
  }

  public boolean connected(int x, int y){
    return find(x) == find(y);
  }

  public void union(int x, int y){
    int rootX = find(x);
    int rootY = find(y);

    if(rootX!=rootY){
      if(rank[rootX] > rank[rootY]){
        root[rootY] = rootX;
      }else if(rank[rootY] > rank[rootX]){
        root[rootX] = rootY;
      }else {
        root[rootY] = rootX;
        rank[rootX] += 1;
      }
      count-- ;
    }
  }

  private int find(int x) {
    if(x == root[x]){
      return x;
    }
    return root[x] = find(root[x]);
  }

  public int getCount(){
    return count;
  }
}
