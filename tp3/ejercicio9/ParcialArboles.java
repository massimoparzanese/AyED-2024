package tp3.ejercicio9;

import java.util.*;

import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
		boolean ok = false;
		if(!arbol.isEmpty()) {
			ok =esDeSeleccion_aux(arbol);
		}
		return ok;
	}
	private static boolean esDeSeleccion_aux(GeneralTree<Integer> arbol) {
		boolean ok = true;
		int min = 99999;
		if(!arbol.isLeaf()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child:children) {
				ok = esDeSeleccion_aux(child);
				if(child.getData() < min) {
					min = child.getData();
				}}
			 
			 if(min != arbol.getData()) {
				 ok = false;
			 }
			}
		
		return ok;
	}
}
