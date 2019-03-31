/*
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */

package baekjoon.step7_문자열사용하기;

import java.io.*;

public class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().toUpperCase();
        while(str.length() > 1000000 || isAlphabetOnly(str)) {
            br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine().toUpperCase();
        }

        int[] alphabet = new int[26];
        char[] array = str.toCharArray();

        for (char a : array) {
            for (int j = 65; j <= 90; j++) {
                if (a == j) {
                    alphabet[j - 65]++;
                    break;
                }
            }
        }

        int max = 0;
        for (int a : alphabet) if (a >= max) max = a;

        int count = 0;
        for (int a : alphabet) if (a == max) count++;

        if (count > 1) System.out.println("?");
        else {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == max) {
                    bw.write((char)(i + 65));
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean isAlphabetOnly(String alphabet) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) < 'A' || alphabet.charAt(i) > 'Z') return true;
        }
        return false;
    }

//    두번째 풀이
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String str = br.readLine().toUpperCase();
//        while(str.length() > 1000000 || isAlphabetOnly(str)) {
//            br = new BufferedReader(new InputStreamReader(System.in));
//            str = br.readLine().toUpperCase();
//        }
//
//        int[] array = new int[26];
//
//        for(int i = 0; i < str.length(); i++) {
//            int index = str.charAt(i) - 'A';
//            array[index]++;
//        }
//
//        int max = -1;
//        char answer = '?';
//
//        for(int i = 0; i < 26; i++) {
//            if(array[i] > max) {
//                max = array[i];
//                answer = (char)(i + 65);
//            } else if(array[i] == max)
//                answer = '?';
//        }
//
//        bw.write(answer);
//        bw.flush();
//        bw.close();
//    }
}
