/*
문제
4개의 기호 ‘(’, ‘)’, ‘[’, ‘]’를 이용해서 만들어지는 괄호열 중에서 올바른 괄호열이란 다음과 같이 정의된다.

한 쌍의 괄호로만 이루어진 ‘()’와 ‘[]’는 올바른 괄호열이다.
만일 X가 올바른 괄호열이면 ‘(X)’이나 ‘[X]’도 모두 올바른 괄호열이 된다.
X와 Y 모두 올바른 괄호열이라면 이들을 결합한 XY도 올바른 괄호열이 된다.
예를 들어 ‘(()[[]])’나 ‘(())[][]’ 는 올바른 괄호열이지만 ‘([)]’ 나 ‘(()()[]’ 은 모두 올바른 괄호열이 아니다.
우리는 어떤 올바른 괄호열 X에 대하여 그 괄호열의 값(괄호값)을 아래와 같이 정의하고 값(X)로 표시한다.

‘()’ 인 괄호열의 값은 2이다.
‘[]’ 인 괄호열의 값은 3이다.
‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
예를 들어 ‘(()[[]])([])’ 의 괄호값을 구해보자.
‘()[[]]’ 의 괄호값이 2 + 3×3=11 이므로  ‘(()[[ ]])’의 괄호값은 2×11=22 이다.
그리고  ‘([])’의 값은 2×3=6 이므로 전체 괄호열의 값은 22 + 6 = 28 이다.

여러분이 풀어야 할 문제는 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력하는 것이다.

입력
첫째 줄에 괄호열을 나타내는 문자열(스트링)이 주어진다. 단 그 길이는 1 이상, 30 이하이다.

출력
첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다.
 */

package baekjoon.step11_스택사용하기;

import java.io.*;
import java.util.Stack;

public class Q2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            // (나 [가 주어지면 일단 스택에 넣고본다.
            if (arr[i].equals("(") || arr[i].equals("[")) stack.push(arr[i]);

            // )나 ]가 주어진 케이스를 확인한다.
            else {
                // 스택이 비었다면 추가적인 )]이 공급된것. 잘못된 문자열이므로 break;
                if (stack.isEmpty()) break;

                // )가 주어졌을 때
                if (arr[i].equals(")")) {
                    // 그전이 [라면 잘못된 문자열. break;
                    if(stack.peek().equals("[")) break;

                    // 그전이 (라면 이녀석을 pop하고 2를 넣어준다.
                    if(stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else { // 그전이 숫자라면 그 전녀석에 x2를 해주자.
                        int num = Integer.parseInt(stack.pop());

                        stack.push(String.valueOf(num * 2));
                    }

                }
                // ]가 주어졌을 때
                else {
                    // 그 전이 (라면 잘못된 문자열. break;
                    if(stack.peek().equals("(")) break;

                    // 그전이 [라면 이녀석을 pop하고 3을 넣어준다.
                    if(stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else { // 그전이 숫자라면 그 전녀석에 x3를 해주자.
                        int num = Integer.parseInt(stack.pop());

                        stack.push(String.valueOf(num * 3));
                    }
                }
            }
        }

        // 해결해야할 문제점 : 그전이 숫자이지만 거대한 괄호가 닫혀 내부 숫자 덧셈 후 곱해야 할 경우...

        answer = Integer.parseInt(stack.pop());

        if (!stack.isEmpty()) answer = 0;

        System.out.println(answer);
    }
}
