package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/13 16:30
 * @Version 1.0
 * @Description
 */
public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;//进位
        while (l1 != null|| l2 != null){
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
