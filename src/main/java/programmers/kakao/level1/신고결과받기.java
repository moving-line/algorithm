package programmers.kakao.level1;

import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

// 2022 카카오 블라인드 채용
public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 우당탕탕 풀이

        // userInfo에 모든 id와 셋(똑같은놈 신고시 무시) 초기화.
        Map<String, Set<String>> userInfo = new HashMap<>();
        for (String id : id_list) userInfo.put(id, new HashSet<>());

        // 리포트된 정보를 돌면서, userInfo에 신고당한놈을 키로 찾아서, 벨류로 신고자를 리스트에 추가함.
        for (String row : report) {
            String[] attr = row.split(" ");
            userInfo.get(attr[1]).add(attr[0]);
        }

        // 결과 반환위해 메일횟수 세는 countMail. 순서보장토록 LinkedHashMap
        Map<String, Integer> countMail = new LinkedHashMap<>();
        for (String id : id_list) countMail.put(id, 0);

        // countMail 을 돌면서..
        // 만약 크기가 k이상(정지확정)이면, 그 리스트의 멤버들에게 각각 메일횟수를 추가한다.
        for (Set<String> reportUsers : userInfo.values()) {
            if (reportUsers.size() >= k) {
                for (String id : reportUsers) {
                    countMail.put(id, countMail.get(id) + 1);
                }
            }
        }

        return countMail.values().stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Test
    public void test() {
        assertThat(solution(
                new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                2)).isEqualTo(new int[]{2, 1, 1, 0}
        );

        assertThat(solution(
                new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                3)).isEqualTo(new int[]{0, 0}
        );
    }

}
