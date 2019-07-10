package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-06
 * Time : 20:11
 * Description :
 */
public class GraphNode {

    int label;

    List<GraphNode> neighbors;

    public GraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}
