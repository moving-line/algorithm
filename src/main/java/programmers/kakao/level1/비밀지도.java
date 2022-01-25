package programmers.kakao.level1;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 2018 카카오 블라인드 채용
public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int decimalNum = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append((decimalNum % 2 == 1) ? "#" : " ");
                decimalNum /= 2;
            }

            answer[i] = sb.reverse().toString();
        }

        return answer;

//         변환 함수 사용
//        String[] answer = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
//
//            for (int j = 0; j < n; j++) {
//                binary = String.format("%" + n + "s", binary);
//                binary = binary.replaceAll("1", "#");
//                binary = binary.replaceAll("0", " ");
//            }
//
//            answer[i] = binary;
//        }
//
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}))
                .isEqualTo(new String[]{"#####", "# # #", "### #", "#  ##", "#####"});

        assertThat(solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10}))
                .isEqualTo(new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "});

    }
}
