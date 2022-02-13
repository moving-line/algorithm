package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // 첫 풀이
        int[] answer = new int[nums1.length];
        int a = 0, b = 0;

        for (int i = 0; i < nums1.length; i++) {
            if ((m - a > 0 || nums1[a] != 0)
                    && nums1[a] < ((n - b > 0) ? nums2[b] : Integer.MAX_VALUE)
            ) { // a가 작다
                answer[i] = nums1[a++];
            } else { // b가 작다
                answer[i] = nums2[b++];
            }
        }

        System.arraycopy(answer, 0, nums1, 0, nums1.length);

        // 추가배열 없이. 빈곳을 역으로 큰놈부터 넣는다
//        int a = m - 1;
//        int b = n - 1;
//        int pos = m + n - 1;
//
//        while (a >= 0 && b >= 0) {
//            nums1[pos--] = (nums1[a] > nums2[b]) ? nums1[a--] : nums2[b--];
//        }
//
//        // 윗줄 끝난이유 : a나 b 인덱스가 끝나서..
//        // a가 끝났다면 남은 b만 넣으면 되고, b가 끝났다면 a쪽은 이미 정렬되어있으므로 넣을필요 X
//        while (b >= 0) {
//            nums1[pos--] = nums2[b--];
//        }
    }

    @Test
    void test() {
        // given
        int[] array1 = {1, 2, 3, 0, 0, 0};
        // when
        merge(array1, 3, new int[]{2, 5, 6}, 3);
        //then
        assertThat(array1).isEqualTo(new int[]{1, 2, 2, 3, 5, 6});

        // given
        int[] array2 = {1};
        // when
        merge(array2, 1, new int[]{}, 0);
        //then
        assertThat(array2).isEqualTo(new int[]{1});

        // given
        int[] array3 = {1};
        // when
        merge(array3, 0, new int[]{1}, 1);
        //then
        assertThat(array3).isEqualTo(new int[]{1});

        // given
        int[] array4 = {2, 0};
        // when
        merge(array4, 1, new int[]{1}, 1);
        //then
        assertThat(array4).isEqualTo(new int[]{1, 2});

        // given
        int[] array5 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        // when
        merge(array5, 6, new int[]{1, 2, 2}, 3);
        //then
        assertThat(array5).isEqualTo(new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 3});
    }
}
