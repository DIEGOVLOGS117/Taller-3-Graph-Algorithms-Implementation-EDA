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
    this.AlmacenarAristas = new int[A][3]; // pasandole [u,v,peso] // 
    //this.peso = peso;
}
    
    public void agregarArista(int indice, int u, int v, int peso) {
    AlmacenarAristas[indice][0] = u;
    AlmacenarAristas[indice][1] = v;
    AlmacenarAristas[indice][2] = peso; // peso de la arista
}

     public void ordenarAristasPorPeso() { // mediante burbuja ordenar el peso de las aristas
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
     
public int encontrar(int[] padre, int i) {
    if (padre[i] != i) {
        padre[i] = encontrar(padre, padre[i]); // Compresión de camino
    }
    return padre[i];
}

    public void union(int[] padre, int[] rango, int x, int y) {
    int raizX = encontrar(padre, x);
    int raizY = encontrar(padre, y);
    
    if (rango[raizX] < rango[raizY]) {
        padre[raizX] = raizY;
    } else if (rango[raizX] > rango[raizY]) {
        padre[raizY] = raizX;
    } else {
        padre[raizY] = raizX;
        rango[raizX]++;
    }
}

    public void grafoGudKruskalMethodo() {
    // 1. Ordenar aristas por peso
    ordenarAristasPorPeso();
    
    int[] padre = new int[V];
    int[] rango = new int[V];
    for (int i = 0; i < V; i++) {
        padre[i] = i;
        rango[i] = 0;
    }
    
    int aristasSeleccionadas = 0;
    int pesoTotal = 0;
    
    System.out.println("Aristas En El MST: ");
    for (int i = 0; i < A && aristasSeleccionadas < V - 1; i++) {
        int u = AlmacenarAristas[i][0];
        int v = AlmacenarAristas[i][1];
        int peso = AlmacenarAristas[i][2];
        
        int raizU = encontrar(padre, u);
        int raizV = encontrar(padre, v);
        
        if (raizU != raizV) {
            System.out.println(u + " - " + v + " : " + peso);
            pesoTotal += peso;
            union(padre, rango, raizU, raizV);
            aristasSeleccionadas++;
        }
    }
    
    System.out.println("Peso Total Del MST: " + pesoTotal);
}
   
   public void mostrarAristas() {
    System.out.println("Todas Las Aristas Del grafo:");
    for (int i = 0; i < A; i++) {
        System.out.println("Arista " + i + ": " + 
            AlmacenarAristas[i][0] + " - " + 
            AlmacenarAristas[i][1] + " : " + 
            AlmacenarAristas[i][2]);
    }
}
    
} 