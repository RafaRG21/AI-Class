package kruskal;

import java.util.*;

class DisjointSet {
    public static int totalWeigth = 0;
    Map<String, String> parent = new HashMap<>();

    public void makeSet(List<AristaGrafico> aristas) {
        System.out.println("aristas= "+aristas);

        // se crea el set disjunto (uno para cada nodo)
        for (int i = 0; i < aristas.size();i++) {

            parent.put(aristas.get(i).src,aristas.get(i).src);
            parent.put(aristas.get(i).dest,aristas.get(i).dest);
            System.out.println("n= "+i+": "+parent);
        }
        System.out.println(parent);
    }//makeSet

    // Se encuentra la raiz del set donde pertenezca k
    private String find(String k) {
        // Si k es raíz
        System.out.println("Parent: " +parent.get(k)+" k: "+k);
        if (parent.get(k).equals(k)) {
            return k;
        }

        // se llama el metodo a si mismo hasta encontrar la raiz
        return find(parent.get(k));
    }//find


    private void union(String a, String b) {
        //  Se encuentra la raiz de los sets donde pertenezcan x e y
        String x = find(a);
        String y = find(b);

        parent.put(x, y);
        System.out.println("Parent: "+getParent());
    }//union

    // Algoritmo Kruskal
    public static List<AristaGrafico> runKruskalAlgorithm(List<AristaGrafico> aristas, int n) {
        totalWeigth = 0;
        //se guardan las aristas en MST
        List<AristaGrafico> MST = new ArrayList<>();


        DisjointSet ds = new DisjointSet();
        ds.makeSet(aristas);

        int index = 0;

        // se ordena las aristas por peso
        Collections.sort(aristas, Comparator.comparingInt(e -> e.getPeso()));


        while (MST.size() != n - 1)
        {
            AristaGrafico siguienteArista = aristas.get(index++);


            String x = ds.find(siguienteArista.src);
            String y = ds.find(siguienteArista.dest);

            // se comprueba que tengan diferentes padres para que no se cicle
            if (!x.equals(y))
            {
                MST.add(siguienteArista);
                ds.union(x, y);
                totalWeigth += siguienteArista.getPeso();
            }
        }//while
        return MST;
    }//runKruskalAlgorithm

    public Map<String, String> getParent() {
        return parent;
    }
}//class DisjointSet
