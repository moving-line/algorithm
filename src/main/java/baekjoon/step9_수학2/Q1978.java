/*
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.
 */

package baekjoon.step9_수학2;

import java.io.*;

public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while(N > 100 || N < 1) {
            System.out.println("N 다시써라~");
            N = Integer.parseInt(br.readLine());
        }

        String[] Ns  = br.readLine().split(" ");
        while(Ns.length != N) {
            Ns  = br.readLine().split(" ");
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (checkN(Integer.parseInt(Ns[i]))) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static boolean checkN(int n) {
        if(n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
