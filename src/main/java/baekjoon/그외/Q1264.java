/*
문제
영문 문장을 입력받아 모음의 개수를 세는 프로그램을 작성하시오. 모음은 'a', 'e', 'i', 'o', 'u'이며 대문자 또는 소문자이다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 영어 대소문자, ',', '.', '!', '?', 공백으로 이루어진 문장이 주어진다.
각 줄은 최대 255글자로 이루어져 있다.

입력의 끝에는 한 줄에 '#' 한 글자만이 주어진다.

출력
각 줄마다 모음의 개수를 세서 출력한다.
 */

package baekjoon.그외;

import java.util.Scanner;

public class Q1264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String str = sc.nextLine();
            if(str.equals("#")) return;

            int numOfVowel = 0;
            for (int i = 0; i < str.length(); i++) {
                numOfVowel += isVowel(str.toLowerCase().charAt(i));
            }
            System.out.println(numOfVowel);
        }
    }

    private static int isVowel(char c) {
        if(c == 'a' || c =='e' || c =='i' || c =='o' || c =='u') return 1;
        return 0;
    }
}
