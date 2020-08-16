package JZ;
/*
地上有一个m行和n列的方格。
一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
但是不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格（35,37），
因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class JZ66 {
    public static void main(String[] args) {
        System.out.println(sum(35,37));
        //movingCount()
    }

    public static int movingCount(int threshold, int rows, int cols) {
        boolean [][] flag = new boolean[rows][cols];
        return help(0,0, rows, cols, flag, threshold);
    }

    private static int help(int i, int j, int rows, int cols, boolean[][] flag, int threshold) {
        if (i <0 ||i > rows -1 || j < 0|| j > cols - 1||
                sum(i,j) >threshold || flag[i][j] == true)
            return 0;
        flag[i][j] = true;
        return help(i - 1,j,rows,cols,flag,threshold)+
                help(i + 1,j,rows,cols,flag,threshold)+
                help(i,j - 1,rows,cols,flag,threshold)+
                help(i,j + 1,rows,cols,flag,threshold)
                + 1;
    }

    public static int sum(int row, int col){
        int res = 0;
        while (row > 0){
            res += row % 10;
            row /= 10;
        }
        while (col > 0){
            res += col % 10;
            col /= 10;
        }
        return res;
    }
}
