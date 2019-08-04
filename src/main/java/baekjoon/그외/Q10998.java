/*
제
두 정수 A와 B를 입력받은 다음, A×B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
첫째 줄에 A×B를 출력한다.
 */

package baekjoon.그외;

import java.util.Scanner;

public class Q10998 {
    public static void main(String[] args) {
        int A, B;

        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        System.out.println(A * B);
    }
}
