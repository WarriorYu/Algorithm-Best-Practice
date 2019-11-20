package playwithdatastructures.trie_10;

import java.util.TreeMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/20
 * Describe : Trie树
 */
public class Trie {

    public class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        //默认的构造，一般不是字符串的结尾
        public Node() {
            this(false);
        }
    }

    public Node root;
    public int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    //获取Trie中的字符串数量
    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                //没有这个字符，添加上
                cur.next.put(c, new Node());
            }
            //更新节点
            cur = cur.next.get(c);
        }
        //如果以前这个节点不代表单词的结尾
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

}
