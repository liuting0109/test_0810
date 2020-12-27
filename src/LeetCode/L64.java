package LeetCode;

/**
 * @Author LT
 * @Date 2020/12/27 15:59
 * @Version 1.0
 * @Description
 */
public class L64 {
    public int minPathSum(int[][] grid) {//dp

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0)grid[i][j] = grid[i - 1][j] +grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j],grid[i][j -1]) +grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
