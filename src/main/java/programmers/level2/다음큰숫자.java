/*
문제 설명
자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

제한 사항
n은 1,000,000 이하의 자연수 입니다.
 */

package programmers.level2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 다음큰숫자 {
//     첫번째 풀이
    public int solution(int n) {
        int numOfOne = getNumberOfOne(n);
        int bigNum = n + 1;

        while (getNumberOfOne(bigNum) != numOfOne) bigNum++;
        return bigNum;
    }

    private int getNumberOfOne(int n) {
        List<Integer> list = new ArrayList<>();

        while (n != 1) {
            list.add(n % 2);
            n /= 2;
        }
        list.add(n);

        int count = 0;
        for (Integer i : list) if (i == 1) count++;

        return count;
    }

//     두번째 풀이
//    public int solution(int n) {
//        int count = Integer.bitCount(n);
//        int big = n + 1;
//
//        while (Integer.bitCount(big) != count) big++;
//        return big;
//    }

    @Test
    public void test() {
        assertThat(solution(78)).isEqualTo(83);
        assertThat(solution(15)).isEqualTo(23);
    }
}
