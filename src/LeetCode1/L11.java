package LeetCode1;

public class L11 {
    public int maxArea(int[] height) {
        /**
         * 若向内移动短板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，
         * 因此水槽面积 S(i, j)S(i,j) 可能增大。
         * 若向内移动长板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，
         * 下个水槽的面积一定小于当前水槽面积。
         * “其实可以加一句，无论是移动短板或者长板，
         * 我们都只关注移动后的新短板会不会变长，而每次移动的木板都只有三种情况，
         * 1.比原短板短，则新短板更短。2.与原短板相等或者比原短板长，则新短板不变。
         * 所以，向内移动长板，一定不能使新短板变长。
         */
        int i = 0, j = height.length - 1, res = 0;
        while (i < j){
            res = height[i] < height[j]?
                    Math.max(res,(j - i)*height[i++]):
                    Math.max(res,(j - i)*height[j--]);
        }
        return res;
    }
}
