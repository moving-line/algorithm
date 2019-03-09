/*
문제 설명
String형 배열 seoul의 element중 Kim의 위치 x를 찾아, 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요.
seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

제한 사항
seoul은 길이 1 이상, 1000 이하인 배열입니다.
seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
Kim은 반드시 seoul 안에 포함되어 있습니다.
*/

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
    }

    @Test
    public void test() {
        String[] seoul = {"Lee", "Choi", "Kim", "Park"};
        String[] seoul2 = {"Lee", "Choi", "Park", "Kim"};
        String[] seoul3 = {"Kim", "Choi", "Park", "Lee"};

        assertThat(solution(new String[] {"Lee", "Choi", "Kim", "Park"})).isEqualTo("김서방은 2에 있다");
        assertThat(solution(new String[] {"Lee", "Choi", "Park", "Kim"})).isEqualTo("김서방은 3에 있다");
        assertThat(solution(new String[] {"Kim", "Choi", "Park", "Lee"})).isEqualTo("김서방은 0에 있다");
    }
}
