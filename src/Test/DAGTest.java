package Test;

import java.util.ArrayList;
import java.util.List;

public class DAGTest {
    static Graph graph;

    public static void main(String[] args) {

    }

    private static void init() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("A", "C"));
        nodes.add(new Node("C", "D"));
        nodes.add(new Node("C", "E"));
        nodes.add(new Node("B", "D"));
        nodes.add(new Node("B", "E"));
        nodes.add(new Node("B", "F"));
        nodes.add(new Node("F", "G"));
        nodes.add(new Node("G", "H"));
        graph = new Graph(nodes);
    }

}

class Graph {
    List<Node> nodes = new ArrayList<>();

    Graph(List<Node> nodes) {
        this.nodes.addAll(nodes);
    }
}

class Node {
    private String vertex;
    private String target;

    Node(String vertex, String target) {
        this.vertex = vertex;
        this.target = target;
    }

    public String getVertex() {
        return vertex;
    }

    public void setVertex(String vertex) {
        this.vertex = vertex;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}

class CommonAncestor {
    private Graph graph;

    CommonAncestor(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void process(String startNode, String targetNode1, String targetNode2) {
        Graph graph = getSubGraph(startNode, targetNode1, targetNode2);
    }

    private Graph getSubGraph(String startNode, String targetNode1, String targetNode2) {
        List<Node> nodes = this.getGraph().nodes;

        return null;
    }
}