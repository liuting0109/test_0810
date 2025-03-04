package LeetCode;

import java.util.*;

/**
 * 字母异位词分组
 */
public class L49 {
    public static void main(String[] args) {

        List<String> aa = new ArrayList();
        aa.add("a1");
        aa.add("a2");
        //todo 这俩有啥区别
//        System.out.println(new ArrayList<>(aa));// 使用带泛型的构造函数
//        System.out.println(new ArrayList(aa));// 使用不带泛型的构造函数，可能会看到原始类型警告

        //"eat", "tea", "tan", "ate", "nat", "bat"
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }

    //排序
    // 时间复杂度：O(nklogk)其中 n 是 strs 中的字符串的数量，
    // k 是 strs 中的字符串的的最大长度。需要遍历 n 个字符串，
    // 对于每个字符串，需要 O(klogk) 的时间进行排序以及 O(1) 的时间更新哈希表，因此总时间复杂度是 O(nklogk)。
    //空间复杂度：O(nk)，其中 n 是 strs 中的字符串的数量，k 是 strs 中的字符串的的最大长度。需要用哈希表存储全部字符串
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        //int[] count = new int[26];//26个字母
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
//        return new ArrayList<>(ans.values());//错误
        //会报错的原因是 ans.values() 返回的是一个 Collection 类型，而 ArrayList<>(...) 需要一个具体类型（如 List<String>）。
        //由于 Map<String, List> 中的 List 没有指定具体的泛型类型，这就导致了类型不匹配的问题。
        return new ArrayList(ans.values());
    }
}
