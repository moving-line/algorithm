/*
문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.
 */

package baekjoon.그외;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int two = 0, five = 0;

        for (int i = 1; i <= n; i++) {
            int temp = i;

            while (temp % 2 == 0 || temp % 5 == 0) {
                if (temp % 2 == 0) {
                    temp /= 2;
                    two++;
                } else {
                    temp /= 5;
                    five++;
                }
            }
        }

        System.out.println(two < five ? two : five);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        System.out.println(checkNoneZero(factiorial(N)));
////        System.out.println(checkNoneZero2(factiorial(N)));
//    }
//
//    private static BigInteger checkNoneZero(BigInteger num) {
//        String[] arr = String.valueOf(num).split("");
//
//        BigInteger count = BigInteger.ZERO;
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if(arr[i].equals("0")) count = count.add(BigInteger.ONE);
//            else break;
//        }
//
//        return count;
//    }
//
////    private static int checkNoneZero2(BigInteger num) {
////        int count = 0;
////
////        while(num.mod(BigInteger.valueOf(10)).equals(BigInteger.ZERO)) {
////            num = num.divide(BigInteger.valueOf(10));
////            count++;
////        }
////        return count;
////    }
//
//    private static BigInteger factiorial(int num) {
//        if(num <= 1) return BigInteger.ONE;
//
//        BigInteger factorial = BigInteger.ONE;
//        for (int i = 2; i <= num; i++) {
//            factorial = factorial.multiply(BigInteger.valueOf(i));
//        }
//        return factorial;
//    }
}
