package domain.test_month9.Freewheel;


import java.util.ArrayList;

/**
 * @Author LT
 * @Date 2020/9/19 17:05
 * @Version 1.0
 * @Description
 */
public class fw1 {
    public ArrayList<ArrayList<Integer>> hashJoin (ArrayList<Integer> setA, ArrayList<Integer> setB) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < setA.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(setA.get(i));
            temp.add(i);
            //temp.add();
            res.add(temp);
        }
        for (int i = 0; i < setB.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(setB.get(i));
            temp.add(i);
            //temp.add();
            res.add(temp);
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> sortMergeJoin (ArrayList<Integer> setA, ArrayList<Integer> setB) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < setB.size(); i++) {
            for (int j = 0; j < setA.size(); j++) {
                if (setB.get(i) == setA.get(j)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    //temp.add();
                    res.add(temp);
                }
            }
        }

        return res;
    }

    public int minCost (int n, int[] cuePoints) {
        // write code here

        int res = 0;
        for (int i = 0; i < cuePoints.length; i++) {
            res += cuePoints[i];
        }
        return res;
    }
}
