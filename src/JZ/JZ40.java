package JZ;

import java.util.HashMap;
import java.util.Set;

/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次
。请写程序找出这两个只出现一次的数字。
 */
public class JZ40 {
    public static void main(String[] args) {
        System.out.println((int) Math.pow(2, 32));//2^32 = 2147483647
        System.out.println(Integer.MAX_VALUE);
        System.out.println(4>>1);//2
        System.out.println(4>>2);
        System.out.println(5&1);
    }
    //num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
    /*
    首先还是先异或，剩下的数字肯定是A、B异或的结果，
    这个结果的二进制中的1，表现的是A和B的不同的位。
    我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，
    分组标准是第3位是否为1。如此，相同的数肯定在一个组，
    因为相同数字所有位都相同，而不同的数，肯定不在一组。
    然后把这两个组按照最开始的思路，依次异或，
    剩余的两个结果就是这两个只出现一次的数字。
     */

        //只有一个数字出现了一次
        public int singleNumber(int[] nums) {
            int once = 0;
            for (int i = 0; i < nums.length; i++) {
                once = once ^ nums[i];
            }
            return once;
        }

        public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
            int len = array.length;
            if (len == 2){
                num1[0] = array[0];
                num2[1] = array[1];
                return;
            }
            int bitRes = 0;
            for (int i = 0; i < len; i++) {
                bitRes ^= array[i];
            }
            int index = findFirst1(bitRes);

            for (int i = 0; i < len; i++) {
                if (isBit1(array[i], index)){
                    num1[0] ^= array[i];
                }else {
                    num2[0] ^= array[i];
                }
            }
        }

        private boolean isBit1(int i, int index) {
            return ((i >> index) & 1) == 1;
        }

        private int findFirst1(int bitRes) {
            int index = 0;
            while ((bitRes & 1) == 0 && index < 32){
                index++;
                bitRes >>= 1;
            }
            return index;
        }

        //方法二
        public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i]))
                    map.put(array[i], 2);
                else
                    map.put(array[i], 1);
            }

            int c = 0;
            for (Integer i : map.keySet()){
                if (map.get(i) == 1 && c==0){
                    num1[0] = i;
                    c++;
                }else if (map.get(i) == 1 && c==1){
                    num2[0] = i;
                }
            }
        }
    }

