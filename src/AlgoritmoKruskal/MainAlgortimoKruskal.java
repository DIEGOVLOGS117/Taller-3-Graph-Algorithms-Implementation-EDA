package AlgoritmoKruskal;

public class MainAlgortimoKruskal {
    
    public static void main(String[] args) {
        
        // Crear grafo con 9 vértices y 14 aristas
        GrafoAlgoritmoKruskal g = new GrafoAlgoritmoKruskal(9, 14);
        
        g.agregarArista(0, 0, 1, 4);   // A-B
        g.agregarArista(1, 0, 7, 8);   // A-H
        g.agregarArista(2, 1, 7, 11);  // B-H
        g.agregarArista(3, 1, 2, 8);   // B-C
        g.agregarArista(4, 2, 3, 7);   // C-D
        g.agregarArista(5, 2, 5, 4);   // C-F
        g.agregarArista(6, 2, 8, 2);   // C-I
        g.agregarArista(8, 3, 4, 9);   // D-E
        g.agregarArista(9, 3, 5, 14);  // D-F
        g.agregarArista(10, 4, 5, 10); // E-F
        g.agregarArista(11, 5, 6, 2);  // F-G
        g.agregarArista(12, 6, 7, 1);  // G-H
        g.agregarArista(13, 6, 8, 6);  // G-I
        
        System.out.println("=== GRAFO ORIGINAL ===");
        g.mostrarAristas();
        
        System.out.println("\n=== EJECUTANDO ALGORITMO DE KRUSKAL ===");
        g.grafoGudKruskalMethodo();
        
    }
}