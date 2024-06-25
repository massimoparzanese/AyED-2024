package tp5.ejercicio4;

import java.util.*;

import tp5.ejercicio1.*;

public class VisitaOslo {
	
	public List<String> paseoEnBici(Graph<String> lugares, String destino, 
			int maxTiempo, List<String> lugaresRestringidos){
		List<String> camino = new LinkedList<String>();
		boolean [] marcados = new boolean[lugares.getSize()];
		if(lugares != null && !lugares.isEmpty()) {
			Vertex<String> origen = lugares.search("Ayuntamiento");
			paseoEnBiciAux(origen,destino,marcados,maxTiempo,lugaresRestringidos,camino,lugares);
		}
		
		return camino;
		
	}
	private void paseoEnBiciAux(Vertex<String>origen, String destino,boolean[]marcados,int maxTiempo,
			List<String> lugaresRestringidos,List<String> camino, Graph<String> lugares) {
		camino.add(origen.getData());
		marcados[origen.getPosition()] = true;
		if(!origen.getData().equals(destino)) {
			List<Edge<String>> aristas = lugares.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			while(it.hasNext() && !camino.contains(destino)) {
				Edge<String> arista = it.next();
				Vertex<String> v = arista.getTarget();
				int aux = maxTiempo - arista.getWeight();
				if(!marcados[v.getPosition()] && aux > 0 && !lugaresRestringidos.contains(v.getData())) {
					paseoEnBiciAux(v,destino,marcados,aux,lugaresRestringidos,camino,lugares);
				}
					
			}
		}
		if(!camino.contains(destino)) {
			camino.remove(camino.size()-1);
			marcados[origen.getPosition()] = false;
		}
	}
}
