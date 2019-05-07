package algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 3, 1, 5, 2, 1, 1, 4, 6};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot, right);
        }
    }

    public static int partition(int arr[], int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) left++; // 피봇보다 작으면 left 인덱스 증가. 큰 놈이면 패스
            while (arr[right] > pivot) right--; // 피봇보다 크면 right 인덱스 감소. 작은놈이면 패스
            if (left <= right) { // 인덱스가 역전되지 않은 상태라면 스왚
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
