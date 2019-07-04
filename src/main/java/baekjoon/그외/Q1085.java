/*
문제
한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)에 있고, 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 x y w h가 주어진다. w와 h는 1,000보다 작거나 같은 자연수이고, x는 1보다 크거나 같고, w-1보다 작거나 같은 자연수이고, y는 1보다 크거나 같고, h-1보다 작거나 같은 자연수이다.

출력
첫째 줄에 문제의 정답을 출력한다.
 */

package baekjoon.그외;

import java.util.Scanner;

public class Q1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int horizontal = x;
        int vertical = y;

        if(x > w - x) {
            horizontal = w - x;
        }
        if(y > h - y) {
            vertical = h - y;
        }

        System.out.println(Math.min(horizontal, vertical));
    }
}
