/*
문제
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
입력은 가입한 순서로 주어진다.

출력
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
 */

package baekjoon.step9_수정렬하기;

import java.util.*;

public class Q10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] userInput = sc.nextLine().split(" ");
            users.add(new User(Integer.parseInt(userInput[0]), userInput[1], i));
        }

        Collections.sort(users);

        for (User user : users) {
            System.out.printf("%d %s\n", user.getAge(), user.getName());
        }

//         노객체
//        String[][] arr = new String[N][2];
//        for (int i = 0; i < N; i++) {
//            arr[i][0] = sc.next();
//            arr[i][1] = sc.next();
//        }
//
//        Arrays.sort(arr, Comparator.comparingInt(o -> Integer.parseInt(o[0])));
//
//        for (int i = 0; i < N; i++) {
//            System.out.printf("%s %s\n", arr[i][0], arr[i][1]);
//        }
    }
}

class User implements Comparable {
    int age;
    String name;
    int order;

    public User(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public int compareTo(Object o) {
        User u = (User) o;
        if (this.age > u.getAge()) {
            return 1;
        } else if (this.age < u.getAge()) {
            return -1;
        } else {
            if (this.order > u.order) {
                return 1;
            } else if (this.order < u.order) {
                return -1;
            }
        }
        return 0;
    }
}
