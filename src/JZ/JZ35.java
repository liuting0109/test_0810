package JZ;

import java.util.*;
import java.util.jar.JarEntry;

public class JZ35 {
    private long sum = 0;
    public int InversePairs(int [] array) {//统计逆序对的个数
        sum = 0;//统计逆序对的个数
        int left = 0;
        int right = array.length - 1;
        divide(left ,right ,array);
        return (int)(sum % 1000000007);
    }

    private void divide(int left, int right, int[] array) {
        if (left != right){
            int mid = (left + right)>>1;//右移相当于除以2
            divide(left, mid, array);
            divide(mid + 1, right, array);
            merge(left, right, mid, array);
        }
    }

    private void merge(int left, int right, int mid, int[] array) {
        int i = left;//左区间的起点
        int j = mid+1;//右区间的起点
        int[] temp = new int[right - left +1];
        int index = 0;
        while (i <= mid && j <=right){
            if(array[i] > array [j]){
                temp[index++] = array[j++];
                sum += mid - i + 1;//核心
            }else {
                temp[index++] = array[i++];
            }
        }
        while (i <= mid){
            temp[index++] = array[i++];//左区间还有数字
        }
        while (j <= right){
            temp[index++] = array[j++];//右区间还有数字
        }

        index = 0;//把排序后的数组赋值给原数组
        for (int k = left; k <= right; k++){
            array[k] = temp[index++];
        }
    }
}
