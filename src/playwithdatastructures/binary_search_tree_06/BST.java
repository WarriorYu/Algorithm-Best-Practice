package playwithdatastructures.binary_search_tree_06;


import java.util.LinkedList;
import java.util.Stack;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2019/10/14
 * Describe : 二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加元素e,递归算法
/*    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        }else{
            add(root,e);
        }
    }

    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
            //要插入的元素小于根节点，并且根节点的左子树为null
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        //如果左右子树不为null
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right,e);
        }
    }*/

    //向二分搜索树中添加元素e
    public void add(E e) {
        root = add(root, e);
    }


    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树前序遍历，非递归方式
    public void preOrderNR() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        //根节点不为空，推入栈
        stack.push(root);
        //如果栈不为空，继续pop
        while (!stack.empty()) {
            //出栈
            Node cur = stack.pop();
            System.out.println(cur.e);
            //每次出栈一个Node,都把该节点的左右节点以先右后左的顺序入栈，因为栈是先进后出，所有先把右节点入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    //中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        genetateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void genetateBSTString(Node node, int depth, StringBuilder builder) {
        if (node == null) {
            builder.append(generateDepthString(depth) + "null\n");
            return;
        }
        builder.append(generateDepthString(depth) + node.e + "\n");
        genetateBSTString(node.left, depth + 1, builder);
        genetateBSTString(node.right, depth + 1, builder);

    }

    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("--");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        //1.测试添加
        BST<Integer> bst = new BST<>();
        int[] nums = new int[]{5, 3, 6, 8, 4, 2};
        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
        //2.测试包含
        System.out.println(bst.contains(3));
        System.out.println(bst.contains(10));
        System.out.println(bst.contains(30));

        //3.测试BST类
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println("测试摩尔斯" + uniqueMorseRepresentations(words));

        //4.测试前序遍历
        System.out.println("--------------测试前序遍历------------------" );
        bst.preOrder();

        //测试非递归方式前序遍历
        System.out.println("--------------测试非递归方式前序遍历------------------" );
        bst.preOrderNR();

        //测试中序遍历
        System.out.println("--------------测试中序遍历------------------" );
        bst.inOrder();

        //测试后序遍历
        System.out.println("--------------测试后序遍历------------------" );
        bst.postOrder();

        //5.打印树的深度（根据前序遍历）
        System.out.println("--------------打印树的深度------------------" );
        System.out.println(bst.toString());

    }

    //https://leetcode.com/problems/unique-morse-code-words/description/
    public static int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        BST<String> bst = new BST<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
                res.append(codes[word.charAt(i) - 'a']);
            bst.add(res.toString());
        }
        return bst.size();
    }

}
