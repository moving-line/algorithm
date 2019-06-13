/*
문제
스타워즈에 등장하는 로봇인 C3PO는 요즘 콜센터에 근무하고 있다. 콜센터에 앉아있는 C3PO를 그리는 프로그램을 작성하시오.

     /~\
    ( oo|
    _\=/_
   /  _  \
  //|/.\|\\
 ||  \ /  ||
============
|          |
|          |
|          |

출력
예제 출력처럼 콜센터에 앉아있는 C3PO를 출력한다. 마지막 세 줄의 두 '|' 사이에는 공백이 10개 있다.
 */

package baekjoon.그외;

import java.io.*;

public class Q5339 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%9s", "/~\\\n"))
        .append(String.format("%10s", "( oo|\n"))
        .append(String.format("%10s", "_\\=/_\n"))
        .append(String.format("%11s", "/  _  \\\n"))
        .append(String.format("%12s", "//|/.\\|\\\\\n"))
        .append(String.format("%13s", "||  \\ /  ||\n"))
        .append(String.format("%13s", "============\n"))
        .append("|").append(String.format("%12s", "|\n"))
        .append("|").append(String.format("%12s", "|\n"))
        .append("|").append(String.format("%12s", "|\n"));

        System.out.println(sb.toString());
    }
}
