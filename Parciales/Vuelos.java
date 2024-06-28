package Parciales;

import java.util.*;

import tp5.ejercicio1.*;
public class Vuelos {
	
	public List<List<String>> caminos(Graph<String> ciudad){
	
		List<List<String>> caminitos = new LinkedList<List<String>>();
		List<String> camino = new LinkedList<String>();
		
		List<Vertex<String>> totalV = ciudad.getVertices();
		boolean [] marcados = new boolean[ciudad.getSize()];
		if(ciudad != null && !ciudad.isEmpty()) {
			for(Vertex<String> v: totalV) {
				buscarCaminos(ciudad,caminitos,camino,marcados,v,0);
			}
			
		}
		
		return caminitos;
	}
	
	private void buscarCaminos(Graph<String> ciudad,List<List<String>> caminitos,List<String> camino,
			boolean[]marcados,Vertex<String> origen,int costo) {
		camino.add(origen.getData());
		marcados[origen.getPosition()] = true;
		if(costo == 10) {
			caminitos.add(new LinkedList<String>(camino));
			
		}
		else {
			List<Edge<String>> aristas = ciudad.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			
			while(it.hasNext()) {
				Edge<String> ari = it.next();
				Vertex<String> v = ari.getTarget();
				int peso = ari.getWeight();
				if(!marcados[v.getPosition()] && costo + peso <= 10) {
					buscarCaminos(ciudad,caminitos,camino,marcados,v,costo+peso);
				}
			}
		
		}
		camino.remove(camino.size()-1);
		marcados[origen.getPosition()] = false;
		
	}
}
