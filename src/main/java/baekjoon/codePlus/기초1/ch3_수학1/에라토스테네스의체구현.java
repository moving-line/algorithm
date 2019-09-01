package baekjoon.codePlus.기초1.ch3_수학1;

public class 에라토스테네스의체구현 {
    private static int[] prime(int size) {
        int[] prime = new int[size];
        boolean[] check = new boolean[size + 1];
        int primeOfNumber = 0;

        for (int i = 2; i <= size; i++) {
            if (!check[i]) {
                prime[primeOfNumber++] = i;
                for (int j = (i * i); j <= size; j += i) {
                    check[j] = true;
                }
            }
        }

        return prime;
    }
}
