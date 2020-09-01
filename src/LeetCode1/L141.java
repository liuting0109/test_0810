package LeetCode1;

import exam.ListNode;

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

        if (head == null)return false;//双指针
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2!=null && p2.next !=null){
            if (p1 == p2)
                return true;
            p1 = p1.next;//i每次走一步，j每次走两步
            p2 = p2.next.next;
        }
        return false;
    }
}
