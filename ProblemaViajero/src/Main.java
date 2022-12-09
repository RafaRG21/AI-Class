import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Declaracion de nodos
        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        Nodo nodoD = new Nodo("D");
        Nodo nodoE = new Nodo("E");
        Nodo nodoF = new Nodo("F");
        Nodo nodoG = new Nodo("G");
        Nodo nodoH = new Nodo("H");
        Nodo nodoI = new Nodo("I");
        Nodo nodoJ = new Nodo("J");
        //A
        nodoA.caminos.add(new Camino(nodoB,5));
        nodoA.caminos.add(new Camino(nodoC,8));
        nodoA.caminos.add(new Camino(nodoD,2));
        nodoA.caminos.add(new Camino(nodoE,3));
        nodoA.caminos.add(new Camino(nodoF,1));
        nodoA.caminos.add(new Camino(nodoG,4));
        nodoA.caminos.add(new Camino(nodoH,7));
        nodoA.caminos.add(new Camino(nodoI,15));
        nodoA.caminos.add(new Camino(nodoJ,9));
        //b
        nodoB.caminos.add(new Camino(nodoA,5));
        nodoB.caminos.add(new Camino(nodoC,9));
        nodoB.caminos.add(new Camino(nodoD,10));
        nodoB.caminos.add(new Camino(nodoE,3));
        nodoB.caminos.add(new Camino(nodoF,7));
        nodoB.caminos.add(new Camino(nodoG,4));
        nodoB.caminos.add(new Camino(nodoH,8));
        nodoB.caminos.add(new Camino(nodoI,11));
        nodoB.caminos.add(new Camino(nodoJ,10));
        //C
        nodoC.caminos.add(new Camino(nodoA,8));
        nodoC.caminos.add(new Camino(nodoB,9));
        nodoC.caminos.add(new Camino(nodoD,5));
        nodoC.caminos.add(new Camino(nodoE,1));
        nodoC.caminos.add(new Camino(nodoF,2));
        nodoC.caminos.add(new Camino(nodoG,4));
        nodoC.caminos.add(new Camino(nodoH,3));
        nodoC.caminos.add(new Camino(nodoI,7));
        nodoC.caminos.add(new Camino(nodoJ,11));
        //D
        nodoD.caminos.add(new Camino(nodoA,2));
        nodoD.caminos.add(new Camino(nodoB,10));
        nodoD.caminos.add(new Camino(nodoC,5));
        nodoD.caminos.add(new Camino(nodoE,4));
        nodoD.caminos.add(new Camino(nodoF,5));
        nodoD.caminos.add(new Camino(nodoG,8));
        nodoD.caminos.add(new Camino(nodoH,9));
        nodoD.caminos.add(new Camino(nodoI,16));
        nodoD.caminos.add(new Camino(nodoJ,12));
        //E
        nodoE.caminos.add(new Camino(nodoA,3));
        nodoE.caminos.add(new Camino(nodoB,3));
        nodoE.caminos.add(new Camino(nodoC,1));
        nodoE.caminos.add(new Camino(nodoD,4));
        nodoE.caminos.add(new Camino(nodoF,5));
        nodoE.caminos.add(new Camino(nodoG,11));
        nodoE.caminos.add(new Camino(nodoH,21));
        nodoE.caminos.add(new Camino(nodoI,20));
        nodoE.caminos.add(new Camino(nodoJ,13));
        //Caminos F
        nodoF.caminos.add(new Camino(nodoA,1));
        nodoF.caminos.add(new Camino(nodoB,7));
        nodoF.caminos.add(new Camino(nodoC,2));
        nodoF.caminos.add(new Camino(nodoD,5));
        nodoF.caminos.add(new Camino(nodoE,5));
        nodoF.caminos.add(new Camino(nodoG,1));
        nodoF.caminos.add(new Camino(nodoH,3));
        nodoF.caminos.add(new Camino(nodoI,4));
        nodoF.caminos.add(new Camino(nodoJ,9));
        //Caminos H
        nodoH.caminos.add(new Camino(nodoA,7));
        nodoH.caminos.add(new Camino(nodoB,8));
        nodoH.caminos.add(new Camino(nodoC,3));
        nodoH.caminos.add(new Camino(nodoD,9));
        nodoH.caminos.add(new Camino(nodoE,21));
        nodoH.caminos.add(new Camino(nodoF,3));
        nodoH.caminos.add(new Camino(nodoG,9));
        nodoH.caminos.add(new Camino(nodoI,5));
        nodoH.caminos.add(new Camino(nodoJ,8));
        //Caminos I
        nodoI.caminos.add(new Camino(nodoA,15));
        nodoI.caminos.add(new Camino(nodoB,11));
        nodoI.caminos.add(new Camino(nodoC,7));
        nodoI.caminos.add(new Camino(nodoD,16));
        nodoI.caminos.add(new Camino(nodoE,20));
        nodoI.caminos.add(new Camino(nodoF,4));
        nodoI.caminos.add(new Camino(nodoG,2));
        nodoI.caminos.add(new Camino(nodoH,5));
        nodoI.caminos.add(new Camino(nodoJ,7));
        //Caminos J
        nodoJ.caminos.add(new Camino(nodoA,9));
        nodoJ.caminos.add(new Camino(nodoB,10));
        nodoJ.caminos.add(new Camino(nodoC,11));
        nodoJ.caminos.add(new Camino(nodoD,12));
        nodoJ.caminos.add(new Camino(nodoE,13));
        nodoJ.caminos.add(new Camino(nodoF,9));
        nodoJ.caminos.add(new Camino(nodoG,3));
        nodoJ.caminos.add(new Camino(nodoH,8));
        nodoJ.caminos.add(new Camino(nodoI,7));
        //Grafo
        List<Nodo> grafo = new ArrayList<Nodo>();
        grafo.add(nodoA);
        grafo.add(nodoB);
        grafo.add(nodoC);
        grafo.add(nodoD);
        grafo.add(nodoE);
        grafo.add(nodoF);
        grafo.add(nodoG);
        grafo.add(nodoH);
        grafo.add(nodoI);
        grafo.add(nodoJ);
        TSP algoritmo = new TSP(grafo,nodoA,150);
        algoritmo.run();
        System.out.println(algoritmo.obtenerRutas());
    }//main
}//Main
