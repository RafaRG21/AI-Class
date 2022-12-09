import java.util.ArrayList;
import java.util.List;

public class Ruta {
    public List<Nodo> nodos;
    public int totalDistance;

    public Ruta(){
        nodos = new ArrayList<>();
        totalDistance = 0;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(List<Nodo> nodos) {
        this.nodos = nodos;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }
}//Ruta
