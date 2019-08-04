/*
문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.
 */

package baekjoon.step9_수학2;

import java.util.Scanner;

public class Q3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[3][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int x = arr[0][0];
        int y = arr[0][1];

        x = arr[1][0] == x ? arr[2][0] : (arr[1][0] == arr[2][0] ? x : arr[1][0]);
        y = arr[1][1] == y ? arr[2][1] : (arr[1][1] == arr[2][1] ? y : arr[1][1]);

        System.out.printf("%d %d", x, y);
    }
}