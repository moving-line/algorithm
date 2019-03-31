/*
문제
알파벳 소문자로만 이루어진 단어 S가 주어진다.
각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

출력
각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
 */

package baekjoon.step7_문자열사용하기;

import java.util.Arrays;
import java.util.Scanner;

public class Q10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        while (S.length() > 100 || isLower(S)) S = sc.nextLine();

        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < S.length(); i++) {
            for (int a = 97; a <= 122; a++) {
                if (S.charAt(i) == a) {
                    if (alphabet[a - 97] == -1) {
                        alphabet[a - 97] = i;
                        break;
                    }
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : alphabet) sb.append(a).append(" ");

        System.out.println(sb.toString().trim());
    }

    private static boolean isLower(String S) {
        char[] array = S.toCharArray();

        for (char a : array) {
            if (a < 97 || a > 122) return true;
        }
        return false;
    }
}
