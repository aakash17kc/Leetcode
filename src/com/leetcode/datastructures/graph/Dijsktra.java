package com.leetcode.datastructures.graph;

import javafx.util.Pair;

import java.util.*;

public class Dijsktra {
  //https://leetcode.com/problems/network-delay-time/
  public static void main(String[] args) {
    int [][]graph = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
    int n = 4;
    int k = 2;

    Map<Integer,List<Pair<Integer,Integer>>> adj = generateAdj(graph);
    int[] visited = new int[n+1];
    Arrays.fill(visited,Integer.MAX_VALUE);

    dijsktra(adj,k,n,visited,0);

    int ans = Integer.MIN_VALUE;

    for (int i = 1; i <= n; i++) {
      ans = Math.max(ans,visited[i]);
    }

    System.out.println("Min time for sync " + ans);

    }


  private static void dijsktra(Map<Integer, List<Pair<Integer, Integer>>> adj, int k, int n, int[] visited,int currTime) {
    PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
    // time for signal to go from k to k
    priorityQueue.add(new Pair<>(0,k));
    visited[k] = 0;
    while (!priorityQueue.isEmpty()){
      Pair<Integer,Integer> pair = priorityQueue.poll();
      int nodeTime = pair.getKey();
      int node = pair.getValue();
      if(nodeTime > visited[node]){
       continue;
      }
      if(!adj.containsKey(node)){
        continue;
      }

      for (Pair<Integer,Integer> neighbour : adj.get(node)){
        int neighbourTime = neighbour.getKey();
        int neighbourNode = neighbour.getValue();
        if(visited[neighbourNode] > nodeTime + neighbourTime){
          visited[neighbourNode] = nodeTime + neighbourTime;
          priorityQueue.add(new Pair<>(visited[neighbourNode],neighbourNode));
        }
      }


    }
  }

  private static Map<Integer, List<Pair<Integer, Integer>>> generateAdj(int[][] graph) {

    Map<Integer,List<Pair<Integer,Integer>>> adj = new HashMap<>();

    for(int []info:graph){
      int src = info[0];
      int dest = info[1];
      int time = info[2];

      adj.putIfAbsent(src,new ArrayList<>());
      adj.get(src).add(new Pair<>(time,dest));
    }

    //No need to sort for BFS for Dijsktra as PQ will be used.
    return adj;
  }


}
