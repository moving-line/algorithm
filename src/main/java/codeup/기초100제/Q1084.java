package codeup.기초100제;

import java.io.*;

public class Q1084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int g = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < g; j++) {
                for (int k = 0; k < b; k++) {
                    bw.write(i + " " + j + " " + k + "\n");
                }
            }
        }
        bw.write(r * g * b + "");
        bw.flush();
        bw.close();
    }
}
