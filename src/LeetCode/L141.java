package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/25 16:50
 * @Version 1.0
 * @Description
 */
public class L141 {
    public boolean hasCycle(ListNode head) {
        /*    Set<ListNode> set = new HashSet<>();//哈希表
        while (head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;*/
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        //ListNode fast = head;//错误 全部返回true
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            if (fast == slow){
                return true;
            }
            fast = fast.next.next;//i每次走一步，j每次走两步
            slow = slow.next;
        }
        return false;
    }
}
