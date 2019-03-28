/*
문제
세 정수 A, B, C가 주어진다. 이때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, C가 공백으로 구분되어 주어진다. (1 ≤ A, B, C ≤ 100)

출력
두 번째로 큰 정수를 출력한다.
 */

package baekjoon.step4_if문사용해보기;

import java.util.Arrays;
import java.util.Scanner;

public class Q10817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");

        int[] answer = new int[array.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(array[i]);
        }

//         꼼수
//        Arrays.sort(answer);
//        System.out.println(answer[1]);

//         정석
        int temp;
        for (int i = 0; i < answer.length; i++) {
            for (int j = i; j < answer.length; j++) {
                if (answer[i] > answer[j]) {
                    temp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = temp;
                }
            }
        }
        System.out.println(answer[1]);
    }
}
