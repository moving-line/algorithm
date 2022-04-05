package leetcode;

import java.sql.Array;
import java.util.*;

public class L17_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.equals("")) return answer;
        answer.addAll(convertToLetters(digits.charAt(0)));

        for (int i = 1; i < digits.length(); i++) {
            List<String> strs = convertToLetters(digits.charAt(i));
            List<String> newStrs = new ArrayList<>();
            for (String s : answer) {
                for (String str : strs) {
                    newStrs.add(s + str);
                }
            }
            answer = newStrs;
        }
        return answer;

        // 상수크기 배열로
//        List<String> answer = new ArrayList<>();
//        if (digits.equals("")) return answer;
//
//        String[] buttons = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        answer.add("");
//
//        for (char c : digits.toCharArray()) {
//            List<String> newList = new ArrayList<>();
//            for (char subC : buttons[c - '0'].toCharArray()) {
//                for (String s : answer) {
//                    newList.add(s + subC);
//                }
//            }
//            answer = newList;
//        }
//
//        return answer;
    }

    private List<String> convertToLetters(char c) {
        List<String> result = new ArrayList<>();
        if (c == '2') {
            result.add("a");
            result.add("b");
            result.add("c");
        } else if (c == '3') {
            result.add("d");
            result.add("e");
            result.add("f");
        } else if (c == '4') {
            result.add("g");
            result.add("h");
            result.add("i");
        } else if (c == '5') {
            result.add("j");
            result.add("k");
            result.add("l");
        } else if (c == '6') {
            result.add("m");
            result.add("n");
            result.add("o");
        } else if (c == '7') {
            result.add("p");
            result.add("q");
            result.add("r");
            result.add("s");
        } else if (c == '8') {
            result.add("t");
            result.add("u");
            result.add("v");
        } else if (c == '9') {
            result.add("w");
            result.add("x");
            result.add("y");
            result.add("z");
        }
        return result;
    }
}
