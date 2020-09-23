package LeetCode;

import java.util.*;

/**
 * @Author LT
 * @Date 2020/9/11 12:31
 * @Version 1.0
 * @Description
 */
public class l46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
        //perm(nums, 0, 2);
    }
    //全排列递归
    public static void perm(int[] arr, int start, int end) {
        if (start == end){
            System.out.println(Arrays.toString(arr));
        }else {
            for (int i = start; i <= end; i++) {
            //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swap(arr, start, i);
                perm(arr, start + 1,end);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swap(arr, start,i);
            }
        }
    }
    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //回溯
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        //List<List<Integer>> res = new ArrayList<>();
        if (nums == null ||nums.length == 0)
            return res;
        permute(nums, 0,nums.length -1);
        return res;
    }

    public static void permute(int[] nums, int start, int end){
        if (start == end){
            List<Integer> list = new ArrayList<>();
            for (int i: nums){
                list.add(i);
            }
            res.add(list);
        }else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }
}
