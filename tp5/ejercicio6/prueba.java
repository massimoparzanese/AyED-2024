package tp5.ejercicio6;

import java.util.List;

import tp5.ejercicio1.AdjListGraph;
import tp5.ejercicio1.Vertex;

public class prueba {
	public static void main (String[]args) {
		AdjListGraph<String> grafo = new AdjListGraph<String>();
		Vertex<String> ver1 = grafo.createVertex("Casa Caperucita");
		Vertex<String> ver2 = grafo.createVertex("Claro 1");
		Vertex<String> ver3 = grafo.createVertex("Claro 2");
		Vertex<String> ver4 =grafo.createVertex("Claro 3");
		Vertex<String> ver5 =grafo.createVertex("Claro 5");
		Vertex<String> ver6 =grafo.createVertex("Claro 4");
		Vertex<String> ver7 =grafo.createVertex("Casa Abuelita");
		grafo.connect(ver1,ver2,3);
		grafo.connect(ver1,ver3,4);
		grafo.connect(ver1,ver4,4);
		grafo.connect(ver4,ver5,15);
		grafo.connect(ver2,ver5,3);
		grafo.connect(ver3,ver2,4);
		grafo.connect(ver3, ver5,11);
		grafo.connect(ver2,ver6,10);
		grafo.connect(ver6, ver7,9);
		grafo.connect(ver5, ver7,4);
		buscadorDeCaminos bosq = new buscadorDeCaminos(grafo);
		List<List<String>> lista = bosq.recorridosMasSeguro();
		for(List<String> listita: lista) {
			System.out.println(listita);
		}
		}
}
