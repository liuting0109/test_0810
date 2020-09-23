package LeetCode;

/**
 * @Author LT
 * @Date 2020/9/15 16:40
 * @Version 1.0
 * @Description
 */
public class L328 {
    public ListNode oddEvenList(ListNode head) {
        // 特判：头结点为 null，返回null
        // head是奇链表的头
        if (head == null) return null;

        // odd是奇链表的当前节点，先初始化为head（初始化为奇链表头）
        ListNode odd = head;
        // even是偶链表的当前节点，初始化为第二个节点也就是head.next
        ListNode even = head.next;
        // evenHead是偶链表的头节点，初始化为链表第二个节点（初始化为奇链表头的下一个节点）
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            // 这里while退出判断条件还是画图一下才能理解（也就是官方题解的STEP2）
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
