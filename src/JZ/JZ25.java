package JZ;

import java.util.HashMap;

public class JZ25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    /*
    输入一个复杂链表（每个节点中有节点值，
    以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
    请对此链表进行深拷贝，并返回拷贝后的头结点。
    （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    /*
     *解题思路：
     *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     *3、拆分链表，将链表拆分为原链表和复制后的链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        RandomListNode curNode = pHead;
        while (curNode != null){
            RandomListNode cloneNode = new RandomListNode(curNode.label);
            RandomListNode nextNode = curNode.next;
            curNode.next = cloneNode;
            cloneNode.next = nextNode;
            curNode = nextNode;
        }

        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        curNode = pHead;
        while (curNode != null){
            curNode.next.random = curNode.random == null? null: curNode.random.next;
            curNode = curNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        curNode = pHead;
        RandomListNode pCloneHead = curNode.next;
        while (curNode != null){
            RandomListNode cloneNode = curNode.next;
            curNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ?null:cloneNode.next.next;
            curNode = curNode.next;
        }

        return pCloneHead;
    }
    // 方法二
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null)
            return pHead;
        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p1 != null){
            map.put(p1, new RandomListNode(p1.label));
            p1 = p1.next;
        }
        while (p2 != null){
            map.get(p2).next = p2.next == null?null :map.get(p2.next);
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }
}
