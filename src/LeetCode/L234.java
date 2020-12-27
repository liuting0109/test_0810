package LeetCode;

import java.util.Stack;

/**
 * @Author LT
 * @Date 2020/12/25 16:11
 * @Version 1.0
 * @Description
 */
public class L234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        //1.快慢指针,找到链表的中点。
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //2.将slow之后链表反转
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        //3.前后链表进行比较，注意若为奇数链表，多1一个节点，然而并不影响判断回文
        while (head != null && pre != null){
            if (head.val != pre.val)
                return false;
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    //以下未验证
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            if (head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }

        return true;
    }
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null)return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode p = null, pre = null;
        //用快慢指针遍历的同时翻转前半部分，然后与后半部分比较即可。
        while (fast != null && fast.next !=null){
            p = slow;
            slow = slow.next;
            fast = fast.next.next;//快慢遍历

            p.next = pre;//翻转
            pre = p;
        }
        if (fast !=null)//奇数个节点时跳过中间节点
            slow = slow.next;
        while (p!=null){//前半部分和后半部分比较
            if (p.val !=slow.val)
                return false;
            p = p.next;
            slow = slow.next;
        }
        return true;
        /*if (head == null || head.next == null)return true;
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while ( p != null){
            // 根据快慢指针，找到链表的中点
            // while (p2!= null && p1 != null){/stack.push(p1);//条件写的不对
            stack.push(p.val);//入栈的是节点的值，而不是节点的地址；stack.push(p);错误
            p = p.next;
        }
        p = head;
        while (!stack.isEmpty()){
            if (stack.peek() != p.val)
                return false;
            stack.pop();
            p = p.next;
        }
        return true;*/
    }
}
