/*
문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.
 */

package programmers.level2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        for (int i = 0; i + 1 < sb.length() && k > 0; i++) {
            if (sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                i = -1;
                k--;
            }
        }

        if (k != 0) sb.delete(sb.length() - k, sb.length());
        return sb.toString();
    }

//    시간초과풀이
//    public String solution(String number, int k) {
//        List<Integer> list = Arrays.stream(number.split(""))
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .collect(Collectors.toList());
//
//        int i = 0;
//        while(k > 0 && i < list.size() - 1) {
//            if(list.get(i) < list.get(i + 1)) {
//                list.remove(i);
//                k--;
//                i = 0;
//            } else i++;
//        }
//
//        while(k != 0) {
//            int min = list.get(0);
//            for (Integer l : list) {
//                if (l < min) min = l;
//            }
//
//            for (Integer l : list) {
//                if(l == min) {
//                    list.remove(l);
//                    k--;
//                    break;
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int a : list) sb.append(a);
//        return sb.toString();
//    }

    @Test
    public void test() {
        assertThat(solution("1924", 2)).isEqualTo("94");
        assertThat(solution("1231234", 3)).isEqualTo("3234");
        assertThat(solution("4177252841", 4)).isEqualTo("775841");
        assertThat(solution("11311", 4)).isEqualTo("3");
        assertThat(solution("11111", 4)).isEqualTo("1");
    }
}
