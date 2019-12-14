package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Arrays;
import java.util.Scanner;

public class Q13398 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");

        int[] array = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];

        for (int i = 0; i < n; i++) {
            dpLeft[i] = array[i];
            if (i > 0 && dpLeft[i] < dpLeft[i - 1] + array[i]) {
                dpLeft[i] = dpLeft[i - 1] + array[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            dpRight[i] = array[i];
            if (i < n - 1 && dpRight[i] < dpRight[i + 1] + array[i]) {
                dpRight[i] = dpRight[i + 1] + array[i];
            }
        }

        int sum = Arrays.stream(dpLeft).max().getAsInt();
        for (int i = 1; i < n - 1; i++) {
            if (sum < dpLeft[i - 1] + dpRight[i + 1]) {
                sum = dpLeft[i - 1] + dpRight[i + 1];
            }
        }
        System.out.println(sum);
    }

//    시간초과 풀
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        sc.nextLine();
//        String[] str = sc.nextLine().split(" ");
//        int[] array = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
//
//        int[] dp = new int[n];
//        dp[0] = array[0];
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
//        }
//
//        int max = Arrays.stream(dp).max().getAsInt();
//
//        //array에서 원소 1개씩 빼면서 진행해보자
//        for (int i = 0; i < n; i++) {
//            int[] newArray = Arrays.copyOf(array, array.length);
//            newArray[i] = 0;
//            int[] newDp = new int[n];
//
//            newDp[0] = newArray[0];
//            for (int j = 1; j < n; j++) {
//                newDp[j] = Math.max(newDp[j - 1] + newArray[j], newArray[j]);
//            }
//
//            int newMax = Arrays.stream(newDp).max().getAsInt();
//            max = Math.max(newMax, max);
//        }
//
//        System.out.println(max);
//    }
}
