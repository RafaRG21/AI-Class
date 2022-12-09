package Dijkstra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Lienzo extends JPanel implements MouseListener, MouseMotionListener {

    private ArrayList<NodoGrafico> arrayNodosG;
    private ArrayList<NodoGrafico> nodos;
    private ArrayList<NodoGrafico> nodesPath;
    private ArrayList<AristaGrafico> aristaGraficos;
    private ArrayList<AristaGrafico> aristaPath;


    private Point p1, p2;
    private NodoGrafico nodoMover;
    private boolean buttonPressed = false;
    private int iNodo;
    Graph graph = new Graph();
    JButton obtainAEM;
    String src, dest;
    List<AristaGrafico> kruskal;



    public Lienzo(){
        this.arrayNodosG = new ArrayList<>();
        this.aristaGraficos = new ArrayList<>();
        this.aristaPath = new ArrayList<>();
        this.nodesPath = new ArrayList<>();
        this.nodos = new ArrayList<>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
         this.obtainAEM = new JButton("Correr Dijkstra");
        this.add(obtainAEM);
        this.obtainAEM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String source,destination;
                int weight = 0;
                int src=0, dest=0, cont=0;
                source = JOptionPane.showInputDialog("Ingresar nodo origen:");
                destination = JOptionPane.showInputDialog("Ingresar nodo destino");
                for (NodoGrafico nodo : nodos){
                    if (nodo.getNombre().equals(source)) {
                        src = cont;
                    }
                    if (nodo.getNombre().equals(destination)) {
                        dest = cont;
                    }
                    cont++;
                }
                graph = Dijkstra.calculateShortestPathFromSource(graph,nodos.get(src),nodos.get(dest));
                System.out.println("Src: "+src+" "+nodos.get(src)+" Dest: "+dest+" "+nodos.get(dest));
                System.out.println("PATH:");
                nodesPath.addAll(Dijkstra.Camino);
                for (NodoGrafico nodo : nodesPath){
                    System.out.println(nodo.nombre);

                }
                System.out.println("PATH arista:");

                for(int i=0;i<nodesPath.size()-1;i++){
                    for (AristaGrafico arista : aristaGraficos){
                        if (arista.getSrc().equals(nodesPath.get(i).getNombre()) && arista.getDest().equals(nodesPath.get(i+1).getNombre())){
                            aristaPath.add(arista);
                            weight += arista.getPeso();
                            System.out.println(arista.getSrc()+ " - "+arista.getDest() );
                        }
                        else if (arista.getX1()==nodesPath.get(i+1).getX() && arista.getY1()==nodesPath.get(i+1).getY() && arista.getX2()==nodesPath.get(i).getX() && arista.getY2()==nodesPath.get(i).getY()){
                            System.out.println(arista.getSrc()+ " - "+arista.getDest() );
                            aristaPath.add(arista);
                        }
                    }//for arista
                }//for nodo
                System.out.println("Arista path size: "+aristaPath.size()+" Node path size: "+nodesPath.size());

                buttonPressed = true;
                repaint();

                String mensaje = "Camino más corto:\n";
                for (NodoGrafico nodo : nodesPath)
                    mensaje += nodo.nombre + " - ";
                mensaje += "\n"+"Costo del camino: " + String.valueOf(weight);
                weight = 0;
                JOptionPane.showMessageDialog(Lienzo.this, mensaje, "Algoritmo ejecutado", JOptionPane.INFORMATION_MESSAGE);


            }
        });//addActionListener

    }//constructor


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (NodoGrafico nodoGrafico : arrayNodosG)
            nodoGrafico.dibujar(g);

        for (AristaGrafico arista : aristaGraficos)
            arista.dibujarArista(g,Color.BLACK);
        if(buttonPressed){
            for (AristaGrafico arista : aristaPath)
                arista.dibujarArista(g,Color.green);
            buttonPressed = false;
            aristaPath.clear();
            nodesPath.clear();
        }

    }//paint

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            String nombreNodo = JOptionPane.showInputDialog("Ingresar nombre del nodo:");
            this.arrayNodosG.add(new NodoGrafico(e.getX(),e.getY(),nombreNodo));
            this.nodos.add(new NodoGrafico(e.getX(),e.getY(),nombreNodo));
           repaint();
        }

        if (e.getButton() == MouseEvent.BUTTON3){
            for (NodoGrafico nodo : arrayNodosG){
                if (new Rectangle(nodo.getX() - NodoGrafico.d/2,nodo.getY() - NodoGrafico.d/2,NodoGrafico.d,NodoGrafico.d).contains(e.getPoint())){
                    if (p1 == null){
                        p1 = new Point(nodo.getX(),nodo.getY());
                        src = nodo.getNombre();
                    }else{
                        p2 = new Point(nodo.getX(),nodo.getY());
                        dest = nodo.getNombre();
                        String input;
                        int peso = 0;
                        do {
                            input = JOptionPane.showInputDialog("Ingresar peso de la arista:");
                            if (input.matches("^[0-9]*$")) {
                                peso = Integer.parseInt(input);
                               this.aristaGraficos.add(new AristaGrafico(p1.x,p1.y,p2.x,p2.y,peso,src,dest));
                                System.out.println("Source: "+src+" Dest: "+dest);
                                int posSrc=0, posDest=0,i = 0;
                                for (NodoGrafico nodeAux : nodos){
                                    if(nodeAux.getNombre().equals(src))
                                        posSrc = i;
                                    if(nodeAux.getNombre().equals(dest))
                                        posDest = i;
                                    i++;
                                }
                                nodos.get(posSrc).addDestination(nodos.get(posDest),peso);
                                nodos.get(posDest).addDestination(nodos.get(posSrc),peso);

                            } else {
                                JOptionPane.showMessageDialog(this, "Ingrese sólo números", "ERROR", JOptionPane.WARNING_MESSAGE);
                            }
                        } while (!input.matches("^[0-9]*$"));
                        repaint();
                        p1 = p2 = null;
                    }
                }
            }
        }
    }//mouseClicked

    @Override
    public void mousePressed(MouseEvent e) {
        int iN = 0;
        for (NodoGrafico nodo : arrayNodosG){
            if(new Rectangle(nodo.getX() - NodoGrafico.d/2,nodo.getY() - NodoGrafico.d/2,NodoGrafico.d,NodoGrafico.d).contains(e.getPoint())){
                nodoMover = nodo;
                iNodo = iN;
                break;
            }
            iN++;
        }
    }//mousePressed

    @Override
    public void mouseReleased(MouseEvent e) {
        nodoMover = null;
        iNodo = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (nodoMover != null){
            this.arrayNodosG.set(iNodo,new NodoGrafico(e.getX(),e.getY(),nodoMover.nombre));
            int iA = 0;
            for (AristaGrafico arista : aristaGraficos){
                if (new Rectangle(arista.getX1() - NodoGrafico.d/2, arista.getY1() - NodoGrafico.d/2,NodoGrafico.d,NodoGrafico.d).contains(e.getPoint())){
                    this.aristaGraficos.set(iA,new AristaGrafico(e.getX(),e.getY(),arista.getX2(),arista.getY2(),arista.getPeso(),arista.getSrc(),arista.getDest()));
                } else if (new Rectangle(arista.getX2() - NodoGrafico.d/2, arista.getY2() - NodoGrafico.d/2,NodoGrafico.d,NodoGrafico.d).contains(e.getPoint())){
                    this.aristaGraficos.set(iA,new AristaGrafico(arista.getX1(),arista.getY1(),e.getX(),e.getY(),arista.getPeso(),arista.getSrc(),arista.getDest()));
                }
                iA++;
            }//for
        }
        repaint();
    }//mouseDragged

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}//Lienzo
