package tp2.ejercicio5;

import tp1.ejercicio9.Queue;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbolsito;
	
	public void setAr(BinaryTree<Integer> aux) {
		this.arbolsito = aux;
	}
	
	public int sumaElementosProfundidad (int p) {
		if(!arbolsito.isEmpty()) {
			return sumaElementosProfundidad(p,arbolsito);
		}
		else {
			return 0;
		}
		
	}
	
	private int sumaElementosProfundidad(int p, BinaryTree<Integer> ab) {
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		int suma = 0;
		int nivel = 0;
		cola.enqueue(ab);
		cola.enqueue(null);
		while(!cola.isEmpty() && nivel <= p) {
			BinaryTree<Integer> aux = cola.dequeue();
			if(aux != null) {
			if(nivel == p) {
				suma += aux.getData();
			}
			if(aux.hasLeftChild()) {
				cola.enqueue(aux.getLeftChild());
				}
			if(aux.hasRightChild()) {
				cola.enqueue(aux.getRightChild());
			}
			}
			else if(!cola.isEmpty()) {
				    cola.enqueue(null);
					nivel++;
				}
			
		}
		return suma;
		
	}
}
