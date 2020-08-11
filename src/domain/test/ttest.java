package domain.test;

public class ttest {
    public static void main(String[] args) {
        int[] arr = {3,2,4,6,8,7};
        quickSort(arr, 0, arr.length - 1);
        //sort(arr);
        for (int i: arr) {
            System.out.print(i+" ");
        }

        System.out.println("++++++++++++++++++++++++");

        int[] arr1 = {1,2,3,4,6};
        int res = findMissNum(arr1);
        System.out.println(res);
    }

    //1-n个数只有n-1个数找出缺失的那个数
    public static int findMissNum(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        for (int i = 0; i < arr.length + 1; i++) {
            res^= (i + 1);//(i+1), not i
        }
        return res;
    }

    //归并
    public static void sort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr, 0 ,arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left <right){
            int mid = (left + right) /2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid){
            temp[t++] = arr[i++];
        }
        while (j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right){
            arr[left++] =temp[t++];
        }

    }

    //快排
    private static void quickSort(int[] arr, int left, int right) {
        if (left > right)
            return;
        int base = arr[left];
        int i = left;
        int j = right;


        while (i < j) {
            while (arr[j] >= base && i < j){
                j--;
            }
            while (arr[i] <= base && i < j){
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        quickSort(arr, left ,i -1);
        quickSort(arr, i+1, right);
    }
    public static void swap(int[] arr, int i , int j){
        /*int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;*/

        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
