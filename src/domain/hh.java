package domain;

import java.util.Scanner;

/**
 * @Author LT
 * @Date 2020/9/26 18:55
 * @Version 1.0
 * @Description
 */
//java输入处理
public class hh {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] str = sc.nextLine().trim().split(" ");
       /* 1.输入格式：每行输入带有空格的数字
        6
        2 1
        3 2
        4 3
        5 2
        6 1

        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine()) - 1;
        int[][] num = new int[count][2];
        for (int i = 0; i < count; i++) {
            String temp = in.nextLine();
            String[] ss = temp.trim().split(" ");
            num[i][0] = Integer.parseInt(ss[0]);
            num[i][1] = Integer.parseInt(ss[1]);
        }

        法2：
        3
        1 2 2
        1 2 3
        2 3 4

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] games=new int[n][3];
        for (int i=0;i<n;i++){
            games[i][0]=in.nextInt();
            games[i][1]=in.nextInt();
            games[i][2]=in.nextInt();
        }

        */

       /*2.输入格式：每行一个字符串
        3
        hahahah
        ohohho
        hhhhhh

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        String[] S=new String[n];
        for (int i = 0; i < m; i++) {
            S[i] = sc.nextLine();
        }

       * */

       /*3.输入格式：每行循环输入得出结果
       2 3
       5 //OUTPUT
       3 5
       8 //OUTPUT

       * Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int a=in.nextInt();
            int b=in.nextInt();
            System.out.println(a+b);
            }

       * */

       /*4.输入格式：输入带有数字和符号
       3
       aa
       b
       ac
       bbaac

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String[] strs = new String[count];
        for (int i = 0; i < count; i++) {
            strs[i] = in.nextLine();
        }
        String strT = in.nextLine();
        * */


       /*
       * 5.输入格式：输入带有数字和符号
        20,3
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);
        *
       * */

       /*
       *6.输入格式
        第一行输入    数列的项数   数列1 n项  数列2 m项
        第二行输入 数列1 的 值（共n项）
        第三行输入 数列2 的 值（共m项）
        输入样例：
        4 5
        1 2 3 4
        1 2 3 4 5

        Scanner scanner = new Scanner(System.in);
        int length1 = scanner.nextInt();
        int length2 = scanner.nextInt();
        int[] nums1 = new int[length1];
        int[] nums2 = new int[length2];
        int index = 0;
        while(scanner.hasNext()) {
            nums1[index] = Integer.parseInt(scanner.next());
            index++;
            if(index>length1-1){
                break;
            }
        }
        index = 0;
        while(scanner.hasNext()) {
            nums2[index] = Integer.parseInt(scanner.next());
            index++;
            if(index>length2-1){
                break;
            }
        }


       * */




        }
    }

