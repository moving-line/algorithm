package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class L412_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            answer.add(isFizzBuzz(i));
        }
        return answer;
    }

    private String isFizzBuzz(int num) {
        // 첫 풀이
        boolean divisibleBy3 = num % 3 == 0;
        boolean divisibleBy5 = num % 5 == 0;

        if (divisibleBy3 && divisibleBy5) {
            return "FizzBuzz";
        } else if (divisibleBy3) {
            return "Fizz";
        } else if (divisibleBy5) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }

        // 확장성 개선. 만약 추가로 확인할 숫자가 늘어날때 유리
//        String numStr = "";
//        if(divisibleBy3) {
//            numStr += "Fizz";
//        }
//        if (divisibleBy5) {
//            numStr += "Buzz";
//        }
//        if(numStr.equals("")) {
//            numStr = String.valueOf(num);
//        }
//
//        return numStr;

        // 확장성 개선2. 아예 해시맵 사용
//        Map<Integer, String> map = new HashMap<>() {{
//            put(3, "Fizz");
//            put(5, "Buzz");
//        }};
//
//        String numStr = "";
//
//        for (Integer i : map.keySet()) {
//            if (num % i == 0) {
//                numStr += map.get(i);
//            }
//        }
//        if (numStr.equals("")) {
//            numStr = String.valueOf(num);
//        }
//
//        return numStr;
    }

    @Test
    void test() {
        assertThat(fizzBuzz(3)).isEqualTo(List.of("1", "2", "Fizz"));
        assertThat(fizzBuzz(5)).isEqualTo(List.of("1", "2", "Fizz", "4", "Buzz"));
        assertThat(fizzBuzz(15)).isEqualTo(List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"));
    }
}
