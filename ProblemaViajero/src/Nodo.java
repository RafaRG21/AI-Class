import java.util.ArrayList;
import java.util.List;

public class Nodo {
    public String ciudad;
    public List<Camino> caminos;


    public Nodo(String ciudad){
        this.ciudad = ciudad;
        caminos = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Camino> getCaminos() {
        return caminos;
    }

    public void setCaminos(List<Camino> caminos) {
        this.caminos = caminos;
    }
}//Nodo
