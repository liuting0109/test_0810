package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author LT
 * @Date 2020/12/12 16:55
 * @Version 1.0
 * @Description
 */
public class L406 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
        for (int[] i : people){
            System.out.println(i[0]+" "+i[1]);
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        if (0 == people.length || 0 == people[0].length)
            return new int[0][0];
        //按照身高降序 K升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0]? o1[1] - o2[1] :o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        //K值定义为 排在h前面且身高大于或等于h的人数
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此K值即为需要插入的位置
        for (int[] p: people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
