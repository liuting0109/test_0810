package domain.test;

import static domain.test.ttest.swap;

public class sortMethod {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 0, 4, 2};
        //bubbleSort(arr);
       // selectSort(arr);
        mergeSort(arr, 0, arr.length - 1);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }

    //归并
    private static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high)/2;
        if (low < high){
            mergeSort(arr, low, mid);// 左边
            mergeSort(arr, mid + 1, high);// 右边

            merge(arr, low, mid, high);// 左右归并
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j= mid + 1;// 右指针
        int k = 0;
        while (i <= mid && j <= high){// 把较小的数先移到新数组中
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid){// 把左边剩余的数移入数组
            temp[k++] = arr[i++];
        }

        while (j <= high){// 把右边边剩余的数移入数组
            temp[k++] = arr[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int m = 0; m < temp.length; m++) {
            arr[low + m] = temp[m];
        }

    }

    //选择排序 每次固定一个数后后面所有的数进行比较
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {//j < arr.length - 1
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    //冒泡排序
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
