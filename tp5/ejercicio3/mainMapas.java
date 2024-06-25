package tp5.ejercicio3;

import tp5.ejercicio1.AdjListGraph;
import tp5.ejercicio1.Vertex;
import java.util.*;
public class mainMapas {
	public static void main(String[]args) {
		AdjListGraph<String> grafo = new AdjListGraph<String>();
		Vertex<String> ver1 = grafo.createVertex("Pedrinho");
		Vertex<String> ver2 = grafo.createVertex("Santiago Montoya");
		Vertex<String> ver3 = grafo.createVertex("Lamadrid");
		Vertex<String> ver4 =grafo.createVertex("Chivilcoy");
		Vertex<String> ver5 =grafo.createVertex("La Plata");
		Vertex<String> ver6 =grafo.createVertex("Coronel Mom");
		Vertex<String> ver7 =grafo.createVertex("Mercedes");
		grafo.connect(ver1,ver2,5);
		grafo.connect(ver6, ver5,7);
        grafo.connect(ver2, ver3,10);
        grafo.connect(ver5, ver4,4);
        grafo.connect(ver2,ver6,12);
        grafo.connect(ver6, ver7,4);
        grafo.connect(ver4, ver1,8);
        grafo.connect(ver7, ver4,9);
        grafo.connect(ver3, ver4,14);
        grafo.connect(ver3, ver1,1);
        grafo.connect(ver6, ver1,7);
		Mapa mapita = new Mapa(grafo);
		//System.out.println(mapita.devolverCamino("Santiago Montoya","Chivilcoy"));
		List<String> restringidos = new LinkedList<String>();
		restringidos.add(ver3.getData());
		restringidos.add(ver5.getData());
		//restringidos.add(ver1.getData());
		//System.out.println(mapita.devolverCaminoExceptuando("Coronel Mom","Pedrinho",restringidos));
		//System.out.println(mapita.caminoMasCorto("Coronel Mom","Pedrinho"));
		System.out.println(mapita.caminoSinCargarCombustible("Coronel Mom","Pedrinho",20));
	}
}
