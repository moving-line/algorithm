/*
문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
- numbers의 길이는 1 이상 100,000 이하입니다.
- numbers의 원소는 0 이상 1,000 이하입니다.
- 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

입출력 예
numbers	            return
[6, 10, 2]	        "6210"
[3, 30, 34, 5, 9]	"9534330"
 */

package programmers.javaKit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


public class 정렬대표_가장큰수 {
    public String solution(int[] numbers) {
        String[] strArray = new String[numbers.length]; // 문자 변환
        for (int i = 0; i < numbers.length; i++) strArray[i] = String.valueOf(numbers[i]);

        Arrays.sort(strArray, (s1, s2) -> (s2 + s1).compareTo(s1 + s2)); // 내림차순 정렬
        if (strArray[0].equals("0")) return "0"; // 0000처럼 0이 여러개이면 0으로만 반환

        StringBuilder sb = new StringBuilder(); // 결과 문자 조립
        for (String s : strArray) sb.append(s);

        return sb.toString();

//        스트림으로 줄인 답
//        String answer = IntStream.of(numbers)
//                .mapToObj(String::valueOf)
//                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
//                .collect(Collectors.joining());
//        if(answer.startsWith("0")) return "0";
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(new int[]{6, 10, 2})).isEqualTo("6210");
        assertThat(solution(new int[]{0, 0, 0})).isEqualTo("0");
        assertThat(solution(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
    }
}


