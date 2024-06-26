package tp5.ejercicio5;

import java.util.*;
import tp1.ejercicio9.Queue;
import tp5.ejercicio1.*;

public class bancoItau {
	
	public List<Persona> devolver(Graph<Persona> grafo,Persona per, int distancia,int limite){
		List<Persona> camino = new LinkedList<Persona>();
		boolean [] marcados = new boolean[grafo.getSize()];
		if(grafo != null && !grafo.isEmpty()) {
			Vertex<Persona> origen = buscar(grafo,per);
			if(origen != null) {
				retornarJubilados(origen,grafo,distancia,40,camino,marcados);
		}}
		return camino;
}
	private Vertex<Persona> buscar(Graph<Persona> grafo, Persona per){
		List<Vertex<Persona>> vertices = grafo.getVertices();
		Iterator<Vertex<Persona>> it = vertices.iterator();
		boolean ok = false;
		Vertex<Persona> v = null;
		while(it.hasNext() && !ok) {
			Vertex<Persona> aux = it.next();
			if(aux.getData().equals(per)) {
				v = aux;
				ok = true;
			}
		}
		return v;
	}
	
	private void retornarJubilados(Vertex<Persona> origen,Graph<Persona> grafo,
			int distancia,int limite, List<Persona> jubilados,boolean []marcados) {
		Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
		cola.enqueue(origen);
		cola.enqueue(null);
		int actual = 0;
		while(!cola.isEmpty() && jubilados.size() < limite && actual < distancia) {
			Vertex<Persona> v = cola.dequeue();
			if(v != null) {
				if(!marcados[v.getPosition()]) {
					marcados[v.getPosition()] = true;
					if(v.getData().getTipo().equals("jubilado")) {
						jubilados.add(v.getData());
					}
					List<Edge<Persona>> aristas = grafo.getEdges(v);
					for(Edge<Persona> ari:aristas) {
						if(ari.getTarget().getData().getTipo().equals("jubilado")) {
							cola.enqueue(ari.getTarget());
							}
					}
				}
			}
			else {
				if(!cola.isEmpty()) {
					actual++;
					cola.enqueue(null);
				}
			}
		}

}
}