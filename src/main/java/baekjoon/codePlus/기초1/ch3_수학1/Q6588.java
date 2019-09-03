package baekjoon.codePlus.기초1.ch3_수학1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Q6588 {
    public static final int MAX = 1000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> prime = new ArrayList<>();
        boolean[] check = new boolean[MAX + 1];
        check[0] = check[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (check[i]) {
                continue;
            }
            prime.add(i);
            for (int j = i + i; j <= MAX; j += i) {
                check[j] = true;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;

            if (n == 0) {
                break;
            }

            for (int i = 1; i < prime.size(); i++) {
                int p = prime.get(i);
                if (!check[n - p]) {
                    bw.write(n + " = " + p + " + " + (n - p) + "\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                bw.write("Goldbach's conjecture is wrong\n");
            }
        }

        bw.flush();
        bw.close();
    }
}