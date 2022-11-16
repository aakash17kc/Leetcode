package com.leetcode.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Palindrome {

  public static void main(String[] args) {
    String[] words = {"abcd","dcba","lls","s","sssll"};
    new Palindrome().palindromePairs(words);
  }

  public List<List<Integer>> palindromePairs(String[] words) {

    HashMap<String,Integer> map = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    for(int i=0;i<words.length;i++){
      map.put(words[i],i);
    }
    // when two words are of same length
    for(String word:map.keySet()){
      int currentWordIndex = map.get(word);
      String rWord = new StringBuilder(word).reverse().toString();
      if(map.containsKey(rWord) && map.get(rWord)!=currentWordIndex){
        List<Integer> list = new ArrayList<>();
        list.add(currentWordIndex);
        list.add(map.get(rWord));
        result.add(list);
      }
      for(String suff:getAllSuffixes(word)){
        String rsuff = new StringBuilder(suff).reverse().toString();
        if(map.containsKey(rsuff)){
          List<Integer> list = new ArrayList<>();
          list.add(currentWordIndex);
          list.add(map.get(rsuff));
          result.add(list);
        }

      }
      for(String pref:getAllPrefixes(word)){
        String rpref = new StringBuilder(pref).reverse().toString();
        if(map.containsKey(rpref)){
          List<Integer> list = new ArrayList<>();
          list.add(currentWordIndex);
          list.add(map.get(rpref));
          result.add(list);
        }

      }
    }
    return result;

  }

  private List<String> getAllPrefixes(String word) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < word.length() ; i++) {
      if(isPalindrome(word,i,word.length()-1)){
        list.add(word.substring(0,i));
      }
    }
    return list;
  }

  private List<String> getAllSuffixes(String word) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < word.length() ; i++) {
      if(isPalindrome(word,0,i)){
        list.add(word.substring(i+1));
      }
    }
    return list;
  }

  private boolean isPalindrome(String word, int left, int right) {

    while (left < right){
      if(word.charAt(left) == word.charAt(right)){
        left++;
        right--;
      }else{
        return false;
      }
    }
    return true;
  }
}
