package JZ;
/*
在一个长度为n的数组里的所有数字都在0到n-1的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 那么对应的输出是第一个重复的数字2。
 */

public class JZ50 {
    public static void main(String[] args) {
        int [] array = {2,1,3,1,4};
        int [] duplication = new int[2];
        System.out.println(duplicate(array, 9, duplication));
    }

    /*  bingo！！！！！！！
        0   1   2   3   4位置
        2,  1,  3,  1,  4
        2,  1, -3,  1,  4第一轮把num[abs(0)] = 2的位置变为 负数
        2, -1, -3,  1,  4第二轮把num[abs(1)] = 1的位置变为 负数
        2, -1, -3, -1,  4第三轮把num[abs(2)] = 3的位置变为 负数
        2,  1, -3, -1,  4第四轮把num[abs(3)] = 1的位置变为 负数；由于第二轮1的位置已经是负数了，所以是重复的数
     */
    public static boolean duplicate3(int numbers[],int length,int [] duplication) {
        if (length <= 1)
            return false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[Math.abs(numbers[i])] < 0){
                duplication[0] = numbers[i];
                return true;
            }
            numbers[Math.abs(numbers[i])] = -numbers[Math.abs(numbers[i])];
        }
        return false;
    }

    /*
    ，题目里写了数组里数字的范围保证在0 ~ n-1 之间，
    所以可以利用现有数组设置标志，当一个数字被访问过后，
    可以设置对应位上的数 + n，之后再遇到相同的数时，
    会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
     */
    public static boolean duplicate2(int numbers[],int length,int [] duplication) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int index = numbers[i];
            if (index >= len){
                index -= len;
            }
            if (numbers[index] >= len){
                duplication[0] = numbers[index];
                return true;
            }

            numbers[index] = numbers[index] + len;
        }
        return false;
    }

/*
以数组 {2,3,1,0,2,5,3} 为例
当 i = 0 时，nums[i] = 2 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{1,3,2,0,2,5,3}
此时 i = 0，nums[i] = 1 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{3,1,2,0,2,5,3}
此时 i = 0，nums[i] = 3 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{0,1,2,3,2,5,3}
此时 i = 0，nums[i] = 0 = i，继续下一组
当 i = 1，nums[i] = 1 = i，继续下一组
当 i = 2，nums[i] = 2 = i，继续下一组
当 i = 3，nums[i] = 3 = i，继续下一组
当 i = 4，nums[i] = 2 != i，判断 nums[i] 等于 nums[nums[i]]，出现重复，赋值返回
 */
    //运行超时
    public static boolean duplicate1(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < numbers.length; i++) {
            while (i != numbers[i]){
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[numbers[i]] = temp;
            }
        }
        return false;
    }

    //错误
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int temp = 0;
        if (length <= 1)
            return false;
        for (int i = 0; i < numbers.length; i++) {
            temp ^= numbers[i];
            if (temp == 0){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
