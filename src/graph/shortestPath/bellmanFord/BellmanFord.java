package graph.shortestPath.bellmanFord;

import java.util.Arrays;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-07
 * Time : 20:00
 * Description :
 */
public class BellmanFord {

    public void bellmanFord(Graph graph) {
        int[] minDist = new int[graph.vertices];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        for (int i = 1; i < graph.vertices; i++) {
            for (int j = 0; j < graph.allEdges.size(); j++) {
                Edge edge = graph.allEdges.get(j);
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;
                if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                    minDist[end] = minDist[start] + weight;
                }
            }

        }

        for (int j = 0; j < graph.allEdges.size(); j++) {
            Edge edge = graph.allEdges.get(j);
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            if (minDist[start] != Integer.MAX_VALUE && minDist[start] + weight < minDist[end]) {
                System.out.println("负权环");
            }
        }

        print(minDist);
    }

    public  void print(int[] minDists) {
        System.out.println("BellmanFord: ");
        for (int i = 0; i < minDists.length; i++) {
            System.out.println("source vertex 0 : to vertex" + i + " minDist : " + minDists[i]);
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(2, 1, 1);
        graph.addEdge(3, 2, -2);
        graph.addEdge(1, 3, 2);
        graph.addEdge(4, 3, -1);
        graph.addEdge(4, 1, -4);
        graph.addEdge(5, 4, 1);
        graph.addEdge(0, 5, 8);
        graph.addEdge(0, 1, 10);
        BellmanFord bellmanFord = new BellmanFord();

        bellmanFord.bellmanFord(graph);
    }
}
