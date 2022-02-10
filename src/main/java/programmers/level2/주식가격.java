/*
문제 설명
초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

제한사항
prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.
 */

package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 주식가격 {
    public int[] solution(int[] prices) {
//        첫번째 풀이
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            boolean down = false;
            int count = -1;

            for (int j = i; j < prices.length; j++) {
                if(prices[i] <= prices[j]) count++;
                else {
                    answer[i] = count + 1;
                    down = true;
                    break;
                }
            }
            if (!down) answer[i] = count;
        }

        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 2, 3, 2, 3})).isEqualTo(new int[]{4, 3, 1, 1, 0});
    }
}
