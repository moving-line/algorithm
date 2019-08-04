/*
문제
모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다. 이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.
예를 들어, A가 111이고, B가 1111인 경우에 A와 B의 최대공약수는 1이고, A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.

입력
첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 263보다 작은 자연수이다.

출력
첫째 줄에 A와 B의 최대공약수를 출력한다. 정답은 천만 자리를 넘지 않는다.
 */

package baekjoon.그외;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd(A, B); i++) sb.append(1);

        System.out.println(sb.toString());
    }

    private static long gcd(long a, long b) {
        long number1 = a;
        long number2 = b;
        long remain = 1;

        if(b > a) {
            number1 = b;
            number2 = a;
        }

        while (remain > 0) {
            remain = number1 % number2;
            number1 = number2;
            number2 =  remain;
        }

        return number1;
    }
}