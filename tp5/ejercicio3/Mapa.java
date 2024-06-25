package tp5.ejercicio3;

import java.util.*;

import tp5.ejercicio1.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> grafo) {
		
		this.mapaCiudades = grafo;
	
	}
	
	
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<String>();
		boolean [] marcados = new boolean[this.mapaCiudades.getSize()];
		
		if(!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			
			if(origen != null) {
				devolverCaminoAux(origen,marcados,ciudad2,lista);
			}
			
		}
		return lista;
	}
	
	private void devolverCaminoAux(Vertex<String>origen,boolean[]marcados,
			String ciudad2,List<String> camino) {
			camino.add(origen.getData());
			marcados[origen.getPosition()] = true;
			if(!origen.getData().equals(ciudad2)) {
			  List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen);
			  Iterator<Edge<String>> it = aristas.iterator();
			  while(it.hasNext() && !camino.get(camino.size()-1).equals(ciudad2)) {
				  Edge<String> ari = it.next();
				  Vertex<String> v = ari.getTarget();
				  if(!marcados[v.getPosition()]) {
					  devolverCaminoAux(v,marcados,ciudad2,camino);
				  }
			  }
			}
		     if(!camino.contains(ciudad2)) {
		    	 camino.remove(camino.size()-1);
		    	 marcados[origen.getPosition()] = false;
		    }
		    
	}
	
	public List<String> devolverCaminoExceptuando (String ciudad1, 
			String ciudad2, List<String> ciudades){
		/*Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
		  que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
	      vacía. (Sin tener en cuenta el combustible) 
		 * */
		List<String> lista = new LinkedList<String>();
		boolean [] marcados = new boolean[this.mapaCiudades.getSize()];
		if(this.mapaCiudades != null && !this.mapaCiudades.isEmpty() ) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			if(origen != null) {
				devolverCaminoExceptuandoAux(origen,lista,ciudad2,marcados,ciudades);
				
			}
			
		}
		return lista;
	}
	
	private void devolverCaminoExceptuandoAux(Vertex<String> origen,List<String> camino,
			String destino,boolean[] marcados,List<String> restringidos) {
		   camino.add(origen.getData());
		   marcados[origen.getPosition()] = true;
		   
		   if(!origen.getData().equals(destino)) {
			   List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen);
			   Iterator<Edge<String>> it = aristas.iterator();
				  while(it.hasNext() && !camino.get(camino.size()-1).equals(destino)) {
					  Edge<String> ari = it.next();
					  Vertex<String> v = ari.getTarget();
					  if(!marcados[v.getPosition()] && !restringidos.contains(v.getData())) {
						  devolverCaminoExceptuandoAux(v,camino,destino,marcados,restringidos);
					  }
				  }
			   
		   }
		   if(!camino.contains(destino)) {
		    	 camino.remove(camino.size()-1);
		    	 marcados[origen.getPosition()] = false; 
		     }
		  
		
	}
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<String>();
		boolean [] marcados = new boolean[this.mapaCiudades.getSize()];
		List<String> listaMin = new LinkedList<String>();
		if(this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			if(origen != null) {
				caminoMasCortoAux(origen,marcados,ciudad2,lista,listaMin,0,9999);
		}
		}
		
		return listaMin;
	}
	
	private int caminoMasCortoAux(Vertex<String> origen,boolean[]marcados,String ciudad2,
			List<String>camino,List<String> caminoMin,int total,int min) {
		camino.add(origen.getData());
		marcados[origen.getPosition()] = true;
		
		if(camino.contains(ciudad2)&& (total < min ) ) {
				caminoMin.removeAll(caminoMin);
				caminoMin.addAll(camino);
				min = total;
			
		}
		else {
		List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen);
		   Iterator<Edge<String>> it = aristas.iterator();
			  while(it.hasNext() && total < min) {
				  Edge<String> ari = it.next();
				  Vertex<String> v = ari.getTarget();
				  int suma = total + ari.getWeight();
				  if(!marcados[v.getPosition()] && suma < min) {
					  min = caminoMasCortoAux(v,marcados,ciudad2,camino,caminoMin,suma,min);
				  }
			  }
		}
	    camino.remove(camino.size()-1);
	    marcados[origen.getPosition()] = false;
	    return min;
	}
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> camino = new LinkedList<String>();
		boolean[] marcados = new boolean[this.mapaCiudades.getSize()];
		if(this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			if(origen != null) {
				caminoSinCargarCombustibleAux(origen,marcados,ciudad2,tanqueAuto,camino);
			}
		}
		return camino;
	}
	private void caminoSinCargarCombustibleAux(Vertex<String> origen,boolean[] marcados,
			String ciudad2,int tanqueAuto,List<String> camino) {
		camino.add(origen.getData());
		marcados[origen.getPosition()] = true;
		if(!origen.getData().equals(ciudad2)) {
			List<Edge<String>> aristas = this.mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			while(it.hasNext() && !camino.contains(ciudad2)) {
				Edge<String> ari = it.next();
				Vertex<String> v = ari.getTarget();
				int aux = tanqueAuto - ari.getWeight();
				if(aux > 0) {
					caminoSinCargarCombustibleAux(v,marcados,ciudad2,aux,camino);
				}
			}
		}
		if(!camino.contains(ciudad2)) {
			camino.remove(camino.size()-1);
			marcados[origen.getPosition()] = false;
		}
		
	}
}
