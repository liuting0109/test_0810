package domain.test_month9.XieCheng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
考虑实现一个敏感词过滤的功能，给定指定的敏感单词、句子、替换词，把句子中的敏感单词词全部替换成替换词。

注意替换过程中敏感词需要忽略字母顺序，例如you这个敏感词，句子里如果出现oyu、uyo等，也同样需要进行替换，以免有人利用不影响人类理解的错误字母顺序钻空子。



输入描述
输入为三行内容：

第一行是敏感单词

第二行是待检测的句子

第三行是替换的目标词

输出描述
输出替换好敏感词的句子


样例输入
you
i love you,oyu love me
jack
样例输出
i love jack,jack love me
 */
/**
 * @Author LT
 * @Date 2020/9/8 19:51
 * @Version 1.0
 * @Description
 */
public class xieCheng1 {
    static Set<String> res = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[3];
        for (int i = 0; i < 3; i++) {
            str[i] = sc.nextLine();
        }
        String res = MingGan(str);
       /* char[] chars ={'a','b','c'};
        allOrder(chars, 0 ,chars.length - 1);
        System.out.println(res);*/
        System.out.println(res);
    }

    private static String MingGan(String[] str) {
        String mingan = str[0];
        String sentence= str[1];
        StringBuffer sb = new StringBuffer(sentence);
        String world = str[2];
        char[] chars = mingan.toCharArray();
        allOrder(chars, 0 ,chars.length - 1);
        //System.out.println(res);
        String[] tihuan = new String[res.size() + 1];
        tihuan[0] = sentence;
        int index = 0;
        int j = index+1;
        /*for (int i = 1; i < res.size(); i++) {
            tihuan[i] = tihuan[i -1].replaceAll(res.)
        }*/
        //if (sentence.contains(s))
        for (String  s: res){
            //System.out.println(s);
            //String temp = sentence.replaceAll(s, world);
            //sb.toString().replaceAll(s,world);
            //String temp = fun(s, sentence,world);
            tihuan[index + 1] = tihuan[index].replaceAll(s, world);
            //System.out.println(tihuan[index + 1]);
            index++;
        }
        //String res  = sentence.replaceAll(mingan, world);
        return tihuan[index];
    }
    public static String fun(String s, String str,String world){
        String res = str.replaceAll(s, world);
        return res;

    }

    public static void allOrder(char[] chars, int begin, int end){
        if (begin > end){
            return;
        }
        if (begin == end){
            res.add(String.valueOf(chars));
        }
        for (int i = begin; i <= end; i++) {
            swap(chars, i, begin);
            allOrder(chars, begin + 1, end);
            swap(chars, i ,begin);
        }
    }

    private static void swap(char[] chars, int i, int begin) {
        char temp = chars[i];
        chars[i] = chars[begin];
        chars[begin] = temp;
    }

    /*public static void backtrack(String str,int begin, int end){
        char[] chars = str.toCharArray();


    }*/
}
