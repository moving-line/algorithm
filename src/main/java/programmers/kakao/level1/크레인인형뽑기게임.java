package programmers.kakao.level1;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

// 2019 카카오 개발자 겨울 인턴십
public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {

        // 첫 풀이
        List<Queue<Integer>> list = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new LinkedList<>());
        }

        for (int[] line : board) {
            for (int j = 0; j < line.length; j++) {
                Queue<Integer> que = list.get(j);
                if (line[j] != 0) {
                    que.offer(line[j]);
                }
            }
        }

        Stack<Integer> bucket = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            Queue<Integer> queue = list.get(move - 1);
            if (queue.isEmpty()) continue;
            int pick = queue.poll();

            if (!bucket.isEmpty() && (bucket.peek() == pick)) {
                bucket.pop();
                answer += 2;
            } else {
                bucket.push(pick);
            }
        }

        return answer;


        // 굳이 큐 안만들고 바로 pick
//        int answer = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (int move : moves) {
//            for (int j = 0; j < board.length; j++) {
//                int pick = board[j][move - 1];
//                if (pick != 0) {
//                    if (!stack.isEmpty() && (pick == stack.peek())) {
//                        stack.pop();
//                        answer += 2;
//                    } else
//                        stack.push(pick);
//
//                    board[j][move - 1] = 0;
//                    break;
//                }
//            }
//        }
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4})).isEqualTo(4);
    }
}
