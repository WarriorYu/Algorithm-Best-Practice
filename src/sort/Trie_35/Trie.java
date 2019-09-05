package sort.Trie_35;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/9/5
 * Describe :
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    /**
     * 往 Trie 树中插入一个字符串
     *
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            //如果index对应的指针是null，新建子节点，插入
            if (p.children[index] == null) {
                p.children[index] = new TrieNode(text[i]);
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在Trie树中查找一个字符串
     *
     * @param pattern
     */
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }


    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
