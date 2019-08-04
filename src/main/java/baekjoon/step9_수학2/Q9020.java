/*
문제
1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다.
하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.
골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 이러한 수를 골드바흐 수라고 한다.
또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다.
10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오.
만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다. (4 ≤ n ≤ 10,000)

출력
각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.
 */

package baekjoon.step9_수학2;

import java.io.*;

public class Q9020 {
    public static void main(String[] args) throws IOException {
//        단순 제곱근 활용 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int small = n/2;
            int big = n/2;
            outer : while(true) {
                for (int j = 2; j <= Math.sqrt(small); j++) {
                    if (small % j == 0) {
                        small--;
                        big++;
                        continue outer;
                    }
                }

                for (int j = 2; j <= Math.sqrt(big); j++) {
                    if (big % j == 0) {
                        small--;
                        big++;
                        continue outer;
                    }
                }

                break;
            }

            sb.append(small).append(" ").append(big).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

//        에라토스테네스의 체 - 단순활용 풀이
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        boolean[] array;
//
//        for (int i = 0; i < T; i++) {
//            int n = Integer.parseInt(br.readLine());
//            while(n % 2 != 0 || n < 4 || n > 10000) n = Integer.parseInt(br.readLine());
//
//            array = new boolean[n + 1];
//            array[1] = true;
//
//            for (int j = 2; j < array.length; j++) {
//                if (array[j]) continue;
//                for (int k = 2; j * k < array.length; k++) {
//                    array[j * k] = true;
//                }
//            }
//
//            int small = n/2;
//            int big = n/2;
//
//            while(array[small] || array[big]) {
//                small--;
//                big++;
//            }
//
//            sb.append(small).append(" ").append(big).append("\n");
//        }
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();

//        에라토스테네스의 체 - 성능 좋은 풀이(소수찾는로직 중복제거) => 추천!!
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine());
//        int[] input = new int[T];
//        for (int i = 0; i < T; i++) input[i] = Integer.parseInt(br.readLine());
//
//        int max = 4;
//        for (int i = 0; i < T; i++) if (input[i] > max) max = input[i];
//
//        boolean[] array = new boolean[max + 1];
//        array[1] = true;
//
//        for (int i = 2; i < array.length; i++) {
//            if (array[i]) continue;
//            for (int j = 2; i * j < array.length; j++) {
//                array[i * j] = true;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < T; i++) {
//            int small = input[i] / 2;
//            int big = input[i] / 2;
//            while (array[small] || array[big]) {
//                small--;
//                big++;
//            }
//            sb.append(small).append(" ").append(big).append("\n");
//        }
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
    }
}