/*
문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때
숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.

 */

package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 타켓넘버 {
    public int solution(int[] numbers, int target) {
        int dp[][] = new int[numbers.length][];

        dp[0] = new int[2];
        dp[0][0] = numbers[0];
        dp[0][1] = -numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            int num = (int) Math.pow(2, i + 1);

            dp[i] = new int[num];
            for (int j = 0; j < num; j++) {
                dp[i][j] = dp[i - 1][j / 2] + (j % 2 == 0 ? 1 : -1) * numbers[i];
            }
        }

        int count = 0;
        for (int i = 0; i < dp[numbers.length - 1].length; i++) {
            if (dp[numbers.length - 1][i] == target) count++;
        }

        return count;
    }

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 1, 1, 1, 1}, 3)).isEqualTo(5);
    }
}
