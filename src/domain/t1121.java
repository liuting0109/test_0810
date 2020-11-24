package domain;



import java.util.*;

/**
 * @Author LT
 * @Date 2020/11/21 10:13
 * @Version 1.0
 * @Description
 */
public class t1121 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        //fun(arr);
        //fun1(1,10);
        //prime(1,100);
        //judgePrime(100);
        int[] nums = {1,1,1,2,2,3};
        ArrayList<Integer> res = new ArrayList<>();
        topKFrequent(nums, 2);
        System.out.println(res);
    }

    //基于快排  当划分到下标为（length-k）后，其后元素即为前K大的元素
    public static List<Integer> topKFrequent(int[] nums, int k){//有问题？？？怎么解决
        List<Integer> res = new ArrayList<>();
        //先用hashmap统计词频
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }

        int[] nums2 = new int[map.size()];
        int index = 0;
        for(Integer key: map.keySet()){
            nums2[index++] = map.get(key);
        }
        //对map中的词频提取前K
       /* // 方法一：快排
        findK(nums2, 0, nums2.length - 1, nums.length - k);
        //找到词频对应的数(方法一)
        for(int i=nums2.length-1;i>=nums2.length-k;i--) {
            //  map.keySet():返回set类型 map.values():collection类型
            for(Integer key: map.keySet()){
                if (map.get(key) == nums[i]){
                    if (res.size() == k)
                        return res;
                    res.add(key);
                    map.put(key, 0);//去重
                }
            }
        }*/
        //方法二：堆排
        int[] top = topK(nums2, k);
        for(int i=0;i<k;i++) {
            //  map.keySet():返回set类型 map.values():collection类型
            for (Integer key : map.keySet()) {
                if (map.get(key) == top[i]) {
                    if (res.size() == k) return res;
                    res.add(key);
//                    去重   map更新值：put方法覆盖原先数据
                    map.put(key, 0);
                }
            }
        }
            return res;
    }
    // 方法一：快排 找到index为k的划分 复杂度：O(n)
    private static void findK(int[] nums, int left, int right, int k) {
        int partion = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            if (nums[j] >= partion) {
                j--;
            }
            else {
                nums[i] = nums[j];
                nums[j] = partion;
                while (i < j){
                    if (nums[i] <= partion){
                        i++;
                    }else {
                        nums[j] = nums[i];
                        nums[i] = partion;
                        break;
                    }
                }
            }
        }
        if (i == k)return;
        if (i > k) findK(nums, left, i - 1, k);//左边递归
        if (i < k) findK(nums, i + 1, right, k);//右边递归
    }
    //方法二，基于堆排。前K大，维护最小堆；前K小，维护最大堆
    /*
    1.初始化一个最小堆
    2.输入新数据，若大于堆顶则替换堆顶，调整堆为最小堆（从最后一个父节点开始调整）
    3.遍历完数据，遍历完数据，堆中数据即为所求
     */

    //查找topK
    private static int[] topK(int[] nums, int k) {
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = nums[i];
        }
        //初始化堆
        buildHeap(top);
        //输入数据，更新堆
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > top[0]){
                top[0] = nums[i];
                adjust(top, k, 0);
            }
        }
        return top;
    }
    //堆排
    //调整堆 递归过程
    private static void adjust(int[] nums, int size, int index) {
        //调整规则：比较父节点和子节点(left,right)
        int left = 2*index + 1;
        int right = 2*index + 2;
        //index为调整前父节点
        int min = index;
        if (left < size && nums[left] < nums[min]) min = left;
        if (right < size && nums[right] < nums[min]) min = right;
        //交换位置
        if (min != index){
            int temp = nums[min];
            nums[min] = nums[index];
            nums[index] = temp;
            //递归调整堆
            adjust(nums, size, min);
        }
    }
    //建堆
    private static void buildHeap(int[] top) {
        int len = top.length;
        //从length/2-1开始调整
        for (int i = len/2 - 1; i >= 0; i--) {
            adjust(top, len,i);
        }
    }

    public static void judgePrime(int n){//正解
        StringBuffer str = new StringBuffer();
        for(int i = 1;i <= n;i++){
            int count = 0;
            for(int j = 1;j <= i;j++){
                if(i%j == 0){
                    count++;
                }
            }
            if(count == 2){//只能被1 和 自身整除的数为素数
                str.append(i + " ");
            }
        }
        System.out.print("范围内存在的素数有：" + str);
    }
    public static void prime(int n, int m){
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int j = 1;
        for (int i = n; i <= m; i++) {
            for (j = 2; j < n; j++) {
                if (i % j == 0)
                    break;
            }
            if (j >= i){
                res.add(i);
                count ++;
            }
        }
        System.out.println(count +"***"+res);
    }
    public static void fun(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null){
                map.put(arr[i], 1);
            }else {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
