package JZ;

public class JZ13 {
    public static void main(String[] args) {
        int[]a = {1,2,3,4,5,6,7};
        reOrderArray(a);
        for (int i: a){
            System.out.print(i+" ");
        }
    }
    public static void reOrderArray(int [] array) {
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] %2 ==1)
                oddCount++;
        }
        int[] res = array.clone();
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] %2 ==1){
                res[j++] = array[i];
            }else
                res[oddCount+ j] = array[i];
        }
    }
}
