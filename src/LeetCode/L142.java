package LeetCode;



public class L142 {

    public ListNode detectCycle(ListNode head) {
        //步骤一：使用快慢指针判断链表是否有环
        ListNode fast = head, slow = head;
        while (true){
            if (fast == null || fast.next == null)//无环返回null
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        /** a+b 个节点，其中 链表头部到链表入口 有 a
         *  个节点（不计链表入口节点）， 链表环 有 b 个节点
         * .第一次相遇，slow = nb
         * 2.a+nb = 入口点
         * 3.slow再走a = 入口 = head走到入口 = a
         * 4.由3得出，起始距离入口 = 第一次相遇位置 + a
         * 感觉就是数学公式推导+逻辑结合的一道题
         */
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

