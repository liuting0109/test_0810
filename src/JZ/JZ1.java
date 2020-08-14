package JZ;

public class JZ1 {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols){
            if (array[row][col] > target)
                row--;
            else if (array[row][col] < target)
                col++;
            else
                return true;
        }
        return false;
    }
}
