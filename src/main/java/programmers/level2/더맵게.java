/*
문제 설명
매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

제한 사항
scoville의 길이는 1 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 */

package programmers.level2;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : scoville) q.add(s);

        int count = 0;

        while(q.size() > 1 && q.element() < K) {
            q.add(q.remove() + (q.remove() * 2));
            count++;
        }

        return q.element() < K ?  -1 : count;

//        만약 우선순위 큐를 사용하지 않는다면? -> 시간초과함. 불가.
//        List<Integer> list = new ArrayList<>();
//        for (int s : scoville) list.add(s);
//
//        Collections.sort(list);
//
//        int count = 0;
//        while(list.size() > 1 && list.get(0) < K) {
//            int first = list.get(0);
//            list.remove(0);
//            int second = list.get(0);
//            list.remove(0);
//
//            list.add(0, first + (second * 2));
//            Collections.sort(list);
//            count++;
//        }
//
//        return list.get(0) < K ? -1 : count;
    }

    @Test
    public void test() {
        assertThat(solution(new int[] {1, 2, 3, 9, 10, 12}, 7)).isEqualTo(2);
    }
}
