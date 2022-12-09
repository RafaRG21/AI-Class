import java.util.*;

public class TSP {
    private List<Nodo> grafo;
    private int n;
    private Nodo origen;
    private List<Ruta> soluciones;

    public TSP(List<Nodo> grafo,Nodo origen, int n){
        this.grafo = grafo;
        this.origen = origen;
        this.n = n;
    }//constructor

    public void run(){
        soluciones = new ArrayList<>();
        for (int i = 0; i < n; i++){
            soluciones.add(generar());
        }
        soluciones.sort(Comparator.comparingInt(e -> e.totalDistance));

    }//run


    private Ruta generar(){
        Ruta solucion = new Ruta();
        solucion.nodos.add(origen);
        Nodo actual  = origen;
        for (int i = 0; i < grafo.size()-1;i++){
            Nodo siguiente = null;
            do {
                siguiente = nodoSiguiente(actual);

            }while (solucion.nodos.contains(siguiente));

            solucion.nodos.add(siguiente);

            for (Camino camino : actual.caminos) {
                if(camino.nodo.ciudad.equals(siguiente.ciudad))
                    solucion.totalDistance += camino.distancia;

            }//foreach
            actual = siguiente;
        }//for

        solucion.nodos.add(origen);
        for (Camino camino : actual.caminos) {
            if(camino.nodo.ciudad.equals(origen.ciudad))
                solucion.totalDistance += camino.distancia;

        }//foreach
        return solucion;
    }//generar

    private Nodo nodoSiguiente(Nodo actual){
        int nodoSig = new Random().nextInt(0,grafo.size()-1);
        return actual.caminos.get(nodoSig).nodo;
    }//nodoSiguiente

    public String obtenerRutas(){
        String resultado = "";
        for (Ruta ruta : soluciones){
            for (Nodo nodo : ruta.nodos){
                resultado += nodo.ciudad+", ";
            }
            resultado += "\nDistancia total: " + ruta.totalDistance+"\n";
        }
        return resultado;
    }
}//TSP
