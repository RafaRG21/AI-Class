package Dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<NodoGrafico> nodes = new HashSet<>();

    public void addNode(NodoGrafico nodeA) {
        nodes.add(nodeA);
    }

    public Set<NodoGrafico> getNodes() {
        return nodes;
    }

    public void setNodes(Set<NodoGrafico> nodes) {
        this.nodes = nodes;
    }

    // getters and setters
}//Graph