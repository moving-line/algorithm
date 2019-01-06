package level1;

/*
문제 설명
길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

제한 조건
n은 길이 10,000이하인 자연수입니다.
 */

public class 수박수박수박수박수박수 {
    public String solution(int n) {
        StringBuilder str = new StringBuilder();
        for(int i=1; i<=n; i++) {
            str.append((i%2 != 0) ? "수" : "박");
        }

        return str.toString();
    }
}
