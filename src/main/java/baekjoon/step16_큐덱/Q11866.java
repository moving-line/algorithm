/*
문제
조세퍼스 문제는 다음과 같다.
1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-조세퍼스 순열이라고 한다.
예를 들어 (7, 3)-조세퍼스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-조세퍼스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
1 4
출력
예제와 같이 조세퍼스 순열을 출력한다.
 */

package baekjoon.step16_큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] arr = input.split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) q.add(i);

        List<String> answer = new ArrayList<>();

        while(!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) q.add(q.remove());
            answer.add(String.valueOf(q.remove()));
        }

        StringJoiner sj = new StringJoiner(", " ,"<", ">");
        for (int i = 0; i < N; i++) sj.add(answer.get(i));

        System.out.println(sj.toString());

//         스트림활용
//        System.out.println(answer.stream().collect(Collectors.joining(", ", "<", ">")));
    }
}
