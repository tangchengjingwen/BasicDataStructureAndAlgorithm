package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 21:06
 * Description :
 */
public class BFS {

    public static void bfs(GraphNode graphNode) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while (!queue.isEmpty()) {
            GraphNode curNode = queue.poll();
            System.out.println(curNode.label);
            for (GraphNode neighbor : curNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    /**
     * bfs 按层来遍历
     * @param graphNode
     */
    public static void bfs2(GraphNode graphNode) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphNode curNode = queue.poll();
                System.out.println(curNode.label);
                for (GraphNode neighbor : curNode.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            System.out.println();
        }
    }


    public static void bfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer vertex = queue.poll();
                    System.out.println(vertex);
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (matrix[vertex][j] == 1 && visited[j] == 0) {
                            visited[j] = 1;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
    }

    public static void bfsMatrixIteration2(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        Integer vertex = queue.poll();
                        System.out.println(vertex);
                        for (int j = 0; j < matrix[0].length; j++) {
                            if (matrix[vertex][j] == 1 && visited[j] == 0) {
                                visited[j] = 1;
                                queue.offer(j);
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
    }



    public static void main(String[] args) {

        GraphNode a = new GraphNode(0);
        GraphNode b = new GraphNode(1);
        GraphNode c = new GraphNode(2);
        GraphNode d = new GraphNode(3);
        GraphNode e = new GraphNode(4);
        GraphNode f = new GraphNode(5);

        a.neighbors.add(b);
        a.neighbors.add(d);
        a.neighbors.add(f);

        b.neighbors.add(a);
        b.neighbors.add(e);
        b.neighbors.add(c);

        c.neighbors.add(b);
        c.neighbors.add(e);

        d.neighbors.add(a);
        d.neighbors.add(e);

        e.neighbors.add(d);
        e.neighbors.add(b);
        e.neighbors.add(c);

        f.neighbors.add(a);

        int[][] matrix = new int[][] {
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0}
        };

        bfs(a);
        System.out.println("=====================================");
        bfs2(a);
        System.out.println("=====================================");
        bfsMatrixIteration(matrix);

        System.out.println("=====================================");
        bfsMatrixIteration2(matrix);

    }
}
