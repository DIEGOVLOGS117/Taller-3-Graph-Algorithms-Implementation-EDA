package AlgoritmoDijkstra;

public class MainAlgoritmoDijkstra {

    public static void main(String[] args) {

        // El grafo tiene 9 vértices (A=0, B=1, ..., I=8)
        GrafoAlgoritmoDijkstra g = new GrafoAlgoritmoDijkstra(9);

        g.agregarArista(0, 1, 4);   // A-B
        g.agregarArista(0, 7, 8);   // A-H
        g.agregarArista(1, 7, 11);  // B-H
        g.agregarArista(1, 2, 8);   // B-C
        g.agregarArista(2, 3, 7);   // C-D
        g.agregarArista(2, 5, 4);   // C-F
        g.agregarArista(2, 8, 2);   // C-I
        g.agregarArista(3, 4, 9);   // D-E
        g.agregarArista(3, 5, 14);  // D-F
        g.agregarArista(4, 5, 10);  // E-F
        g.agregarArista(5, 6, 2);   // F-G
        g.agregarArista(6, 7, 1);   // G-H
        g.agregarArista(6, 8, 6);   // G-I

        // Ejecutando Dijkstra desde el vértice 0 (A)
        g.dijkstra(0);
    }
}
