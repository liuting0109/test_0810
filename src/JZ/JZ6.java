package JZ;

public class JZ6 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int left = 0, right = array.length - 1;
        while (left < right){
            if (array[left] < array[right])
                return array[left];//终止循环条件

            int mid = (left + right)/2;
            if (array[mid] > array[left]){
                left = mid + 1;
            }else if (array[mid] < array[right]){
                right = mid;
            }else left++;
        }
       // return 0;
        return array[left];
    }
}
