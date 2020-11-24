package JZ;

import java.util.*;

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}

public class JZ3 {
    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode h = listNode;
        /* Stack<ListNode> stack = new Stack<>();
        while (h != null){
            stack.push(h);
            h = h.next;
        }
        while (!stack.isEmpty()){
            res.add(stack.pop().val);
        }*/
        while (h != null){
            res.add(0, h.val);
        }
        return res;
    }
    //先翻转再打印
}
