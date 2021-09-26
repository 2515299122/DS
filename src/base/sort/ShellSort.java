package base.sort;

import java.util.Random;

public class ShellSort {
    void run(int[] arr) {
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i],j;
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
        new ShellSort().run(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
