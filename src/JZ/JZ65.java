package JZ;

import java.util.Arrays;

/*
判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，
每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
例如
a b c e
s f c s
a d e e
   矩阵中包含一条字符串"bcced"的路径，
   但是矩阵中不包含"abcb"路径，
   因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
   路径不能再次进入该格子。
 */
public class JZ65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] flag = new boolean[rows][cols];
        char[][] array = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = matrix[cols * i + j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //循环遍历二维数组，找到起点等于str第一个元素的值，
                // 再递归判断四周是否有符合条件的----回溯法
                if (help(array, i, j, rows, cols, str, flag, 0))
                    return true;
            }
        }
        return false;
    }
    int k = 0;
    private boolean help(char[][] matrix, int i, int j, int rows, int cols, char[] str, boolean[][] flag, int k) {
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (k >= str.length)
            return true;
        if (i < 0|| i >= rows || j <0 || j >= cols ||
                flag[i][j] == true || matrix[i][j] != str[k])
            return false;
        flag[i][j] = true;
        ////回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (help(matrix,i - 1,j,rows,cols,str,flag,k+1)||
                help(matrix,i + 1,j,rows,cols,str,flag,k+1)||
                help(matrix,i,j - 1,rows,cols,str,flag,k+1)||
                help(matrix,i,j + 1,rows,cols,str,flag,k+1)
        )
            return true;

        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[i][j] = false;
        return false;
    }
}
