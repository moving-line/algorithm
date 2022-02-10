/*
문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */

package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 가장큰수 {
    public String solution(int[] numbers) {
//        첫번째 풀이
        List<Num> list = new ArrayList<>();
        for (int number : numbers) list.add(new Num(String.valueOf(number)));

        Collections.sort(list);

        if (list.get(0).checkZero()) return "0";

        StringBuilder sb = new StringBuilder();
        for (Num num : list) sb.append(num.getNumber());

        return sb.toString();
    }

    class Num implements Comparable<Num> {
        String number;

        public Num(String number) {
            this.number = number;
        }

        public boolean checkZero() {
            return number.equals("0");
        }

        public String getNumber() {
            return number;
        }

        @Override
        public int compareTo(Num o) {
            return (o.number + this.number).compareTo(this.number + o.number);
        }
    }

    public String solution2 (int[] numbers) {
//        두번째 풀이
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
//        Arrays.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2 + o1).compareTo(o1 + o2);
//            }
//        });

        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String anArr : arr) sb.append(anArr);

        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(solution(new int[] {6, 10, 2})).isEqualTo("6210");
        assertThat(solution(new int[] {3, 30, 34, 5, 9})).isEqualTo("9534330");
    }
}
