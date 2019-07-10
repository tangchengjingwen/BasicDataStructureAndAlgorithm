package tree.avl;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-08
 * Time : 21:55
 * Description :
 */
public class AVLNode {

    public int val;

    public int height;

    public AVLNode left;

    public AVLNode right;

    public AVLNode(int val) {
        this.val = val;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

}
