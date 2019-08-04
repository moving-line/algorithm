/*
문제
지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.

    1. 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
    2. 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
    3. 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.

큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.)
이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다. N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.
둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다. 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.

출력
첫째 줄에 문제의 정답을 출력한다.
 */

package baekjoon.그외;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q1021 {
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) dq.add(i);

        for (String s : input2) {
            int position = 0;
            for (Integer i : dq) {
                if(i == Integer.parseInt(s)) break;
                position++;
            }

            while(position != 0 && position < dq.size()) {
                if (position <= dq.size() / 2) {
                    moveLeft(dq);
                    position--;
                }
                else {
                    moveRight(dq);
                    position++;
                }
            }
            dq.removeFirst();
        }

        System.out.println(result);
    }

    private static void moveLeft(Deque<Integer> dq) {
        dq.addLast(dq.removeFirst());
        result++;
    }

    private static void moveRight(Deque<Integer> dq) {
        dq.addFirst(dq.removeLast());
        result++;
    }
}