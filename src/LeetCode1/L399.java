package LeetCode1;

import java.util.HashMap;
import java.util.List;

public class L399 {//并查集
    /**
     * key : 当前节点
     * value : 其父节点
     */
    private HashMap<String,String> parent=new HashMap<>();
    /**
     * key : 当前节点
     * value : 父节点/当前节点
     */
    private HashMap<String,Double> quotient=new HashMap<>();

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation=equations.get(i);
            merge(equation.get(0),equation.get(1),values[i]);
        }
        double[] res=new double[queries.size()];
        int index=0;
        for (List<String> query:queries) {
            String a=find(query.get(0));
            String b=find(query.get(1));
            System.out.println(a+" "+b);
            if (!parent.containsKey(query.get(0)) || !parent.containsKey(query.get(1)) || !a.equals(b)) {
                res[index++]=-1;
            }else{
                //没有路劲压缩,需要遍历整个路劲求积
                res[index++]=cal(query.get(0))/cal(query.get(1));
            }
        }
        return res;
    }

    public void merge(String a,String b,Double value){
        init(a);init(b);
        String fa=find(a); // a/fa=val[a], b/fb=val[b]
        String fb=find(b);
        if (fa.equals(fb)) {
            return;
        }
        parent.put(fa,fb);
        quotient.put(fa,value*(cal(b)/cal(a))); //cal(a)和cal(b)代表a和b到根节点的总值
    }

    /**
     * 循环的pm函数,计算当前节点到根节点的路径乘积
     */
    public double cal(String index){
        double res=quotient.get(index);
        while(parent.get(index)!=index){
            index=parent.get(index);
            res*=quotient.get(index);
        }
        return res;
    }

    /**
     * 找到x的根节点//不带路径压缩
     */
    public String find(String p){
        while (parent.get(p)!=p) {
            p=parent.get(p);
        }
        return p;
    }


    private void init(String x) {
        if (!parent.containsKey(x)){
            parent.put(x,x);
            quotient.put(x, 1.0);
        }
    }
}
