package domain.test;

public class ttest {
    public static void main(String[] args) {
        int[] arr = {3,2,4,6,8,7};
        quickSort(arr, 0, arr.length - 1);
        for (int i: arr) {
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left > right)
            return;
        int base = arr[left];
        int i = left;
        int j = right;
        while (i < j){
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
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
