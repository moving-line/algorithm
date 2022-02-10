package programmers.school;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
//첫번째 풀이
//        Word[] words = new Word[strings.length];
//
//        for (int i = 0; i < strings.length; i++) {
//            words[i] = new Word(n, strings[i]);
//        }

//        Arrays.sort(words);
//
//        String[] answer = new String[strings.length];
//        for (int i = 0; i < words.length; i++) {
//            answer[i] = words[i].str;
//        }
//        return answer;

//두번째 풀이
//        Word[] words = Arrays.stream(strings)
//                .map(i -> new Word(n, i))
//                .toArray(Word[]::new);
//
//        return Arrays.stream(words)
//                .sorted()
//                .map(i -> i.str)
//                .toArray(String[]::new);

//세번째 풀이
        return Arrays.stream(strings)
                .map(i -> new Word(n, i))
                .sorted()
                .map(i -> i.str)
                .toArray(String[]::new);
    }

    class Word implements Comparable<Word> {
        int index;
        String str;

        public Word(int index, String str) {
            this.index = index;
            this.str = str;
        }

        @Override
        public int compareTo(Word o) {
            char c1 = this.str.charAt(index);
            char c2 = o.str.charAt(index);

            if (c1 > c2) {
                return 1;
            } else if (c1 < c2) {
                return -1;
            } else {
                return this.str.compareTo(o.str);
            }
        }

        @Override
        public String toString() {
            return "Word{" +
                    "index=" + index +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

    @Test
    public void test() {
        assertThat(solution(new String[]{"sun", "bed", "car"}, 1)).isEqualTo(new String[]{"car", "bed", "sun"});
        assertThat(solution(new String[]{"abce", "abcd", "cdx"}, 1)).isEqualTo(new String[]{"abcd", "abce", "cdx"});
    }
}
