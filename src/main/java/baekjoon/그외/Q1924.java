/*
문제
오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 빈 칸을 사이에 두고 x(1≤x≤12)와 y(1≤y≤31)이 주어진다.
참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.

출력
첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.
 */

package baekjoon.그외;

import java.util.Scanner;

public class Q1924 {
    public static void main(String[] args) {
//        첫번째 풀이
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");

        int x = Integer.parseInt(array[0]);
        int y = Integer.parseInt(array[1]);

        while (x < 1 || x > 12 || y < 1 || y > 31) {
            input = sc.nextLine();
            array = input.split(" ");

            x = Integer.parseInt(array[0]);
            y = Integer.parseInt(array[1]);
        }

        int sum = 0;
        for (int i = 1; i <= x; i++) {
            if (i == 1) sum += 0;
            else if (i == 5 || i == 7 || i == 10 || i == 12) sum += 30;
            else if (i == 3) sum += 28;
            else sum += 31;
        }
        sum += y;

        int day = sum % 7;
        if (day == 1) System.out.println("MON");
        else if (day == 2) System.out.println("TUE");
        else if (day == 3) System.out.println("WED");
        else if (day == 4) System.out.println("THU");
        else if (day == 5) System.out.println("FRI");
        else if (day == 6) System.out.println("SAT");
        else System.out.println("SUN");

//        두번째 풀이
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        String[] array = input.split(" ");
//
//        int x = Integer.parseInt(array[0]);
//        int y = Integer.parseInt(array[1]);
//
//        while (x < 1 || x > 12 || y < 1 || y > 31) {
//            input = sc.nextLine();
//            array = input.split(" ");
//
//            x = Integer.parseInt(array[0]);
//            y = Integer.parseInt(array[1]);
//        }
//
//        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        String[] Weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
//
//        int sum = 0;
//        for (int i = 1; i < x; i++) sum += days[i - 1];
//        sum += y;
//
//        for (int i = 0; i < Weeks.length; i++) {
//            if (sum % 7 == i) System.out.println(Weeks[i]);
//        }

//        세번째 풀이
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//
//        while (x < 1 || x > 12 || y < 1 || y > 31) {
//            x = sc.nextInt();
//            y = sc.nextInt();
//        }
//
//        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        String[] Weeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
//
//        int sum = y;
//        for (int i = 1; i < x; i++) sum += days[i - 1];
//
//        System.out.println(Weeks[sum % 7]);
    }
}
