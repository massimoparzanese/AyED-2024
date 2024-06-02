package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {

	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean ok;
		if(!arbol1.isEmpty() && !arbol2.isEmpty()) {
		   ok = esPrefijoaux(arbol1,arbol2);
		}
		else {
			ok = true;
		}
		return ok;
	}
	
	private boolean esPrefijoaux(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean ok = true;
		if(arbol1.getData() != arbol2.getData()) {
			ok = false;
		}
		if(arbol1.hasLeftChild() &&  ok) {
			if(arbol2.hasLeftChild()) {
				ok = esPrefijoaux(arbol1.getLeftChild(),arbol2.getLeftChild());}
			else {ok = false;}
		}
		if(arbol1.hasRightChild() && ok) {
			if(arbol2.hasRightChild()) {
			ok = esPrefijoaux(arbol1.getRightChild(),arbol2.getRightChild());}
			else ok = false;
		}
		return ok;
		
	}
}
