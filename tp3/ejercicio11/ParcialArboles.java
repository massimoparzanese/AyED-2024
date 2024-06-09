package tp3.ejercicio11;

import tp3.ejercicio1.GeneralTree;
import java.util.*;
import tp1.ejercicio9.Queue;

public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean ok = false;
		if(!arbol.isEmpty()) {
			ok = resolverAux(arbol);
		}
		return ok;
	}
	
	private static boolean resolverAux(GeneralTree<Integer> arbol) {
		boolean seguir = true;
		int nivelAnt = 0;
		int nivelAct = 0;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty() && seguir) {
			GeneralTree<Integer> aux = cola.dequeue();
			if(aux != null) {
				nivelAct+=1;
				List<GeneralTree<Integer>> children = aux.getChildren();
				for(GeneralTree<Integer> child:children) {
					cola.enqueue(child);
				}}
			else {
				if(!cola.isEmpty()) {
					if(nivelAct == nivelAnt+1) {
						nivelAnt = nivelAct;
						nivelAct = 0;
					}
					else {seguir = false;}
					cola.enqueue(null);
				}
			}
		}
		
		return seguir;
	}

}
