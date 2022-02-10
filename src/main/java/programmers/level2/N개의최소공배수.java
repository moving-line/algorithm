/*
문제 설명
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

제한 사항
arr은 길이 1이상, 15이하인 배열입니다.
arr의 원소는 100 이하인 자연수입니다.
 */

package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class N개의최소공배수 {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm(lcm, arr[i]);
        }

        return lcm;
    }

    public static int gcd(int a, int b) {
        int number1 = a;
        int number2 = b;
        int remain = 1;

        if (b > a) {
            number1 = b;
            number2 = a;
        }

        while (remain > 0) {
            remain = number1 % number2;
            number1 = number2;
            number2 = remain;
        }

        return number1;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 6, 8, 14})).isEqualTo(168);
        assertThat(solution(new int[]{1, 2, 3})).isEqualTo(6);
    }
}
