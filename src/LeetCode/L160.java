package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/25 22:38
 * @Version 1.0
 * @Description
 */
public class L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null ||headB == null)return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = pA.next;
            pB = pB.next;
            if (pA == null) pA = pA.next;
            if (pB == null) pB = pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部,
         最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if (headA == null ||headB == null)return null;
        ListNode pA = headA;
        ListNode pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头,
        // 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB){
            if (pA != null){
                pA = pA.next;
            }else pA = headB;//not pA = pB;
            if (pB != null){
                pB = pB.next;
            }else pB = headA;
        }
        return pA;
    }
}
