package AlgoritmoFloydWarshall;

public class GrafoAlgoritmoFloydWarshall {

    private static final int INF = 100000000; 
    private int V;
    private int[][] dist;

    public GrafoAlgoritmoFloydWarshall(int V) {
        this.V = V;
        dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }
    }

    // Agregar arista u–v con pesos
    public void agregarArista(int u, int v, int peso) {
        dist[u][v] = peso;
        dist[v][u] = peso; 
    }

    // Algoritmo Floyd–Warshall
    public void floydWarshall() {
        for (int k = 0; k < V; k++) {        // vértice intermedio
            for (int i = 0; i < V; i++) {    // fila
                for (int j = 0; j < V; j++) { // columna
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    // Imprimir matriz
public void imprimirDistancias() {
    System.out.println("Matriz de Distancias Mas Cortas:\n");
    for (int i = 0; i < V; i++) {
        System.out.print("[ ");
        for (int j = 0; j < V; j++) {

            if (dist[i][j] == INF)
                System.out.printf("%4s ", "INF");
            else
                System.out.printf("%4d ", dist[i][j]);
        }
        System.out.println("]");
    }
}
}