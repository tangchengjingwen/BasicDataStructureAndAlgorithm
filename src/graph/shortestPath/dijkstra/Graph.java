package graph.shortestPath.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-07
 * Time : 13:53
 * Description :
 */
public class Graph {

    int vertices;

    // vertice -->  edge  邻接表
    List<Edge>[] list;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.list = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            list[i] = new ArrayList<>();
        }
    }


    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);

        list[start].add(edge);

        //无向图
        edge = new Edge(end, start, weight);
        list[end].add(edge);
    }
}
