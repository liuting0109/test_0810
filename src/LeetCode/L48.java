package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/27 15:23
 * @Version 1.0
 * @Description
 */
public class L48 {
    public void rotate(int[][] matrix) {
        //先转置在翻转每行
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
