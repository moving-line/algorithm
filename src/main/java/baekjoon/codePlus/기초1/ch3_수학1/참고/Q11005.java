package baekjoon.codePlus.기초1.ch3_수학1.참고;

import java.util.Scanner;
import java.util.Stack;

public class Q11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        Stack<Character> stack = new Stack<>();

        while (N / B != 0) {
            stack.push(convert(N % B));
            N /= B;
        }
        if (N != 0) {
            stack.push(convert(N % B));
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop());
        }
    }

    private static char convert(int r) {
        return (char) (r > 9 ? r + 'A' - 10 : r + '0');
    }
}
