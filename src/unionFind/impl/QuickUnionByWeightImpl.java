package unionFind.impl;

import unionFind.MyUnionFind;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-07
 * Time : 11:37
 * Description :  孩子结点指向父亲结点
 */
public class QuickUnionByWeightImpl implements MyUnionFind {

    /**
     * number of nodes
     */
    int count;

    /**
     * nodes
     */
    private int[] parents;

    /**
     * weight
     */
    private int[] size;

    public QuickUnionByWeightImpl(int count) {
        this.count = count;
        parents = new int[count];
        this.size = new int[count];

        for (int i = 0; i < parents.length; i++) {
            // 每个节点指向自己
            parents[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    /**
     * o(h)
     * @param x
     * @param y
     */
    @Override
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }
//        for (int i = 0; i < parents.length; i++) {
//            if (parents[i] == xRoot) {
//                parents[i] = yRoot;
//            }
//        }
        if (size[xRoot] < size[yRoot]) {
            parents[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else {
            parents[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
    }

    /**
     * o(h)
     * @param index
     * @return
     */
    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Invalid input");
        }
        while (index != parents[index]) {
            index = parents[index];
        }
        return parents[index];
    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
