package playwithdatastructures.binary_search_tree_06;


import java.util.*;

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

    // 二分搜索树的层序遍历
    private void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.e);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    // 寻找二分搜索树的最小元素
    private E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node minNode = minimum(root);
        return minNode.e;

    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        //最小值在左子树，当最小叶子节点的左子树为null，当且叶子节点就是最小值所在节点
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    private E removeMin() {
        E ret = minimum();
        root = removeMin(root);

        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根

    //原理：递归到一个node节点的左子节点(node.left)，该节点的左子节点(node.left.left)为null，说明已经找到最小值了，
    //将最小值(node.left)的右子节点作为左子节点。
    //第一种case：结果就是把2删除。

    /////////////////
    //      5      //
    //    /   \    //
    //   3    6    //
    //  / \    \   //
    // 2  4     8  //
    /////////////////

    //第二种case:把3删除，把4作为5的左节点

    /////////////////
    //      5      //
    //    /   \    //
    //   3    6    //
    //    \    \   //
    //     4     8  //
    /////////////////
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 寻找二分搜索树的最大元素
    private E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    // 从二分搜索树中删除最大值所在节点, 返回最大值
    private E removeMax() {
        E ret = maximum(root).e;
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    private void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        //待删除节点小，遍历左子树
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {//e.compareTo(node.e) == 0
            //待删除节点的左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //待删除节点的右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //带删除节点的左右子树都不为空的情况
            //找到比待删除节点大的最小子节点，即待删除节点的右子节点的最小节点
            //用这个节点代替待删除节点的位置

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
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
        System.out.println("--------------测试前序遍历------------------");
        bst.preOrder();

        //测试非递归方式前序遍历
        System.out.println("--------------测试非递归方式前序遍历------------------");
        bst.preOrderNR();

        //测试中序遍历
        System.out.println("--------------测试中序遍历------------------");
        bst.inOrder();

        //测试后序遍历
        System.out.println("--------------测试后序遍历------------------");
        bst.postOrder();

        //测试层序遍历
        System.out.println("--------------测试层序遍历------------------");
        bst.levelOrder();

        //5.打印树的深度（根据前序遍历）
        System.out.println("--------------打印树的深度------------------");
        System.out.println(bst.toString());

        //6.Test removeMin
        BST<Integer> bst1 = new BST<>();
        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst1.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums1 = new ArrayList<>();
        while (!bst1.isEmpty()) {
            nums1.add(bst1.removeMin());
        }
        System.out.println(nums1);
        for (int i = 1; i < nums1.size(); i++) {
            if (nums1.get(i - 1) > nums1.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test  completed");

        //7.Test removeMax
        bst1 = new BST<>();
        random = new Random();

        for (int i = 0; i < n; i++) {
            bst1.add(random.nextInt(10000));
        }
        nums1 = new ArrayList<>();
        while (!bst1.isEmpty()) {
            nums1.add(bst1.removeMax());
        }
        System.out.println(nums1);
        for (int i = 1; i < nums1.size(); i++) {
            if (nums1.get(i - 1) < nums1.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax test  completed");

        //8.Test remove
        bst1 = new BST<>();
        random = new Random();
        for (int i = 0; i < n; i++) {
            bst1.add(random.nextInt(n));
        }

        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // order数组中存放[0...n)的所有元素
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        shuffle(order);
        // 乱序删除[0...n)范围里的所有元素
        for (int i = 0; i < n; i++) {
            if (bst1.contains(order[i])) {
                bst1.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst1.size() );
            }
        }
        // 最终整个二分搜索树应该为空
        System.out.println(bst1.size());

        HashMap<Object, Object> map = new HashMap<>();
        HashSet<Object> objects = new HashSet<>();

        String a = "";



    }
    private int b =3;

    private void testFinxal(int a) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(a);
            }
        }).start();
    }

    //打乱数组的顺序
    private static void shuffle(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int pos = (int)Math.random() * (i + 1);
            Object temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
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
