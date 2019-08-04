/*
문제
베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19)
또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하며, 한 줄로 이루어져 있다. (n ≤ 123456)

입력의 마지막에는 0이 주어진다.

출력
각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
 */

package baekjoon.step9_수학2;

import java.io.*;

public class Q4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        while(input != 0) {
            boolean[] array = new boolean[input * 2 + 1];
            array[1] = true;

            for (int i = 2; i <= input * 2; i++) {
                if (array[i]) continue;
                for (int j = 2; i * j <= input * 2; j++) {
                    array[i * j] = true;
                }
            }

//          제곱근을 활용하는 방법
//            for (int i = input; i <= input * 2; i++) {
//                for (int j = 2; j <= Math.sqrt(i); j++) {
//                    if(i % j == 0) {
//                        array[i] = true;
//                        break;
//                    }
//                }
//            }


            int sum = 0;
            for (int i = input + 1; i <= input * 2; i++) {
                if (!array[i]) sum++;
            }
            sb.append(sum).append("\n");

            input = Integer.parseInt(br.readLine());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}