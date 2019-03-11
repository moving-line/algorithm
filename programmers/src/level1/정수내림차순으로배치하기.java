/*
문제 설명
함수 solution은 정수 n을 매개변수로 입력받습니다.
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
예를 들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        //첫번째 풀이
        String[] strList = String.valueOf(n).split("");
        int[] list = new int[strList.length];

        for (int i = 0; i < String.valueOf(n).length(); i++) {
            list[i] = Integer.parseInt(strList[i]);
        }

        List<Integer> list1 = new ArrayList<>();
        for (int i : list) list1.add(i);
        int[] list2 = list1.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

        StringBuilder sb = new StringBuilder();
        for (int aList2 : list2) sb.append(String.valueOf(aList2));

        return Long.parseLong(sb.toString());

//        두번째 풀이
//        String[] strList = String.valueOf(n).split("");
//        int[] intList = new int[strList.length];
//        for (int i = 0; i < intList.length; i++) intList[i] = Integer.parseInt(strList[i]);
//
//        Arrays.sort(intList);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < intList.length; i++) sb.append(String.valueOf(intList[i]));
//
//        return Long.parseLong(sb.reverse().toString());

//        세번째 풀이
//        String[] list = String.valueOf(n).split("");
//        Arrays.sort(list);
//
//        StringBuilder sb = new StringBuilder();
//        for (String aList : list) sb.append(aList);
//
//        return Long.parseLong(sb.reverse().toString());
    }

    @Test
    public void test() {
        assertThat(solution(118372)).isEqualTo(873211);
    }
}
