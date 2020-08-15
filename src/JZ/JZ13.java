package JZ;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class JZ13 {
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,6,7};
        reOrderArray1(a);
        for (int i: a){
            System.out.print(i+" ");
        }
    }

    //类似冒泡算法，前偶后奇数就交换：
    public static void reOrderArray1(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j  > i; j--) {
                if (array[j - 1] %2 == 0 && array[j] %2 == 1){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }


    public static void reOrderArray(int [] array) {
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] %2 ==1)
                oddCount++;
        }
        int[] temp = array.clone();
        int j = 0;
        for (int i = 0; i < temp.length; i++) {//temp和array不要写反
            if (temp[i] %2 ==1){
                array[j++] = temp[i];
            }else
                array[oddCount++] = temp[i];
        }
    }

}
