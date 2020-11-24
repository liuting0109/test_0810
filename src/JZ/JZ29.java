package JZ;

import java.util.*;
//输入n个整数，找出其中最小的K个数。
// 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
public class JZ29 {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        /*quickSort1(arr, 0, arr.length - 1);
        for (int i: arr){
            System.out.print(i+" ");
        }*/
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, 4);
        for (int i: res){
            System.out.print(i+" ");
        };
    }
    //优先队列
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k){
        if (input == null || k > input.length || k== 0)
            return new ArrayList<>();
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int cur: input){
            if (maxHeap.size() < k){
                maxHeap.add(cur);
            }else {
                if (cur < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(cur);
                }
            }
        }
        return new ArrayList<>(maxHeap);
    }
    //堆排
    /*public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k){
        //ArrayList<Integer>
        if (k > input.length || k== 0)
            return new ArrayList<>();

        int[] a = new int[k];//用数组去模拟k个节点的堆结构
        *//*for (int i = 0; i < k; i++) {
            a[i] = input[i];
        }*//*
        //初始化堆中元素
        System.arraycopy(input,0,a,0,k);//可以代替上面数组拷贝过程
        //维护成大顶堆
        for (int i = k/2 - 1; i >=0 ; i--) {

        }

    }*/

    //运行超时？？？？？？？？
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res= new ArrayList<>();//边界条件
        if (k > input.length|| input == null|| k<= 0)
            return res;
        int left = 0;
        int right = input.length - 1;
        quickSort1(input, left, right);
        /*int index = quickSort(input,0, input.length - 1);
        while (index != k - 1){
            if (index < k - 1){
                left = index + 1;
                index = quickSort(input, left, right);
            }else {
                right = index - 1;
                index = quickSort(input, left, right);
            }
        }*/
        for (int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }
    public static int quickSort(int[] arr, int left, int right){
        if (left >= right)
            return 0;
        int base = arr[left];
        int i = left, j = right;
        while (i < j){
            while (i < j && arr[j] >= base)
                j--;
            while (i < j && arr[i] <= base)
                i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        return i;
        /*quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);*/
    }

    //快排
    public static void quickSort1(int[] arr, int left, int right){
        if (left >= right)
            return;
        int base = arr[left];//左边基准数
        int i = left, j = right;//i指向最左边。 j指向最右边
        while (i < j){
            while (i < j && arr[j] >= base)
                j--;//j 从右往左检索比基准数小的，如果检索到，停下
            while (i < j && arr[i] <= base)
                i++;//i 从左往右检索比基准数大的，如果检索到，停下
            int temp = arr[i];//i ,j 都已停下 交换元素
            arr[i] = arr[j];
            arr[j] = temp;
        }
         /*
        如果上面while不成立， 则会跳出循环，往下执行。此时i ==j
        交换基准数和相遇位置的元素
         */
        arr[left] = arr[i];//相遇位置的元素赋值给基准数位置的元素
        arr[i] = base;//基准数赋值给相遇位置的元素

         /*
        基准数在这里归位了，左边的数字都比他小，右边都比他大
         */
        quickSort1(arr, left, i -1);
        quickSort1(arr, i + 1, right);
    }
}
