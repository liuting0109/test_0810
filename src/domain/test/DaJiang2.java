package domain.test;

import java.util.*;

/***
 * 大疆“hello undo redo world”； 输出“hello world”
 * undo 撤销前一个输入；redo 重新键入
 */
public class DaJiang2 {
    public static void main(String[] args) {
        //String s = "hello undo redo world";
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        /*StringBuffer sb = new StringBuffer();
        while (sc.hasNext()){
            sb.append(sc.nextLine());
        }
        String str = sb.toString();*/
        //System.out.println(str);
        ArrayList<String> res = fun(str);
        /*System.out.println(11+"\t"+11);
        System.out.println(11+"\n"+11);//换行符*/
        for(String i: res){
            System.out.print(i+" ");
        }
        //System.out.println(res);
    }

    private static ArrayList<String> fun(String str) {
        ArrayList<String> res = new ArrayList<>();
        String undo = "undo";
        String redo = "redo";
        String[] temp = str.split(" ");
        //StringBuffer sb = new StringBuffer();
       /* for (int i = 0; i < temp.length; i++) {
            //if ()
        }*/
        if (str.contains(undo) && str.contains(redo)){
            for (int i = 0; i < temp.length; i++) {
                if (!temp[i].equals(undo) && !temp[i].equals(redo)){
                    res.add(temp[i]);
                }
            }
        }else if (str.contains(undo)){
            int index = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].equals(undo))
                    index = i;
            }
            int i = 0;
            for (; i < temp.length; i++) {
                if (i != index - 1 && i != index){
                    res.add(temp[i]);
                }
            }
        }else {
            res.add(str);
            /*for (int i = 0; i < temp.length ; i++) {
                 res.add(temp[i]);
            }*/
        }
        return res;
    }
}
