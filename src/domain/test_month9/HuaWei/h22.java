package domain.test_month9.HuaWei;

import java.util.*;

/**
 * @Author LT
 * @Date 2020/9/30 19:18
 * @Version 1.0
 * @Description
 */
/*
10
4
1 2 3 1
2 1 5 2
3 20 7 6
4 5 2 2
 */
public class h22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Expire = sc.nextInt();
        int N = sc.nextInt();
        int[][] arr = new int[N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        fun(arr, Expire, N);

    }

    private static void fun(int[][] arr, int expire, int N) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
       /* for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("+++++");*/

        for (int i = 0; i < N; i++) {
            if (arr[i][0] == -1) continue;

            if (arr[i][2] + arr[i][3] > expire){
                arr[i][0] = -1;
            }
        }
        ArrayList<int[]> list = new ArrayList<>();

        ArrayList<Integer> time = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (arr[i][0] == -1) continue;
            //list.add(arr[i]);

            if (!list.isEmpty()) {
                int[] temp = arr[i];
                int begin = temp[2];
                int end = begin + temp[3];
                int j = begin;
                for (; j <= end; j++) {
                    if (time.contains(j)){
                        break;
                    }
                }
                if (j == end + 1){
                    list.add(temp);
                }
            }else {
                list.add(arr[i]);
                int[] temp = list.get(list.size() - 1);
                int begin = temp[2];
                int end = begin + temp[3];
                for (int j = begin; j <= end; j++) {
                    time.add(j);
                }
            }
        }
       /* for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[j]+" ");
            }
            System.out.println();
        }*/


        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int sum = 0;
        int size = list.size();
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            sum += temp[1];
        }

        System.out.println(sum);
        System.out.println(size);
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            System.out.println(temp[0]);
        }

    }
}
