package JZ;

public class JZ6 {
    /**
     把一个数组最开始的若干个元素搬到数组的末尾，
     我们称之为数组的旋转。
     输入一个非递减排序的数组的一个旋转，
     输出旋转数组的最小元素。
     例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
     该数组的最小值为1。
     NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int left = 0, right = array.length - 1;
        while (left < right){
            if (array[left] < array[right])
                return array[left];//终止循环条件

            int mid = (left + right)/2;
            if (array[mid] > array[left]){
                left = mid + 1;//#左边有序取另一半
            }else if (array[mid] < array[right]){
                right = mid;// 右边有序右边取最小.如果是mid-1，则可能会错过最小值，因为找的就是最小值
            }else left++; // 前面两个相等的时候，left进一继续 巧妙避免了offer书上说的坑点（1 0 1 1 1）
        }
       // return 0;
        return array[left];
    }
}
