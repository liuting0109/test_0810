package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/26 17:45
 * @Version 1.0
 * @Description
 */
public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;//前一个指针节点
        ListNode cur = head;//当前指针节点
        ListNode next = null;
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (cur != null){
            next = cur.next;//临时节点，暂存当前节点的下一节点，用于后移
            cur.next = pre;//将当前节点指向它前面的节点
            pre = cur;//前指针后移
            cur = next;//当前指针后移
        }
        return pre;
    }
}
