package LeetCode;

import java.util.*;

/**
 * @Author LT
 * @Date 2020/9/11 12:31
 * @Version 1.0
 * @Description
 */
//全排列
public class L46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
        //perm(nums, 0, 2);
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
    //全排列递归
    public static void permute(int[] nums, int start, int end){
        if (start == end){
            //System.out.println(Arrays.toString(nums));
            List<Integer> list = new ArrayList<>();
            for (int i: nums){
                list.add(i);
            }
            res.add(list);
        }else {
            for (int i = start; i <= end; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swap(nums, start, i);
                permute(nums, start + 1, end);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swap(nums, start, i);
            }
        }
    }

    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //方法2
    public List<List<Integer>> permute2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0)return res;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0 ,path, used,res);
        return res;
    }

    //深度搜索
    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len){
            //res.add(path);
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth +1, path,used,res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}
