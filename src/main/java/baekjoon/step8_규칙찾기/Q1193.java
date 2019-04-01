/*
무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

1/1	1/2	1/3	1/4	1/5	…
2/1	2/2	2/3	2/4	…	…
3/1	3/2	3/3	…	…	…
4/1	4/2	…	…	…	…
5/1	…	…	…	…	…
…	…	…	…	…	…

이와 같이 나열된 분수들을 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> … 과 같은 지그재그 순서로
차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

출력
첫째 줄에 분수를 출력한다.
 */

package baekjoon.step8_규칙찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        while(X < 1 || X > 10000000) X = Integer.parseInt(br.readLine());

        int totalCount = 0;
        int i = 0;

        while(totalCount < X) totalCount += ++i;

        int top = i - (totalCount - X);
        int bottom = 1 + (totalCount - X);

        StringBuilder sb = new StringBuilder();

        System.out.println((i % 2 == 0) ? sb.append(top).append("/").append(bottom).toString() :
                        sb.append(bottom).append("/").append(top).toString());
    }
}
