/*
문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
 */

package baekjoon.step5_1차원배열;

import java.util.Scanner;

public class Q10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int max = -1000000000;
        int min = 1000000;
        int target;

        for (int i = 0; i < N; i++) {
            target = sc.nextInt();
            min = Math.min(target, min);
            max = Math.max(target, max);
        }

        System.out.printf("%d %d", min, max);

//        다른 풀이 .. 시간을 더 개선할 풀이는 없을까?
//        sc.nextLine();
//        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
//        System.out.printf("%d %d", input[0], input[N - 1]);
    }
}