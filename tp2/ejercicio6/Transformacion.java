package tp2.ejercicio6;

import tp1.ejercicio9.Queue;
import tp2.ejercicio1.BinaryTree;

public class Transformacion {
   private BinaryTree<Integer> arbol;
	
	public void setAr(BinaryTree<Integer> ar) {
		this.arbol = ar;
	}
   
   public BinaryTree<Integer> suma () {
		
		if(!arbol.isEmpty()) {
			suma(arbol);
			return arbol;
		}
		else return null;
		
	}
	
	private int suma (BinaryTree<Integer> ab) {
		if(ab.isLeaf()) {
			int num = ab.getData();
			ab.setData(0);
			return num;
		}
		else{
			int k = 0;
			int h = 0;
			if(ab.hasLeftChild()) {
				k = suma(ab.getLeftChild());
			}
			if(ab.hasRightChild()) {
				h = suma(ab.getRightChild());
			}
			int aux = ab.getData();
			ab.setData(k+h);
		   return aux+k+h;	
		}
	
		
	}
	public String toString() {
		String aux = "";
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			BinaryTree<Integer> aux1 = cola.dequeue();
			if(aux1 != null) {
			  aux += " | "+ aux1 + " | ";
			if(aux1.hasLeftChild()) {
				cola.enqueue(aux1.getLeftChild());
				}
			if(aux1.hasRightChild()) {
				cola.enqueue(aux1.getRightChild());
			}
			}
			else if(!cola.isEmpty()) {
				    aux+= "\n";
				    
				    cola.enqueue(null);
				}
	}
		return aux;
    }
	}
