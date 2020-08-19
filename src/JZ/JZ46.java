package JZ;

import java.util.LinkedList;

/*约瑟夫环
f[1]=0;
f[i]=(f[i-1]+m)%i;  (i>1)

围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个出列并且不再回到圈中,从他的下一个开始,
继续0...m-1报数....这样下去....直到剩下最后一个小朋友下
编号是从0到n-1)
如果没有，请返回-1
 */
public class JZ46 {
    //用链表模拟游戏过程即可。
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1){
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.size() == 1? list.get(0): -1;
    }

    public int LastRemaining_Solution1(int n, int m) {
        if (n == 0|| m == 0)
            return -1;
        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }
}
