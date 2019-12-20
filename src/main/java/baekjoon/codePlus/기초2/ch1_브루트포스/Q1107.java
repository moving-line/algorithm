package baekjoon.codePlus.기초2.ch1_브루트포스;

import java.util.Scanner;

public class Q1107 {
    private static final boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }

        int minCount = N - 100;
        if (minCount < 0) {
            minCount = -minCount;
        }

        for (int i = 0; i <= 1000000; i++) {
            int channel = i;
            int countNumberButton = checkBaseChannel(channel);

            if (countNumberButton > 0) { // 숫자를 누르는 경우, +-를 누르는 경우 비교
                int countPNButton = channel - N;
                if (countPNButton < 0) {
                    countPNButton = -countPNButton;
                }
                if (minCount > countNumberButton + countPNButton) {
                    minCount = countNumberButton + countPNButton;
                }
            }
        }

        System.out.println(minCount);
    }

    private static int checkBaseChannel(int channel) {
        if (channel == 0) {
            return broken[0] ? 0 : 1;
        }

        int count = 0;
        while (channel > 0) {
            if (broken[channel % 10]) {
                return 0;
            }
            count += 1;
            channel /= 10;
        }
        return count;
    }
}
