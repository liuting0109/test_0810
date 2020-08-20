package JZ;

import java.util.Stack;

/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class JZ56 {

    /*
    . 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
        2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，
        而last指针相当于工作指针，一直往后面搜索。
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode head = new ListNode(0);
        head.next = pHead;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null){
            if (cur.next != null && cur.next.val == cur.val){
                // 找到最后的一个相同节点
                while (cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                pre.next = cur.next; // pre 连接新结点
                cur = cur.next;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head.next;
    }
}
