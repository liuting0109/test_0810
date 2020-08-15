package JZ;

//输入一个链表，输出该链表中倒数第k个结点。
public class JZ14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0)
            return null;//边界条件漏了
        ListNode h1 = head;;
        ListNode h2 = head;
        while (h1 != null && k-- > 0){
            h1 = h1.next;
        }
        if (k > 0)//if (k != 0)错误了
            return null;
        while (h1 != null){
            h2 = h2.next;
            h1 = h1.next;
        }
        return h2;
    }
}
