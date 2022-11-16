package com.leetcode.datastructures.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPath2DMatrix {
  //https://leetcode.com/problems/shortest-path-in-binary-matrix/solution/
  int[][] distances = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
  static int[][] graph;

  public static void main(String[] args) {
    graph = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
    System.out.println(new ShortestPath2DMatrix().findShortestPath(graph));
  }

  // from top left to bottom right
  public int findShortestPath(int[][] graph) {

    Queue<int[]> queue = new ArrayDeque<>();
    //check if graph is valid
    if (graph[0][0] != 0 || graph[graph.length - 1][graph[0].length - 1] != 0) {
      return -1;
    }
    queue.add(new int[]{0, 0, 1});
    int visited[][] = new int[graph.length][graph[0].length];

    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int row = cell[0];
      int col = cell[1];
      int dist = cell[2];

      if (row == graph.length - 1 && col == graph[0].length - 1) {
        return dist;
      }


      for (int[] neighbours : getNeighbours(row, col)){
        int nRow = neighbours[0];
        int nCol = neighbours[1];
        if (visited[nRow][nCol] == 1) {
          continue;
        }
        visited[nRow][nCol] = 1;
        queue.add(new int[]{nRow,nCol,dist+1});
      }
    }
    return -1;
  }

  private List<int[]> getNeighbours(int row, int col) {
    List<int[]> neigh = new ArrayList<>();
    for (int i = 0; i < distances.length; i++) {
      int nRow = row + distances[i][0];
      int nCol = col + distances[i][1];

      if (nRow < 0 || nCol < 0 || nRow >= graph.length
          || nCol >= graph[0].length
          || graph[nRow][nCol] != 0) {
        continue;
      }
      neigh.add(new int[]{nRow, nCol});
    }
    return neigh;
  }
}
