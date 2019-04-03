/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */

package baekjoon.step9_수정렬하기;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Q2750 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] array = new int[T];
        for (int i = 0; i < T; i++) array[i] = sc.nextInt();

        Arrays.sort(array);

        for (int i : array) System.out.println(i);

//        두번째 풀이
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine());
//        int[] array = new int[T];
//
//        for (int i = 0; i < T; i++) array[i] = Integer.parseInt(br.readLine());
//        Arrays.sort(array);
//
//        StringBuilder sb = new StringBuilder();
//        for (int a : array) sb.append(a).append("\n");
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();

//        세번째 풀이
//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();
//        int[] array = new int[T];
//        for (int i = 0; i < T; i++) array[i] = sc.nextInt();
//
//
//        IntStream stream = IntStream.of(array);
////        IntStream stream = Arrays.stream(array);
//        stream.sorted().forEach(System.out::println);
    }
}
