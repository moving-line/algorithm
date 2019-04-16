/*
문제
피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n>=2)가 된다.
n=17일때 까지 피보나치 수를 써보면 다음과 같다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n이 주어진다. n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 n번째 피보나치 수를 1,000,000으로 나눈 나머지를 출력한다.
 */

package baekjoon.step14_피보나치수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2749 {
    // 피보나치 수를 나눌 수를 K라고 할 때, k=10^n 이면, 피사노 주기는 15∗10^(n−1)이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long div = (long)Math.pow(10, 6);
        int pisano = 15 * (int)(div / 10);

        long[] pibo = new long[pisano];
        pibo[0] = 0; pibo[1] = 1;

        for (int i = 2; i < pisano; i++) {
            pibo[i] = pibo[i - 1] + pibo[i - 2];
            pibo[i] %= div;
        }
        if(n >= pisano) n %= pisano;

        System.out.println(pibo[(int) n]);
    }
}

