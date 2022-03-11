package leetcode;

import java.util.*;

public class L49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 첫 풀이
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
//            String sortedStr = String.valueOf(chars);

//            if (map.get(sortedStr) != null) {
//                List<String> strings = map.get(sortedStr);
//                strings.add(str);
//            } else {
//                List<String> newbie = new ArrayList<>();
//                newbie.add(str);
//                map.put(sortedStr, newbie);
//            }
            // if문 이렇게 간소화 가능
            map.computeIfAbsent(String.valueOf(chars), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());


        // 정렬 없이
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String str : strs) {
//            char[] chars = new char[26];
//            for (char c : str.toCharArray()) chars[c - 'a']++;
//            map.computeIfAbsent(String.valueOf(chars), k -> new ArrayList<>()).add(str);
//        }
//
//        return new ArrayList<>(map.values());
    }
}
