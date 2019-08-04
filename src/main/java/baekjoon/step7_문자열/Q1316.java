/*
문제
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
예를 들면,
ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고,
kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

출력
첫째 줄에 그룹 단어의 개수를 출력한다.
 */

package baekjoon.step7_문자열;

import java.util.*;

public class Q1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N > 100 | N < 1) N = sc.nextInt();

        sc.nextLine();
        String[] array = new String[N];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            while(str.length() > 100 | !str.toLowerCase().equals(str) | isDuplicate(array, str)) str = sc.nextLine();
            array[i] = str;
        }

        int count = 0;
        Map<Character, Integer> map;

        for (String a : array) {
            map = new HashMap<>();
            char[] c = a.toCharArray();
            boolean isContinue = true;

            for (int j = 0; j < c.length; j++) {
                if (map.get(c[j]) == null) map.put(c[j], 1);
                else {
                    if (c[j - 1] == c[j]) continue;
                    isContinue = false;
                    break;
                }
            }

            if (isContinue) count++;
        }

        System.out.println(count);
    }

    private static boolean isDuplicate(String[] array, String str) {
        if (array[0] == null) return false;
        for (String s : array) if(str.equals(s)) return true;
        return false;
    }

//    두번째 풀이
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        while (N > 100 | N < 1) N = sc.nextInt();
//
//        sc.nextLine();
//        String[] array = new String[N];
//        for (int i = 0; i < N; i++) {
//            String str = sc.nextLine();
//            while (str.length() > 100 | !str.toLowerCase().equals(str) | isDuplicate(array, str)) str = sc.nextLine();
//            array[i] = str;
//        }
//
//        int answer = N;
//        for (String a : array) {
//            boolean[] check = new boolean[26];
//            check[a.charAt(0) - 'a'] = true;
//
//            for (int j = 1; j < a.length(); j++) {
//                if (check[a.charAt(j) - 'a']) {
//                    if (a.charAt(j) != a.charAt(j - 1)) {
//                        answer--;
//                        break;
//                    }
//                } check[a.charAt(j) - 'a'] = true;
//            }
//        }
//
//        System.out.println(answer);
//    }
}
