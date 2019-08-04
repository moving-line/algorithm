/*
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000)
좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */

package baekjoon.step11_정렬;

import java.util.*;

public class Q11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            coordinates.add(new Coordinate(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(coordinates);
        for (Coordinate c : coordinates) {
            System.out.printf("%d %d \n", c.getX(), c.getY());
        }

//         커스텀 객체 만들지않는 풀이
//        int[][] arr = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            arr[i][0] = sc.nextInt();
//            arr[i][1] = sc.nextInt();
//        }
//
//        Arrays.sort(arr, (o1, o2) -> {
//            if (o1[0] == o2[0]) {
//                return Integer.compare(o1[1], o2[1]);
//            }
//            return Integer.compare(o1[0], o2[0]);
//        });
//
//        for (int[] i : arr) {
//            System.out.printf("%d %d \n", i[0], i[1]);
//        }
    }
}

class Coordinate implements Comparable {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Object o) {
        Coordinate p = (Coordinate) o;
        if (this.x > p.x) {
            return 1;
        } else if (this.x < p.x) {
            return -1;
        } else {
            if (this.y > p.y) {
                return 1;
            } else if (this.y < p.y) {
                return -1;
            }
            return 0;
        }
    }
}
