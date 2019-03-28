/*
문제
시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
시험 성적을 출력한다.
 */

package baekjoon.step4_if문사용해보기;

import java.util.Scanner;

public class Q9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int exam = sc.nextInt();
        while (exam < 0 || exam > 100) exam = sc.nextInt();

        String answer;
        if(exam >= 90) answer = "A";
        else if (exam >= 80) answer = "B";
        else if (exam >= 70) answer = "C";
        else if (exam >= 60) answer = "D";
        else answer = "F";

        System.out.println(answer);
    }
}
