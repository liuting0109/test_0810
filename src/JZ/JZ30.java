package JZ;
//连续子数组的最大和
public class JZ30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            //sum = sum + array[i] > 0 ? sum+array[i]:array[i];//错误
            sum = sum > 0 ? sum + array[i]:array[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    public int FindGreatestSumOfSubArray1(int[] array) {
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {//i从1 开始
            sum = Math.max(sum + array[i], array[i]);//相当于dp的思想
            max = Math.max(sum, max);
        }
        return max;
    }

    //dp解法

}
