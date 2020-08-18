package JZ;

import java.util.Arrays;

//统计一个数字在升序数组中出现的次数。
public class JZ37 {
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
