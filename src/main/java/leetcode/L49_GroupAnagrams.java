package leetcode;

import java.util.*;

public class L49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            if (map.get(sortedStr) != null) {
                List<String> strings = map.get(sortedStr);
                strings.add(str);
            } else {
                List<String> newbie = new ArrayList<>();
                newbie.add(str);
                map.put(sortedStr, newbie);
            }
        }

        return new ArrayList<>(map.values());
    }
}
