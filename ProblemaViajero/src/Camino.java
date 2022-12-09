public class Camino {
    public Nodo nodo;
    public int distancia;

    public Camino(Nodo nodo, int distancia){
        this.nodo = nodo;
        this.distancia = distancia;

    }//constructor


    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
}//Camino
