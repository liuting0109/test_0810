package LeetCode;

import java.util.Arrays;

/**
 * @Author: liuting
 * @Date: 2025/12/11 10:36
 * @Description:
 */
public class L3531 {
    //给你一个正整数 n，表示一个 n x n 的城市，同时给定一个二维数组 buildings，其中 buildings[i] = [x, y] 表示位于坐标 [x, y] 的一个 唯一 建筑。
    //如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑 被覆盖 。
    //返回 被覆盖 的建筑数量。

    public static void main(String[] args) {
        int n = 5;
//        int[][] buildings = {{1, 1}, {1, 2}, {2, 1}, {2, 2}};//n=3, res = 0
        int[][] buildings = {{1, 3}, {3, 2}, {3, 3}, {3, 5}, {5, 3}};//n=5, res=1
//        int[][] buildings = {{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}};//n=3, res=1
        System.out.println(countCoveredBuildings(n, buildings));
    }

    //统计行列的最小值和最大值
    public static int countCoveredBuildings(int n, int[][] buildings) {
//        if (buildings.length <= 4) {
//            return 0;
//        }
        int[] rowMin = new int[n + 1];
        int[] rowMax = new int[n + 1];
        int[] colMin = new int[n + 1];
        int[] colMax = new int[n + 1];
        Arrays.fill(rowMin, n + 1);
        Arrays.fill(colMin, n + 1);

        for (int[] p : buildings) {
            int x = p[0], y = p[1];
            //算出每一行的横坐标最大和最小值
            rowMin[y] = Math.min(rowMin[y], x);
            rowMax[y] = Math.max(rowMax[y], x);
            //算出每一列的纵坐标最大和最小值
            colMin[x] = Math.min(colMin[x], y);
            colMax[x] = Math.max(colMax[x], y);
        }
        int res = 0;
        //对于每个建筑 (x,y)，如果 x 在这一行的最小值和最大值之间（不能相等），y 在这一列的最小值和最大值之间（不能相等），那么答案加一
        for (int[] p : buildings) {
            int x = p[0], y = p[1];
            if (rowMin[y] < x
                    && rowMax[y] > x
                    && colMin[x] < y
                    && colMax[x] > y) {
                res++;
            }
        }
        return res;
    }
}

