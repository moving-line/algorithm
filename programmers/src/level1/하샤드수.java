/*
문제 설명
양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

제한 조건
x는 1 이상, 10000 이하인 정수입니다.
 */

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 하샤드수 {
    public boolean solution(int x) {
        //첫번째 풀이
        String strX = Integer.toString(x);
        int sum = 0;

        for (int i = 0; i < strX.length(); i++) {
            sum += Integer.parseInt(strX.substring(i, i+1));
        }

        return x % sum == 0;

//        두번째 풀이
//        String[] strX = Integer.toString(x).split("");
//        int sum = 0;
//        for (String s : strX) sum += Integer.parseInt(s);
//
//        return x % sum == 0;

//        세번째풀이
//        int sum = 0;
//        int temp = x;
//
//        while(temp != 0) {
//            sum += temp % 10;
//            temp /= 10;
//        }
//
//        return x % sum == 0;
    }

    @Test
    public void test() {
        하샤드수 test = new 하샤드수();

        assertThat(test.solution(10)).isEqualTo(true);
        assertThat(test.solution(12)).isEqualTo(true);
        assertThat(test.solution(11)).isEqualTo(false);
        assertThat(test.solution(13)).isEqualTo(false);
    }
}
