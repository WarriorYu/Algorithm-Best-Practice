package playwithdatastructures.trie_10;

import java.util.TreeMap;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/22
 * Describe : Leetcode 211
 */
public class WordDictionary {
    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();

    }

    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        private Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        private Node() {
            this(false);
        }
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node cur, String word, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (char charKey : cur.next.keySet()) {
                if (match(cur.next.get(charKey), word, index + 1)) {
                    return true;
                }
            }
            return false;

        } else {
            //如果是字母
            if (cur.next.get(c) == null) {
                return false;
            }
            return match(cur.next.get(c), word, index + 1);
        }
    }
}
