package com.leetcode.arrays.medium;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringMap = new HashMap<>();
        int count[] = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int n : count) {
                stringBuilder.append("#");
                stringBuilder.append(n);
            }
            if(!stringMap.containsKey(stringBuilder.toString())){
                stringMap.put(stringBuilder.toString(),new ArrayList<>());
            }
            stringMap.get(stringBuilder.toString()).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> val : stringMap.values()) {
            res.add(val);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        res.stream().forEach(val -> System.out.println(val));
    }
}
