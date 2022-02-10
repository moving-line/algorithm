/*
문제 설명
올바른 괄호란 (())나 ()와 같이 올바르게 모두 닫힌 괄호를 의미합니다. )(나 ())() 와 같은 괄호는 올바르지 않은 괄호가 됩니다.
괄호 쌍의 개수 n이 주어질 때, n개의 괄호 쌍으로 만들 수 있는 모든 가능한 괄호 문자열의 갯수를 반환하는 함수 solution을 완성해 주세요.

제한사항
- 괄호 쌍의 개수 N : 1 ≤ n ≤ 14, N은 정수

입출력 예
n	result
2	2
3	5

입출력 예 설명
입출력 예 #1
2개의 괄호쌍으로 [ "(())", "()()" ]의 2가지를 만들 수 있습니다.

입출력 예 #2
3개의 괄호쌍으로 [ "((()))", "(()())", "(())()", "()(())", "()()()" ]의 5가지를 만들 수 있습니다.

 */

package programmers.javaKit;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class DFS대표_올바른괄호의갯수 {
    public int solution(int n) {
        // DFS : Stack 이용
        Stack<Bracket> stack = new Stack<>();
        stack.push(new Bracket(0, 0));
        int answer = 0;

        while (!stack.empty()) {
            Bracket bracket = stack.pop();

            if (bracket.numOfOpen > n) continue;
            if (bracket.numOfOpen < bracket.numOfClose) continue;
            if (bracket.numOfOpen + bracket.numOfClose == 2 * n) {
                answer++;
                continue;
            }

            stack.push(new Bracket(bracket.numOfOpen + 1, bracket.numOfClose)); // 기존 + (
            stack.push(new Bracket(bracket.numOfOpen, bracket.numOfClose + 1)); // 기존 + )
        }

        return answer;
    }

    class Bracket {
        int numOfOpen;
        int numOfClose;

        public Bracket(int numOfOpen, int close) {
            this.numOfOpen = numOfOpen;
            this.numOfClose = close;
        }
    }

    @Test
    public void test() {
        assertThat(solution(2)).isEqualTo(2);
        assertThat(solution(3)).isEqualTo(5);
    }
}
