package baekjoon.codePlus.기초2.ch1_브루트포스;

import java.util.Scanner;

public class Q1476 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int year = 1;
        JunGyuDate date = new JunGyuDate();
        while (!date.check(E, S, M)) {
            date.addYear();
            year++;
        }

        System.out.println(year);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int year = 1, e = 1, s = 1, m = 1;
        while (!(e == E && s == S && m == M)) {
            year++;
            e = (e == 16) ? 1 : e + 1;
            s = (s == 29) ? 1 : s + 1;
            m = (m == 20) ? 1 : m + 1;
        }
        System.out.println(year);
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int e = 1, s = 1, m = 1;
        for (int i = 1; true; i++) {
            if (e == E && s == S && m == M) {
                System.out.println(i);
                break;
            }
            e = (e == 16) ? 1 : e + 1;
            s = (s == 29) ? 1 : s + 1;
            m = (m == 20) ? 1 : m + 1;
        }
    }
}

class JunGyuDate {
    private int e;
    private int s;
    private int m;

    public JunGyuDate() {
        this.e = 1;
        this.s = 1;
        this.m = 1;
    }

    public void addYear() {
        e = (e + 1 > 15) ? 1 : e + 1;
        s = (s + 1 > 28) ? 1 : s + 1;
        m = (m + 1 > 19) ? 1 : m + 1;
    }

    public boolean check(int E, int S, int M) {
        return (this.e == E) && (this.s == S) && (this.m == M);
    }
}
