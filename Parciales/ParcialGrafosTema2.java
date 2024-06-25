package Parciales;

import java.util.*;

import tp5.ejercicio1.*;

public class ParcialGrafosTema2 {
	
	public String resolver(Graph<recinto>sitios, int tiempo) {
		String es = "No alcanzable";
		int aux = -1;
		
		if(!sitios.isEmpty()) {
			boolean [] marcados = new boolean[sitios.getSize()];
			aux = buscarOrigen(sitios,"Entrada");
			
		if(aux != -1) {
			Vertex<recinto> origen = sitios.getVertex(aux);
			List<recinto> lista = new LinkedList<recinto>();
			resolverAux(origen,sitios,marcados,tiempo,lista);
			if(lista.size() == sitios.getSize()) {
				es = "Alcanzable";
			}
			for(recinto re:lista) {
				System.out.print(re.getName() + " ");
			}
		}
		
		}
		
		
		return es;
		
		
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
	
	private void resolverAux(Vertex<recinto> origen,Graph<recinto>sitios,boolean [] marcados ,
			int tiempo,List<recinto> lista) {
			
			int tiempores = tiempo - origen.getData().getTime();
			if(tiempores >= 0) {
			   lista.add(origen.getData());
			   marcados[origen.getPosition()] = true;
				
			   if(tiempores > 0) {
					List<Edge<recinto>> aristas = sitios.getEdges(origen);
					Iterator<Edge<recinto>> it = aristas.iterator() ;
					while( lista.size() != sitios.getSize() && it.hasNext() ) {
						Edge<recinto> ari = it.next();
						Vertex<recinto> v = ari.getTarget();
						if(!marcados[v.getPosition()]) {
							int tiempoaux =  ari.getWeight();
							if(tiempores > tiempoaux ) {
								resolverAux(v,sitios,marcados,tiempores -tiempoaux,lista);
							}
					     }
					}		
				  }
			   
			   if (lista.size() != sitios.getSize()){
				  marcados[origen.getPosition()] = false;
				 lista.remove(lista.size() - 1);
                 
               }
       	     }
			}
	
}
