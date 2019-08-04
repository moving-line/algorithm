/*
문제
알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.

한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어가 주어진다. 단어는 알파벳 소문자와 대문자로만 이루어져 있으며, 길이는 100을 넘지 않는다. 길이가 0인 단어는 주어지지 않는다.

출력
입력으로 주어진 단어를 열 개씩 끊어서 한 줄에 하나씩 출력한다. 단어의 길이가 10의 배수가 아닌 경우에는 마지막 줄에는 10개 미만의 글자만 출력할 수도 있다.
 */

package baekjoon.그외;

import java.util.Scanner;

public class Q11721 {
    public static void main(String[] args) {
//        첫번째 풀이
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        while(str.length() > 100 || str.length() == 0) str = sc.nextLine();

        int size = str.length();
        for (int i = 0; i < size / 10; i++) {
            System.out.println(str.substring(i * 10, (i * 10) + 10));
        }

        if (size < 10) System.out.println(str);
        else if (size % 10 != 0) System.out.println(str.substring((size / 10) * 10));

//        두번째 풀이
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//
//        while(str.length() > 100 || str.length() == 0) str = sc.nextLine();
//
//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(str.charAt(i));
//            if (i % 10 == 9) System.out.println();
//        }

//        세번째 풀이
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//
//        while(str.length() > 100 || str.length() == 0) str = sc.nextLine();
//
//        for (int i = 0; i < str.length(); i++) {
//            if (i % 10 == 0 && i != 0) System.out.println();
//            System.out.print(str.charAt(i));
//        }
    }
}
