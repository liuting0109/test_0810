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
    /*
    非叶子节点的下摆哦 = 节点数/2 - 1；
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length || k== 0)
            return new ArrayList<>();

        int[] arr = new int[k];//用数组去模拟k个节点的堆结构
        for (int i = 0; i < k; i++) {//初始化堆中元素
            arr[i] = input[i];
        }
        //初始化堆中元素
        //System.arraycopy(input,0,a,0,k);//可以代替上面数组拷贝过程
        //维护成大顶堆
        //index 要维护的堆节点下标
        for (int index = k/2 - 1; index >=0 ; index--) {
            buildHeap(index, arr, k);
        }
        //去遍历剩下的len - k个节点
        for (int i = k; i < input.length ; i ++){
            if (input[i] < arr[0]){
                arr[0] = input[i];
                buildHeap(0, arr, k);
            }
        }
        //将大顶堆中的元素进行升序
        for (int i = arr.length - 1; i > 0; i --){
            int temp = arr[i];//第一步交换
            arr[i] = arr[0];
            arr[0] = temp;
            buildHeap(0, arr, i);//第二步固定，通过控制堆的节点个数
        }
        for (int i : arr){
            res.add(i);
        }
        return res;
    }

    /**
     *初始化堆，维护每一个节点位置的函数
     * @param index 维护当前堆的下标
     * @param arr 数组->堆
     * @param len 堆的节点个数
     */
    private static void buildHeap(int index, int[] arr, int len) {
          int temp = arr[index];//先保存当前位置的值
          for (int k = index * 2 + 1; k < len; k = k * 2 + 1){
              if (( k + 1) < len && arr[k + 1] > arr[k]){
                  k ++; //取出当前位置的左右孩子节点值最大的节点
              }
              if (arr[k] > temp){
                  arr[index] = arr[k];
                  index = k;//更新index的值， index表示temp数字最终在堆中的位置
                  //当 k = k * 2 + 1执行后，index和k想防御父节点和子节点的关系
              }else {
                  break;//因为是从下往上维护的，所以没有往下维护的必要
              }
          }
          arr[index] = temp;//更新index所在位置
    }

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

    //堆排序算法
    public static void HeapSort(int []arr){
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i > 0; i --){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j --){
            swap(arr, 0 , j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1){//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[ k + 1]){//如果左子结点小于右子结点，k指向右子结点
                k ++;
            }
            if (arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
