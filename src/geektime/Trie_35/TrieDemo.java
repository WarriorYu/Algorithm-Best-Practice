package geektime.Trie_35;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/9/5
 * Describe :
 */
public class TrieDemo {
    //存储无意义字符
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd".toCharArray());
        trie.insert("aaaa".toCharArray());
        trie.insert("rtrtuur".toCharArray());
        trie.insert("abc".toCharArray());
        System.out.println(trie.find("iii".toCharArray()));
        System.out.println(trie.find("abc".toCharArray()));

    }
}
