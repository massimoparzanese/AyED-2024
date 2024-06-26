package Parciales;

import tp5.ejercicio1.*;
import tp5.ejercicio1.Vertex;
import java.util.*;

public class mainBfs {

	public static void main(String[] args) {
		Graph<String> grafo = new AdjListGraph<String>();
		Vertex<String> v1 = grafo.createVertex("PC1");
		Vertex<String> v2 = grafo.createVertex("PC2"); 
		Vertex<String> v3 = grafo.createVertex("PC3"); 
		Vertex<String> v4 = grafo.createVertex("PC4");
		Vertex<String> v6 = grafo.createVertex("PC6");
		Vertex<String> v7 = grafo.createVertex("PC7");
		Vertex<String> v8 = grafo.createVertex("PC8");
		Vertex<String> v9 = grafo.createVertex("PC9");
		Vertex<String> v10 = grafo.createVertex("PC10");
		
		grafo.connect(v9, v10);
		grafo.connect(v1,v2);
		grafo.connect(v3,v4);
		grafo.connect(v6,v7);
		grafo.connect(v2,v4);
		grafo.connect(v1,v6);
		grafo.connect(v10,v8);
		grafo.connect(v1,v10);
		grafo.connect(v3,v2);
		grafo.connect(v2,v6);
		grafo.connect(v6,v8);
		
		ParcialBfs bf = new ParcialBfs();
		System.out.println(bf.infeccion(grafo, "PC1"));
}}
