package domain.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//俄罗斯套娃信封问题 leetcode 354
/*
小明情人节想给女朋友送一束花，但是他想给女朋友开个玩笑，于是找来很多高度和直径不等的圆柱形包装盒，一层一层地包装花（即先用一个小盒子包装花，再用一个稍大的盒子包装小盒子，以此类推，要求外面的盒子高度和直径都大于里面一层的盒子），给出所有的盒子数据，求最多能包装多少个盒子。假设花可以装进最小的盒子.

输入描述
所有数值均为正整数. 输入为一个二维自然数组,第一行为行数，第二行为列数，后续每行代表一个盒子,  第一列为盒子高, 第二列为盒子直径.
输出描述
最多包装盒子个数 整数
样例输入
6
2
100 65
150 70
90 56
190 75
95 60
110 68
样例输出
6
 */
public class xiaohongshu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _boxes_rows = 0;
        int _boxes_cols = 0;
        _boxes_rows = Integer.parseInt(in.nextLine().trim());
        _boxes_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _boxes = new int[_boxes_rows][_boxes_cols];
        for(int _boxes_i=0; _boxes_i<_boxes_rows; _boxes_i++) {
            for(int _boxes_j=0; _boxes_j<_boxes_cols; _boxes_j++) {
                _boxes[_boxes_i][_boxes_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = maxBoxes(_boxes);
        System.out.println(String.valueOf(res));
    }

    static int maxBoxes(int[][] boxes) {
        int _boxes_rows = boxes.length;
        int _boxes_cols = boxes[0].length;
        int res = 0;
        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < _boxes_rows; i++) {
            for (int j = i + 1; j < _boxes_rows; j++) {
                if (boxes[i][1] < boxes[j][1]){
                    res++;
                    i = j;
                    break;
                }else {
                    i++;
                    continue;
                }
            }
        }

        return res + 1;

    }

}
