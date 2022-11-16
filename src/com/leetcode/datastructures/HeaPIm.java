package com.leetcode.datastructures;

import java.util.*;

public class HeaPIm {
  public static void main(String[] args) {
    System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
  }

  public static List<String> topKFrequent(String[] words, int k) {

    HashMap<String, Integer> map = new HashMap<>();
    String[] finalWords = new String[k];
    LinkedHashMap<String, Integer> sortedmap = new LinkedHashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.put(words[i], map.getOrDefault(words[i], 0) + 1);
    }
    map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey())).forEachOrdered(x -> sortedmap.put(x.getKey(), x.getValue()));
    List<String> strlist = new ArrayList<>();
    int j = 1;
    for (Map.Entry<String, Integer> entry : sortedmap.entrySet()) {
      strlist.add(entry.getKey());
      if (j == k) {
        break;
      }
      j++;
    }
    Collections.sort(strlist);
    return strlist;
  }

  static String getHash(String s) {
    char[] chars = s.toCharArray();
    StringBuilder hashKey = new StringBuilder();

    for (int i = 1; i < chars.length; i++) {
      hashKey.append((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));
    }

    return hashKey.toString();
  }

  public String addString(List<Character> set) {
    StringBuilder finnaString = new StringBuilder();
    for (Character c : set) {
      finnaString.append(c);
    }
    return finnaString.toString();
  }

  public int lastStoneWeight(int[] stones) {
    Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return 0;
      }
    });
    for (int i = 0; i < stones.length; i++) {
      queue.add(stones[i]);
    }
    while (queue.size() > 1) {
      int x = queue.poll();
      int y = queue.poll();
      if (x != y) {
        queue.add(x - y);
      }
    }

    if (queue.isEmpty())
      return 0;
    return queue.poll();

  }

  public String lengthOfLongestSubstring(String s) {
    List<Character> set = new ArrayList<>();
    String finalString = "";
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; i++) {
      if (set.contains(c[i])) {
        String temp = addString(set);
        if (temp.length() > finalString.length()) {
          finalString = temp;
        }
        set.clear();
      }
      set.add(c[i]);
    }
    return finalString;
  }
}
