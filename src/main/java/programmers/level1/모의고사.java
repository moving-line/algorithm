/*
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 */
package programmers.level1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 모의고사 {
    public int[] solution(int[] answers) {
//        첫번째 풀이
        int[][] students = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] answerCount = new int[students.length];
        for (int i = 0; i < students.length; i++) {
            int count = 0;
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == students[i][j % students[i].length]) count++;
            }
            answerCount[i] = count;
        }

        int max = 0;
        for (int c : answerCount) {
            if (c > max) max = c;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < answerCount.length; i++) {
            if (answerCount[i] == max) {
                list.add(i + 1);
            }
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

//        두번째 풀이
//        int[][] students = {
//                {1, 2, 3, 4, 5},
//                {2, 1, 2, 3, 2, 4, 2, 5},
//                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
//        };
//        int[] score = new int[3];
//
//        for (int i = 0; i < answers.length; i++) {
//            for (int j = 0; j < students.length; j++) {
//                if (answers[i] == students[j][i % students[j].length]) score[j]++;
//            }
//        }
//
//        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < score.length; i++) {
//            if (maxScore == score[i]) list.add(i + 1);
//        }
//
//        return list.stream().mapToInt(i -> i).toArray();
    }


    @Test
    public void test() {
        assertThat(solution(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{1});

        assertThat(solution(new int[]{1, 1, 3, 3, 4})).isEqualTo(new int[]{1, 2});
        assertThat(solution(new int[]{1, 2, 1, 1, 3})).isEqualTo(new int[]{1, 3});
        assertThat(solution(new int[]{2, 1, 1, 1, 5})).isEqualTo(new int[]{2, 3});

        assertThat(solution(new int[]{1, 3, 2, 4, 2})).isEqualTo(new int[]{1, 2, 3});
        assertThat(solution(new int[]{5, 5, 5, 5, 4})).isEqualTo(new int[]{1, 2, 3});
    }
}
