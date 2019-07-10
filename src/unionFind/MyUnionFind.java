package unionFind;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-07
 * Time : 11:36
 * Description :
 */
public interface MyUnionFind {
    /**
     * number or nodes
     * @return
     */
    int count();

    /**
     * union two nodes
     * @param x
     * @param y
     */
    void union(int x, int y);

    /**
     * find which set a node belongs to.
     * @param index
     * @return
     */
    int find(int index);

    /**
     * if two nodes are connected
     * @param x
     * @param y
     * @return
     */
    boolean connected(int x, int y);
}
