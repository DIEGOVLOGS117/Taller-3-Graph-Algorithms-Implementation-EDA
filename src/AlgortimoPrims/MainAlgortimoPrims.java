package AlgortimoPrims;

public class MainAlgortimoPrims {

    public static void main(String[] args) {

        GrafoAlgoritmoPrims g = new GrafoAlgoritmoPrims(9);

        g.agregarArista(0, 0, 1, 4);   // A-B
        g.agregarArista(1, 0, 7, 8);   // A-H
        g.agregarArista(2, 1, 7, 11);  // B-H
        g.agregarArista(3, 1, 2, 8);   // B-C
        g.agregarArista(4, 2, 3, 7);   // C-D
        g.agregarArista(5, 2, 5, 4);   // C-F
        g.agregarArista(6, 2, 8, 2);   // C-I
        g.agregarArista(7, 3, 4, 9);   // D-E
        g.agregarArista(8, 3, 5, 14);  // D-F
        g.agregarArista(9, 4, 5, 10);  // E-F
        g.agregarArista(10, 5, 6, 2);  // F-G
        g.agregarArista(11, 6, 7, 1);  // G-H
        g.agregarArista(12, 6, 8, 6);  // G-I

        g.prims(6);  // iniciar en G (índice 6)
    }
}