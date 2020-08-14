package domain.test;

import java.util.ArrayList;
import java.util.List;

/*class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}*/
class TreeNode {
    //左子节点
    private TreeNode leftNode;

    //右子节点
    private TreeNode rightNode;

    //节点值
    private Object value;

    /**
     * 添加节点(插入数据)
     */
    public void add(Object v){
        //如果当前节点没有值，就把值放到此节点上
        if (value == null)
            value = v;
        else {
            //如果当前节点有值，根据大小关系决定放在左子节点还是右子节点
            //新增的值比当前的值小或者相同
            if ((Integer)v - (Integer)value < 0){
                if (leftNode == null)
                    leftNode = new TreeNode();
                leftNode.add(v);
            }else {
                if (rightNode == null)
                    rightNode = new TreeNode();
                rightNode.add(v);
            }
        }
    }

    public List<Object> listValues(){
        List<Object> res = new ArrayList<>();
        //递归所有左节点
        if (leftNode != null){
            res.addAll(leftNode.listValues());
        }
        res.add(value);
        if (rightNode != null){
            res.addAll(rightNode.listValues());
        }
        return res;
    }

}
public class ttest {
    public static void main(String[] args) {
        int[] arr = {3,2,4,6,8,7};
        quickSort(arr, 0, arr.length - 1);
        //sort(arr);
        for (int i: arr) {
            System.out.print(i+" ");
        }

        System.out.println("++++++++++++++++++++++++");

        int[] arr1 = {1,2,3,4,6};
        int res = findMissNum(arr1);
        System.out.println(res);
        System.out.println("++++++++++++++++++++++++");

        int[] arr2 = {3,2,1,4,6,5};
        TreeNode res2 = new TreeNode();
        for (int n: arr2){
            res2.add(n);
        }
        System.out.println(res2.listValues());

    }
    //Java实现二叉树并利用遍历排序数组

    /*public static TreeNode sortedArrayToBST(int[] nums){
        if (nums == null ||nums.length ==0)
            return null;
        return solve(nums, 0 ,nums.length - 1);
    }

    private static TreeNode solve(int[] nums, int start, int end) {
        if (start <= end){
            int mid = start +(end - start)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = solve(nums,start, mid - 1);
            root.right = solve(nums, mid +1 ,end);
            return root;
        }
        return null;
    }*/


    //1-n个数只有n-1个数找出缺失的那个数
    public static int findMissNum(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        for (int i = 0; i < arr.length + 1; i++) {
            res^= (i + 1);//(i+1), not i
        }
        return res;
    }

    //归并
    public static void sort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr, 0 ,arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left <right){
            int mid = (left + right) /2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid){
            temp[t++] = arr[i++];
        }
        while (j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right){
            arr[left++] =temp[t++];
        }

    }

    //快排
    private static void quickSort(int[] arr, int left, int right) {
        if (left > right)
            return;
        int base = arr[left];
        int i = left;
        int j = right;


        while (i < j) {
            while (arr[j] >= base && i < j){
                j--;
            }
            while (arr[i] <= base && i < j){
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        quickSort(arr, left ,i -1);
        quickSort(arr, i+1, right);
    }
    public static void swap(int[] arr, int i , int j){
        /*int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;*/

        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
