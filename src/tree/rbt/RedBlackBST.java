package tree.rbt;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-09
 * Time : 21:05
 * Description :
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {


    // true means red, false means black
    private static final boolean RED = true;

    private static final boolean BLCAK = false;
    private Node root;

    private class Node {

        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }

    }

    public RedBlackBST() {

    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("input is null");
        }
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        while (root != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0){
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }
}
