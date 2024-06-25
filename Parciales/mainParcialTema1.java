package Parciales;

import java.util.List;

import tp5.ejercicio1.AdjListGraph;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class mainParcialTema1 {
	public static void main(String[]args) {
	Graph<recinto> grafo = new AdjListGraph<recinto>();
    
    recinto entrada = new recinto("Entrada", 15);
    recinto tigres = new recinto("Tigres", 10);
    recinto cebras = new recinto("Cebras", 10);
    recinto tortugas = new recinto("Tortugas", 10);
    recinto pumas = new recinto("Pumas", 15);
    recinto wallabies = new recinto("Wallabies", 30);
    recinto murcielagos = new recinto("Murciélagos", 20);
    recinto flamencos = new recinto("Flamencos", 25);
    
    Vertex<recinto> v1 = grafo.createVertex(entrada);
    Vertex<recinto> v2 = grafo.createVertex(tigres);
    Vertex<recinto> v3 = grafo.createVertex(cebras);
    Vertex<recinto> v4 = grafo.createVertex(tortugas);
    Vertex<recinto> v5 = grafo.createVertex(pumas);
    Vertex<recinto> v6 = grafo.createVertex(wallabies);
    Vertex<recinto> v7 = grafo.createVertex(murcielagos);
    Vertex<recinto> v8 = grafo.createVertex(flamencos);

    grafo.connect(v1, v2, 15);
    grafo.connect(v1, v3, 10);
    grafo.connect(v1, v8, 25);
    grafo.connect(v2, v1, 15);
    grafo.connect(v2, v3, 8);
    grafo.connect(v3, v1, 10);
    grafo.connect(v3, v2, 8);
    grafo.connect(v3, v4, 5);
    grafo.connect(v4, v3, 5);
    grafo.connect(v4, v5, 15);
    grafo.connect(v5, v4, 15);
    grafo.connect(v5, v6, 2);
    grafo.connect(v6, v5, 2);
    grafo.connect(v6, v7, 8);
    grafo.connect(v7, v8, 20);
    grafo.connect(v8, v7, 20);
    grafo.connect(v8, v1, 25);
    grafo.connect(v7, v6, 8);
    
    ParcialGrafosTema1 par = new ParcialGrafosTema1();
    List<recinto> listita = par.resolver(grafo, 138);
    for(recinto re:listita) {
    	System.out.println(re.getName() + re.getTime());
    }
    System.out.println(listita.size());
    }
}
