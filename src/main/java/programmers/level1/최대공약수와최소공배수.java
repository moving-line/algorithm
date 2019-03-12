/*
문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
두 수는 1이상 1000000이하의 자연수입니다.
 */
package programmers.level1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        // 첫번째 풀이
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int remain = 1;

        while(remain > 0){
            remain = max % min;
            max = min;
            min = remain;
        }

        return new int[] {max, (n * m)/max};

//         두번째 풀이
//        int[] answer = new int[2];
//
//        for(int i = 1; i <= Math.max(n, m); i++){
//            if(n % i == 0 && m % i == 0) answer[0] = i;
//        }
//        answer[1] = (n * m) / answer[0];
//
//        return answer;

//        세번째풀이
//        for(int i = Math.max(n, m); i >= 1; i--){
//            if(n % i == 0 && m % i == 0) return new int[] {i, n * m / i};
//        }
//        return null;
    }


    @Test
    public void test() {
        assertThat(solution(3, 12)).isEqualTo(new int[] {3, 12});
        assertThat(solution(2, 5)).isEqualTo(new int[] {1, 10});
        assertThat(solution(6, 14)).isEqualTo(new int[] {2, 42});
    }
}
