package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbolsito;
	
	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbolsito = arbol;
	}
	public int retardoReenvio() {
		  if(!arbolsito.isEmpty()) {
			  return retardoReenvio(arbolsito);
		  }
		  else return 0;
		}
		
	private int retardoReenvio(BinaryTree<Integer> ab) {
		
		if(ab.isLeaf()) {
			return ab.getData();
		}
		else {
			int k = 0;
			int h = 0;
			if(ab.hasLeftChild()) {
				k= retardoReenvio(ab.getLeftChild());
			}
			if(ab.hasRightChild()) {
				h= retardoReenvio(ab.getRightChild());
			}
		return ab.getData() + Math.max(k, h);
		}
		
	}
}
