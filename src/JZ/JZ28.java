package JZ;

import java.util.Arrays;

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class JZ28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int key = array[array.length/2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (key == array[i]){
                count++;
            }
        }
        return count > array.length/2 ? key: 0;
    }
    public int MoreThanHalfNum_Solution1(int [] array) {
        int res = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {// 更新result的值为当前元素，并置次数为1
                res = array[i];
                count =1;
            }else if (array[i] == res){
                count++;//因为是超过二分之一的数，所以必然会有两个相邻的数字
            }else {
                count--;
            }
        }
        // 判断result是否符合条件，即出现次数大于数组长度的一半
        //强推方法
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res)
                count++;
        }
        return count > array.length/2 ? res: 0;
    }
}
