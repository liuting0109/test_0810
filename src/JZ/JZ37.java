package JZ;

import java.util.Arrays;

//统计一个数字在升序数组中出现的次数。
public class JZ37 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK2(arr, 3));
    }
    public static int GetNumberOfK2(int [] array , int k) {
        int num = 0;
        int first = first(array, 0, array.length - 1, k);

        int last = last(array,0 ,array.length - 1, k);
        if (last != -1 && first != -1){
            num = last - first + 1;
        }
        System.out.println(first + " " + last);
        return num;

    }
    public static int first(int[] arr, int left, int right, int k){
        if (left > right)
            return -1;
        int midIndex = (left + right) /2;
        int midData = arr[midIndex];
        if (midData == k){
            //找出第一个位置k的终止条件：要么middleIndex=0;要么middleIndex > 0但是middleIndex-1处的位置不等于k
            if ((midIndex >0 && arr[midIndex - 1] != k || midIndex == 0))
                return midIndex;
            else {
                right = midIndex - 1;
            }
        }else if (midData > k){
            right = midIndex - 1;
        }else {
            left = midIndex + 1;
        }
        return first(arr, left, right, k);
    }
    public static int last(int[] arr, int left, int right, int k){
        if (left > right)
            return -1;
        int midIndex = (left + right) /2;
        int midData = arr[midIndex];
        if (midData == k ){
            //找出第一个位置k的终止条件：要么middleIndex=0;要么middleIndex > 0但是middleIndex-1处的位置不等于k
            if ((midIndex < arr.length - 1 && arr[midIndex + 1] != k || midIndex == arr.length - 1))
                return midIndex;
            else {
                left = midIndex + 1;
            }
        }else if (midData > k){
            right = midIndex - 1;
        }else {
            left = midIndex + 1;
        }
        return last(arr, left, right, k);
    }

    public int GetNumberOfK(int [] array , int k) {
        //Arrays.binarySearch()
        int left = 0;
        int right = array.length - 1;
        int res = 0;
        int mid = 0;
        while (left <= right){
            mid = (left + right)/2;
            if (array[mid] < k){
                left = mid + 1;//left = mid;//写的不对
            }else if (array[mid] > k){
                right = mid - 1;//right = mid;//写的不对
            }else {
                break;
            }
        }
        for (int i = mid; i < array.length ; i++) {
            if (array[i] == k){
                res++;
            }else
                break;
        }
        for (int i = mid - 1; i >= 0 ; i--) {
            if (array[i] == k){
                res++;
            }else
                break;
        }
        return res;
    }
}
