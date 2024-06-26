package Parciales;

import java.util.*;

import tp5.ejercicio1.*;

public class ParcialGrafosTema1 {
	 
	public List<recinto> resolver(Graph<recinto> sitios,int tiempo){
		int pos = -1;
		List<recinto> lista = new LinkedList<recinto>();
		List<recinto> listaMax = new LinkedList<recinto>();
		if(!sitios.isEmpty()) {
			pos = buscarOrigen(sitios,"Entrada");
			boolean [] marcados = new boolean[sitios.getSize()];
			if(pos != -1) {
				Vertex<recinto> v = sitios.getVertex(pos);
				if(tiempo >= 0) {
	
				resolverAux(v,sitios,lista,tiempo,marcados,listaMax);}
				
			}
		}
	 return listaMax;

	
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
	private void resolverAux(Vertex<recinto> origen, Graph<recinto> sitios,List<recinto> lista,
			int tiempo, boolean [] marcados,List<recinto> listaMax) {
		    tiempo = tiempo - origen.getData().getTime();
		    if(tiempo >= 0){
		    	lista.add(origen.getData());
		    	marcados[origen.getPosition()] = true;
		    	if(lista.size() > listaMax.size()) {
		    		listaMax.removeAll(listaMax);
		    		listaMax.addAll(lista);
			    }
		    	if(tiempo > 0) {
		    		List<Edge<recinto>> aristas = sitios.getEdges(origen);
		    		Iterator<Edge<recinto>> it = aristas.iterator();
		    		while(it.hasNext()) {
		    			Edge<recinto> arista = it.next();
		    			Vertex<recinto> v = arista.getTarget();
		    			if(!marcados[v.getPosition()]) {
		    				if(tiempo - arista.getWeight() > 0) {
		    					resolverAux(v,sitios,lista,tiempo-arista.getWeight(),marcados,listaMax);
		    				}
		    			  }
		    		   }
		    		}
		    	
		        lista.remove(lista.size()-1);
		        marcados[origen.getPosition()] = false;
		    }
		  }

			
	
}
