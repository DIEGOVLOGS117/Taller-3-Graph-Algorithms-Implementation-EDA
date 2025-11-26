package AlgoritmoDijkstra;

public class GrafoAlgoritmoDijkstra {
    
    private static final int INF = 100000000; // "infinito" grande
    private int V;               // número de vértices
    private int[][] grafo;       // matriz de adyacencia

    // Constructor: crear un grafo con V vértices
    public GrafoAlgoritmoDijkstra(int V) {
        this.V = V;
        grafo = new int[V][V];

        // Inicializar matriz: 0 
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    grafo[i][j] = 0;
                } else {
                    grafo[i][j] = INF;
                }
            }
        }
  }

    // Agregar arista u–v con peso 
    public void agregarArista(int u, int v, int peso) {
        grafo[u][v] = peso;
        grafo[v][u] = peso; 
    }

    // Algoritmo de Dijkstra desde el vértice 'inicio' que seleccione
    public void dijkstra(int inicio) {
        int[] dist = new int[V];
        boolean[] visitado = new boolean[V];

        // Inicializar distancias
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            visitado[i] = false;
        }
        dist[inicio] = 0;

        // Repetir V-1 veces
        for (int c = 0; c < V - 1; c++) {

            // Escoger el vértice no visitado con menor distancia
            int u = nodoDistanciaMinima(dist, visitado);
            if (u == -1) break; 
            visitado[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visitado[v] &&
                    grafo[u][v] != INF &&
                    dist[u] != INF &&
                    dist[u] + grafo[u][v] < dist[v]) {

                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }

        imprimirDistancias(dist, inicio);
    }

    // Devuelve el índice del vértice no visitado con menor distancia
    public int nodoDistanciaMinima(int[] dist, boolean[] visitado) {
        int min = INF;
        int idx = -1;

        for (int i = 0; i < V; i++) {
            if (!visitado[i] && dist[i] < min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }

    // Imprimir las distancias desde el vértice inicio
    public void imprimirDistancias(int[] dist, int inicio) {
        System.out.println("Distancias Mas Cortas Desde El Vertice " + inicio + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF) {
                System.out.println(inicio + " -> " + i + " = INF");
            } else {
                System.out.println(inicio + " -> " + i + " = " + dist[i]);
            }
        }
    }
}