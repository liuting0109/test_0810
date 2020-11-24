package JZ;

import java.util.*;

public class JZ63 {
    /*
    数据流中的中位数？
    如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
    如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     */

    //左区间，大顶堆
    PriorityQueue<Integer> high = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));

    //右区间，小顶堆，优先队列默认就是小顶堆
    PriorityQueue<Integer> low = new PriorityQueue<>();
    int sum = 0;//统计数据个数
    public void Insert(Integer num) {
        if (sum % 2 == 0){
            //当两个堆中的元素一样的时候，此时新增一个元素，放入大顶堆，左区间
            high.add(num);
        }else {
            low.add(num);
        }
        //交换维护两个堆
        if (!low.isEmpty() && high.peek() > low.peek()){
            int temp1 = high.poll();
            int temp2 = low.poll();
            high.add(temp2);
            low.add(temp1);
        }
        sum++;
    }

    public Double GetMedian() {
        if (sum % 2 == 0){
            return (high.peek() + low.peek()) / 2.0;
        }else {
            return (double)high.peek();
        }
    }
}
