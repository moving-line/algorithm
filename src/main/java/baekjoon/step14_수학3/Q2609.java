/*
문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 */

package baekjoon.step14_수학3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int gcd = gcd(A, B);
        int lcm = lcm(A, B , gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int gcd(int a, int b) {
        int number1 = a;
        int number2 = b;
        int remain = 1;

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

    private static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}
