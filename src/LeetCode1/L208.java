package LeetCode1;

public class L208 {
    private boolean is_string = false;
    private L208 next[] = new L208[26];
    /** Initialize your data structure here. */
    public L208() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        L208 root = this;
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i] -'a'] == null)
                root.next[w[i] - 'a'] = new L208();
            root = root.next[w[i] - 'a'];
        }
        root.is_string = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        L208 root = this;
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i] -'a'] == null)
                return false;
            root = root.next[w[i] - 'a'];
        }
        return root.is_string;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        L208 root = this;
        char p[] = prefix.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (root.next[p[i] -'a'] == null)
                return false;
            root = root.next[p[i] - 'a'];
        }
       return true;
    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
