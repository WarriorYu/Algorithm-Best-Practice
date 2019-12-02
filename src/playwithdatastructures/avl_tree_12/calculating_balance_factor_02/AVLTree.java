package playwithdatastructures.avl_tree_12.calculating_balance_factor_02;

import playwithdatastructures.set_and_map_07.linkedlistmap_06.Map;
import playwithdatastructures.trie_10.FileOperation;

import java.util.ArrayList;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/11/28
 * Describe : AVLTree:解决二分搜索树退化成链表，具有二分搜索树所有的特性，并且一个节点的左右子节点的高度差不会超过1.
 */
public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;//树的高度

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            //添加节点，会递归到底，所以添加的节点的height是1
            height = 1;

        }
    }

    //获取节点的高度
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    //计算平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //判断是否是二分搜索树。二分搜索树中序遍历后，是顺序递增的，根据这个特点判断是否是二分搜索树
    public boolean isBST() {

        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4

    private Node leftRotate(Node y) {

        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }


    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        //更新height:1+左右节点height的最大值
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        //计算平衡因子：当平衡因子大于1，就不是avl树
        int balanceFactor = getBalanceFactor(node);

        //维持平衡
        //LL:添加Node到左子树的左子树导致的不平衡
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        //RR:添加Node到右子树的右子树导致的不平衡
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        //LR:添加Node到左子树的右子树导致的不平衡
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //RL:添加Node到右子树的左子树导致的不平衡
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }


    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        Node retNode;
        //待删除节点小，遍历左子树
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            // return node;
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            // return node;
            retNode = node;
        } else {//e.compareTo(node.e) == 0
            //待删除节点的左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                //return rightNode;
                retNode = rightNode;
            } else if (node.right == null) {
                //待删除节点的右子树为空的情况

                Node leftNode = node.left;
                node.left = null;
                size--;
                // return leftNode;
                retNode = leftNode;
            } else {

                //带删除节点的左右子树都不为空的情况
                //找到比待删除节点大的最小子节点，即待删除节点的右子节点的最小节点
                //用这个节点代替待删除节点的位置

                Node successor = minimum(node.right);
//                successor.right = removeMin(node.right);
                successor.right = remove(node.right,successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                // return successor;
                retNode = successor;
            }
        }
        if (retNode == null) {
            return null;
        }

        //更新height:1+左右节点height的最大值
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        //计算平衡因子：当平衡因子大于1，就不是avl树
        int balanceFactor = getBalanceFactor(retNode);

        //维持平衡
        //LL:添加retNode到左子树的左子树导致的不平衡
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }

        //RR:添加retNode到右子树的右子树导致的不平衡
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        //LR:添加retNode到左子树的右子树导致的不平衡
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        //RL:添加retNode到右子树的左子树导致的不平衡
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

/*    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }*/


    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        //最小值在左子树，当最小叶子节点的左子树为null，当且叶子节点就是最小值所在节点
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }


    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " dosn't exsit ");
        }
        node.value = newValue;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());

            for(String word: words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced())
                    throw new RuntimeException();
            }
        }

        System.out.println();
    }
}
