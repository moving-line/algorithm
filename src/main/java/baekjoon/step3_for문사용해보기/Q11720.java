/*
문제
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 10미만의 숫자 N개가 공백없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다.
 */

package baekjoon.step3_for문사용해보기;

import java.util.Scanner;

public class Q11720 {
    public static void main(String[] args) {
//        첫번째 풀이
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String number = sc.nextLine();

        while(N < 1 || N > 100 || number.length() != N) {
            N = sc.nextInt();
            sc.nextLine();
            number = sc.nextLine();
        }

        int sum = 0;
        String[] array = number.split("");

        for (String s : array) sum += Integer.parseInt(s);

        System.out.println(sum);

//        두번째 풀이
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        sc.nextLine();
//        String number = sc.nextLine();
//
//        while(N < 1 || N > 100 || number.length() != N) {
//            N = sc.nextInt();
//            sc.nextLine();
//            number = sc.nextLine();
//        }
//
//        int sum = 0;
//        for (int i = 0; i < number.length(); i++) {
//            sum += Integer.parseInt(number.substring(i, i+1));
//        }
//
//        System.out.println(sum);

//        세번째 풀이
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        sc.nextLine();
//        String number = sc.nextLine();
//
//        while(N < 1 || N > 100 || number.length() != N) {
//            N = sc.nextInt();
//            sc.nextLine();
//            number = sc.nextLine();
//        }
//
//        int sum = 0;
//        for (int i = 0; i < number.length(); i++) {
//            sum += number.charAt(i) - '0';
////            sum += number.charAt(i) - 48;
//        }
//
//        System.out.println(sum);
    }
}
