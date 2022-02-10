/*
문제 설명
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
 */

package programmers.level3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 베스트앨범 {
//     >>>>>>>>>>>> 첫번째 풀이 <<<<<<<<<<<<<
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Map<Integer, List<Integer>>> map = new HashMap<>();
        Map<String, Integer> sortMap = new TreeMap<>();

        for (int i = 0; i < genres.length; i++) {
            if(!sortMap.containsKey(genres[i])) sortMap.put(genres[i], plays[i]);
            else sortMap.put(genres[i], sortMap.get(genres[i]) + plays[i]);
        }

        for (int i = 0; i < genres.length; i++) {
            if(!map.containsKey(genres[i])) {
                Map<Integer, List<Integer>> subMap = new TreeMap<>();
                List<Integer> list = new ArrayList<>();
                list.add(i);
                subMap.put(plays[i], list);
                map.put(genres[i], subMap);
            } else {
                TreeMap subMap = (TreeMap) map.get(genres[i]);
                List<Integer> list;

                if (subMap.get(plays[i]) == null) list = new ArrayList<>();
                else list = (List<Integer>) subMap.get(plays[i]);

                list.add(i);
                subMap.put(plays[i], list);
                map.put(genres[i], subMap);
            }
        }

        List<Integer> answerList = new ArrayList<>();
        Iterator it = sortByValue(sortMap).iterator();

        while(it.hasNext()) {
            String temp = (String) it.next();

            for (Map.Entry<String, Map<Integer, List<Integer>>> entry : map.entrySet()) {
                if (entry.getKey().equals(temp)) {
                    TreeMap subMap = (TreeMap) entry.getValue();
                    List<Integer> list = (List<Integer>) subMap.lastEntry().getValue();
                    Collections.sort(list);
                    answerList.add((list.get(0)));

                    if (list.size() > 1) answerList.add(list.get(1));
                    else {
                        if (subMap.size() > 1) {
                            list = (List<Integer>) subMap.lowerEntry(subMap.lastKey()).getValue();
                            Collections.sort(list);
                            answerList.add(list.get(0));
                        }
                    }
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) answer[i] = answerList.get(i);

        return answer;
    }

    public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list, (Comparator) (o1, o2) -> {
            Object v1 = map.get(o1);
            Object v2 = map.get(o2);
            return ((Comparable) v2).compareTo(v1);
        });

        return list;
    }

//     >>>>>>>>>>>> 두번째 풀이 <<<<<<<<<<<<<
    class Music implements Comparable<Music> {
        private int played;
        private int index;

        public Music(int played, int index) {
            this.played = played;
            this.index = index;
        }
        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Music other) {
            if (this.played > other.played) return -1;
            else if (this.played < other.played) return 1;
            else {
                if (this.index < other.index) return -1;
                return 1;
            }
        }
    }

    private List<Integer> answerList;

    public int[] solution2(String[] genres, int[] plays) {
        answerList = new ArrayList<>();

        Map<String, List<Music>> map = generateMap(genres, plays);

        Map<Integer, String> sortMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, List<Music>> entry : map.entrySet()) {
            sortMap.put(sum(entry.getValue()), entry.getKey());
        }

        for (Map.Entry<Integer, String> entry : sortMap.entrySet()) {
            List<Music> list = map.get(entry.getValue());
            Collections.sort(list);
            addAnswer(list);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = answerList.get(i);

        return answer;
    }

    private Map<String, List<Music>> generateMap(String[] genres, int[] plays) {
        Map<String, List<Music>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if(map.get(genres[i]) != null) {
                List<Music> list = map.get(genres[i]);
                list.add(new Music(plays[i], i));
                map.put(genres[i], list);
            } else {
                List<Music> list = new ArrayList<>(Arrays.asList(new Music(plays[i], i)));
                map.put(genres[i], list);
            }
        }

        return map;
    }

    private void addAnswer(List<Music> list) {
        answerList.add(list.get(0).getIndex());
        if(list.size() > 1) answerList.add(list.get(1).getIndex());
    }

    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) answer += music.played;
        return answer;
    }

    @Test
    public void test() {
        assertThat(solution2(new String[] {"classic", "pop", "classic", "classic", "pop"},
                new int[] {500, 600, 150, 800, 2500})).isEqualTo(new int[] {4, 1, 3, 0});

        assertThat(solution2(new String[] {"classic", "pop", "classic", "classic", "pop"},
                new int[] {800, 600, 800, 800, 2500})).isEqualTo(new int[] {4, 1, 0, 2});

        assertThat(solution2(new String[] {"classic", "pop", "classic", "classic", "pop"},
                new int[] {800, 600, 600, 800, 2500})).isEqualTo(new int[] {4, 1, 0, 3});

        assertThat(solution2(new String[] {"classic", "classic", "pop"},
                new int[] {800, 800, 2500})).isEqualTo(new int[] {2, 0, 1});
    }
}
