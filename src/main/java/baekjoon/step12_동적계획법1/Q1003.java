/*
문제
다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.

int fibo(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibo(n‐1) + fibo(n‐2);
    }
}

fibo(3)을 호출하면 다음과 같은 일이 일어난다.

fibo(3)은 fibo(2)와 fibo(1) (첫 번째 호출)을 호출한다.
fibo(2)는 fibo(1) (두 번째 호출)과 fibo(0)을 호출한다.
두 번째 호출한 fibo(1)은 1을 출력하고 1을 리턴한다.
fibo(0)은 0을 출력하고, 0을 리턴한다.
fibo(2)는 fibo(1)과 fibo(0)의 결과를 얻고, 1을 리턴한다.
첫 번째 호출한 fibo(1)은 1을 출력하고, 1을 리턴한다.
fibo(3)은 fibo(2)와 fibo(1)의 결과를 얻고, 2를 리턴한다.

1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibo(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

출력
각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 */

package baekjoon.step12_동적계획법1;

import java.io.*;

public class Q1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n + 1][2];

            if (n < 2) {
                if (n == 0) System.out.println("1 0");
                if (n == 1) System.out.println("0 1");
                continue;
            }

            arr[0][0] = 1; arr[1][1] = 1;

            for (int i = 2; i <= n; i++) {
                arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
                arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
            }

            System.out.println(arr[n][0] + " " + arr[n][1]);

        }
    }
}
