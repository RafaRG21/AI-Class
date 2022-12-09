package Dijkstra;

import javax.swing.*;
import java.util.*;

public class Dijkstra {
    static List<NodoGrafico> Camino = new ArrayList<NodoGrafico>();
    public static Graph calculateShortestPathFromSource(Graph graph, NodoGrafico source,NodoGrafico dest) {
        source.setDistance(0);

        Set<NodoGrafico> settledNodes = new HashSet<>();
        Set<NodoGrafico> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            NodoGrafico currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<NodoGrafico, Integer> adjacencyPair :
                    currentNode.getAdjacentNodes().entrySet()) {
                NodoGrafico adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
            if(currentNode.getNombre().equals(dest.getNombre())) {
                Camino = currentNode.getShortestPath();
                Camino.add(currentNode);
            }

        }
        return graph;
    }

    private static NodoGrafico getLowestDistanceNode(Set<NodoGrafico> unsettledNodes) {
        NodoGrafico lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (NodoGrafico node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void CalculateMinimumDistance(NodoGrafico evaluationNode,
                                                 Integer edgeWeigh, NodoGrafico sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<NodoGrafico> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Algoritmo de Kruskal 20110374");
        window.add(new Lienzo());
        window.setSize(700,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}