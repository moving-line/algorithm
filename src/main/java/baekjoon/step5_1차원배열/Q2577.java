/*
문제
세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
예를 들어 A = 150, B = 266, C = 427 이라면
A × B × C = 150 × 266 × 427 = 17037300 이 되고,
계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.

입력
첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 같거나 크고, 1,000보다 작은 자연수이다.

출력
첫째 줄에는 A×B×C의 결과에 0 이 몇 번 쓰였는지 출력한다.
마찬가지로 둘째 줄부터 열 번째 줄까지 A×B×C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
 */

package baekjoon.step5_1차원배열;

import java.util.Scanner;

public class Q2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        while(A < 100 || B < 100 || C < 100 || A > 1000 || B > 1000 || C > 1000 ) {
            A = sc.nextInt();
            B = sc.nextInt();
            C = sc.nextInt();
        }

        char[] array = String.valueOf(A * B * C).toCharArray();

        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (char c : array) if (i == c - '0') count++;
            System.out.println(count);
        }

//        두번째 풀이
//        String[] array = String.valueOf(A * B * C).split("");
//
//        for (int i = 0; i < 10; i++) {
//            int count = 0;
//            for (String s : array) if (i == Integer.parseInt(s)) count++;
//            System.out.println(count);
//        }

//        세번째 풀이
//        int number = A * B * C;
//        int[] counts = new int[10];
//
//        while (number > 0) {
//            counts[number % 10]++;
//            number /= 10;
//        }
//
//        for (int count : counts) System.out.println(count);
    }
}
