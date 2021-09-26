package base.sort;

import java.util.Random;

/**
 * 快速排序
 */
class QuickSort {
    void run(int[] arr,int low,int high){
        int i=low,j=high-1;
        if(i<j){
            int temp=arr[low];
            while(i<j){
                while(i<j&&arr[j]>=temp) j--;
                if(i<j) arr[i++]=arr[j];
                while (i<j&&arr[i]<temp) i++;
                if(i<j) arr[j--]=arr[i];
            }
            arr[i]=temp;
            run(arr,low,i-1);
            run(arr,i+1,high);
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
        new QuickSort().run(arr,0,arr.length);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
