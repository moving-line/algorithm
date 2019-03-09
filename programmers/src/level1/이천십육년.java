/*
문제 설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다.
예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

 */

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 이천십육년 {
    public String solution(int a, int b) {
        // 첫번째 풀이 (진정한 사나이의 풀이)
        if (a == 1) {
            return util(b);
        } else if (a == 2) {
            return util(31 + b);
        } else if (a == 3) {
            return util(31 + 29 + b);
        } else if (a == 4) {
            return util(31 + 29 + 31 + b);
        } else if (a == 5) {
            return util(31 + 29 + 31 + 30 + b);
        } else if (a == 6) {
            return util(31 + 29 + 31 + 30 + 31 + b);
        } else if (a == 7) {
            return util(31 + 29 + 31 + 30 + 31 + 30 + b);
        } else if (a == 8) {
            return util(31 + 29 + 31 + 30 + 31 + 30 + 31 + b);
        } else if (a == 9) {
            return util(31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + b);
        } else if (a == 10) {
            return util(31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + b);
        } else if (a == 11) {
            return util(31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + b);
        } else {
            return util(31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + b);
        }

//         두번째 풀이
//        List<String> day = Arrays.asList("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU");
//        List<Integer> date = Arrays.asList(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30);
//
//        int answer = 0;
//        for (int i = 0; i < a - 1; i++) {
//            answer += date.get(i);
//        }
//        answer += b - 1;
//
//        return day.get(answer % 7);

//        세번째 풀이
//        LocalDate date = LocalDate.of(2016, a, b);
//        return date.getDayOfWeek().toString().substring(0, 3);
    }

    private String util(int x) {
        if (x % 7 == 1) {
            return "FRI";
        } else if( x % 7 == 2) {
            return "SAT";
        } else if( x % 7 == 3) {
            return "SUN";
        } else if( x % 7 == 4) {
            return "MON";
        } else if( x % 7 == 5) {
            return "TUE";
        } else if( x % 7 == 6) {
            return "WED";
        } else {
            return "THU";
        }
    }

    @Test
    public void test() {
        assertThat(solution(2, 1)).isEqualTo("MON");
        assertThat(solution(3, 1)).isEqualTo("TUE");
        assertThat(solution(6, 1)).isEqualTo("WED");
        assertThat(solution(9, 1)).isEqualTo("THU");
        assertThat(solution(1, 1)).isEqualTo("FRI");
        assertThat(solution(10, 1)).isEqualTo("SAT");
        assertThat(solution(5, 1)).isEqualTo("SUN");
    }
}
