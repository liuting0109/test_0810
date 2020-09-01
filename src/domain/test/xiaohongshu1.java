package domain.test;

import java.util.ArrayList;
import java.util.Scanner;
/*
为了满足消息发送的要求，我们需要将一大段文本分成多个消息发送，每个消息最大长度不超过1024个英文字符，文本内容为英文字符和英文标点符号（包括”,”/“.”/“;”/“!”以及换行），为了尽可能保证可读性，我们希望每一个消息尽可能是分在段落结束。如果不行，可以分在句子结束。可以保证输入的文本内容每个句子长度不超过1024（包括符号）。请给出拆分算法。 String[] splitMsg(String textContent)



输入描述
一段文本（英文字符加英文符号）。

输出描述
String的数组，每个数组长度不超过1024字节。

内容为分段或者分句。


样例输入
This is a very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very long sentence. With longer than 1024 bytes paragraph, it should be splitted into 2 part.
One is : This is a very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very long sentence.
The other is : With longer than 1024 bytes paragraph, it should be splitted into 2 part.
样例输出
msg1:This is a very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very long sentence.
msg2:With longer than 1024 bytes paragraph, it should be splitted into 2 part.

msg3:One is : This is a very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very long sentence.
msg4:The other is : With longer than 1024 bytes paragraph, it should be splitted into 2 part.
 */
public class xiaohongshu1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;
        StringBuffer sb = new StringBuffer();
        while (in.hasNextLine()){
            String line = in.nextLine() ;
            if (line.length()==0)break;
            sb.append(line +"\n");
        }

        res = splitMsg(sb.toString());
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.format("msg%d:%s",res_i+1,res[res_i]));
        }

    }

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String[] splitMsg(String text) {
        //int MAX_SIZE = 20;//只需要改动此处即可！！！！改错题？？？
        int MAX_SIZE = 1024;

        char[] tempArray =new char[MAX_SIZE];
        int lastParagraphEnd=0,lastSentenceEnd=0 , pos=0,lastTextPos=0;
        ArrayList<String> ret =new ArrayList<>();
        char[] textChars = text.toCharArray() ;
        char[] splited ;
        for (int textpos=0;textpos<textChars.length;) {
            char c = textChars[textpos++];
            tempArray[pos] = c ;
            if (c == '\n'){//段落
                lastParagraphEnd = pos ;
            }else if ('.' == c || '!' == c){//句子
                lastSentenceEnd = pos ;
            }
            pos++ ;
            if (pos==MAX_SIZE){
                int splitPos = lastParagraphEnd>0?lastParagraphEnd:lastSentenceEnd;
                splited = new char[splitPos+1];
                System.arraycopy(tempArray,0,splited,0,splitPos+1);

                ret.add(new String(splited));
                lastParagraphEnd=0;
                lastSentenceEnd=0;
                pos=0;
                textpos = lastTextPos+splitPos+1;
                lastTextPos = textpos ;
            }
        }
        if (pos>0) {
            splited = new char[pos - 1];

            System.arraycopy(tempArray, 0, splited, 0, pos - 1);
            ret.add(new String(splited));
        }
        return ret.toArray(new String[]{}) ;
    }
    /******************************结束写代码******************************/




}
