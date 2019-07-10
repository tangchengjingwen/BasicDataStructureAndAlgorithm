package tree.avl.impl;

import tree.avl.AVLNode;
import tree.avl.MyAVLTree;
import tree.traversal.Inorder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-08
 * Time : 21:57
 * Description :
 */
public class AVLTreeImpl implements MyAVLTree {

    private AVLNode root;

    private int size;

    public AVLTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    private AVLNode remove(AVLNode node, int val) {
        if (node == null) {
            return null;
        }

        AVLNode changeNode;

        if (node.val > val) {
            node.left = remove(node.left, val);
            changeNode = node;
        } else if (node.val < val) {
            node.right = remove(node.right, val);
            changeNode = node;
        } else {
            if (node.left == null) {
                size--;
                changeNode = node.right;
            } else if (node.right == null) {
                size--;
                changeNode = node.left;
            } else {
                //找到右子树的最小值上移
                AVLNode minNode = findMin(node.right);
                node.val = minNode.val;
                node.right = remove(node.right, node.val);
                changeNode = node;
            }
        }
        if (changeNode == null) {
            return null;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        /**
         * 计算平衡因子，重新排列avl
         * 四种情况  LL/RR/LR/RL
         */
        int balanceFactor = getBalanceFactor(changeNode);

        // LL
        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) >= 0) {
            return rightRotate(changeNode);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) <= 0) {
            return leftRotate(changeNode);
        }

        if (balanceFactor > 1 && getBalanceFactor(changeNode.left) < 0) {
            changeNode.left = leftRotate(changeNode.left);
            return rightRotate(changeNode);
        }

        if (balanceFactor < -1 && getBalanceFactor(changeNode.right) > 0) {
            changeNode.right = rightRotate(changeNode.right);
            return leftRotate(changeNode);
        }

        return changeNode;
    }

    private AVLNode findMin(AVLNode node) {
        if (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(AVLNode node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        }
        if (node.val > val) {
            return contains(node.left, val);
        } else {
            return contains(node.right, val);
        }
    }

    private AVLNode add(AVLNode node, int val) {
        if (node == null) {
            size++;
            return new AVLNode(val);
        }
        if (node.val == val) {
            throw new IllegalArgumentException("node already exist");
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        /**
         * 计算平衡因子，重新排列avl
         * 四种情况  LL/RR/LR/RL
         */
        int balanceFactor = getBalanceFactor(node);

        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


    private int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private boolean isBST(AVLNode node) {
        if (node == null) {
            return true;
        }
        return isBSTHelper(node, null, null);
    }

    private boolean isBSTHelper(AVLNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return isBSTHelper(node.left, min, node.val) && isBSTHelper(node.right, node.val, max);
    }

    private boolean isBalanced(AVLNode node) {
        if (node == null) {
            return true;
        }
        return isBalancedHelp(node) != -1;
    }

    private int isBalancedHelp(AVLNode node) {
        if (node == null) {
            return 0;
        }
        int l = isBalancedHelp(node.left);
        int r = isBalancedHelp(node.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

    private int getBalanceFactor(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private AVLNode rightRotate(AVLNode x) {
        AVLNode y = x.left;
        AVLNode c = y.right;

        y.right = x;
        x.left = c;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode c = y.left;

        y.left = x;
        x.right = c;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private void print() {

        int level = 0;
        Queue<AVLNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("第" + (level + 1) + "层： ");
            for (int i = 0; i < size; i++) {
                AVLNode cur = queue.poll();
                System.out.print(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                    System.out.print(" 的左孩子：" + cur.left.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    System.out.print(" 右孩子：" + cur.right.val);
                }
                System.out.println();
            }
            System.out.println();
            level++;
        }
    }

}
