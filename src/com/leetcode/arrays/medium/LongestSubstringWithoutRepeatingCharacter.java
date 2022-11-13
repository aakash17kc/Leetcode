package com.leetcode.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
    int ans = Integer.MIN_VALUE;
        if(s.length()==0)
            return 0;
        if(s.length()==1){
            return 1;
        }
    Map<Character,Integer> map = new HashMap<>();
        int pos=0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                pos = Math.max(pos, map.get(s.charAt(i)));
            }
            ans = Math.max(ans,i-pos+1);
            map.put(s.charAt(i),i+1);
        }
        if(ans==Integer.MIN_VALUE){
            return map.keySet().size();
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring("pwwkew"));
    }
}
