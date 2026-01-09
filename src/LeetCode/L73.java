package LeetCode;

import java.util.Arrays;

/**
 * @Author: liuting
 * @Date: 2026/1/7 16:13
 * @Description:
 */
public class L73 {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};//输出[[1,0,1],[0,0,0],[1,0,1]]
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};//输出[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        setZeroes1(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    //用一个长为 m 的布尔数组 rowHasZero 记录每一行是否包含 0。
    //遍历 matrix[i]，如果包含 0，那么置 rowHasZero[i]=true。
    //用一个长为 n 的布尔数组 colHasZero 记录每一列是否包含 0。
    //遍历 matrix 的 j 列，如果包含 0，那么置 colHasZero[j]=true。
    //然后，再次遍历 matrix。对于 matrix[i][j]，如果 rowHasZero[i]=true
    // 或者 colHasZero[j]=true，说明 i 行有 0，或者 j 列有 0，把 matrix[i][j] 变成 0。
    //时间复杂度：O(mn)，其中 m 和 n 分别是 matrix 的行数和列数。
    //空间复杂度：O(m+n)。
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        boolean[] rowHasZero = new boolean[m];// 行是否包含 0
        boolean[] colHasZero = new boolean[n];// 列是否包含 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowHasZero[i] || colHasZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    //用第一列的 matrix[i][0] 保存 rowHasZero[i]：
    //如果 i 行有 0，那么置 matrix[i][0]=0。
    //用第一行的 matrix[0][j] 保存 colHasZero[j]：
    //如果 j 列有 0，那么置 matrix[0][j]=0。
    //然后，再次遍历 matrix。对于 matrix[i][j]，
    // 如果 matrix[i][0]=0 或者 matrix[0][j]=0，说明 i 行有 0，或者 j 列有 0，把 matrix[i][j] 变成 0。
    //解决办法：在一开始，额外用两个布尔变量分别记录第一行是否包含 0，第一列是否包含 0。最后，如果第一行在一开始就包含 0，那么把第一行全变成 0；
    // 如果第一列在一开始就包含 0，那么把第一列全变成 0。
    //既然最后会单独修改第一行和第一列，那么在修改 matrix[i][j] 时，跳过第一行和第一列。
    // 这也避免了一个 bug：如果提前把 matrix[i][0] 变成 0，我们会误认为 i 行要全部变成 0。
    // 时间复杂度：O(mn)，其中 m 和 n 分别是 matrix 的行数和列数。
    //空间复杂度：O(1)。
    public static void setZeroes1(int[][] matrix) {
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        boolean firstRowZero = false;
        boolean firstColZero = false;
        // 记录第一行是否包含 0
        for (int x : matrix[0]) {
            if (x == 0) {
                firstRowZero = true;
                break;
            }
        }
        // 记录第一列是否包含 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        // 用第一列 matrix[i][0] 保存 rowHasZero[i]
        // 用第一行 matrix[0][j] 保存 colHasZero[j]
        for (int i = 1; i < m; i++) {// 无需遍历第一行，如果 matrix[0][j] 本身是 0，那么相当于 colHasZero[j] 已经是 true
            for (int j = 1; j < n; j++) {// 无需遍历第一列，如果 matrix[i][0] 本身是 0，那么相当于 rowHasZero[i] 已经是 true
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;// 相当于 rowHasZero[i] = true
                    matrix[0][j] = 0;// 相当于 colHasZero[j] = true
                }
            }
        }
        for (int i = 1; i < m; i++) {// 跳过第一行，留到最后修改
            for (int j = 1; j < n; j++) {// 跳过第一列，留到最后修改
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;// 相当于 rowHasZero[i] = true
                }
            }
        }
        // 如果第一列一开始就包含 0，那么把第一列全变成 0
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        // 如果第一行一开始就包含 0，那么把第一行全变成 0
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
