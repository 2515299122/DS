package base.search;

public class ArraySearch {
    public int search(int[] arr, int e) {
        for (int i = 0; i < arr.length; i++) {
            if (e == arr[i])
                return i;
        }
        return -1;
    }

    public int binarySearch(int[] arr, int e) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid]==e){
                return mid;
            }else if (arr[mid]<e){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr=new int[10];
        ArraySearch arraySearch = new ArraySearch();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1+i*2;
        }
        System.out.println(arraySearch.search(arr,7));
        System.out.println(arraySearch.search(arr,8));
        System.out.println(arraySearch.binarySearch(arr,7));
        System.out.println(arraySearch.binarySearch(arr,8));
    }
}
