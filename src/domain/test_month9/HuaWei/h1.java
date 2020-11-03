package domain.test_month9.HuaWei;

import java.util.*;

/**
 * @Author LT
 * @Date 2020/9/26 18:54
 * @Version 1.0
 * @Description
 */
/*
performance
adam,125
andy,110
bill,92
evan,154

organization
araon,abel,adam
araon,abel,andy
araon,jone,bill
araon,jone,evan
eof
*/
public class h1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (!str.equals("performance")){
            return;
        }

        List<String> p_list = new ArrayList<>();
        while (sc.hasNext()){
            String line = sc.nextLine();
            if (!line.equals("organization" )&& line.length() > 0){
                p_list.add(line);
            }else
                break;
        }

        String ssss = sc.nextLine();
        List<String> o_list = new ArrayList<>();
        while (sc.hasNext()){
            String line = sc.nextLine();
            if (line.equals("eof")){
                break;
            }else if (line.length() > 0){
                o_list.add(line);
            }
        }


        for (int i = 0; i < p_list.size(); i++) {
            //System.out.println(p_list.get(i));
        }
        Map<String, Integer> waiBao = new HashMap<>();
        for (int i = 0; i < p_list.size(); i++) {
            //System.out.println(p_list.get(i));
            String[] arr = p_list.get(i).split(",");
            //System.out.println(arr.length);
            waiBao.put(arr[0], Integer.parseInt(arr[1]));
        }


        sc.close();

        Map<String, Integer> zuYuan = new HashMap<>();

        String[][] guanXi = new String[o_list.size()][3];

        //Map<String, List<String>> jinliZuyuan  = new HashMap<>();

        Map<String, Integer> jinLi = new HashMap<>();


        for (int i = 0; i < o_list.size(); i++) {
            //System.out.println(o_list.get(i));
            String[] org = o_list.get(i).split(",");
            //System.out.println(org.length);
            guanXi[i] = org;
            if (zuYuan.containsKey(org[1])){
                zuYuan.put(org[1], zuYuan.get(org[1]) + waiBao.get(org[2]));
            }else {
                zuYuan.put(org[1], waiBao.get(org[2]));
            }

            if (jinLi.containsKey(org[0])){
               // System.out.println(jinLi.get(org[0]) +" "+ waiBao.get(org[2]));
                jinLi.put(org[0], jinLi.get(org[0]) + waiBao.get(org[2]));
            }else {
                jinLi.put(org[0], waiBao.get(org[2]));
            }
        }

        for(String ss: jinLi.keySet()){
            System.out.println(ss +"<" + jinLi.get(ss)+">");
            //if (jinLi.containsKey(ss))
        }

        for(String ss: zuYuan.keySet()){
            System.out.println("-"+ ss +"<"+ zuYuan.get(ss)+">");
            //if (jinLi.containsKey(ss))
        }
        for(String ss: waiBao.keySet()){
            System.out.println("--"+ss +"<"+ waiBao.get(ss)+">");
        }

    }
}
