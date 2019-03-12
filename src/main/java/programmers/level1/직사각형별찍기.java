/*
문제 설명
이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

제한 조건
n과 m은 각각 1000 이하인 자연수입니다.
 */
package programmers.level1;

import java.util.Scanner;

public class 직사각형별찍기 {
    public static void main(String[] args) {
        //첫번째 풀이
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 가로
        int m = sc.nextInt(); // 세로

        for (int vertical = 0; vertical < m; vertical++) {
            for (int horizontal = 0; horizontal < n; horizontal++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //두번째 풀이
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 가로
//        int m = sc.nextInt(); // 세로
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) sb.append("*");
//        for (int i = 0; i < m; i++) System.out.println(sb.toString());
    }
}
