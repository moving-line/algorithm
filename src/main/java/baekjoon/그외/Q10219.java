/*

 */

package baekjoon.그외;

import java.util.Scanner;

public class Q10219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < test; i++) {
            String[] input = sc.nextLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < H; j++) {
                String str = sc.nextLine();
                for (int k = W - 1; k >= 0; k--) {
                    sb.append(str.charAt(k));
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}