package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class L347 {
    public int[] topKFrequent(int[] nums, int k) {
        /**
         * 借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
         * 维护一个元素数目为 kk 的最小堆
         * 每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
         * 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
         * 最终，堆中的 k个元素即为前 k 个高频元素
         */
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num: nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }
            // 或者一句：map.put(num, map.getOrDefault(num, 0) + 1);
            else map.put(num, 1);
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        //lambda写法也对，优先队列默认是大跟堆
        PriorityQueue<Integer> pp = new PriorityQueue<>((o1, o2)->(map.get(o1) - map.get(o2)));
        for (Integer key: map.keySet()){
            if (pq.size() < k){
                pq.add(key);
            }else if (map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()){
            result[i++] = pq.remove();
        }
        return result;
        /*List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty())
            res.add(pq.remove());
        return res;*/
    }
}
