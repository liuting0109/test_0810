package LeetCode1;

import exam.ListNode;

public class L148 {//归并完成链表排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;//找到中点后分割
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right !=null){
            if (left.val < right.val){
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left !=null ? left: right;//分割后分奇偶数个，左边可能会多一个
        return res.next;//return res错误，会返回表头0
    }
}
