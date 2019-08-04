/*
문제
문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
S에는 QR Code "alphanumeric" 문자만 들어있다.
QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

입력
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
S의 길이는 적어도 1이며, 20글자를 넘지 않는다.

출력
각 테스트 케이스에 대해 P를 출력한다.
 */

package baekjoon.step7_문자열;

import java.util.Scanner;

public class Q2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T < 1 || T > 1000) {
            System.out.println("테스트 케이스 개수를 다시 입력하시오.");
            T = sc.nextInt();
        }

        sc.nextLine();
        String[] array = new String[T];
        for (int i = 0; i < T; i++) array[i] = sc.nextLine();
        while(checkR(array) || checkS(array)) {
            System.out.println("테스트 케이스의 반복 횟수와 해당 문자열을 다시 입력하시오");
            array = new String[T];
            for (int i = 0; i < T; i++) array[i] = sc.nextLine();
        }

        for (String a : array) {
            int R = Integer.parseInt(a.split(" ")[0]);
            String S = a.split(" ")[1];
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) sb.append(S.toCharArray()[j]);
            }

            System.out.println(sb.toString());
        }
        
    }

    private static boolean checkS (String[] array) {
        for (String a : array) {
            int S = Integer.parseInt(a.split(" ")[0]);
            if (S < 1 || S > 8) return true;
        }
        return false;
    }

    private static boolean checkR(String[] array) {
        for (String a : array) {
            String S = a.split(" ")[1];
            if (S.length() < 1 || S.length() > 20) return true;
        }
        return false;
    }
}
