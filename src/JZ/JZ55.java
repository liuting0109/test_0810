package JZ;

import java.util.HashMap;
import java.util.Map;

/*给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class JZ55 {

    /*
      设置快慢指针，都从链表头出发，快指针每次走两步，慢指针一次走一步，
      假如有环，一定相遇于环中某点(结论1)。
      接着让两个指针分别从相遇点和链表头出发，两者都改为每次走一步，
      最终相遇于环入口(结论2)。以下是两个结论证明：
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                slow = pHead;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    //map存节点
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode h = pHead;
        Map<ListNode, Integer> map = new HashMap<>();
        while (h != null){
            map.put(h, map.getOrDefault(h,0)+1);
            if (map.get(h) == 2)
                return h;
            h = h.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead){
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow  =pHead;
                while (fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            return fast;
        }
        return null;
    }

}
