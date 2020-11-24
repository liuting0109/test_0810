package JZ;

public class JZ16 {
    //输入两个单调递增的链表，输出两个链表合成后的链表，
    // 当然我们需要合成后的链表满足单调不减规则。
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if (list1 != null)
            cur.next = list1;

        if (list2 != null)
            cur.next = list2;
            //写错了 不是while 而是if；是把多余的链表的部分整个放到cur的后面
        /*while (list1 != null){
            cur.next = list1;
            list1 = list1.next;
        }
        while (list2 != null){
            cur.next = list2;
            list2 = list2.next;
        }*/
            return h.next;
    }

    //递归版本
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode res = null;
        if (list1.val < list2.val){
            res = list1;
            res.next = Merge(list1.next, list2);
        }else {
            res = list2;
            list2.next = Merge(list1, list2.next);
        }
        return res;
    }
}
