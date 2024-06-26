package Parciales;

import java.util.List;


import tp5.ejercicio1.*;

public class mainParcialTema1 {
	public static void main(String[]args) {
		Graph<recinto> grafo = new AdjListGraph<recinto>();

        // Crear recintos
        recinto entrada = new recinto("Entrada", 0);
        recinto cebras = new recinto("Cebras", 10);
        recinto tortugas = new recinto("Tortugas", 15);
        recinto tigres = new recinto("Tigres", 20);
        recinto flamencos = new recinto("Flamencos", 25);
        recinto murcielagos = new recinto("Murcielagos", 10);
        recinto wallabies = new recinto("Wallabies", 30);

        // Agregar recintos al grafo
        Vertex<recinto> v1= grafo.createVertex(entrada);
        Vertex<recinto> v2= grafo.createVertex(cebras);
        Vertex<recinto> v3= grafo.createVertex(tortugas);
        Vertex<recinto> v4= grafo.createVertex(tigres);
        Vertex<recinto> v5= grafo.createVertex(flamencos);
        Vertex<recinto> v6= grafo.createVertex(murcielagos);
        Vertex<recinto> v7= grafo.createVertex(wallabies);


        

    ParcialGrafosTema1 par = new ParcialGrafosTema1();
    List<recinto> listita = par.resolver(grafo, 108);
    for(recinto re:listita) {
    	System.out.println(re.getName() + re.getTime());
    }
    System.out.println(listita.size());
    }
}
