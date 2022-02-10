/*
문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.

 */
package programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        //첫번째풀이
        HashMap<String, Integer> map = new HashMap<>();

        for (String c : completion) map.merge(c, 1, (a, b) -> a + b);
        for (String p : participant) map.merge(p, 1, (a, b) -> a + b);
        for (String p : participant) if (map.get(p) % 2 != 0) return p;

        return null;

//        두번째 풀이
//        HashMap<String, Integer> map = new HashMap<>();
//        String answer = "";
//
//        for (String c : completion) map.merge(c, 1, (a, b) -> a + b);
//        for (String p : participant) map.merge(p, 1, (a, b) -> a + b);
//        for (String p : participant) if (map.get(p) % 2 != 0) answer = p;
//
//        return answer;

//        세번째 풀이
//        HashMap<String, Integer> map = new HashMap<>();
//        String answer = "";
//
//        for (String p : participant) map.merge(p, 1, (a, b) -> a + b);
//        for (String c : completion) map.put(c, map.get(c) - 1);
//        for (String s : map.keySet()) if (map.get(s) != 0) answer = s;
//
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"})).isEqualTo("leo");
        assertThat(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"})).isEqualTo("vinko");
        assertThat(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"})).isEqualTo("mislav");
    }
}
