package baekjoon.codePlus.기초1.ch2_자료구조1;

public class 스택구현 {
    private int[] data;
    private int size;

    public 스택구현() {
        data = new int[10000];
    }

    public void push(int num) {
        data[size] = num;
        size++;
    }

    public int pop() {
        if(empty()) {
            return  -1;
        } else {
            size--;
            return data[size];
        }
    }

    public boolean empty() {
        return size == 0;
    }

    public int top() {
        if(empty()) {
            return -1;
        } else {
            return data[size - 1];
        }
    }
}
