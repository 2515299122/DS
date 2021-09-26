package base.sort;

import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSort {
    void run(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                return;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(50);
        }
        new BubbleSort().run(arr);
        for (int item : arr) {
            System.out.print(item+" ");
        }
    }
}
