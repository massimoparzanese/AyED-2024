package tp3.ejercicio7;

import java.util.*;

import tp3.ejercicio1.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> arbolito;
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.arbolito = arbol;
	}
	public List<Integer> caminoAHojaMasLejana (){
		LinkedList<Integer> lista = new LinkedList<Integer>();
		if(!this.arbolito.isEmpty())
			lista = caminoAHojaMasLejana(this.arbolito);
		return lista;
	}
	private LinkedList<Integer> caminoAHojaMasLejana(GeneralTree<Integer> ar) {
		LinkedList<Integer> listita= new LinkedList<Integer>();
		LinkedList<Integer> lista= new LinkedList<Integer>();
		if(ar.isLeaf()) {
			listita.add(ar.getData());
			return listita;
		}
		else {
			List<GeneralTree<Integer>>children = ar.getChildren();
			for(GeneralTree<Integer> child:children) {
				listita = new LinkedList<Integer>();
				listita.addAll(caminoAHojaMasLejana(child));
				if(lista.size() < listita.size()) {
					lista = listita;
				}
			}
			lista.add(ar.getData());
			return lista;
		}
		
	}

}
