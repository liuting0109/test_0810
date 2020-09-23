package domain.test_month9.Bianlifeng;

import java.util.*;

/**
 * @Author LT
 * @Date 2020/9/18 17:13
 * @Version 1.0
 * @Description
 */
/*
假设我们有一个连通的无向图，里面可能最多存在一个环，检测输入的图是否有环。
这个图有n个不重复的顶点，输入的图的边[a,b]，满足a<b。如果有环输出Y，否则输出N。
n表示输入数组的长度，数组里每个数字都小于n。 (n<=10000)
1--2–3
  |  |
  5–4
如上图，2-3-4-5是一个环

输入描述
public String removeOneConnection(int[][] edges)
说明:
edges表示输入的图的边
输出描述
返回：Y or N
样例输入
[[1,2],[2,3],[3,4],[4,5],[2,5]]
样例输出
Y
提示
样例 2：
输入：
[[1,2],[2,3],[3,4],[4,5]]
输出：
N
 */
public class blf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(fun(str));
    }
    public static String fun(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '0' && str.charAt(i) <'9'){
                if (map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),map.get(str.charAt(i)) + 1);
                }else {
                    map.put(str.charAt(i), 1);
                }
                if (map.get(str.charAt(i)) >= 3)
                    return "Y";
            }
        }
        for (Character i : map.keySet()){
            //System.out.println(i + " "+ map.get(i));
        }
        return "N";
    }

        //int[][] edges = new int[][2];
        //System.out.println(removeOneConnection(edges));
    public static String removeOneConnection(int[][] edges){
        Arrays.sort(edges);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            if (!set.contains(edges[i][0])){
                set.add(edges[i][0]);
            }else {
                return "N";
            }
        }
        return "Y";
    }
}
