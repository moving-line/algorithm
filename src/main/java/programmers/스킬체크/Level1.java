package programmers.스킬체크;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Level1 {
    // 문제1
    public int solution1(int num) {
        int count = 0;
        long number = num;

        while (number != 1) {
            if (number % 2 == 0) number /= 2;
            else number = (number * 3) + 1;
            count++;

            if (count >= 500) return -1;
        }

        return count;
    }

    @Test
    public void test1() {
        assertThat(solution1(6)).isEqualTo(8);
        assertThat(solution1(16)).isEqualTo(4);
        assertThat(solution1(626331)).isEqualTo(-1);
    }

    // 문제2
    public String solution2(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String c : completion) map.merge(c, 1, Integer::sum);
        for (String p : participant) map.merge(p, 1, Integer::sum);
        for (String p : participant) if (map.get(p) % 2 != 0) return p;

        return null;
    }

//    시간초과
//    public String solution2(String[] participant, String[] completion) {
//        List<String> p = new LinkedList<>();
//        Collections.addAll(p, participant);
//
//        for (String c : completion) {
//            for (int j = 0; j < p.size(); j++) {
//                if (c.equals(p.get(j))) {
//                    p.remove(j);
//                    break;
//                }
//            }
//        }
//
//        return p.get(0);
//    }

//    추가풀이
//    public String solution2(String[] participant, String[] completion) {
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//
//        for (int i = 0; i < completion.length; i++) {
//            if (!participant[i].equals(completion[i])) {
//                return participant[i];
//            }
//        }
//        return participant[participant.length - 1];
//    }

    @Test
    public void test2() {
        assertThat(solution2(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}))
                .isEqualTo("leo");

        assertThat(solution2(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}))
                .isEqualTo("vinko");

        assertThat(solution2(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}))
                .isEqualTo("mislav");
    }
}
