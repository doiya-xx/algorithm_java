package utils;

import java.util.Arrays;
import java.util.Random;

public class SortUtils {
    private static final int n = 10;
    private static int[] arr = new int[n];

    public static void main(String[] args) {
        generateArr();

        // System.out.println("list = " + Arrays.toString(arr));
        // long start = System.nanoTime();
        // selection_sort(arr, arr.length);
        // long end = System.nanoTime();
        // System.out.println("list = " + Arrays.toString(arr));
        // System.out.println("耗时 = " + ((double)(end - start))/1000000d + "毫秒");

    }

    private static void generateArr() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(46);
        }
    }

    private static void test_f() {
        System.out.println("list = " + Arrays.toString(arr));
        long start = System.nanoTime();
        selection_sort(arr, arr.length);
        long end = System.nanoTime();
        System.out.println("list = " + Arrays.toString(arr));
        System.out.println("耗时 = " + ((double)(end - start))/1000000d + "毫秒");
    }

    /**
     * <h1>选择排序</h1>
     * <p>arr代码下标从 1 开始索引</p>
     *
     * @param arr
     * @param n
     */
    public static void selection_sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int cur_min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[cur_min]) {
                    cur_min = j;
                }
            }
            if (cur_min == i) {
                continue;
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[cur_min];
            arr[cur_min] = temp;
        }
    }
}
