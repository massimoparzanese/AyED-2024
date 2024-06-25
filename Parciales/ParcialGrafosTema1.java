package Parciales;

import java.util.*;
import tp5.ejercicio1.*;

public class ParcialGrafosTema1 {
	 
	public List<recinto> resolver(Graph<recinto> sitios,int tiempo){
		int pos = -1;
		List<recinto> lista = new LinkedList<recinto>();
		if(!sitios.isEmpty()) {
			pos = buscarOrigen(sitios,"Entrada");
			boolean [] marcados = new boolean[sitios.getSize()];
			if(pos != -1) {
				Vertex<recinto> v = sitios.getVertex(pos);
				tiempo-= v.getData().getTime();
				if(tiempo >= 0) {
				marcados[v.getPosition()] = true;
				resolverAux(v,sitios,lista,tiempo,marcados);}
				
			}
		}
	 return lista;

	
	}
	
	private int buscarOrigen(Graph<recinto>sitios,String origen) {
		List<Vertex<recinto>> lista = sitios.getVertices();
		int pos = -1;
		Iterator<Vertex<recinto>> it = lista.iterator();
		while(it.hasNext() && pos == -1) {
			Vertex<recinto> v = it.next();
			if(origen.equals(v.getData().getName())) {
				pos = v.getPosition(); 
			}
		}
		return pos;
	}
	private boolean resolverAux(Vertex<recinto> origen, Graph<recinto> sitios,List<recinto> lista,
			int tiempo, boolean [] marcados) {
		    lista.add(origen.getData());
			boolean ok = false;
			List<Edge<recinto>> aristas = sitios.getEdges(origen);
			Iterator<Edge<recinto>> it = aristas.iterator();
			while(it.hasNext() && !ok) {
				Edge<recinto> ari = it.next();
				Vertex<recinto> v = ari.getTarget();
				if(!marcados[v.getPosition()]) {
				  int aux = ari.getWeight() + ari.getTarget().getData().getTime();
				  if(tiempo-aux >= 0) {
					 marcados[origen.getPosition()] = true;
					 tiempo = tiempo - aux;
					 ok = resolverAux(v,sitios,lista,tiempo,marcados);
				 }
				 else ok = true;

				}
			}

			return ok;
	
	}

			
	
}
