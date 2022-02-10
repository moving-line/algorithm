/*
문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
 */


package programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        //첫번째 풀이
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) list.add(array[j]);
            Collections.sort(list);
            answer[i] = list.get(commands[i][2] - 1);
        }

        return answer;

//        두번째 풀이
//        List<Integer> answer = new ArrayList<>();
//
//        for (int[] c : commands) {
//            int tempSize = c[1] - c[0] + 1;
//            int[] temp = new int[tempSize];
//
//            System.arraycopy(array, c[0] - 1, temp, 0, tempSize);
//            Arrays.sort(temp);
//            answer.add(temp[c[2] - 1]);
//        }
//
//        int[] answers = new int[commands.length];
//        for (int i = 0; i < answers.length; i++) answers[i] = answer.get(i);
//
//        return answers;

//        세번째 풀이
//        int[] answer = new int[commands.length];
//
//        for(int i = 0; i < commands.length; i++){
//            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
//            Arrays.sort(temp);
//            answer[i] = temp[commands[i][2] - 1];
//        }
//
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))
                .isEqualTo(new int[] {5, 6, 3});
    }
}
