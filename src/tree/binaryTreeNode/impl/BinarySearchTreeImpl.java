package tree.binaryTreeNode.impl;

import tree.binaryTreeNode.MyBinarySearchTree;
import tree.binaryTreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-08
 * Time : 21:07
 * Description :
 */
public class BinarySearchTreeImpl implements MyBinarySearchTree {

    private TreeNode root;

    private int size;

    public BinarySearchTreeImpl() {
        root = null;
        size = 0;
    }

    @Override
    public void add(int val) {
        root = add(root, val);
    }

    @Override
    public void remove(int val) {
        root = remove(root, val);
    }

    @Override
    public boolean contains(int val) {
        return contains(root, val);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private TreeNode add(TreeNode node, int val) {
        if (node == null) {
            size++;
            return new TreeNode(val);
        }
        if (node.val == val) {
            throw new IllegalArgumentException("node already exist");
        }
        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        return node;
    }

    /**
     * time : avg : O(logn)   worst case : O(n)
     * @param node
     * @param val
     * @return
     */
    private boolean contains(TreeNode node, int val) {
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

    private TreeNode remove(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val > val) {
            node.left = remove(node.left, val);
        } else if (node.val < val) {
            node.right = remove(node.right, val);
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }
            //找到右子树的最小值上移
            TreeNode minNode = findMin(node.right);
            node.val = minNode.val;
            node.right = remove(node.right, node.val);
            size--;
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        if (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void print() {

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("第" + (level + 1) + "层： ");
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
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

    public static void main(String[] args) {
        BinarySearchTreeImpl binarySearchTree = new BinarySearchTreeImpl();
        binarySearchTree.add(8);
        binarySearchTree.add(5);
        binarySearchTree.add(6);
        binarySearchTree.add(3);
        binarySearchTree.add(10);
        binarySearchTree.add(9);
        binarySearchTree.add(11);

        binarySearchTree.print();

        System.out.println(binarySearchTree.contains(6));
        System.out.println(binarySearchTree.contains(0));

        binarySearchTree.remove(8);
        binarySearchTree.print();


    }
}
