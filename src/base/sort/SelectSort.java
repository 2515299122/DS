package base.sort;

import java.util.Random;

/**
 * 直接选择排序
 */
public class SelectSort {
    void run(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp =arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(50);
        }
        new SelectSort().run(arr);
        for (int item : arr) {
            System.out.print(item+" ");
        }
    }
}
