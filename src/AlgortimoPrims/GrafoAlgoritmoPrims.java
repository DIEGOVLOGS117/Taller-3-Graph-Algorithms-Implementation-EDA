package AlgortimoPrims;

import java.util.*;

public class GrafoAlgoritmoPrims {

    protected int V;
    protected int[][] grafo; // matriz de adyacencia

    public GrafoAlgoritmoPrims(int V) {
        this.V = V;
        grafo = new int[V][V];
    }

    public void agregarArista(int indice, int u, int v, int peso) {
        grafo[u][v] = peso;
        grafo[v][u] = peso; // porque es un grafo no dirigido
    }

    // el int del inicio es el valor del vertice donde queremos iniciar nuestro recorrido
    public void prims(int iniciarRecorridoGrafo) {
        
        System.out.println("Selecciono Iniciar Desde El Vertice " + iniciarRecorridoGrafo);
        
        boolean[] visitado = new boolean[V]; // vector  de tipo booleano para comprobar si el vertice fue visitado o no
        int[] menorPesoAris = new int[V]; // vector tipo entero para almacenar las aristas de menor peso
        int[] padre = new int[V];

        Arrays.fill(menorPesoAris, Integer.MAX_VALUE);
        menorPesoAris[iniciarRecorridoGrafo] = 0;
        padre[iniciarRecorridoGrafo] = -1;

        for (int i = 0; i < V - 1; i++) {
            int u = minKey(menorPesoAris, visitado);
            visitado[u] = true;

            for (int v = 0; v < V; v++) {
                if (grafo[u][v] != 0 && !visitado[v] && grafo[u][v] < menorPesoAris[v]) {
                    padre[v] = u;
                    menorPesoAris[v] = grafo[u][v];
                }
            }
        }

        imprimirMST(padre);
    }

    private int minKey(int[] key, boolean[] visitado) {
        int min = Integer.MAX_VALUE, idx = -1;

        for (int i = 0; i < V; i++)
            if (!visitado[i] && key[i] < min) {
                min = key[i];
                idx = i;
            }

        return idx;
    }

   private void imprimirMST(int[] padre) {

    System.out.println("Aristas Usando Prims:");

    for (int i = 0; i < V; i++) {
        if (padre[i] != -1) {
            System.out.println(padre[i] + " - " + i + "  peso: " + grafo[i][padre[i]]);
        }
    }
}
   
}