package baekjoon.codePlus.기초1.ch3_수학1;

import java.util.Scanner;

public class Q17103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 에라토스테네스의 체를 활용한 소수배열 만들
        int size = 1000000;
        int[] primes = new int[size];
        boolean[] check = new boolean[size + 1];
        int primeOfNumber = 0;

        for (int i = 2; i <= size; i++) {
            if (!check[i]) {
                primes[primeOfNumber++] = i;
                for (int j = (2 * i); j <= size; j += i) {
                    check[j] = true;
                }
            }
        }

        // 본격 골드바흐 파티션 구하기
        while (T-- > 0) {
            int N = sc.nextInt();
            int count = 0;

            for (int p : primes) {
                int other = N - p;
                if (other >= 2 && p <= other) {  // 2보다 크고 p보다 크지않은 숫자 일때
                    if (!check[other]) { // 그 숫자가 소수라면?
                        count += 1;
                    }
                } else { // 유효한 숫자범위(p보다 큰건 x. 순서가 다르면 같은 파티션이라) 를 벗어났으니 루프 끝
                    break;
                }
            }
            System.out.println(count);
        }
    }

    // 시간초과한 무식한 풀이
//    public class Main {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//
//            int T = sc.nextInt();
//            int[] prime = prime(1000000);
//
//            for (int i = 0; i < T; i++) {
//                int N = sc.nextInt();
//                int count = 0;
//
//                for (int j = 0; j < prime.length; j++) {
//                    int first = prime[j];
//                    if(first > N) break;
//                    for (int k = j; k < prime.length; k++) {
//                        int second = prime[k];
//                        if(N == first + second) {
//                            count++;
//                            break;
//                        }
//                        if(N < first + second) {
//                            break;
//                        }
//                    }
//                }
//
//                System.out.println(count);
//            }
//        }
//
//        private static int[] prime(int size) {
//            int[] prime = new int[size];
//            boolean[] check = new boolean[size + 1];
//            int primeOfNumber = 0;
//
//            for (int i = 2; i <= size; i++) {
//                if (!check[i]) {
//                    prime[primeOfNumber++] = i;
//                    for (int j = (2 * i); j <= size; j += i) {
//                        check[j] = true;
//                    }
//                }
//            }
//
//            return prime;
//        }
//    }
}

