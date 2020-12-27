package LeetCode;

public class L240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * “方法四”的“如何选出发点”的补充：
         * 选左上角，往右走和往下走都增大，不能选
         * 选右下角，往上走和往左走都减小，不能选
         * 选左下角，往右走增大，往上走减小，可选
         * 选右上角，往下走增大，往左走减小，可选
         */
        int m = matrix.length;
        if (m == 0)return false;
        int row = m - 1;
        int n = matrix[0].length;
        if (n == 0)return false;
        int col = 0;
        while (row >= 0 && col < n){
            if (matrix[row][col] < target){
                col++;
            }else if (matrix[row][col] > target){
                row --;
            }else {
                return true;
            }
        }
        return false;
    }
}
