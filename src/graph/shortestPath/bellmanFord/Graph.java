package graph.shortestPath.bellmanFord;

import java.util.ArrayList;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-07
 * Time : 14:38
 * Description :
 */
public class Graph {

    int vertices;

    ArrayList<Edge> allEdges;

    public Graph(int vertices) {
        this.vertices = vertices;
        allEdges = new ArrayList<>();
    }

    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        allEdges.add(edge);
    }

}
