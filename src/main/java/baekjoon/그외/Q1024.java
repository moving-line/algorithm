/*
문제
N과 L이 주어질 때, 합이 N이면서, 길이가 적어도 L인 가장 짧은 연속된 음이 아닌 정수 리스트를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 L이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이고, L은 2보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
만약 리스트의 길이가 100보다 작거나 같으면, 연속된 수를 첫째 줄에 공백으로 구분하여 출력한다.
만약 길이가 100보다 크거나 그러한 수열이 없을 때는 -1을 출력한다.
 */

package baekjoon.그외;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        while(true) {
            List<String> answer = new ArrayList<>();
            int k = N / L;

            int start = (L % 2 != 0) ? k - L / 2 : k - L / 2 + 1;
            int last = k + L / 2;

            if(start < 0) {
                if(L < 100) {
                    L++;
                    continue;
                } else {
                    System.out.println(-1);
                    return;
                }
            }

            int sum = 0;
            for (int j = start; j <= last; j++) {
                answer.add(String.valueOf(j));
                sum += j;
            }

            if(sum == N) {
                System.out.println(String.join(" ", answer));
                return;
            }

            if (L >= 100) {
                System.out.println(-1);
                return;
            }

            L++;
        }
    }
}