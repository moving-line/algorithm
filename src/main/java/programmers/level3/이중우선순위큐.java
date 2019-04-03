/*
문제 설명
이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	    큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.
이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때,
모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

제한사항
operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다
operations의 원소는 큐가 수행할 연산을 나타냅니다.
원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

 */

package programmers.level3;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] array = operations[i].split(" ");

            if (array[0].startsWith("I")) {
                int num =  Integer.parseInt(array[1]);
                minQ.add(num); maxQ.add(num);
            } else {
                if (!minQ.isEmpty()) {
                    if (array[1].equals("1")) minQ.remove(maxQ.remove());
                    else maxQ.remove(minQ.remove());
                }
            }
        }

        if (minQ.isEmpty()) return new int[] {0, 0};
        return new int[] {maxQ.element(), minQ.element()};
    }

    @Test
    public void test() {
        assertThat(solution(new String[] {"I 16", "D 1"})).isEqualTo(new int[] {0, 0});
        assertThat(solution(new String[] {"I -1"})).isEqualTo(new int[] {-1, -1});
        assertThat(solution(new String[] {"D 1"})).isEqualTo(new int[] {0, 0});
        assertThat(solution(new String[] {"I 7", "I 5", "I -5", "D -1"})).isEqualTo(new int[] {7, 5});
        assertThat(solution(new String[] {"I 2", "I 2", "I 3", "I 3", "D -1"})).isEqualTo(new int[] {3, 2});
        assertThat(solution(new String[] {"I 2", "I 2", "I 3", "D -1"})).isEqualTo(new int[] {3, 2});
        assertThat(solution(new String[] {"I 2", "I 2", "I 3", "D -1", "D 1"})).isEqualTo(new int[] {2, 2});
        assertThat(solution(new String[] {"I 2", "I 2", "I 3", "D -1", "D 1", "D 1"})).isEqualTo(new int[] {0, 0});
        assertThat(solution(new String[] {"I 2", "I 2", "I 3", "D -1", "D 1", "D 1", "D -1"})).isEqualTo(new int[] {0, 0});
        assertThat(solution(new String[] {"I 1", "I -1", "D 1", "I 2", "D 1", "D -1", "D -1", "I 3"})).isEqualTo(new int[] {3, 3});
    }
}
