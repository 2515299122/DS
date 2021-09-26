package base.sort;

import java.util.Random;

class BinaryInsertSort {
    void run(int[] arr) {
        int item, low, high, mid;
        for (int i = 1; i < arr.length; i++) {
            item = arr[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (high - low) / 2 + low;
                if (arr[mid] > item)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (int j = i - 1; j >= high + 1; j--) {
                arr[j + 1] = arr[j];
            }
            arr[high + 1] = item;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
        new BinaryInsertSort().run(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
