package kruskal;

import javax.swing.*;

public class Grafo {
    public static void main(String[] args) {
        JFrame window = new JFrame("Algoritmo de Kruskal 20110374");
        window.add(new Lienzo());
        window.setSize(700,700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }//main
}//Grafo
