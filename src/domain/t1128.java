package domain;

import java.util.PriorityQueue;

/**
 * @Author LT
 * @Date 2020/11/28 21:12
 * @Version 1.0
 * @Description
 */
public class t1128 {
    static int aaa = 10;
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");

        System.out.println(a == b);//t
        System.out.println(a == c);//f
        System.out.println(b == c);//f
        System.out.println(a.equals(b));//t
        System.out.println(aaa);
        aaa = 20;
        System.out.println(aaa);

        int[] arr = {1,2,3,4};
        for (int i : arr){
            System.out.println(i);
            break;
        }
    }
    public static void topM(int[] arr, int m){
        int temp;
        //大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(heap.poll());
        }
    }
    //堆排 https://www.cnblogs.com/lezon1995/p/11235329.html
    /*
    二叉树的最后一个非叶子节点，计算公式是：array.length / 2 - 1
    非叶子节点都是相邻的，这就是为什么buildMaxHeap方法中的i的步进方式是减1
    父节点的左子节点的计算公式是：2 * i + 1
    父节点的右子节点的计算公式是：2 * i + 2
    buildMaxHeap方法的length参数意义：因为构建大顶堆后，
    根节点就成了最大值，此时将根节点和数组尾元素交换，
    就能将最大值移动到数组末尾，那么第一大的值已经确定，
    现在需要确定第二大的值，那么就需要在剩下的元素当中再次构建大顶堆，
    所以就需要控制后续构建大顶堆时的数组长度，也就是length
     */
    /**
     * 构建大顶堆
     * @param arr 原始数组
     * @param len 需要构建的长度
     */
    public static void buildMaxHeap(int[] arr, int len){
        //从最后一个非叶子节点开始
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i , len);
        }
    }

    /**
     * 调整大顶堆
     * @param arr 调整数组
     * @param index 非叶子节点
     * @param len 需要调整的长度
     */
    private static void adjustHeap(int[] arr, int index, int len) {
        //获取当前非叶子节点的值
        int temp = arr[index];
        //依次遍历非叶子节点的左子节点
        for (int i = 2 * index + 1; i < len; i =2 * i + 1){
            //让i指向左右子节点较大的哪个
            if (i + 1 < len && arr[i] < arr[i + 1]){
                i++;
            }
            //如果子节点>父节点
            if (arr[i] > temp){
                //让当前非叶子节点的值等于子节点的值
                arr[index] = arr[i];
                index = i; //让当前非叶子节点的下标指向当前字节点的下标
            }else {
                break; //因为大顶堆是从下到上构建的，所以如果父节点是最大的那个的话就可以直接退出循环
            }
            arr[i] = temp;//让大的子节点等于之前非叶子节点的值
        }
    }

    public static int[] heapSort(int[] arr, int n){
        int size = n;
        //第一次构建大顶堆
        int len = arr.length;
        buildMaxHeap(arr, len);
        //此时顶端是数组中最大的节点，将顶端与数组末尾交换，然后在剩下的数组中再次构建大顶堆
        while (n > 0 && n <= len){
            int temp = arr[0];
            arr[0] = arr[len - 1];
            arr[len - 1] = temp;
            n--;
            len--;
            buildMaxHeap(arr, len);
        }
        int [] res = new int[size];
        System.arraycopy(arr, arr.length - size, res, 0, size);
        return res;
    }
}
