package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.util.Arrays;

public class 큐구현 {
    private int[] data;
    private int begin, end;

    public 큐구현() {
        this.data = new int[10000];
    }

    public void push(int num) {
        data[end++] = num;
    }

    public int pop() {
        if(empty()) {
            return -1;
        }

        return data[begin++];
    }

    public boolean empty() {
        return begin == end;
    }

    public int size() {
        return end - begin;
    }

    public int front() {
        return data[begin];
    }

    public int back() {
        return data[end - 1];
    }
}
