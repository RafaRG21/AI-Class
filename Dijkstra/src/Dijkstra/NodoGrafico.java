package Dijkstra;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NodoGrafico {
    private int x ,y;
    String nombre;
    public static final int d = 70;

    private List<NodoGrafico> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<NodoGrafico, Integer> adjacentNodes = new HashMap<>();

    public NodoGrafico(int x, int y,String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }//constructor


    public void addDestination(NodoGrafico destination, int distance) {
        adjacentNodes.put(destination, distance);
    }



    public void dibujar(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(this.x-d/2,this.y-d/2,d,d);
        g.setColor(Color.BLUE);
        g.drawString(nombre,x,y);
    }//dibujar

    public String getNombre() {
        return nombre;
    }//getNombre

    public void setNombre(String x) {
        this.nombre = x;
    }//setNombre

    public int getX() {
        return x;
    }//getX

    public void setX(int x) {
        this.x = x;
    }//setX

    public int getY() {
        return y;
    }//getY

    public void setY(int y) {
        this.y = y;
    }//setY

    public List<NodoGrafico> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<NodoGrafico> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<NodoGrafico, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<NodoGrafico, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}//NodoGrafico
