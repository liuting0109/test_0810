package LeetCode1;

import exam.ListNode;

public class L234 {
    public boolean isPalindrome(ListNode head) {
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
