package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/12 14:16
 * @Version 1.0
 * @Description
 */
public class L21 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
    }
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {

            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i - 1]);
        }
        return profit;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(-1);
        //ListNode cur = h.next;//错误,会出现空指针异常
        ListNode cur = h;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;//可能空指针异常
                cur = cur.next;
                l1 = l1.next;
            }else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return h.next;
    }
}
