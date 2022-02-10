/*
문제 설명
선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

제한 조건
스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
스킬 순서와 스킬트리는 문자열로 표기합니다.
예를 들어, C → B → D 라면 CBD로 표기합니다
선행 스킬 순서 skill의 길이는 2 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
skill_trees는 길이 1 이상 20 이하인 배열입니다.
skill_trees의 원소는 스킬을 나타내는 문자열입니다.
skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 */

package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        // 첫번째 풀이
        Queue<Character> q;
        int count = 0;

        skill_trees :
        for (String st : skill_trees) { // BACDE/CBADF/AECB/BDA를 하나 꺼내오는 외곽 루프문
            q = new LinkedList<>();
            for (int i = 0; i < skill.length(); i++) q.add(skill.charAt(i));

            int index = 0;
            boolean flag = false;

            skill : for (int i = 0; i < skill.length(); i++) { //... C/B/D를, BACDE와  루프문
                for (int j = 0; j < st.length(); j++) { //... C를 BACDE의 원소 하나하나와 비교하는 내부루프문
                    if (st.charAt(j) == q.element()) { // 일단 같은 단어를 발견했다.
                        if(flag) continue skill_trees; // 앞선단어는 같은게 없었다. C없이 B를 배울순 없다. 다음단어로!
                        if (j < index) continue skill_trees; // 이전 단어가 같긴했지만 C/B/D의 순서를 위반했다. 다음단어로!

                        // 문제가 없으므로 C/B/D의 C를 제거하고, 다음 요소인 B를 BACDE와 비교할 수 있도록 넘어가자.
                        index = j;
                        q.poll();
                        flag = false;
                        continue skill;
                    }
                }
                // C는 BACDE 전체와 비교했을 때 같은녀석이 없었다. flag에 따로 표시를 하고, C를 제거하고 다음 단어 B로 넘어가자.
                flag = true;
                q.poll();
            }
            count++;
        }
        return count;

//         두번째 풀이
//        List<String> sList = Arrays.asList(skill.split(""));
//        List<String> stList = Arrays.asList(skill_trees);
//
//        boolean empty;
//        int index;
//        int count = 0;
//
//        outer : for (String st : stList) {
//            empty = false;
//            index = 0;
//
//            inner : for (String s : sList) {
//                String[] stArray = st.split("");
//                for (int j = 0; j < st.length(); j++) {
//                    if (s.equals(stArray[j])) {
//                        if(empty) continue outer;
//                        if (j < index) continue outer;
//                        index = j;
//                        continue inner;
//                    }
//                }
//                empty = true;
//            }
//            count++;
//        }
//
//        return count;

//         세번째 풀이
//        List<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
//        skillTrees.removeIf(s -> skill.indexOf(s.replaceAll("[^" + skill + "]", "")) != 0);
//
//        return skillTrees.size();
    }

    @Test
    public void test() {
        assertThat(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})).isEqualTo(2);
    }
}
