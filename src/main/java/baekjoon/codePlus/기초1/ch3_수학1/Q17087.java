package baekjoon.codePlus.기초1.ch3_수학1;

import java.util.Scanner;

public class Q17087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동생 N명
        int S = sc.nextInt(); // 나의 위치 S
        int[] As = new int[N]; // 동생 위치 As
        int result; // 비교한 최대공약수
        for (int i = 0; i < N; i++) {
            As[i] = Math.abs(sc.nextInt() - S);
        }

        if(As.length == 1) {
            System.out.println(As[0]);
            return;
        }

        result = gcd(As[0], As[1]);
        for (int i = 2; i < N; i++) {
            result = gcd(result, As[i]);

            if(result == 1) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(result);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
