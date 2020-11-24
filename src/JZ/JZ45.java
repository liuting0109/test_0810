package JZ;

import java.util.Arrays;

/*
一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
模拟上面的过程,如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class JZ45 {
    /*
    1、排序
    2、计算所有相邻数字间隔总数
    3、计算0的个数
    4、如果2、3相等，就是顺子
    5、如果出现对子，则不是顺子
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5){
            return false;
        }
        int king = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] ==0)
                king++;
        }
        Arrays.sort(numbers);
        for (int i = king; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1])
                return false;
            king -= numbers[i + 1] - numbers[i] - 1;
        }
        /*for (int i = king; i < numbers.length - 1; i++) {//错误
            if (numbers[i + 1] - numbers[i] > 1){
                king -- ;
            }
        }*/

        return king >= 0;
    }
}
