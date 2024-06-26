package tp5.ejercicio6;

import tp5.ejercicio1.*;
import java.util.*;
public class buscadorDeCaminos {
	
	private Graph<String> bosque;
	
	public buscadorDeCaminos(Graph<String> bosquesito) {
		this.bosque = bosquesito;
	}
	public List<List<String>> recorridosMasSeguro(){
		List<List<String>> caminos = new LinkedList<List<String>>();
		List<String> camino = new LinkedList<String>();
		boolean [] marcados = new boolean[this.bosque.getSize()];
		
		if(this.bosque != null && !this.bosque.isEmpty()) {
			Vertex<String> origen = this.bosque.search("Casa Caperucita");
			Vertex<String> destino = this.bosque.search("Casa Abuelita");
			if(origen != null && destino != null) {
				buscadorCaminos(origen,camino,caminos,marcados,"Casa Abuelita");
			}
			
		}
		
		
		return caminos;
	}
	
	private void buscadorCaminos(Vertex<String> origen, List<String> camino,
			List<List<String>>caminos,boolean[]marcados,String destino) {
		camino.add(origen.getData());
		marcados[origen.getPosition()] = true;
		if(origen.getData().equals(destino)) {
			caminos.add(new LinkedList<String>(camino));
		}
		else {
			List<Edge<String>> aristas = this.bosque.getEdges(origen);
			for(Edge<String> aris:aristas) {
				Vertex<String> v = aris.getTarget();
				if(!marcados[v.getPosition()] && aris.getWeight() <= 5) {
					buscadorCaminos(v,camino,caminos,marcados,destino);
				}
			}
		}
		camino.remove(camino.size()-1);
		marcados[origen.getPosition()]= false;
		
		
	}

}
