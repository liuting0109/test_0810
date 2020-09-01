package domain.test;
/*
一个链表，让位于奇数位的节点移到前面，且相对顺序不变。空间复杂度O(1),时间复杂度O(n)

输入：2->3->1->5->4->NULL
输出：2->1->4->3->5->NULL
 */
class ListNode{
    ListNode next;
    int val;
    ListNode (int val){
        this.val = val;
    }
}

public class Tiger1 {
    public ListNode lineUp (ListNode head) {
        if (head == null || head.next == null|| head.next.next == null)
            return head;
        // write code here
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode p1 = res;
        ListNode p2 = res.next;
        while (p2 != null && p2.next !=null){
            p1.next = p2.next;
            p2.next = p1.next.next;
            p1 = p1.next;
            p2 = p1.next;
        }

        return res.next;
    }

    //正解
    public ListNode lineUp1 (ListNode head) {
        ListNode p = head, q = head.next, second = q;
        while (p != null && q != null){
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
            if (q == null || q.next == null)
                break;
        }
        p.next = second;
        return head;
    }
}
