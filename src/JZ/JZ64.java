package JZ;

import java.util.*;

/*
给定一个数组和滑动窗口的大小，
找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
  {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
  {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
窗口大于数组长度的时候，返回空
 */
public class JZ64 {
    public static void main(String[] args) {
        int[] nums = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> res = maxInWindows3(nums, 3);
        System.out.println(res);
    }
    /**
     用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     1.判断当前最大值是否过期
     2.新增加的值从队尾开始比较，把所有比他小的值丢掉
     */
    //https://blog.csdn.net/u010429424/article/details/73692248
    public static ArrayList<Integer> maxInWindows3(int [] num, int size){
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0 || size > num.length){
            return result;
        }
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            if (!queue.isEmpty()){
                if (i >= queue.peek() + size){// 如果队列头元素不在滑动窗口中了，就删除头元素
                    queue.pop();
                }
                // 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                while ( !queue.isEmpty() && num[i] >= num[queue.getLast()]){
                    queue.removeLast();
                }
            }
            queue.offer(i); // 入队列
            if (i + 1 >= size){// 滑动窗口经过三个元素，获取当前的最大值，也就是队列的头元素
                //System.out.println(queue.peek());
                result.add(num[queue.peek()]);
            }
        }
        return result;
    }



    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        //思路时=是，一个双向链表存储小标，当当前元素比下标小时，入队列，大时，遍历队列，比该元素小时就舍弃，然后入队列
        //begin记录滑动窗口左边
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;//代表滑动窗口的起点
            if(q.isEmpty())
                q.add(i);
            else if(begin > q.peekFirst())
                q.pollFirst();

            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }


    //看不懂
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > num.length || size <= 0)
            return res;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i])
                deque.pollLast();
            deque.add(i);
            //判断队首元素是否过期
            if (deque.peekFirst() == i - size)
                deque.pollFirst();
            //向result列表中加入元素
            if (i >= size -1){
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }

    //暴力法
    public ArrayList<Integer> maxInWindows1(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > num.length || size <= 0)
            return res;

        for (int i = 0; i < num.length - size + 1; i++) {
            int max = num[i];
            for (int j = i; j < size + i; j++) {
                max = Math.max(max,num[j]);
            }
            res.add(max);
        }
        return res;
    }
}
