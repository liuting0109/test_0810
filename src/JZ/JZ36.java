package JZ;

import java.util.Stack;

/*输入两个链表，找出它们的第一个公共结点。
1 2 4 5 6
  3 4 5 6
遍历方式  1 2 4 5 6 3 4（*） 5 6
        3 4 5 6 1 2 4（*） 5 6
4的时候相等
 */
public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1  == null || pHead1 == null)
            return null;
        /*
        while (pHead1 != pHead2){
            if (pHead1 != null)
                pHead1 = pHead1.next;
            else
                pHead1 = pHead2;
            if (pHead2 != null)
                pHead2 = pHead2.next;
            else
                pHead2 = pHead1;
        }*/

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode pa = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.peek().val == stack2.peek().val){
                pa = stack1.peek();
                stack1.pop();
                stack2.pop();
            }else {
                break;
            }
        }
        return pa;
    }
}
