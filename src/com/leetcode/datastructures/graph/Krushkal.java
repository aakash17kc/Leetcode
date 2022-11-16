package com.leetcode.datastructures.graph;

import java.util.PriorityQueue;

public class Krushkal {
  public static void main(String[] args) {
    int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    Solution solution = new Solution();
    System.out.print("Minimum Cost to Connect Points = ");
    System.out.println(solution.minCostConnectPoints(points));
  }
}

class Solution {
  public int minCostConnectPoints(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> a.cost - b.cost);

    UnionFind unionFind = new UnionFind(points.length);

    for (int i = 0; i < points.length; i++) {
      int[] p1 = points[i];
      for (int j = i + 1; j < points.length; j++) {
        int[] p2 = points[j];
        int cost = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        priorityQueue.offer(new Edge(i, j, cost));
      }
    }

    int finalCost = 0;
    int count = points.length -1;
    while (!priorityQueue.isEmpty() && count > 0) {
      Edge edge = priorityQueue.poll();
      if (!unionFind.connected(edge.row,edge.col)){
        unionFind.union(edge.row, edge.col);
          finalCost += edge.cost;
          count--;

        }
    }
    return finalCost;

  }
}

interface Foo{
  int x=10;

}

//class Demo {
//  public static void main(String[] args) {
//    Foo.x = 20;
//
//  }
//
//}

class Edge {
  public Edge(int row, int col, int cost) {
    this.row = row;
    this.col = col;
    this.cost = cost;
  }

  int row;
  int col;
  int cost;
}

class UnionFind {
  int[] root;
  int[] rank;

  public UnionFind(int size) {
    root = new int[size];
    rank = new int[size];
    for (int i = 0; i < size; i++) {
      root[i] = i;
      rank[i] = 1;
    }
  }

  public int find(int x) {
    if (x == root[x]) {
      return x;
    }
    return root[x] = find(root[x]);
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      if (rank[rootX] > rank[rootY]) {
        root[rootY] = rootX;
      } else if (rank[rootX] < rank[rootY]) {
        root[rootX] = rootY;
      } else {
        root[rootY] = rootX;
        rank[rootX] += 1;
      }
    }
  }

  public boolean connected(int x, int y) {
    return find(x) == find(y);
  }
}
