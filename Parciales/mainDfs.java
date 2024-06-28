package Parciales;

import java.util.*;

import tp5.ejercicio1.*;

public class mainDfs {
	public static void main(String[] args) {
		 Graph<String> ciudades = new AdjListGraph<>();
		 Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
		 Vertex<String> v2 = ciudades.createVertex("Santiago");
		 Vertex<String> v3 = ciudades.createVertex("Asunción");
		 Vertex<String> v4 = ciudades.createVertex("Caracas");
		 Vertex<String> v5 = ciudades.createVertex("Madrid");
		 Vertex<String> v6 = ciudades.createVertex("Roma");
		 Vertex<String> v7 = ciudades.createVertex("Tokio");
		 Vertex<String> v8 = ciudades.createVertex("Paris");
		 
		 ciudades.connect(v1, v2, 3);  // Buenos Aires -> Santiago
		 ciudades.connect(v1, v3, 6);  // Buenos Aires -> Asunción
		 ciudades.connect(v2, v6, 4);  // Santiago -> Roma
		 ciudades.connect(v3, v4, 2);  // Asunción -> Caracas
		 ciudades.connect(v4, v5, 2);  // Caracas -> Madrid
		 ciudades.connect(v3, v5, 10); // Madrid -> Asunción
		 ciudades.connect(v5, v7, 60); // Madrid -> Tokio 
		 ciudades.connect(v6, v8, 65); // Roma -> París
		 ciudades.connect(v6, v7, 80); // Roma -> tokio
		 ciudades.connect(v7, v8, 35); // Tokio -> París
		 ciudades.connect(v8, v7, 35); // París -> Tokio
		 ciudades.connect(v8, v5, 65); // París -> Madrid
		 ciudades.connect(v7, v1, 10); // Tokio -> París
		    Vuelos vuelos = new Vuelos();
		 List<List<String>> lista = vuelos.caminos(ciudades);
		 for (List<String> e: lista){
		  System.out.println(e);
		 }

}
	}	
