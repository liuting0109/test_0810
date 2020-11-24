package JZ;

import com.sun.xml.internal.bind.v2.model.core.ID;

/*
输入一个整数数组，
判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。
假设输入的数组的任意两个数字都互不相同。
 */
public class JZ23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        return help(sequence, 0 ,sequence.length -1);
    }
    /*BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
    如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
     */
    private boolean help(int[] sequence, int start, int root) {
        if (start >= root)
            return true;
        int key = sequence[root];
        int index = start;
        for ( ; index < root; index++) { //找到左右子树的分界点
            if (sequence[index] > key)
                break;
        }
        for (int j = index; j <root; j++){//在右子树中判断是否含有小于root的值，如果有返回false
            if (sequence[j] < key){
                return false;
            }
        }
        return help(sequence, start ,index - 1) && help(sequence, index, root - 1);
        //return help(sequence, 0,index - 1) && help(sequence, index, root - 1);//也对
    }

    /*
        非递归也是一个基于递归的思想：
        左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
       最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件
        即可，即使到达了左子树左子树也可以看出由左右子树组成的树还想右子树那样处理

        对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
        只需看看右子树的右子树是否符合要求即可
     */
    //非递归
    public boolean VerifySquenceOfBST1(int [] sequence) {
        int size = sequence.length;
        if (size == 0)return false;
        int i = 0;
        while (size -- > 0){
            while (sequence[i] < sequence[size]) i++;
            while (sequence[i] > sequence[size]) i++;
            if (i < size) return false;
            i = 0;
        }
        return true;
    }

}

