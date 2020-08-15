package JZ;
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
}

