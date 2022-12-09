package Dijkstra;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AristaGrafico {
    private int x1,y1,x2,y2;
    private String dest, name, src;
    private int peso;
    private List<AristaGrafico> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<AristaGrafico, Integer> adjacentNodes = new HashMap<>();


    public AristaGrafico(String name) {
        this.name = name;
    }//constructor
    public AristaGrafico(int x1, int y1, int x2, int y2, int peso, String src, String dest ){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.peso = peso;
        this.src = src;
        this.dest = dest;
    }//constructor
    public void addDestination(AristaGrafico dest, int peso) {
        adjacentNodes.put(dest, peso);
    }
    public void dibujarArista(Graphics g,Color c){
        g.setColor(c);
        g.drawLine(x1,y1,x2,y2);
        g.setColor(Color.RED);
        if (x1 > x2 && y1 > y2)
            g.drawString(String.valueOf(peso),x1 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));
        if (x1 < x2 && y1 < y2)
            g.drawString(String.valueOf(peso),x2 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));
        if (x1 < x2 && y1 > y2)
            g.drawString(String.valueOf(peso),x2 - Math.abs((x1 - x2)/2), y1 - Math.abs((y1 - y2)/2));
        if (x1 > x2 && y1 < y2)
            g.drawString(String.valueOf(peso),x1 - Math.abs((x1 - x2)/2), y2 - Math.abs((y1 - y2)/2));


    }//dibujarArista

    public int getX1() {
        return x1;
    }//getX1

    public void setX1(int x1) {
        this.x1 = x1;
    }//setX1

    public int getY1() {
        return y1;
    }//getY1

    public void setY1(int y1) {
        this.y1 = y1;
    }//setY1

    public int getX2() {
        return x2;
    }//getX2

    public void setX2(int x2) {
        this.x2 = x2;
    }//setX2

    public int getY2() {
        return y2;
    }//getY2

    public void setY2(int y2) {
        this.y2 = y2;
    }//setY2
    public int getPeso() {
        return peso;
    }//getPeso

    public void setPeso(int peso) {
        this.peso = peso;
    }//setPeso

    public String getDest() {
        return dest;
    }//getDest

    public void setDest(String dest) {
        this.dest = dest;
    }//setDest

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AristaGrafico> getShortestPath() {
        return shortestPath;
    }



    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<AristaGrafico, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }



    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setShortestPath(List<AristaGrafico> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public void setAdjacentNodes(Map<AristaGrafico, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}//AristaGrafico
