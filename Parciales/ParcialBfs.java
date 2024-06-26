package Parciales;

import java.util.List;
import tp1.ejercicio9.Queue;
import tp5.ejercicio1.*;
/*Un poderoso e inteligente virus de computadora infecta cualquier computadora 
en 1 minuto, logrando infectar toda la red de una empresa con cientos de 
computadoras. Dado un grafo que representa las conexiones entre las 
computadoras de la empresa, y una computadora ya infectada, escriba un 
programa en Java que permita determinar el tiempo que demora el virus en 
infectar el resto de las computadoras. Asuma que todas las computadoras 
pueden ser infectadas, no todas las computadoras tienen conexión directa entre 
sí, y un mismo virus puede infectar un grupo de computadoras al mismo tiempo 
sin importar la cantidad. */
public class ParcialBfs {
	
	public int infeccion(Graph<String> grafo, String inicio) {
		int cant = 0;
		boolean [] marcados = new boolean[grafo.getSize()];
		if(grafo != null && !grafo.isEmpty()) {
			
			Vertex<String> origen = grafo.search(inicio);
			if(origen != null) {
				cant = obtenerTiempo(origen,grafo,marcados);
			}
		}
		return cant;
	}
	
	private int obtenerTiempo(Vertex<String> origen, Graph<String> grafo, boolean[] marcados) {
		Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
		int cant = 0;
		cola.enqueue(origen);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			Vertex<String> v = cola.dequeue();
			if(v != null) {
				marcados[v.getPosition()] = true;
				List<Edge<String>> aristas = grafo.getEdges(v);
				for(Edge<String> aris:aristas) {
					Vertex<String> aux = aris.getTarget();
					if(!marcados[aux.getPosition()]) {
						cola.enqueue(aux);
					}
					
				}
			}
			else {
				if(!cola.isEmpty()) {
					cant++;
					cola.enqueue(null);
			}
		}
		}	
		return cant;
		
	}
	
}
