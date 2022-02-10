package programmers.스킬체크;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Level2 {
    // 문제1
    public int[] solution1(int n, String[] words) {
        int index = -1;
        int a = 0, b = 0;

        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            String exWord = words[i - 1];

            if(word.charAt(0) != exWord.charAt(exWord.length() - 1) || list.contains(word)) {
                index = i;
                break;
            }

            list.add(word);
        }

        if (index != -1) {
            a = (index % n) + 1;
            b = (index / n) + 1;
        }

        return new int[]{a, b};
    }

    @Test
    public void test1() {
        assertThat(solution1(
                2, new String[]{"hello", "one", "even", "never", "now", "world", "draw" }))
                .isEqualTo(new int[]{1, 3});

        assertThat(solution1(
                3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" }))
                .isEqualTo(new int[]{3, 3});

        assertThat(solution1(
                5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive" }))
                .isEqualTo(new int[]{0, 0});

    }

    // 문제2
    public int solution2(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }

    @Test
    public void test2() {
        assertThat(solution2(new String[][] {
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}})).isEqualTo(5);

        assertThat(solution2(new String[][] {
                {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}})).isEqualTo(3);
    }
}
