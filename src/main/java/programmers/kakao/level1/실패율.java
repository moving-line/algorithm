package programmers.kakao.level1;

import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

// 2019 카카오 블라인드 채용
public class 실패율 {
    public int[] solution(int N, int[] stages) {
        List<Stage> list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) list.add(new Stage(i));
        for (int stage : stages) list.get(stage - 1).addPlayer();

        double remainingPlayers = stages.length;
        for (Stage stage : list) {
            stage.calculateFailureRate(remainingPlayers);
            remainingPlayers -= stage.getNumOfPlayer();
        }

        Collections.sort(list);
        return list.stream()
                .filter(s -> s.getId() <= N)
                .mapToInt(Stage::getId)
                .toArray();
    }

    class Stage implements Comparable {
        private final int id;
        private int numOfPlayer;
        private double failureRate;

        public Stage(int id) {
            this.id = id;
            this.numOfPlayer = 0;
            this.failureRate = 0.0;
        }

        public int getId() {
            return id;
        }

        public int getNumOfPlayer() {
            return numOfPlayer;
        }

        public void calculateFailureRate(double remainingPlayers) {
            if (remainingPlayers == 0) {
                return;
            }
            this.failureRate = (double) numOfPlayer / remainingPlayers;
        }

        public void addPlayer() {
            numOfPlayer++;
        }

        @Override
        public int compareTo(Object o) {
            Stage other = (Stage) o;
            if (this.failureRate > other.failureRate) {
                return -1;
            } else if (this.failureRate == other.failureRate) {
                return Integer.compare(this.id, other.id);
            } else {
                return 1;
            }
        }
    }

    @Test
    public void test() {
        assertThat(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})).isEqualTo(new int[]{3, 4, 2, 1, 5});
        assertThat(solution(4, new int[]{4, 4, 4, 4, 4})).isEqualTo(new int[]{4, 1, 2, 3});
    }
}
