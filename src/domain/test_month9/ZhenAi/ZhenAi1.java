package domain.test_month9.ZhenAi;

/**
 * @Author LT
 * @Date 2020/9/11 21:11
 * @Version 1.0
 * @Description
 */
//Ac
public class ZhenAi1 {
    public static void main(String[] args) {
        int[] arr = {1,0,0,1};
        int n = 1;
        System.out.println(parking(arr, n));
    }
    public static boolean parking (int[] park, int n) {
        // write code here
        int len = park.length;
        int start = 0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (park[i] == 1){
                count++;
            }
        }
        if (count + n > park.length/2)
            return false;
        /*for (int i = 0; i < len; i++) {
            if (park[i] == 0){
                start = i;
                for (int j = i + 1; j < len; j++) {
                    if (park[j] == 0){
                        end = j;
                        if (end - start >= 2){
                            count++;
                            start = j;
                        }
                    }
                }
            }
        }*/

        return true;
    }
}
