package LeetCode1;

public class L79 {
    public static void main(String[] args) {
//        char[][] board =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };
//
//        String word = "ABCCED";


        char[][] board = {{'a', 'b'}};
        String word = "ba";
        L79 solution = new L79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);

    }
    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1,0},{0, -1},{0,1},{1,0}};
    private boolean [][] marked;
    private int m, n;//行列
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        marked = new boolean[m][n];
        this.board = board;
        this.word = word;//改为全局变量

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i,j,0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1){
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for (int k = 0; k < 4; k++){
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]){
                    if (dfs(newX, newY , start + 1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }


    private boolean inArea(int x, int y){
        return x >= 0 && x < m && y>= 0 && y < n;
    }

}
