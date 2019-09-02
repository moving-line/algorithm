package baekjoon.codePlus.기초1.ch3_수학1;

import java.io.*;
import java.util.Scanner;

public class Q1929 {
    // 백준풀이
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] check = new boolean[N + 1];
        check[0] = check[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (check[i]) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                check[j] = true;
            }
        }

        for (int i = M; i <= N; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
//    내풀이
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String[] input = br.readLine().split(" ");
//
//        int M = Integer.parseInt(input[0]);
//        int N = Integer.parseInt(input[1]);
//
//        boolean[] check = getPrimeList(M, N);
//        for (int i = M; i <= N; i++) {
//            if(!check[i]) {
//                bw.write(i + "\n");
//            }
//        }
//
//        bw.flush();
//        bw.close();
//    }
//
//    private static boolean[] getPrimeList(int M, int N) {
//        long[] prime = new long[N];
//        boolean[] check = new boolean[N + 1];
//        check[1] = true;
//        int count = 0;
//
//        for (long i = 2; i <= N; i++) {
//            if (!check[(int) i]) {
//                prime[count++] = i;
//
//                for (long j = (i * i); j <= N; j += i) {
//                    check[(int) j] = true;
//                }
//            }
//
//        }
//
//        return check;
//    }
}
