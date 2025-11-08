package AlgoritmoKruskal;

public class GrafoAlgoritmoKruskal {
    
    protected int V; // número de vértices
    protected int A; // número de aristas
    protected int [][] AlmacenarAristas; // matriz donde se guardan las aristas cada fila representara una arista
    protected int peso;
    
    // constructor del grafo para el algoritmo kruskal
    public GrafoAlgoritmoKruskal(int V, int A) {
    this.V = V;
    this.A = A;
    this.AlmacenarAristas = new int[A][3]; // pasandole  // 
}
    
    public void agregarArista(int indice, int u, int v, int peso) {
    AlmacenarAristas[indice][0] = u;
    AlmacenarAristas[indice][1] = v;
    AlmacenarAristas[indice][2] = peso;
}

     private void ordenarAristasPorPeso() {
        for (int i = 0; i < A - 1; i++) {
            for (int j = 0; j < A - i - 1; j++) {
                if (AlmacenarAristas[j][2] > AlmacenarAristas[j + 1][2]) {
                  
                    int[] temp = AlmacenarAristas[j];
                    AlmacenarAristas[j] = AlmacenarAristas[j + 1];
                    AlmacenarAristas[j + 1] = temp;
                }
            }
    
 
  }
    }    
} 