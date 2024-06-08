package tp3.ejercicio2;

import tp3.ejercicio1.GeneralTree;
import java.util.*;
import tp1.ejercicio9.Queue;
public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> Numbers = new LinkedList<Integer>();
		if(a.getData() > n && a.getData() % 2 != 0) {
			Numbers.add(a.getData());
		}
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child:children) {
			Numbers.addAll(numerosImparesMayoresQuePreOrden(child,n));
		}
		return Numbers;
		}
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> Numbers = new LinkedList<Integer>();
		if(!a.isEmpty()) {
		numerosImparesMayoresQueInOrden(Numbers,a, n);
		return Numbers;}
		else {return null;}
	}
	private void numerosImparesMayoresQueInOrden(List<Integer> listita,GeneralTree <Integer> a,Integer n) {
		if(!a.isLeaf()) {
			List<GeneralTree<Integer>> children = a.getChildren();
			numerosImparesMayoresQueInOrden(listita,children.get(0),n);
			children = a.getChildren();
			int Number = a.getData();
			if(Number > n  && Number % 2 != 0) {
				listita.add(Number);
			}
			for(int i=1;i<children.size();i++) {
				numerosImparesMayoresQueInOrden(listita,children.get(i),n);
			}
			
			/* for(GeneralTree<Integer>child:children) {
				if(children.get(0) != child) {
			  numerosImparesMayoresQueInOrden(listita,child,n);
			}
			}*/
		}
		else {
			if( a.getData() > n && a.getData() % 2 != 0 ) {
				listita.add(a.getData());
			}
		}
	}
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,
			Integer n){
		List<Integer> listita = new LinkedList<Integer>();
		if(!a.isEmpty()) {
			numerosImparesMayoresQuePostOrden(listita,a,n);
		}
		return listita;
	}
	private void numerosImparesMayoresQuePostOrden(List<Integer> listita,GeneralTree <Integer> a,
			Integer n) {
		if(!a.isLeaf()) {
			List<GeneralTree<Integer>> children = a.getChildren();
			numerosImparesMayoresQueInOrden(listita,children.get(0),n);
			for(int i=1;i<children.size();i++) {
				numerosImparesMayoresQueInOrden(listita,children.get(i),n);
			}
			if(a.getData() % 2 != 0 && a.getData() > n) {
				listita.add(a.getData());
			}}
		else {
			if(a.getData() % 2 != 0 && a.getData() > n) {
				listita.add(a.getData());
		}
	}
}
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,
			Integer n){
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		List<Integer> lista = new LinkedList<Integer>();
		cola.enqueue(a);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			GeneralTree <Integer> elemento = cola.dequeue();
			if(elemento != null) {
				if(elemento.getData()% 2 != 0 && elemento.getData() > n) {
					lista.add(elemento.getData());
				}

				List<GeneralTree<Integer>> hijos = elemento.getChildren();
				for(GeneralTree<Integer> elem:hijos) {
					cola.enqueue(elem);
				}}
			
			else {if(!cola.isEmpty()) {
				cola.enqueue(null);
			}
				
			}
		}
	return lista;
	}
}
