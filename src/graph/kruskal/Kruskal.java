package graph.kruskal;

import unionFind.impl.PathCompressionImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-07
 * Time : 14:41
 * Description :
 */
public class Kruskal {


    public void kruskalMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        priorityQueue.addAll(graph.allEdges);

        List<Edge> res = new ArrayList<>();
        PathCompressionImpl unionFind = new PathCompressionImpl(graph.vertices);
        int components = graph.vertices;

        while (!priorityQueue.isEmpty()) {
            if (components <= 1) {
                break;
            }
            Edge edge = priorityQueue.poll();
            if (unionFind.connected(edge.start, edge.end)) {
                continue;
            }
            unionFind.union(edge.start, edge.end);
            components--;
            res.add(edge);
        }

        print(res);
    }

    public void print(List<Edge> list) {
        int total = 0;
        System.out.println("MST: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Edge:" + list.get(i).start + " - " + list.get(i).end + " minDist : " + list.get(i).weight);
            total += list.get(i).weight;
        }
        System.out.println("Total :" + total);
    }


    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(0,1, 6);
        graph.addEdge(0,2, 1);
        graph.addEdge(0,3, 5);
        graph.addEdge(1,2, 5);
        graph.addEdge(1,4, 3);
        graph.addEdge(2,4, 6);
        graph.addEdge(2,3, 5);
        graph.addEdge(2,5, 4);
        graph.addEdge(3,5, 2);
        graph.addEdge(4,5, 6);

        Kruskal kruskal = new Kruskal();
        kruskal.kruskalMST(graph);
    }
}


