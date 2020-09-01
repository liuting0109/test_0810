package LeetCode1;

import exam.ListNode;

public class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head ==null|| n == 0) return head;
        ListNode temp = new ListNode(0);//防止[1,2],n=2时出错
        temp.next = head;
        ListNode fast = head;
        ListNode slow = temp;
        for (int i = 1; i <= n; i++) {//为了fast和slow之间差n个数，fast要先走n+1步
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }
}
