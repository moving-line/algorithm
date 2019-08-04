/*
문제
어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 */

package baekjoon.step6_함수;

import java.util.Scanner;

public class Q1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N <= 0 | N > 1000) N = sc.nextInt();

        if (N < 100) {
            System.out.println(N);
            return;
        }

        int count = 99;
        for (int i = 100; i <= N; i++) {
            String[] array = String.valueOf(i).split("");
            int difference = Integer.parseInt(array[0]) - Integer.parseInt(array[1]);
            boolean isEqualDiff = true;

            for (int j = 0; j < array.length - 1; j++) {
                if (Integer.parseInt(array[j]) - Integer.parseInt(array[j + 1]) != difference) {
                    isEqualDiff = false;
                    break;
                }
            }
            if (isEqualDiff) count++;
        }

        System.out.println(count);
    }
}
