package baekjoon.codePlus.기초1.ch3_수학1;

public class 최대공약수구현 {
    // 재귀
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // 논재귀
    private static int gcd2(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
