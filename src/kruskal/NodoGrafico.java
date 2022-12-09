package kruskal;

import java.awt.*;

public class NodoGrafico {
    private int x ,y;
    String nombre;
    public static final int d = 70;

    public NodoGrafico(int x, int y,String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }//constructor

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
}//NodoGrafico
