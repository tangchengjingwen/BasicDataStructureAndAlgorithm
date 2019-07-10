package unionFind.impl;

import unionFind.MyUnionFind;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-07
 * Time : 11:37
 * Description :
 */
public class QuickFindImpl implements MyUnionFind {

    /**
     * number of nodes
     */
    int count;

    /**
     * nodes
     */
    private int[] id;

    public QuickFindImpl(int count) {
        this.count = count;
        id = new int[count];

        for (int i = 0; i < id.length; i++) {
            // 每个节点指向自己
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }

    /**
     * o(n)
     * @param x
     * @param y
     */
    @Override
    public void union(int x, int y) {
        int A = find(x);
        int B = find(y);

        if (A == B) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == A) {
                id[i] = B;
            }
        }

    }

    /**
     * o(1)
     * @param index
     * @return
     */
    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Invalid input");
        }
        return id[index];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
