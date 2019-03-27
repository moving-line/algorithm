/*
문제 설명
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다.
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

  경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
    0	        []	            []	        [7,4,5,6]
    1~2	        []	            [7]	        [4,5,6]
    3	        [7]	            [4]	        [5,6]
    4	        [7]	            [4,5]	    [6]
    5	        [7,4]	        [5]	        [6]
    6~7	        [7,4,5]	        [6]	        []
    8	        [7,4,5,6]	    []	        []

따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다.
이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
 */

package programmers.level2;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 다리를지나는트럭 {
//    첫번째 풀이
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> moving = new LinkedList<>();
        Queue<Integer> waiting = new LinkedList<>();
        List<Integer> complete = new ArrayList<>();
        List<Integer> position = new ArrayList<>();

        for (int t : truck_weights) waiting.add(t);

        while(complete.size() != truck_weights.length) {
            if (moving.size() != 0) {
                for (int i = 0; i < position.size(); i++) {
                    if (position.get(i) > 0) {
                        position.set(i, position.get(i) - 1);
                    }
                    if (position.get(i) == 0) {
                        position.set(i, position.get(i) - 1);
                        complete.add(moving.poll());
                    }
                }
            }
            if (waiting.size() != 0) {
                if (weight >= sumMovingTruckWeight(moving) + waiting.element()) {
                    moving.add(waiting.poll());
                    position.add(bridge_length);
                }
            }
            time++;
        }

        return time;
    }

    private int sumMovingTruckWeight(Queue<Integer> movingTruck) {
        if (movingTruck.size() == 0) return 0;

        int sum = 0;
        for (Integer i : movingTruck) sum += i;

        return sum;

    }

//    두번째 풀이
    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Truck> waiting = new LinkedList<>();
        List<Truck> moving = new ArrayList<>();
        List<Truck> complete = new ArrayList<>();
        for (int i : truck_weights) waiting.add(new Truck(bridge_length, i));

        while(complete.size() != truck_weights.length) {
            if (!moving.isEmpty()) {
                for (int i = moving.size() - 1; i >= 0; i--) {
                    moving.get(i).move();
                    if (moving.get(i).isZero()) complete.add(moving.remove(i));
                }
            }
            if (!waiting.isEmpty()) {
                if (weight >= sumMovingWeight(moving) + waiting.element().getWeight()) {
                    moving.add(waiting.poll());
                }
            }
            time++;
        }

        return time;
    }

    class Truck {
        int position;
        int weight;

        public Truck(int bridge_length, int weight) {
            this.position = bridge_length;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void move() {
            if (position > 0) position--;
        }

        public boolean isZero() {
            return position == 0;
        }

        @Override
        public String toString() {
            return "무게(" + weight + ")위치("
                    + position + ") /// ";
        }
    }

    private int sumMovingWeight(List<Truck> moving) {
        if (moving.isEmpty()) return 0;

        int sum = 0;
        for (Truck t : moving) sum += t.weight;

        return sum;
    }

    @Test
    public void test() {
        assertThat(solution2(2, 10, new int[] {7, 4, 5, 6})).isEqualTo(8);
        assertThat(solution2(100, 100, new int[] {10})).isEqualTo(101);
        assertThat(solution2(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10})).isEqualTo(110);
    }
}
