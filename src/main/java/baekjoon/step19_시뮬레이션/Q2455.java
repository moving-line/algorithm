/*
문제
최근에 개발된 지능형 기차가 1번역(출발역)부터 4번역(종착역)까지 4개의 정차역이 있는 노선에서 운행되고 있다.
이 기차에는 타거나 내리는 사람 수를 자동으로 인식할 수 있는 장치가 있다.
이 장치를 이용하여 출발역에서 종착역까지 가는 도중 기차 안에 사람이 가장 많을 때의 사람 수를 계산하려고 한다.
단, 이 기차를 이용하는 사람들은 질서 의식이 투철하여, 역에서 기차에 탈 때, 내릴 사람이 모두 내린 후에 기차에 탄다고 가정한다.

[그림 생략]

         	내린 사람 수	탄 사람 수
1번역(출발역)	    0       	32
2번역	        3       	13
3번역	        28      	25
4번역(종착역)	    39      	0

예를 들어, 위와 같은 경우를 살펴보자.
이 경우, 기차 안에 사람이 가장 많은 때는 2번역에서 3명의 사람이 기차에서 내리고, 13명의 사람이 기차에 탔을 때로, 총 42명의 사람이 기차 안에 있다.

이 기차는 다음 조건을 만족하면서 운행된다고 가정한다.

    1. 기차는 역 번호 순서대로 운행한다.
    2. 출발역에서 내린 사람 수와 종착역에서 탄 사람 수는 0이다.
    3. 각 역에서 현재 기차에 있는 사람보다 더 많은 사람이 내리는 경우는 없다.
    4. 기차의 정원은 최대 10,000명이고, 정원을 초과하여 타는 경우는 없다.

4개의 역에 대해 기차에서 내린 사람 수와 탄 사람 수가 주어졌을 때, 기차에 사람이 가장 많을 때의 사람 수를 계산하는 프로그램을 작성하시오.

입력
각 역에서 내린 사람 수와 탄 사람 수가 빈칸을 사이에 두고 첫째 줄부터 넷째 줄까지 역 순서대로 한 줄에 하나씩 주어진다.

출력
첫째 줄에 최대 사람 수를 출력한다.
 */

package baekjoon.step19_시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //2차원 배열
        int[][] trains = new int[4][2];

        for (int i = 0; i < trains.length; i++) {
            String[] input = br.readLine().split(" ");

            int out = Integer.parseInt(input[0]);
            int in = Integer.parseInt(input[1]);

            if(i > 0) trains[i][0] = trains[i - 1][1] - out;
            if(i < trains.length - 1) trains[i][1] = trains[i][0] + in;
        }

        int max = 0;
        for (int[] train : trains) {
            for (int t : train) {
                if (t > max) max = t;
            }
        }

        System.out.println(max);

        // 1차원 배열
//        int station = 4;
//        int[] train = new int[station * 2];
//
//
//        for (int i = 0; i < train.length / 2; i++) {
//            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//            if (i > 0) train[i * 2] = train[i * 2 - 1] - input[0];
//            if (i < train.length / 2 - 1) train[i * 2 + 1] = train[i * 2] + input[1];
//        }
//
//        int max = 0;
//        for (int t : train) if (t > max) max = t;
//
//        System.out.println(max);
    }
}
