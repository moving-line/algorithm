/*
nCm을 출력한다.

입력
n과 m이 주어진다. (5 ≤ n ≤ 100, 5 ≤ m ≤ 100, m ≤ n)

출력
nCm을 출력한다.
 */

package baekjoon.step15_이항계수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q2407 {

//    단순 팩토리얼 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        System.out.println(getFactorial(n).divide(getFactorial(m).multiply(getFactorial(n - m))));
    }

    private static BigInteger getFactorial(int num) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= num; i++) factorial = factorial.multiply(BigInteger.valueOf(i));

        return factorial;
    }
//
//    단순 재귀조합 풀이
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String input = br.readLine();
//
//        int n = Integer.parseInt(input.split(" ")[0]);
//        int m = Integer.parseInt(input.split(" ")[1]);
//
//        System.out.println(getCombination(n, m));
//    }
//
//    private static BigInteger getCombination(int n, int m) {
//        if (n == m || m == 0) return BigInteger.ONE;
//
//
//        return getCombination(n - 1, m - 1).add(getCombination(n - 1, m));
//    }
//
//     DP 조합 풀이(중요!!)
//    private static BigInteger[][] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String input = br.readLine();
//
//        int n = Integer.parseInt(input.split(" ")[0]);
//        int m = Integer.parseInt(input.split(" ")[1]);
//
//        arr = new BigInteger[n + 1][m + 1];
//
//        System.out.println(getCombination(n, m));
//    }
//
//    private static BigInteger getCombination(int n, int m) {
//        if (n == m || m == 0) return BigInteger.ONE;
//        if (arr[n][m] != null) return arr[n][m];
//
//        arr[n][m] = getCombination(n - 1, m - 1).add(getCombination(n - 1, m));
//        return arr[n][m];
//    }
}
