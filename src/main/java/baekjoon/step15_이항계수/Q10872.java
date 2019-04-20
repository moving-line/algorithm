/*
문제
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.
 */

package baekjoon.step15_이항계수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(factorialLoop(N));
//        System.out.println(factorialRe(N));
    }

//     루프
    private static int factorialLoop(int num) {
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }
        return answer;
    }

//     재귀
//    private static int factorialRe(int num) {
//        if(num < 2) return 1;
//        return factorialRe(num - 1) * num;
//    }
}
