/*
문제
(세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
[생략]
(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.

출력
첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.


 */

package baekjoon.step1_입출력과사칙연산;

import java.util.Scanner;

public class Q2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num1 = sc.nextLine().split("");
        String[] num2 = sc.nextLine().split("");

        int sum = 0;

        for (int i = num2.length - 1, k = 0; i >= 0; i--, k++) {
            int each = 0;
            for (int j = num1.length - 1, l = 0; j >= 0; j--, l++) {
                each += (Integer.parseInt(num2[i]) * (Integer.parseInt(num1[j]) * Math.pow(10, l)));
            }
            System.out.println(each);
            sum += (each * Math.pow(10, k));
        }

        System.out.println(sum);
    }
}
