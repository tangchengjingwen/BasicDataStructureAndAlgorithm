package graph.topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-07
 * Time : 11:10
 * Description :
 */
public class BfsTopologicalSort {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] res = new int[numCourses];
        int courseCount = 0;
        /**
         * 计算入度
         */
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        /**
         * 入度为0的直接加入queue
         */
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[courseCount++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();  // indegree is zero
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        res[courseCount++] = pair[0];
                    }
                }
            }

        }

        return (courseCount == numCourses) ? res : new int[0];
    }
}
